package mall.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import mall.cart.MyCartList;
import member.model.MemberBean;
import member.model.MemberDao;
import order.model.OrderDao;
import orderdetail.model.OrderDetailBean;
import orderdetail.model.OrderDetailDao;
import products.model.ProductsDao;

@Controller
public class CalculateController {
	
	private final String command = "calculate.mall"; // mallList.jsp 결제하기 클릭
	private final String gotoPage = "redirect:/list.prd";
	
	@Autowired
	private MemberDao mdao;
	
	@Autowired
	private ProductsDao pdao;
	
	@Autowired
	private OrderDao orderDao;
	
	@Autowired
	private OrderDetailDao orderDetailDao;
	
	@RequestMapping(value=command)
	public String doAction(HttpSession session) {
		
		MyCartList mycart = (MyCartList)session.getAttribute("mycart");
		Map<Integer,Integer> orderlists = mycart.getAllOrderLists();
		
		System.out.println("orderlists.entrySet():"+orderlists.entrySet()); // [22=1, 13=1]
		
		MemberBean loginInfo = (MemberBean)session.getAttribute("loginInfo"); // 설정 MLC
		String memberId = loginInfo.getId();
		System.out.println("memberId : " + memberId);
		
		int cnt = orderDao.insertOrder(memberId);
		System.out.println("cnt in ccontroller: "+cnt);
		
		int maxOid = orderDao.getMaxOid();
		System.out.println("maxOid in ccontroller: " + maxOid);
//		3,2
//		5,3
//		17,9
		
		for(Integer pnum : orderlists.keySet()) {
			Integer qty = orderlists.get(pnum);
			OrderDetailBean odBean = new OrderDetailBean();
			odBean.setOid(maxOid);
			odBean.setPnum(pnum);
			odBean.setQty(qty);
			
			orderDetailDao.insertOrderDetail(odBean);
			
			// 상품 재고 수량 감소
			pdao.updateStock(pnum, qty);
		}//for
		
		// 회원 포인트 적립
		mdao.updateMpoint(memberId,100);
		
		 // 중요: 장바구니 비우기
        session.removeAttribute("mycart");
		return gotoPage;
	}
}

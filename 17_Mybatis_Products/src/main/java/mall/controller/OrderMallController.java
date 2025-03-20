package mall.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import member.model.MemberBean;
import order.model.OrderBean;
import order.model.OrderDao;

@Controller
public class OrderMallController {
	
	private final String command = "/order.mall";
	private final String getPage = "myShoppingList";
	
	@Autowired
	private OrderDao orderDao;
	
	@RequestMapping(command)
	public String doAction(HttpSession session) {
		MemberBean mb = (MemberBean)session.getAttribute("loginInfo");
		
		
		if(session.getAttribute("loginInfo") == null) { // 로그인 안했으면
			session.setAttribute("destination", "redirect:/order.mall");
			
			
			return "redirect:/loginForm.mb";
		}else {
			
			List<OrderBean> obLists = orderDao.orderMall(mb.getId());
			session.setAttribute("obLists", obLists);
			return getPage;
		}
	}

}

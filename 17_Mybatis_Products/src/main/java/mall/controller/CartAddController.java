package mall.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import mall.cart.MyCartList;



@Controller
public class CartAddController {
	private final String command = "add.mall"; //productsDetaolForm.jsp에서 요청
	private final String gotoPage = "redirect:/list.mall"; 
	
	@RequestMapping(value=command)
	public String doAction(@RequestParam("num") int num,
							@RequestParam("orderqty") int orderqty,
							HttpSession session) {
		
		if(session.getAttribute("loginInfo")==null) {
			session.setAttribute("destination", "redirect:/list.prd");
			return "redirect:/loginForm.mb";
		}else { //주문하기
			
			MyCartList mycart = (MyCartList)session.getAttribute("mycart");
			
			System.out.println("mycart : " + mycart);
			
			if(mycart == null) {
				mycart = new MyCartList();
			}
			
			session.setAttribute("mycart",mycart);
			//MyCartList mycart = new MyCartList(); //사용하면 아니된다. 사용하면 담을 때마다 새로운 객체가 생성되기 떄문이다. 고로 세션설정으로 해야한다.
			mycart.addOrder(num, orderqty);
			return gotoPage;
			
		}
		
	}
}

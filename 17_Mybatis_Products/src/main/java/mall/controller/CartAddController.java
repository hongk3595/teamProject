package mall.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import mall.cart.MyCartList;



@Controller
public class CartAddController {
	private final String command = "add.mall"; //productsDetaolForm.jsp���� ��û
	private final String gotoPage = "redirect:/list.mall"; 
	
	@RequestMapping(value=command)
	public String doAction(@RequestParam("num") int num,
							@RequestParam("orderqty") int orderqty,
							HttpSession session) {
		
		if(session.getAttribute("loginInfo")==null) {
			session.setAttribute("destination", "redirect:/list.prd");
			return "redirect:/loginForm.mb";
		}else { //�ֹ��ϱ�
			
			MyCartList mycart = (MyCartList)session.getAttribute("mycart");
			
			System.out.println("mycart : " + mycart);
			
			if(mycart == null) {
				mycart = new MyCartList();
			}
			
			session.setAttribute("mycart",mycart);
			//MyCartList mycart = new MyCartList(); //����ϸ� �ƴϵȴ�. ����ϸ� ���� ������ ���ο� ��ü�� �����Ǳ� �����̴�. ��� ���Ǽ������� �ؾ��Ѵ�.
			mycart.addOrder(num, orderqty);
			return gotoPage;
			
		}
		
	}
}

package mall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import mall.cart.ShoppingInfo;
import products.model.CompositeDao;

@Controller
public class OrderDetailViewController {

	private final String command = "orderDetailView.mall"; // myShoppingList.jsp���� �󼼺��� Ŭ���ؼ� �Ѿ��
	private String getPage = "myShoppingDetail";
	@Autowired
	private CompositeDao compositeDao;
	
	
	@RequestMapping(command)
	public String doAction(@RequestParam(value="oid", required = true) int oid, Model model) {
		List<ShoppingInfo> shopLists =  compositeDao.orderDetail(oid);
		 model.addAttribute("shopLists", shopLists);
		
		return getPage;	
	}
}
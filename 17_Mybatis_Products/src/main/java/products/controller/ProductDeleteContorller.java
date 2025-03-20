package products.controller;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import products.model.ProductsBean;
import products.model.ProductsDao;

@Controller
public class ProductDeleteContorller {
	
	private final String command = "delete.prd";
	private String gotoPage = "redirect:/list.prd";
	
	@Autowired
	ProductsDao pdao;
	
	@Autowired
	ServletContext servletContext;
	
	
	
	
	
	@RequestMapping(value=command, method=RequestMethod.GET)
	public ModelAndView doAction(HttpServletRequest request, HttpSession session,
								@RequestParam("num") int num,
								@RequestParam(value="pageNumber",required = false) int pageNumber,
								@RequestParam(value="whatColumn",required = false) String whatColumn,
								@RequestParam(value="keyword",required = false) String keyword) {
		
		
		
		
		ProductsBean pbean = pdao.getOneProduct(num);
		String uploadPath = servletContext.getRealPath("/resources/uploadImage/");
		File url = new File(uploadPath);
		File destination = new File(url,pbean.getImage());
		
		ModelAndView mav = new ModelAndView();
		
		
		
		int cnt = pdao.deleteProducts(num); 
		System.out.println("PDC cnt : " + cnt);
		
		if(cnt != -1) {
			destination.delete();
		}
		
		mav.addObject("pageNumber",pageNumber);
		mav.addObject("whatColumn",whatColumn);
		mav.addObject("keyword",keyword);
		mav.setViewName(gotoPage);
		
		return mav;
	}

}

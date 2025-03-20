package products.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import products.model.ProductsBean;
import products.model.ProductsDao;
import utility.Paging;

@Controller
public class ProductListController {

	private final String command = "/list.prd";
	private String getPage = "productList";
	
	@Autowired
	ProductsDao pdao;
	
	@RequestMapping(command)
	public String list(@RequestParam(value = "whatColumn", required= false) String whatColumn,
			@RequestParam(value = "keyword" , required= false) String keyword,
			@RequestParam(value = "pageNumber", required= false) String pageNumber,
			HttpServletRequest request) {
		
		Map<String,String> map = new HashMap<String,String>();
		map.put("whatColumn", whatColumn);
		map.put("keyword", "%"+keyword+"%");
		int totalCount = pdao.getTotalCount(map);
		String url = request.getContextPath()+"/list.prd";
		
		Paging pageInfo = new Paging(pageNumber,"3",totalCount,url,whatColumn,keyword);
		List<ProductsBean> productLists = pdao.getProductsList(map,pageInfo);
		request.setAttribute("productLists", productLists);
		request.setAttribute("pageInfo", pageInfo); 
		request.setAttribute("totalCount", totalCount);
		request.setAttribute("pageNumber", pageNumber);
		return getPage;
	}
}


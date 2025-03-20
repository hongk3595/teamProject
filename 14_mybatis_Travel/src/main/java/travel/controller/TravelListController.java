package travel.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import travel.model.TravelBean;
import travel.model.TravelDao;
import utility.Paging;

@Controller
public class TravelListController {
	//travelList.jsp로 이동
	
	private final String command = "list.tv";
	private final String getPage = "travelList"; // web-inf\travel\travelList.jsp
	
	@Autowired
	TravelDao tdao;
	
	//start.jsp(X) / travelList.jsp(2)
	@RequestMapping(command)
	public ModelAndView list(HttpServletRequest request,
							@RequestParam(value="whatColumn", required = false) String whatColumn,
							@RequestParam(value="keyword", required = false) String keyword,
							@RequestParam(value="pageNumber", required = false) String pageNumber) {
		
		Map<String,String> map = new HashMap<String, String>();
		map.put("whatColumn", whatColumn); // area or style
		map.put("keyword", "%"+keyword+"%"); // 검색어
		
		System.out.println("pageNumber : " + pageNumber);
		
		int totalCount = tdao.getTotalCount(map);
		System.out.println("totalCount : " + totalCount);
		
		String url = request.getContextPath() + command;
		System.out.println("url : " + url); // /ex/list.tv
		//http://localhost:8080/ex/list.tv
		
		Paging pageInfo = new Paging(pageNumber,"2",totalCount,url,whatColumn,keyword);   
		System.out.println("offset : " + pageInfo.getOffset());
		System.out.println("limit : " + pageInfo.getLimit());
		
		List<TravelBean> lists = tdao.getTravelList(pageInfo, map);  
		//request.setAttribute("travelLists", lists);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("travelLists", lists);
		mav.addObject("totalCount", totalCount);
		mav.addObject("pageInfo", pageInfo);
		
		mav.setViewName(getPage);
		
		return mav;
		//수정완
		//한번 더 수정함 수정함
		//수정완
		//수정완
		//수정완
		//수정완
		//수정완
	} 
}
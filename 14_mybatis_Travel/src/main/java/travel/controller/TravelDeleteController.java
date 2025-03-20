package travel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import travel.model.TravelDao;

@Controller
public class TravelDeleteController {
	private final String gotoPage = "redirect:/list.tv";
	private final String command = "delete.tv";
	
	@Autowired
	TravelDao travelDao;
	
	
	@RequestMapping(command)
	public String doAction(@RequestParam(value="num", required = true) int num) {
			
		System.out.println("delete num : "+num);
		
		int cnt = travelDao.deleteTravel(num);
		
		return gotoPage;   
	}
}

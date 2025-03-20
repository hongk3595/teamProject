package travel.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import travel.model.TravelBean;
import travel.model.TravelDao;

@Controller
public class TravelUpdateController {
	private final String getPage = "travelUpdateForm";
	private final String gotoPage = "redirect:/list.tv";
	private final String command = "update.tv";
	
	@Autowired
	TravelDao travelDao;
	
	//albumList.jsp에서 수정클릭
		@RequestMapping(value=command,method=RequestMethod.GET)
		public String doAction(@RequestParam(value="num", required = true) int num,
								Model model) {
			
			System.out.println("TUC num : " + num);
			
			TravelBean travel = travelDao.getOneTravel(num);
			model.addAttribute("travel", travel);
			 
			return getPage;
		}
		
		//albumUpdateForm.jsp submit
		@RequestMapping(value=command,method=RequestMethod.POST)
		public ModelAndView doAction(@ModelAttribute("travel") @Valid TravelBean travel, BindingResult result) {
			
			ModelAndView mav = new ModelAndView();
			if(result.hasErrors()) {
				mav.setViewName(getPage);
				return mav;
			}
			
			int cnt = travelDao.updateTravel(travel);
			mav.setViewName(gotoPage);
			return mav;
		}

}

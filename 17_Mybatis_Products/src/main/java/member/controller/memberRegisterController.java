package member.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import member.model.MemberBean;
import member.model.MemberDao;

@Controller
public class memberRegisterController {

	private final String command = "register.mb";   
	private final String getPage = "memberRegisterForm";
	private final String gotoPage = "redirect:/list.mb";
	
	@Autowired
	MemberDao mdao; 

	@Autowired
	ServletContext servletContext;
	
	@RequestMapping(value=command, method= RequestMethod.GET)
	public String doAction() {
		
		return getPage;
	}

	@RequestMapping(value=command, method= RequestMethod.POST)
	public ModelAndView doAction(@ModelAttribute("mb") @Valid MemberBean mb, 
			BindingResult result) {
		
		ModelAndView mav = new ModelAndView();

		
		if(result.hasErrors()) {
			mav.setViewName(getPage);
			return mav;
		}
		int cnt = mdao.registerMember(mb); 
		mav.setViewName(gotoPage);
		return mav;
	}
}

package member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import member.model.MemberBean;
import member.model.MemberDao;


@Controller
public class MemberLoginController {

	private final String command = "loginForm.mb";   
	private final String getPage = "memberLoginForm";
	private final String gotoPage = "redirect:/list.mb";
	
	
	
	@Autowired
	MemberDao mdao; 

	@Autowired
	ServletContext servletContext;

	//ProductInsertController loginInfo ==null => 
	@RequestMapping(value=command, method=RequestMethod.GET)
	public String doAction() {
		System.out.println("MLC : ");
		//System.out.println("MLC : " + num);
		
		
			
		return getPage;
	}

	//memeberLoginForm.jsp submit
	@RequestMapping(value=command, method=RequestMethod.POST)
	public ModelAndView doAction(MemberBean mb, HttpServletResponse response, HttpSession session) throws IOException {  

		//System.out.println("MLCing : " + num);
		System.out.println("mb.getId() :" + mb.getId());
		System.out.println("mb.getPassword() :" + mb.getPassword());

		MemberBean login = mdao.getMember(mb.getId());
		PrintWriter pw = response.getWriter();

		response.setContentType("text/html;charset=UTF-8");
		if(login == null) { //일치하는 아이디x
			System.out.println("일치하는 아이디가 없다.");
			pw.print("<script type='text/javascript'>");
			pw.print("alert('일치하는 아이디가 없습니다.')");
			pw.print("</script>");
			pw.flush();

			return  new ModelAndView(getPage);

		}else {//일치하는 아이디가 있다.
			if(login.getPassword().equals(mb.getPassword())) { //아이디 비번 모두 일치
				session.setAttribute("loginInfo", login);
				return  new ModelAndView((String)session.getAttribute("destination"));//redirect:/insert.prd
				
				
			}else {//비번 불일치
				
			pw.print("<script type='text/javascript'>");
			pw.print("alert('비번이 일치하지 않습니다.')");
			pw.print("</script>");
			pw.flush();
			
			return  new ModelAndView(getPage);
			}
		}

	}

}


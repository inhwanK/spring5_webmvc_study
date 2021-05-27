package spring5_webmvc_study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class MemberDetailController {

	@Autowired
	private MemberDao memberDao;

	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	@GetMapping("/members/{id}")
	public ModelAndView detail(@PathVariable("id") Long id) {
		Member member = memberDao.selectById(id);
		if (member == null) {
			throw new MemberNotFoundException();
		}
//		model.addAttribute("member", member);
		ModelAndView mav = new ModelAndView();
		mav.addObject("member", member);
		mav.setViewName("member/memberDetail");
		return mav;
	}

//	@ExceptionHandler(TypeMismatchException.class)
//	public String handleTypeMismatchException() {
//		return "member/invalidId";
//	}
	
//	@ExceptionHandler(MemberNotFoundException.class)
//	public String handleNotFoundException() {
//		return "member/noMember";
//	}
}

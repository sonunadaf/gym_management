package com.gold.gym.proj.controller.addmember;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gold.gym.proj.constant.exception.ExceptionConstant;
import com.gold.gym.proj.constant.pages.EnumPages;
import com.gold.gym.proj.constant.viewmessage.ViewMessage;
import com.gold.gym.proj.entity.gymentity.GymEntity;
import com.gold.gym.proj.entity.member.MemberEntity;
import com.gold.gym.proj.exception.ControllerException;
import com.gold.gym.proj.exception.ServiceException;
import com.gold.gym.proj.service.addmember.AddMemberService;

@Controller
@RequestMapping("*.do")
public class AddMemberController {

	@Autowired
	private AddMemberService addMemberService;
	private static Logger logger = LoggerFactory.getLogger(AddMemberController.class);
	
	@InitBinder
	public void InitBinder(WebDataBinder webDataBinder) throws ControllerException {
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		webDataBinder.registerCustomEditor(Date.class,"joiningDate",new CustomDateEditor(dateFormat, true));
	}

	@RequestMapping(value = "addMember.do", method = RequestMethod.POST)
	public String addMember(MemberEntity memberEntity, HttpServletRequest request,Model model) throws ControllerException {
		try {
			HttpSession session = request.getSession();
			if (session != null && session.getAttribute(ViewMessage.GOLD_SESSION) != null) {
				GymEntity gymFromSession = (GymEntity) session.getAttribute(ViewMessage.GOLD_SESSION);
				addMemberService.addMember(gymFromSession, memberEntity);
				model.addAttribute(ViewMessage.MESSAGE, ViewMessage.MEMBER_ADDED);
				return EnumPages.AddMember.toString();
			}else {
				return EnumPages.Index.toString();
			}
			
		} catch (ServiceException e) {
			logger.error(ExceptionConstant.CONTROLLER + this.getClass().getSimpleName() + " " + e.getMessage());
			throw new ControllerException(
					ExceptionConstant.CONTROLLER + this.getClass().getSimpleName() + " " + e.getMessage());
		}
	}
}

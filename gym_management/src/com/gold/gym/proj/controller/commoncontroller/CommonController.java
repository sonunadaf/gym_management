package com.gold.gym.proj.controller.commoncontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gold.gym.proj.constant.exception.ExceptionConstant;
import com.gold.gym.proj.constant.pages.EnumPages;
import com.gold.gym.proj.constant.viewmessage.ViewMessage;
import com.gold.gym.proj.exception.ControllerException;

@Controller
@RequestMapping("*.do")
public class CommonController {

	private static Logger logger = LoggerFactory.getLogger(CommonController.class);

	@RequestMapping(value = "home.do", method = RequestMethod.GET)
	public String getHome(HttpServletRequest request) throws ControllerException {
		try {
			HttpSession session = request.getSession();
			if (session != null && session.getAttribute(ViewMessage.GOLD_SESSION) != null) {
				return EnumPages.Home.toString();
			} else {
				return EnumPages.Index.toString();
			}
		} catch (Exception e) {
			logger.error(ExceptionConstant.CONTROLLER + this.getClass().getSimpleName() + " " + e.getMessage());
			throw new ControllerException(ExceptionConstant.CONTROLLER + this.getClass().getSimpleName() + " " + e.getMessage());
		}

	}

	@RequestMapping(value = "addMember.do", method = RequestMethod.GET)
	public String getAddMember(HttpServletRequest request) throws ControllerException {
		try {
			HttpSession session = request.getSession();
			if (session != null && session.getAttribute(ViewMessage.GOLD_SESSION) != null) {
				return EnumPages.AddMember.toString();
			} else {
				return EnumPages.Index.toString();
			}
		} catch (Exception e) {
			logger.error(ExceptionConstant.CONTROLLER + this.getClass().getSimpleName() + " " + e.getMessage());
			throw new ControllerException(ExceptionConstant.CONTROLLER + this.getClass().getSimpleName() + " " + e.getMessage());
		}

	}

	@RequestMapping(value = "appointment.do", method = RequestMethod.GET)
	public String getEnquiryForm(HttpServletRequest request) throws ControllerException {
		try {
			HttpSession session = request.getSession();
			if (session != null && session.getAttribute(ViewMessage.GOLD_SESSION) != null) {
				return EnumPages.Enquiry.toString();
			} else {
				return EnumPages.Index.toString();
			}
		} catch (Exception e) {
			logger.error(ExceptionConstant.CONTROLLER + this.getClass().getSimpleName() + " " + e.getMessage());
			throw new ControllerException(ExceptionConstant.CONTROLLER + this.getClass().getSimpleName() + " " + e.getMessage());
		}
	}

	@RequestMapping(value = "addGym.do", method = RequestMethod.GET)
	public String getAddGym(HttpServletRequest request) throws ControllerException {
		try {
			HttpSession session = request.getSession();
			if (session != null && session.getAttribute(ViewMessage.GOLD_SESSION) != null) {
				return EnumPages.AddGym.toString();
			} else {
				return EnumPages.Index.toString();
			}
		} catch (Exception e) {
			logger.error(ExceptionConstant.CONTROLLER + this.getClass().getSimpleName() + " " + e.getMessage());
			throw new ControllerException(ExceptionConstant.CONTROLLER + this.getClass().getSimpleName() + " " + e.getMessage());
		}

	}
	@RequestMapping(value = "login.do", method = RequestMethod.GET)
	public String login(HttpServletRequest request) throws ControllerException {
		try {
			HttpSession session = request.getSession();
			if (session != null && session.getAttribute(ViewMessage.GOLD_SESSION) != null) {
				return EnumPages.Home.toString();
			} else {
				return EnumPages.Index.toString();
			}
		} catch (Exception e) {
			logger.error(ExceptionConstant.CONTROLLER + this.getClass().getSimpleName() + " " + e.getMessage());
			throw new ControllerException(ExceptionConstant.CONTROLLER + this.getClass().getSimpleName() + " " + e.getMessage());
		}
	}
}

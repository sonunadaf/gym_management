package com.gold.gym.proj.controller.logout;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gold.gym.proj.constant.exception.ExceptionConstant;
import com.gold.gym.proj.constant.pages.EnumPages;
import com.gold.gym.proj.exception.ControllerException;

@Controller
@RequestMapping("*.do")
public class LogoutController {

	private static Logger logger = LoggerFactory.getLogger(LogoutController.class);
	@RequestMapping(value="/logout.do",method = RequestMethod.GET)
	public String logout(HttpServletRequest request) throws ControllerException {

		try {
			HttpSession session = request.getSession();
			if (session != null) {
				session.invalidate();
				return EnumPages.Index.toString();
			}else {
				return EnumPages.Index.toString();
			}
		} catch (Exception e) {
			logger.error(ExceptionConstant.CONTROLLER + this.getClass().getSimpleName() + " " + e.getMessage());
			throw new ControllerException(ExceptionConstant.CONTROLLER + this.getClass().getSimpleName() + " " + e.getMessage());
		}	

	}
}

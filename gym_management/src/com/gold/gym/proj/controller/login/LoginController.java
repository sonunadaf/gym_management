package com.gold.gym.proj.controller.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.gold.gym.proj.constant.exception.ExceptionConstant;
import com.gold.gym.proj.constant.pages.EnumPages;
import com.gold.gym.proj.constant.viewmessage.ViewMessage;
import com.gold.gym.proj.entity.gymentity.GymEntity;
import com.gold.gym.proj.exception.ControllerException;
import com.gold.gym.proj.service.getgym.GetGymService;

@Controller
@RequestMapping("*.do")
public class LoginController {

	@Autowired
	private GetGymService getGymService;
	private static Logger logger = LoggerFactory.getLogger(LoginController.class);

	@RequestMapping(value = "login.do", method = RequestMethod.POST)
	public String logIn(@RequestParam String userName, @RequestParam String password, HttpServletRequest request,Model model)
			throws ControllerException {

		try {
			GymEntity gymEntity = getGymService.getGymEntity(userName, password);
			if (gymEntity != null) {
				HttpSession session = request.getSession(true);
				session.setAttribute(ViewMessage.GOLD_SESSION, gymEntity);
				session.setMaxInactiveInterval(60 * 20);				
				return EnumPages.Home.toString();
			} else {
				model.addAttribute(ViewMessage.ERROR, ViewMessage.WORNG_ID_PASS);
				return EnumPages.Index.toString();
			}
		}catch (Exception e) {
			logger.error(ExceptionConstant.CONTROLLER + this.getClass().getSimpleName() + " " + e.getMessage());
			throw new ControllerException(ExceptionConstant.CONTROLLER + this.getClass().getSimpleName() + " " + e.getMessage());
		}
	}
}

package com.gold.gym.proj.controller.addgym;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gold.gym.proj.constant.exception.ExceptionConstant;
import com.gold.gym.proj.constant.pages.EnumPages;
import com.gold.gym.proj.constant.viewmessage.ViewMessage;
import com.gold.gym.proj.entity.gymentity.GymEntity;
import com.gold.gym.proj.exception.ControllerException;
import com.gold.gym.proj.exception.ServiceException;
import com.gold.gym.proj.service.addgym.AddGymService;

@Controller
@RequestMapping("*.do")
public class AddGymController {

	@Autowired
	private AddGymService addGymService;
	private static Logger logger = LoggerFactory.getLogger(AddGymController.class);
	@RequestMapping(value = "/addGym.do", method = RequestMethod.POST)
	public String addNewGym(GymEntity  gymEntity,HttpServletRequest request,Model model) throws ControllerException {
		try {
			HttpSession session = request.getSession();
			if (session != null && session.getAttribute(ViewMessage.GOLD_SESSION) != null) {
				addGymService.addGym(gymEntity);
				model.addAttribute(ViewMessage.MESSAGE,ViewMessage.GYM_ADDED);
				return EnumPages.AddGym.toString();
			}else {
				return EnumPages.Index.toString();
			}
		} catch (ServiceException e) {
			logger.error(ExceptionConstant.CONTROLLER + this.getClass().getSimpleName() + " " + e.getMessage());
			throw new ControllerException(ExceptionConstant.CONTROLLER + this.getClass().getSimpleName() + " " + e.getMessage());
		}catch (Exception e) {
			logger.error(ExceptionConstant.CONTROLLER + this.getClass().getSimpleName() + " " + e.getMessage());
			throw new ControllerException(ExceptionConstant.CONTROLLER + this.getClass().getSimpleName() + " " + e.getMessage());
		}		
	}
}

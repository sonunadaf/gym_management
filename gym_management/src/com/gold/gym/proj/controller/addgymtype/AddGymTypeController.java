package com.gold.gym.proj.controller.addgymtype;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gold.gym.proj.constant.exception.ExceptionConstant;
import com.gold.gym.proj.constant.pages.EnumPages;
import com.gold.gym.proj.constant.viewmessage.ViewMessage;
import com.gold.gym.proj.dto.gymtype.GymTypeDTO;
import com.gold.gym.proj.entity.gymentity.GymEntity;
import com.gold.gym.proj.exception.ControllerException;
import com.gold.gym.proj.exception.ServiceException;
import com.gold.gym.proj.service.addgymtype.AddGymTypeService;
import com.gold.gym.proj.service.getgym.GetGymService;

@Controller
@RequestMapping("*.do")
public class AddGymTypeController {

	@Autowired
	private AddGymTypeService addGymTypeService;
	@Autowired
	private GetGymService getGymService;
	private Set<GymTypeDTO> gymTypeList = new HashSet<GymTypeDTO>();
	private static Logger logger = LoggerFactory.getLogger(AddGymTypeController.class);

	@RequestMapping(value = "addGymType.do", method = RequestMethod.GET)
	public String addGymType(Model model,HttpServletRequest request) throws ControllerException {
		try {
		HttpSession session = request.getSession();
		if (session != null && session.getAttribute(ViewMessage.GOLD_SESSION) != null) {
			GymEntity gymEntity= (GymEntity) session.getAttribute(ViewMessage.GOLD_SESSION);
			GymEntity gymFronDb=getGymService.getGymEntity(gymEntity.getGymUserName());
			model.addAttribute("gymTypeList", gymFronDb.getGymTypeEntities());
			model.addAttribute("gymType", new GymTypeDTO());
			return EnumPages.AddGymType.toString();
		}else {
			return EnumPages.Index.toString();
		}
		}catch(Exception e) {
			logger.error(ExceptionConstant.CONTROLLER + this.getClass().getSimpleName() + " " + e.getMessage());
			throw new ControllerException(ExceptionConstant.CONTROLLER + this.getClass().getSimpleName() + " " + e.getMessage());
		}
		
	}

	@RequestMapping(value = "addGymType.do", method = RequestMethod.POST)
	public String addGymType(@Valid @ModelAttribute("gymTypeDTO") GymTypeDTO gymTypeDTO, HttpServletRequest request,
			BindingResult result, Model model) throws ControllerException {
		try {
			HttpSession session = request.getSession();
			if (session != null && session.getAttribute(ViewMessage.GOLD_SESSION) != null) {
				if (gymTypeDTO.getGymTypeName() != null && !gymTypeDTO.getGymTypeName().isEmpty()) {
					GymEntity gymEntity= (GymEntity) session.getAttribute(ViewMessage.GOLD_SESSION);
					addGymTypeService.addGymType(gymTypeDTO.getGymTypeName(),gymEntity);
					gymTypeList.add(gymTypeDTO);	
				}
				return "redirect:/addGymType.do";
			} else {
				return EnumPages.Index.toString();
			}
		}catch (ServiceException e) {
			logger.error(ExceptionConstant.CONTROLLER + this.getClass().getSimpleName() + " " + e.getMessage());
			throw new ControllerException(ExceptionConstant.CONTROLLER + this.getClass().getSimpleName() + " " + e.getMessage());
		} catch (Exception e) {
			logger.error(ExceptionConstant.CONTROLLER + this.getClass().getSimpleName() + " " + e.getMessage());
			throw new ControllerException(ExceptionConstant.CONTROLLER + this.getClass().getSimpleName() + " " + e.getMessage());
		}
	}

}

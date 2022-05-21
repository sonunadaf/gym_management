package com.gold.gym.proj.controller.addwtreport;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gold.gym.proj.constant.exception.ExceptionConstant;
import com.gold.gym.proj.constant.pages.EnumPages;
import com.gold.gym.proj.constant.viewmessage.ViewMessage;
import com.gold.gym.proj.dto.memberwt.MemberWtDTO;
import com.gold.gym.proj.entity.member.MemberEntity;
import com.gold.gym.proj.exception.ControllerException;
import com.gold.gym.proj.exception.ServiceException;
import com.gold.gym.proj.service.addweight.AddWtService;
import com.gold.gym.proj.service.getmember.GetMemberService;

@Controller
@RequestMapping("*.do")
public class AddWeightController {

	@Autowired
	private AddWtService addWtService;
	@Autowired
	private GetMemberService getMemberService;
	private static Logger logger = LoggerFactory.getLogger(AddWeightController.class);

	@RequestMapping(value = "/addWeight.do", method = RequestMethod.GET)
	public ModelAndView addWeight(@RequestParam int mId, HttpServletRequest request) throws ControllerException {
		try {
			HttpSession session = request.getSession();
			if (session != null && session.getAttribute(ViewMessage.GOLD_SESSION) != null) {
				MemberEntity memberEntity = getMemberService.getMemberEntity(mId);
				logger.info("Name from db " + memberEntity);
				MemberWtDTO memberWtDTO = new MemberWtDTO();
				memberWtDTO.setMid(mId);
				memberWtDTO.setMemberName(memberEntity.getFullName());
				return new ModelAndView(EnumPages.AddMemberWeight.toString(), "memberWt", memberWtDTO);
			} else {
				return new ModelAndView(EnumPages.Index.toString());
			}
		} catch (ServiceException e) {
			logger.error(ExceptionConstant.CONTROLLER + this.getClass().getSimpleName() + " " + e.getMessage());
			throw new ControllerException(
					ExceptionConstant.CONTROLLER + this.getClass().getSimpleName() + " " + e.getMessage());
		}
	}

	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

	@RequestMapping(value = "/addWeight.do", method = RequestMethod.POST)
	public String addWeight(@Valid @ModelAttribute("memberWt") MemberWtDTO memberWt, BindingResult result,
			HttpServletRequest request, Model model) throws ControllerException {
		try {
			HttpSession session = request.getSession();
			if (session != null && session.getAttribute(ViewMessage.GOLD_SESSION) != null) {
				logger.info("Data coming from jsp : " + memberWt.getMemberName());
				if (result.hasErrors()) {
					return EnumPages.AddMemberWeight.toString();
				}
				addWtService.addMemberWeight(memberWt);
				return "redirect:memberList.do";
			} else {
				return EnumPages.Index.toString();
			}
		} catch (ServiceException e) {
			logger.error(ExceptionConstant.CONTROLLER + this.getClass().getSimpleName() + " " + e.getMessage());
			throw new ControllerException(ExceptionConstant.CONTROLLER + this.getClass().getSimpleName() + " " + e.getMessage());
		}
	}

}

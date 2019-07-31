package com.gold.gym.proj.controller.weightlist;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gold.gym.proj.constant.exception.ExceptionConstant;
import com.gold.gym.proj.constant.pages.EnumPages;
import com.gold.gym.proj.constant.viewmessage.ViewMessage;
import com.gold.gym.proj.entity.member.MemberEntity;
import com.gold.gym.proj.entity.weight.WeightEntity;
import com.gold.gym.proj.exception.ControllerException;
import com.gold.gym.proj.exception.ServiceException;
import com.gold.gym.proj.service.getmember.GetMemberService;

@Controller
@RequestMapping("*.do")
public class GetWeightListController {

	@Autowired
	private GetMemberService getMemberService;
	private static Logger logger = LoggerFactory.getLogger(GetWeightListController.class);

	@RequestMapping("/getWtReport.do")
	public String getWeightList(@RequestParam int mId, HttpServletRequest request,Model model) throws ControllerException {
		try {
			HttpSession session = request.getSession();
			if (session != null && session.getAttribute(ViewMessage.GOLD_SESSION) != null) {
				MemberEntity memberEntity=getMemberService.getMemberEntity(mId);
				Set<WeightEntity> weightEntities=memberEntity.getWeightEntities();
				model.addAttribute("member",memberEntity);
				model.addAttribute("weightlist",weightEntities);
				return EnumPages.WeightList.toString();
			}else {
				return EnumPages.Index.toString();
			}
		} catch (ServiceException e) {
			logger.error(ExceptionConstant.CONTROLLER + this.getClass().getSimpleName() + " " + e.getMessage());
			throw new ControllerException(ExceptionConstant.CONTROLLER + this.getClass().getSimpleName() + " " + e.getMessage());
		}
	}
}

package com.gold.gym.proj.controller.memberlist;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gold.gym.proj.constant.exception.ExceptionConstant;
import com.gold.gym.proj.constant.pages.EnumPages;
import com.gold.gym.proj.constant.viewmessage.ViewMessage;
import com.gold.gym.proj.entity.gymentity.GymEntity;
import com.gold.gym.proj.entity.member.MemberEntity;
import com.gold.gym.proj.exception.ControllerException;

@Controller
@RequestMapping("*.do")
public class GetMemberListController {
	
	private static Logger logger = LoggerFactory.getLogger(GetMemberListController.class);

	@RequestMapping(value="memberList.do")
	public String getMemberList(HttpServletRequest request,Model model) throws ControllerException {
		
		try {
			HttpSession session = request.getSession();
			if (session != null && session.getAttribute(ViewMessage.GOLD_SESSION) != null) {
				GymEntity  gymEntity=(GymEntity) session.getAttribute(ViewMessage.GOLD_SESSION);
				Set<MemberEntity> memberEntities=gymEntity.getMemberEntities();
				model.addAttribute("memberEntities",memberEntities);
				logger.info("Member Entities list "+memberEntities+"");
				return EnumPages.MemberList.toString();
			} else {
				return EnumPages.Index.toString();
			}
		} catch (Exception e) {
			logger.error(ExceptionConstant.CONTROLLER + this.getClass().getSimpleName() + " " + e.getMessage());
			throw new ControllerException(ExceptionConstant.CONTROLLER + this.getClass().getSimpleName() + " " + e.getMessage());
		}
	}
}

package com.gold.gym.proj.service.getmember;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gold.gym.proj.constant.exception.ExceptionConstant;
import com.gold.gym.proj.dao.getmember.GetMemberDAO;
import com.gold.gym.proj.entity.member.MemberEntity;
import com.gold.gym.proj.exception.DAOException;
import com.gold.gym.proj.exception.ServiceException;

@Service
public class GetMemberServiceImpl implements GetMemberService{
	
	@Autowired
	private GetMemberDAO getMemberDAO;
	private static Logger logger = LoggerFactory.getLogger(GetMemberServiceImpl.class);

	@Override
	public MemberEntity getMemberEntity(int mid) throws ServiceException {
		MemberEntity memberEntity=null;
		try {
			memberEntity=getMemberDAO.getMemberEntity(mid);
		} catch (DAOException e) {
			logger.error(ExceptionConstant.SERVICE + this.getClass().getSimpleName() + " " + e.getMessage());
			throw new ServiceException(ExceptionConstant.SERVICE + this.getClass().getSimpleName() + " " + e.getMessage());
		}
		return memberEntity;
	}

}

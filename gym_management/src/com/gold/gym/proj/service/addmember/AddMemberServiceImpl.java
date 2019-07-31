package com.gold.gym.proj.service.addmember;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gold.gym.proj.constant.exception.ExceptionConstant;
import com.gold.gym.proj.dao.addmember.AddMemberDao;
import com.gold.gym.proj.entity.gymentity.GymEntity;
import com.gold.gym.proj.entity.member.MemberEntity;
import com.gold.gym.proj.exception.DAOException;
import com.gold.gym.proj.exception.ServiceException;

@Repository
public class AddMemberServiceImpl implements AddMemberService{
	
	@Autowired
	private AddMemberDao addMemberDao;
	private static Logger logger = LoggerFactory.getLogger(AddMemberServiceImpl.class);

	@Override
	public int addMember(GymEntity gymEntity, MemberEntity memberEntity) throws ServiceException {
		
		memberEntity.setGymEntity(gymEntity);
		try {
			addMemberDao.addMember(memberEntity);
		} catch (DAOException e) {
			logger.error(ExceptionConstant.SERVICE + this.getClass().getSimpleName() + " " + e.getMessage());
			throw new ServiceException(ExceptionConstant.SERVICE + this.getClass().getSimpleName() + " " + e.getMessage());
		}

		return 0;
	}

}

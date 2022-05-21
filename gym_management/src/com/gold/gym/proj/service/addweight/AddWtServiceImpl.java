package com.gold.gym.proj.service.addweight;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gold.gym.proj.constant.exception.ExceptionConstant;
import com.gold.gym.proj.dao.addweight.AddWtDAO;
import com.gold.gym.proj.dao.getmember.GetMemberDAO;
import com.gold.gym.proj.dto.memberwt.MemberWtDTO;
import com.gold.gym.proj.entity.member.MemberEntity;
import com.gold.gym.proj.entity.weight.WeightEntity;
import com.gold.gym.proj.exception.DAOException;
import com.gold.gym.proj.exception.ServiceException;

@Service
public class AddWtServiceImpl implements AddWtService {

	@Autowired
	private AddWtDAO addWtDAO;
	@Autowired
	private GetMemberDAO getMemberDAO;
	private static Logger logger = LoggerFactory.getLogger(AddWtServiceImpl.class);

	@Override
	public void addMemberWeight(MemberWtDTO memberWtDTO) throws ServiceException {
		
		try {
			WeightEntity weightEntity = new WeightEntity();
			weightEntity.setLastMonthWt(memberWtDTO.getCurrentWt());
			weightEntity.setLastWtDate(memberWtDTO.getWtDate());
			weightEntity.setMemberName(memberWtDTO.getMemberName());
			MemberEntity memberEntity=getMemberDAO.getMemberEntity(memberWtDTO.getMid());
			weightEntity.setMemberEntities(memberEntity);
			addWtDAO.addMemberWeight(weightEntity);
		} catch (DAOException e) {
			logger.error(ExceptionConstant.SERVICE + this.getClass().getSimpleName() + " " + e.getMessage());
			throw new ServiceException(ExceptionConstant.SERVICE + this.getClass().getSimpleName() + " " + e.getMessage());
		}

	}

}

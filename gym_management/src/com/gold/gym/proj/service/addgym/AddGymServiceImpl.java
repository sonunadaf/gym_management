package com.gold.gym.proj.service.addgym;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gold.gym.proj.constant.exception.ExceptionConstant;
import com.gold.gym.proj.dao.addGym.AddGymDao;
import com.gold.gym.proj.entity.gymentity.GymEntity;
import com.gold.gym.proj.exception.DAOException;
import com.gold.gym.proj.exception.ServiceException;

@Service
public class AddGymServiceImpl implements AddGymService{

	@Autowired
	private AddGymDao addGymDao;
	private static Logger logger = LoggerFactory.getLogger(AddGymServiceImpl.class);
	@Override
	public void addGym(GymEntity gymEntity) throws ServiceException {
		try {
			addGymDao.addGym(gymEntity);
		} catch (DAOException e) {
			logger.error(ExceptionConstant.SERVICE + this.getClass().getSimpleName() + " " + e.getMessage());
			throw new ServiceException(ExceptionConstant.SERVICE + this.getClass().getSimpleName() + " " + e.getMessage());
		} catch (Exception e) {
			logger.error(ExceptionConstant.SERVICE + this.getClass().getSimpleName() + " " + e.getMessage());
			throw new ServiceException(ExceptionConstant.SERVICE + this.getClass().getSimpleName() + " " + e.getMessage());
		}
		
	}
}

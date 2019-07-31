package com.gold.gym.proj.service.getgym;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gold.gym.proj.constant.exception.ExceptionConstant;
import com.gold.gym.proj.dao.getGym.GetGymDao;
import com.gold.gym.proj.entity.gymentity.GymEntity;
import com.gold.gym.proj.exception.DAOException;
import com.gold.gym.proj.exception.ServiceException;

@Service
public class GetGymServiceImpl implements GetGymService {

	@Autowired
	private GetGymDao getGymDao;
	private static Logger logger = LoggerFactory.getLogger(GetGymServiceImpl.class);

	@Override
	public GymEntity getGymEntity(String userName, String password) throws ServiceException {
		GymEntity gymFromDb;
		try {
			gymFromDb = getGymDao.getGymEntity(userName, password);
		} catch (DAOException e) {
			logger.error(ExceptionConstant.SERVICE + this.getClass().getSimpleName() + " " + e.getMessage());
			throw new ServiceException(ExceptionConstant.SERVICE + this.getClass().getSimpleName() + " " + e.getMessage());
		}catch (Exception e) {
			logger.error(ExceptionConstant.SERVICE + this.getClass().getSimpleName() + " " + e.getMessage());
			throw new ServiceException(ExceptionConstant.SERVICE + this.getClass().getSimpleName() + " " + e.getMessage());
		}
		return gymFromDb;
	}

}

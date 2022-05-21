package com.gold.gym.proj.service.addgymtype;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gold.gym.proj.constant.exception.ExceptionConstant;
import com.gold.gym.proj.dao.addgymtype.AddGymTypeDAO;
import com.gold.gym.proj.entity.gymentity.GymEntity;
import com.gold.gym.proj.entity.gymtypelist.GymTypeEntity;
import com.gold.gym.proj.exception.DAOException;
import com.gold.gym.proj.exception.ServiceException;

@Service
public class AddGymTypeServiceImpl implements AddGymTypeService {

	@Autowired
	private AddGymTypeDAO addGymTypeDAO;
	private static Logger logger = LoggerFactory.getLogger(AddGymTypeServiceImpl.class);

	@Override
	public void addGymType(String gymTypeName, GymEntity gymEntity) throws ServiceException {
		try {
			GymTypeEntity gymTypeEntity = new GymTypeEntity();
			gymTypeEntity.setGymTypeName(gymTypeName);
			gymTypeEntity.setGymEntity(gymEntity);
			addGymTypeDAO.addGymType(gymTypeEntity);
		} catch (DAOException e) {
			logger.error(ExceptionConstant.SERVICE + this.getClass().getSimpleName() + " " + e.getMessage());
			throw new ServiceException(
					ExceptionConstant.SERVICE + this.getClass().getSimpleName() + " " + e.getMessage());
		}catch (Exception e) {
			logger.error(ExceptionConstant.SERVICE + this.getClass().getSimpleName() + " " + e.getMessage());
			throw new ServiceException(
					ExceptionConstant.SERVICE + this.getClass().getSimpleName() + " " + e.getMessage());
		}

	}
}

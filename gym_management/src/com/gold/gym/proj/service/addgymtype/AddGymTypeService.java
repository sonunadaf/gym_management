package com.gold.gym.proj.service.addgymtype;

import com.gold.gym.proj.entity.gymentity.GymEntity;
import com.gold.gym.proj.exception.ServiceException;

public interface AddGymTypeService {
	
	public void addGymType(String gymTypeName,GymEntity gymEntity)throws ServiceException;
	
}

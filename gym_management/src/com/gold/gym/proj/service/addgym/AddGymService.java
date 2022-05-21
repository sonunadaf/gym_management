package com.gold.gym.proj.service.addgym;

import com.gold.gym.proj.entity.gymentity.GymEntity;
import com.gold.gym.proj.exception.ServiceException;

public interface AddGymService {

	public void addGym(GymEntity gymEntity) throws ServiceException;
	
}

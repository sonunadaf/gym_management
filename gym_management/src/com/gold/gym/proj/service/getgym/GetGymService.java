package com.gold.gym.proj.service.getgym;

import com.gold.gym.proj.entity.gymentity.GymEntity;
import com.gold.gym.proj.exception.ServiceException;

public interface GetGymService {

	public GymEntity getGymEntity(String userName,String password) throws ServiceException;
}

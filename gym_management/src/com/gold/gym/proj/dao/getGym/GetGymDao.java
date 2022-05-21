package com.gold.gym.proj.dao.getGym;

import com.gold.gym.proj.entity.gymentity.GymEntity;
import com.gold.gym.proj.exception.DAOException;

public interface GetGymDao {
	public GymEntity getGymEntity(String userName,String password) throws DAOException;
	public GymEntity getGymEntity(String userName) throws DAOException;
}

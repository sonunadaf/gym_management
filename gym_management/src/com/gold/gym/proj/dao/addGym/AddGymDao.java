package com.gold.gym.proj.dao.addGym;

import com.gold.gym.proj.entity.gymentity.GymEntity;
import com.gold.gym.proj.exception.DAOException;

public interface AddGymDao {

	public void addGym(GymEntity gymEntity) throws DAOException;

}

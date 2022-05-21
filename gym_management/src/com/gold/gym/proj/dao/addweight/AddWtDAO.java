package com.gold.gym.proj.dao.addweight;

import com.gold.gym.proj.entity.weight.WeightEntity;
import com.gold.gym.proj.exception.DAOException;

public interface AddWtDAO {
	
	public void addMemberWeight(WeightEntity weightEntity) throws DAOException;

}

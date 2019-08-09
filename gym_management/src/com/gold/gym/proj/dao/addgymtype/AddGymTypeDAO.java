package com.gold.gym.proj.dao.addgymtype;

import com.gold.gym.proj.entity.gymtypelist.GymTypeEntity;
import com.gold.gym.proj.exception.DAOException;

public interface AddGymTypeDAO {
	
	public void addGymType(GymTypeEntity gymTypeEntity) throws DAOException;

}

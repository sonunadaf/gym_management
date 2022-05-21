package com.gold.gym.proj.dao.addGym;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gold.gym.proj.constant.exception.ExceptionConstant;
import com.gold.gym.proj.entity.gymentity.GymEntity;
import com.gold.gym.proj.exception.DAOException;

@Repository
public class AddGymDaoImpl implements AddGymDao {

	@Autowired
	private SessionFactory sessionFactory;
	private static Logger logger = LoggerFactory.getLogger(AddGymDaoImpl.class);
	
	@Override
	public void addGym(GymEntity gymEntity) throws DAOException {
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.save(gymEntity);
			transaction.commit();
		} catch (HibernateException e) {
			logger.error(ExceptionConstant.DAO + this.getClass().getSimpleName() + " " + e.getMessage());
			throw new DAOException(ExceptionConstant.DAO + this.getClass().getSimpleName() + " " + e.getMessage());
		}

	}

}

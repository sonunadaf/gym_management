package com.gold.gym.proj.dao.getGym;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gold.gym.proj.constant.exception.ExceptionConstant;
import com.gold.gym.proj.entity.gymentity.GymEntity;
import com.gold.gym.proj.exception.DAOException;

@Repository
public class GetGymDaoImpl implements GetGymDao{

	@Autowired
	private SessionFactory sessionFactory;
	private static Logger logger = LoggerFactory.getLogger(GetGymDaoImpl.class);
	@Override
	public GymEntity getGymEntity(String userName, String password) throws DAOException {
		Session session=null;
		GymEntity gymFromDb=null;
		try {
			String hql="from GymEntity where gymUserName=:un and gymPassword=:gp";
			session=sessionFactory.openSession();
			Query query=session.createQuery(hql);
			query.setParameter("un", userName);
			query.setParameter("gp", password);
			gymFromDb= (GymEntity) query.uniqueResult();
		} catch (HibernateException e) {
			logger.error(ExceptionConstant.DAO + this.getClass().getSimpleName() + " " + e.getMessage());
			throw new DAOException(ExceptionConstant.DAO + this.getClass().getSimpleName() + " " + e.getMessage());
		}catch (Exception e) {
			logger.error(ExceptionConstant.DAO + this.getClass().getSimpleName() + " " + e.getMessage());
			throw new DAOException(ExceptionConstant.DAO + this.getClass().getSimpleName() + " " + e.getMessage());
		}
		return gymFromDb;
	}
	@Override
	public GymEntity getGymEntity(String userName) throws DAOException {
		Session session=null;
		GymEntity gymFromDb=null;
		try {
			String hql="from GymEntity where gymUserName=:un";
			session=sessionFactory.openSession();
			Query query=session.createQuery(hql);
			query.setParameter("un", userName);
			gymFromDb= (GymEntity) query.uniqueResult();
		} catch (HibernateException e) {
			logger.error(ExceptionConstant.DAO + this.getClass().getSimpleName() + " " + e.getMessage());
			throw new DAOException(ExceptionConstant.DAO + this.getClass().getSimpleName() + " " + e.getMessage());
		}catch (Exception e) {
			logger.error(ExceptionConstant.DAO + this.getClass().getSimpleName() + " " + e.getMessage());
			throw new DAOException(ExceptionConstant.DAO + this.getClass().getSimpleName() + " " + e.getMessage());
		}
		return gymFromDb;
	}

}

package com.gold.gym.proj.dao.addmember;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gold.gym.proj.constant.exception.ExceptionConstant;
import com.gold.gym.proj.entity.member.MemberEntity;
import com.gold.gym.proj.exception.DAOException;

@Repository
public class AddMemberDaoImpl implements AddMemberDao {

	@Autowired
	private SessionFactory sessionFactory;
	private static Logger logger = LoggerFactory.getLogger(AddMemberDaoImpl.class);
	@Override
	public int addMember(MemberEntity memberEntity) throws DAOException {
		int id = 0;

		try {
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			id = (int) session.save(memberEntity);
			transaction.commit();
		} catch (HibernateException e) {
			logger.error(ExceptionConstant.DAO + this.getClass().getSimpleName() + " " + e.getMessage());
			throw new DAOException(ExceptionConstant.DAO + this.getClass().getSimpleName() + " " + e.getMessage());
		}

		return id;
	}

}

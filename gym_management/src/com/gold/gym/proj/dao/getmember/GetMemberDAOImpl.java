package com.gold.gym.proj.dao.getmember;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gold.gym.proj.constant.exception.ExceptionConstant;
import com.gold.gym.proj.entity.member.MemberEntity;
import com.gold.gym.proj.exception.DAOException;

@Repository
public class GetMemberDAOImpl implements GetMemberDAO {

	private static Logger logger = LoggerFactory.getLogger(GetMemberDAOImpl.class);
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public MemberEntity getMemberEntity(int mid) throws DAOException {
		Session session = null;
		MemberEntity memberEntity = null;

		try {
			String hql = "from MemberEntity where mId=:id";
			session = sessionFactory.openSession();
			Query query = session.createQuery(hql);
			query.setParameter("id", mid);
			memberEntity = (MemberEntity) query.uniqueResult();
		} catch (HibernateException e) {
			logger.error(ExceptionConstant.DAO + this.getClass().getSimpleName() + " " + e.getMessage());
			throw new DAOException(ExceptionConstant.DAO + this.getClass().getSimpleName() + " " + e.getMessage());
		}
		return memberEntity;
	}

}

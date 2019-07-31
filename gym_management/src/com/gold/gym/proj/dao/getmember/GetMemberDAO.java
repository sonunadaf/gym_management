package com.gold.gym.proj.dao.getmember;

import com.gold.gym.proj.entity.member.MemberEntity;
import com.gold.gym.proj.exception.DAOException;

public interface GetMemberDAO {

	public MemberEntity getMemberEntity(int mid) throws DAOException;
	
}

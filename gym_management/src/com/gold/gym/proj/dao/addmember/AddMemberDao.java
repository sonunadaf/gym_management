package com.gold.gym.proj.dao.addmember;

import com.gold.gym.proj.entity.member.MemberEntity;
import com.gold.gym.proj.exception.DAOException;

public interface AddMemberDao {
	
	public int addMember(MemberEntity memberEntity) throws DAOException; 

}

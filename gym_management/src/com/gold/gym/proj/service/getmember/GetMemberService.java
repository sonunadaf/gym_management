package com.gold.gym.proj.service.getmember;

import com.gold.gym.proj.entity.member.MemberEntity;
import com.gold.gym.proj.exception.ServiceException;

public interface GetMemberService {

	public MemberEntity getMemberEntity(int mid) throws ServiceException;
	
}

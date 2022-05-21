package com.gold.gym.proj.service.addmember;

import com.gold.gym.proj.entity.gymentity.GymEntity;
import com.gold.gym.proj.entity.member.MemberEntity;
import com.gold.gym.proj.exception.ServiceException;

public interface AddMemberService {

	public int addMember(GymEntity gymEntity, MemberEntity memberEntity) throws ServiceException;

}

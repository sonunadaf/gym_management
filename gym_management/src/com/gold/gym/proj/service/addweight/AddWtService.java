package com.gold.gym.proj.service.addweight;

import com.gold.gym.proj.dto.memberwt.MemberWtDTO;
import com.gold.gym.proj.exception.ServiceException;

public interface AddWtService {
	
	public void addMemberWeight(MemberWtDTO memberWtDTO) throws ServiceException;

}

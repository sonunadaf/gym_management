package com.gold.gym.proj.dto.gymtype;

import org.springframework.stereotype.Component;

@Component
public class GymTypeDTO {

	//@NotEmpty(message = "Name must not be empty")
	private String gymTypeName;

	public String getGymTypeName() {
		return gymTypeName;
	}

	public void setGymTypeName(String gymTypeName) {
		this.gymTypeName = gymTypeName;
	}

}

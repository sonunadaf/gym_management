package com.gold.gym.proj.entity.gymtypelist;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.gold.gym.proj.entity.gymentity.GymEntity;

@Entity
@Table(name = "gym_type_list")
public class GymTypeEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GenericGenerator(name = "auto", strategy = "increment")
	@GeneratedValue(generator = "auto")
	@Column(name = "GYM_TYPE_ID")
	private int gymTypeId;
	@Column(name = "TYPE_NAME")
	private String gymTypeName;
	@ManyToOne
	@JoinColumn(name = "GYM_ID")
	private GymEntity gymEntity;
	
	public GymEntity getGymEntity() {
		return gymEntity;
	}

	public void setGymEntity(GymEntity gymEntity) {
		this.gymEntity = gymEntity;
	}

	public int getGymTypeId() {
		return gymTypeId;
	}

	public void setGymTypeId(int gymTypeId) {
		this.gymTypeId = gymTypeId;
	}

	public String getGymTypeName() {
		return gymTypeName;
	}

	public void setGymTypeName(String gymTypeName) {
		this.gymTypeName = gymTypeName;
	}

}

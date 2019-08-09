package com.gold.gym.proj.entity.gymplan;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.gold.gym.proj.entity.gymtypelist.GymTypeEntity;

@Entity
@Table(name = "gym_plan")
public class GymPlanEntity {

	@Id
	@GenericGenerator(name = "auto", strategy = "increment")
	@GeneratedValue(generator = "auto")
	@Column(name="PLAN_ID")
	private int planId;
	@Column(name="PLAN_NAME")
	private String planeName;
	@Column(name="PLAN_PRICE")
	private int planPrice;

	@ManyToOne
	@JoinColumn(name = "GYM_TYPE_ID")
	private GymTypeEntity gymTypeEntity;

	public int getPlanId() {
		return planId;
	}

	public void setPlanId(int planId) {
		this.planId = planId;
	}

	public String getPlaneName() {
		return planeName;
	}

	public void setPlaneName(String planeName) {
		this.planeName = planeName;
	}

	public int getPlanPrice() {
		return planPrice;
	}

	public void setPlanPrice(int planPrice) {
		this.planPrice = planPrice;
	}

	public GymTypeEntity getGymTypeEntity() {
		return gymTypeEntity;
	}

	public void setGymTypeEntity(GymTypeEntity gymTypeEntity) {
		this.gymTypeEntity = gymTypeEntity;
	}
	
	

}

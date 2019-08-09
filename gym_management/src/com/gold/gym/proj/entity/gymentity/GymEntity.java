package com.gold.gym.proj.entity.gymentity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.gold.gym.proj.entity.gymtypelist.GymTypeEntity;
import com.gold.gym.proj.entity.member.MemberEntity;

@Entity
@Table(name = "gym_details")
public class GymEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GenericGenerator(name = "auto", strategy = "increment")
	@GeneratedValue(generator = "auto")
	@Column(name="GYM_ID")
	private int gymId;
	@Column(name="GYM_NAME")
	private String gymName;
	@Column(name="GYM_LOCATION")
	private String gymLocation;
	@Column(name="GYM_USER_NAME")
	private String gymUserName;
	@Column(name="GYM_PASSWORD")
	private String gymPassword;
	@OneToMany(mappedBy = "gymEntity")
	private Set<MemberEntity> memberEntities;
	public Set<GymTypeEntity> getGymTypeEntities() {
		return gymTypeEntities;
	}
	public void setGymTypeEntities(Set<GymTypeEntity> gymTypeEntities) {
		this.gymTypeEntities = gymTypeEntities;
	}
	@OneToMany(mappedBy = "gymEntity")
	private Set<GymTypeEntity> gymTypeEntities;
	
	public int getGymId() {
		return gymId;
	}
	public void setGymId(int gymId) {
		this.gymId = gymId;
	}
	public String getGymName() {
		return gymName;
	}
	public void setGymName(String gymName) {
		this.gymName = gymName;
	}
	public String getGymLocation() {
		return gymLocation;
	}
	public void setGymLocation(String gymLocation) {
		this.gymLocation = gymLocation;
	}
	public String getGymUserName() {
		return gymUserName;
	}
	public void setGymUserName(String gymUserName) {
		this.gymUserName = gymUserName;
	}
	public String getGymPassword() {
		return gymPassword;
	}
	public void setGymPassword(String gymPassword) {
		this.gymPassword = gymPassword;
	}
	public Set<MemberEntity> getMemberEntities() {
		return memberEntities;
	}
	public void setMemberEntities(Set<MemberEntity> memberEntities) {
		this.memberEntities = memberEntities;
	}
	
}

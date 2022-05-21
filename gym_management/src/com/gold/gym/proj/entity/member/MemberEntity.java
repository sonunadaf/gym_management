package com.gold.gym.proj.entity.member;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.gold.gym.proj.entity.gymentity.GymEntity;
import com.gold.gym.proj.entity.monthlywt.MonthlyWtEntity;
import com.gold.gym.proj.entity.weight.WeightEntity;

@Entity
@Table(name = "Member")
public class MemberEntity implements Serializable {

	private static final long serialVersionUID = -4338939159356419444L;
	@Id
	@GenericGenerator(name = "auto", strategy = "increment")
	@GeneratedValue(generator = "auto")
	@Column(name = "MEMBER_ID")
	private int mId;
	@Column(name = "NAME")
	private String fullName;
	@Column(name = "CONTACTS")
	public long contacts;
	@Column(name = "EMAIL")
	public String emailId;
	@Column(name = "JOINING_DATE")
	private Date joiningDate;
	@Column(name = "CURRENT_WEIGHT")
	private double currentWt;
	@Column(name = "FITNESS_PLAN")
	private String fitnessPlan;
	@ManyToOne
	@JoinColumn(name = "GYM_ID")
	private GymEntity gymEntity;
	@OneToMany(mappedBy = "memberEntity")
	private Set<MonthlyWtEntity> monthlyWtList;
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "memberEntities",cascade = CascadeType.ALL)
	private Set<WeightEntity> weightEntities=new HashSet<WeightEntity>();
	

	public Set<MonthlyWtEntity> getMonthlyWtList() {
		return monthlyWtList;
	}

	public void setMonthlyWtList(Set<MonthlyWtEntity> monthlyWtList) {
		this.monthlyWtList = monthlyWtList;
	}

	public int getmId() {
		return mId;
	}

	public void setmId(int mId) {
		this.mId = mId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public long getContacts() {
		return contacts;
	}

	public void setContacts(long contacts) {
		this.contacts = contacts;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Date getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}

	public double getCurrentWt() {
		return currentWt;
	}

	public void setCurrentWt(double currentWt) {
		this.currentWt = currentWt;
	}

	public String getFitnessPlan() {
		return fitnessPlan;
	}

	public void setFitnessPlan(String fitnessPlan) {
		this.fitnessPlan = fitnessPlan;
	}

	public GymEntity getGymEntity() {
		return gymEntity;
	}

	public void setGymEntity(GymEntity gymEntity) {
		this.gymEntity = gymEntity;
	}

	public Set<WeightEntity> getWeightEntities() {
		return weightEntities;
	}

	public void setWeightEntities(Set<WeightEntity> weightEntities) {
		this.weightEntities = weightEntities;
	}
	

}

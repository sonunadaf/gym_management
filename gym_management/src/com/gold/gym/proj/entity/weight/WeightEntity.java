package com.gold.gym.proj.entity.weight;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.gold.gym.proj.entity.member.MemberEntity;

@Entity
@Table(name = "member_weight_entity")
public class WeightEntity {

	@Id
	@GenericGenerator(name = "auto", strategy = "increment")
	@GeneratedValue(generator = "auto")
	@Column(name = "WEIGHT_ID")
	private int wId;
	@Column(name = "MEMBER_NAME")
	private String memberName;
	@Column(name = "LAST_WEIGHT_DATE")
	private Date lastWtDate;
	@Column(name = "LAST_WEIGHT")
	private String lastMonthWt;
	@ManyToOne
	@JoinColumn(name = "MEMBER_ID")
	private MemberEntity memberEntities;

	public int getwId() {
		return wId;
	}

	public void setwId(int wId) {
		this.wId = wId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public Date getLastWtDate() {
		return lastWtDate;
	}

	public void setLastWtDate(Date lastWtDate) {
		this.lastWtDate = lastWtDate;
	}

	public String getLastMonthWt() {
		return lastMonthWt;
	}

	public void setLastMonthWt(String lastMonthWt) {
		this.lastMonthWt = lastMonthWt;
	}

	public MemberEntity getMemberEntities() {
		return memberEntities;
	}

	public void setMemberEntities(MemberEntity memberEntities) {
		this.memberEntities = memberEntities;
	}
}

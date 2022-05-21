package com.gold.gym.proj.entity.monthlywt;

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
@Table(name = "member_monthly_wt_report")
public class MonthlyWtEntity {
	
	@Id
	@GenericGenerator(name = "auto", strategy = "increment")
	@GeneratedValue(generator = "auto")
	@Column(name = "WT_ID")
	private int wtId;
	@Column(name = "MONTH")
	private String month;
	@Column(name = "CURRENT_WT")
	private int currentWt;
	@Column(name = "WORK_OUT_DURATION")
	private String workOutDuration;
	@ManyToOne
	@JoinColumn(name = "MEMBER_ID")
	private MemberEntity memberEntity;

	public MemberEntity getMemberEntity() {
		return memberEntity;
	}

	public void setMemberEntity(MemberEntity memberEntity) {
		this.memberEntity = memberEntity;
	}

	public int getWtId() {
		return wtId;
	}

	public void setWtId(int wtId) {
		this.wtId = wtId;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public int getCurrentWt() {
		return currentWt;
	}

	public void setCurrentWt(int currentWt) {
		this.currentWt = currentWt;
	}

	public String getWorkOutDuration() {
		return workOutDuration;
	}

	public void setWorkOutDuration(String workOutDuration) {
		this.workOutDuration = workOutDuration;
	}
}

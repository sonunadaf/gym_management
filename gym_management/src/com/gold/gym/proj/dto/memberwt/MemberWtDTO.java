package com.gold.gym.proj.dto.memberwt;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;


@Component
public class MemberWtDTO {
	
	@NotEmpty(message = "Name must not be empty")
	//@Size(min=6, max=10, message="Member Name Should Not Be Empty")
	private String memberName;
	private int mid;
	private String lastMonthWt;
	@NotEmpty(message = "Enter Current Weight")
	private String currentWt;
	@NotNull(message = "Choose date")
	private Date wtDate;
	
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getLastMonthWt() {
		return lastMonthWt;
	}
	public void setLastMonthWt(String lastMonthWt) {
		this.lastMonthWt = lastMonthWt;
	}
	public String getCurrentWt() {
		return currentWt;
	}
	public void setCurrentWt(String currentWt) {
		this.currentWt = currentWt;
	}
	public Date getWtDate() {
		return wtDate;
	}
	public void setWtDate(Date wtDate) {
		this.wtDate = wtDate;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	
}

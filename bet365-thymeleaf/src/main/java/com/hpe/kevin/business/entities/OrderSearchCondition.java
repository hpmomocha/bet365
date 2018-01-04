package com.hpe.kevin.business.entities;

public class OrderSearchCondition {
	// 投注类型ID
	private String betTypeId;
	
	// 投注球队名称
	private String teamName;

	public OrderSearchCondition() {
		super();
	}

	public String getBetTypeId() {
		return betTypeId;
	}

	public void setBetTypeId(String betTypeId) {
		this.betTypeId = betTypeId;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	
	
}

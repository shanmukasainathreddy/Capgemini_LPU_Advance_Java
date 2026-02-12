package com.practice;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class IPL {
	@Id
	private int team_id;
	private String team_name;
	private int matches;
	private int win;
	private int lose;  
	private double net_run_rate;
	public int getTeam_id() {
		return team_id;
	}
	public void setTeam_id(int team_id) {
		this.team_id = team_id;
	}
	public String getTeam_name() {
		return team_name;
	}
	public void setTeam_name(String team_name) {
		this.team_name = team_name;
	}
	public int getMatches() {
		return matches;
	}
	public void setMatches(int matches) {
		this.matches = matches;
	}
	public int getWin() {
		return win;
	}
	public void setWin(int win) {
		this.win = win;
	}
	public int getLose() {
		return lose;
	}
	public void setLose(int lose) {
		this.lose = lose;
	}
	public double getNet_run_rate() {
		return net_run_rate;
	}
	public void setNet_run_rate(double net_run_rate) {
		this.net_run_rate = net_run_rate;
	}
}


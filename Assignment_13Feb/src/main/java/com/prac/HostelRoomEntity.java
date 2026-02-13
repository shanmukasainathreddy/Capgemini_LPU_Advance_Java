package com.prac;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class HostelRoomEntity {
	@Id
	private int roomid;
	private int roomnumber;
	private String blockname;
	private int floornumber;
	
	
	public int getRoomid() {
		return roomid;
	}
	public void setRoomid(int roomid) {
		this.roomid = roomid;
	}
	public int getRoomnumber() {
		return roomnumber;
	}
	public void setRoomnumber(int roomnumber) {
		this.roomnumber = roomnumber;
	}
	public String getBlockname() {
		return blockname;
	}
	public void setBlockname(String blockname) {
		this.blockname = blockname;
	}
	public int getFloornumber() {
		return floornumber;
	}
	public void setFloornumber(int floornumber) {
		this.floornumber = floornumber;
	}
	
	
	@Override
	public String toString() {
		return "HostelRoomEntity [roomid=" + roomid + ", roomnumber=" + roomnumber + ", blockname=" + blockname
				+ ", floornumber=" + floornumber + "]";
	}
	
	
	
	
}

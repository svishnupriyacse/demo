package com.niit.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "Comment")
@Component
public class Comment {
	
	@Id
	@Column(name="serialNo")
	@GeneratedValue
	private String serialNo;
	
	private String eventId;
	private String userId;
	private String commends;
	public String getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}
	public String getEventId() {
		return eventId;
	}
	public void setEventId(String eventId) {
		this.eventId = eventId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getCommends() {
		return commends;
	}
	public void setCommends(String commends) {
		this.commends = commends;
	}

	
	
	
	
}

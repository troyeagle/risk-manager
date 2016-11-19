package com.padeoe.pojo;

import java.util.Date;

public class Notification {
	private Integer id;
	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
	private String title;
	public String getTitle() { return title; }
	public void setTitle(String title) { this.title = title; }
	
	private String fromUser;
	public String getFromUser() { return fromUser; }
	public void setFromUser(String user) { this.fromUser = user; }
	
	private String toUser;
	public String getToUser() { return toUser; }
	public void setToUser(String user) { this.toUser = user; }
	
	private Integer riskOperation;
	public Integer getRiskOperationId() { return this.riskOperation; }
	public void setRiskOperationId(Integer id) { this.riskOperation = id; }
	
	private Date time;
	public Date getTime() { return this.time; }
	public void setTime(Date time) { this.time = time; }
	
	private String content;
	public String getContent() { return this.content; }
	public void setContent(String content) { this.content = content; }
	
	private Integer read;
	public Integer getRead() {	return this.read; }
	public void setRead(Integer read) { this.read = read; }
}

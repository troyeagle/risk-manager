package com.padeoe.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.padeoe.pojo.Notification;

@Component
public interface INotificationDao {
	public Integer createNotification(Notification notification);
	
	public List<Notification> searchNotification(Notification notification);
	
	public List<Notification> getContent(Integer id);
	
	public Integer markRead(Integer id);
}

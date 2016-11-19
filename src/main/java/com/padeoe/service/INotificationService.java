package com.padeoe.service;

import java.util.List;

import com.padeoe.pojo.Notification;

public interface INotificationService {
	public void notify(Notification notification);
	
	public List<Notification> listNotification(String username);
	
	public Notification openNotification(int notificationId);
}

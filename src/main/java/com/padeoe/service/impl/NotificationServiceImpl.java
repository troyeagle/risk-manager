package com.padeoe.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.padeoe.dao.INotificationDao;
import com.padeoe.pojo.Notification;
import com.padeoe.service.INotificationService;

@Service("notificationService")
public class NotificationServiceImpl implements INotificationService {
	@Resource INotificationDao notificationDao;
	
	@Override
	public void notify(Notification notification) {
		notificationDao.createNotification(notification);
	}

	@Override
	public List<Notification> listNotification(String username) {
		Notification note = new Notification();
		note.setToUser(username);
		return notificationDao.searchNotification(note);
	}

	@Override
	public Notification openNotification(int notificationId) {
		notificationDao.markRead(notificationId);
		List<Notification> result = notificationDao.getContent(notificationId);
		if(result.isEmpty()) return null;
		return result.get(0);
	}
}

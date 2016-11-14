package com.padeoe.service;


import com.padeoe.pojo.Risk;
import com.padeoe.pojo.User;

public interface IRiskService {
	public User getRiskById(int userId);
	public User getRiskByUser(User user);
	public void saveRisk(Risk risk);
	public void deleteRisk(Risk risk);
	public void changeRisk(Risk risk);
	public void searchRisk(Risk risk);
}

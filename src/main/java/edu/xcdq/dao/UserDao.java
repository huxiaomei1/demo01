package edu.xcdq.dao;

import edu.xcdq.bean.User;

import java.util.List;


public interface UserDao {
	//Ôö
	public boolean add(User news);
	//É¾
	public boolean delete(User news);
	//¸Ä
	public void update(User news);
	//²é
	public List<User> getNewsList();


	User getNewsById(int id);


}

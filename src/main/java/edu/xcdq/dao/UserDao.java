package edu.xcdq.dao;

import edu.xcdq.bean.User;

import java.util.List;


public interface UserDao {
	//��
	public boolean add(User news);
	//ɾ
	public boolean delete(User news);
	//��
	public void update(User news);
	//��
	public List<User> getNewsList();


	User getNewsById(int id);


}

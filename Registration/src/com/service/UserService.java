package com.service;

import com.bean.UserBean;
import com.dao.UserDao;

public class UserService {
UserDao userDAO = new UserDao();
public boolean insertUserService(UserBean userBn) {
	boolean status =userDAO.insertUser(userBn);
	return status;
}
public boolean getUserService(UserBean userBn) {
	boolean userFound =userDAO.getUser(userBn);
	return userFound;
}
}

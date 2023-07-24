package com.Service;

import com.Dao.UserDao;
import com.user.UserDTO;

public class UserService {
	private UserDao dao;

	public UserService() {
		dao = new UserDao();
	}

	public boolean createuser(UserDTO user) {
		return UserDao.createuser(user);
	}

	public UserDTO getUser(String email,String pwd) {
		
		return UserDao.getUser(email, pwd);
	}



}

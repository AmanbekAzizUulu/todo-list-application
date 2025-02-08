package com.dandaevit.edu.service.user_service;

import java.util.List;

import com.dandaevit.edu.model.User;
import com.dandaevit.edu.service.Service;

public interface UserService extends Service<User, Integer> {
	List<User> getUserById(Integer userId);
}

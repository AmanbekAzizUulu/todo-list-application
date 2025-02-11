package com.dandaevit.edu.service.user_task_service;

import com.dandaevit.edu.model.User;
import com.dandaevit.edu.service.Service;

public interface UserTaskService extends Service<User, Integer>{
	void addTask(Integer taskId, Integer userId);
}

package com.dandaevit.edu.dao.user_task_dao;

import com.dandaevit.edu.dao.DAO;
import com.dandaevit.edu.model.UserTasks;

public interface UserTaskDAO extends DAO<UserTasks, Integer> {
	void addTask(Integer taskId, Integer userId);
}

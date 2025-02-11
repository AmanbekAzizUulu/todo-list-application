package com.dandaevit.edu.dao.dao_factory;

import com.dandaevit.edu.dao.task_dao.TaskDAOImplementation;
import com.dandaevit.edu.dao.user_dao.UserDAOImplementation;
import com.dandaevit.edu.dao.user_task_dao.UserTaskDAOImplementation;

public class DAOFactory {

	public static UserDAOImplementation getUserDAO() {
		return UserDAOImplementation.getInstance();
	}

	public static TaskDAOImplementation getTaskDAO() {
		return TaskDAOImplementation.getInstance();
	}

	public static UserTaskDAOImplementation getUserTaskDAO(){
		return UserTaskDAOImplementation.getInstance();
	}
}

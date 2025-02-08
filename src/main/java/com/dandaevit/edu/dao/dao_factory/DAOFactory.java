package com.dandaevit.edu.dao.dao_factory;

import com.dandaevit.edu.dao.task_dao.TaskDAOImplementation;
import com.dandaevit.edu.dao.user_dao.UserDAOImplementation;

public class DAOFactory {

	public static UserDAOImplementation getTicketDAO() {
		return UserDAOImplementation.getInstance();
	}

	public static TaskDAOImplementation getFlightDAO() {
		return TaskDAOImplementation.getInstance();
	}

}

package com.dandaevit.edu.dao.task_dao;

import com.dandaevit.edu.dao.DAO;
import com.dandaevit.edu.model.task.Task;

public interface TaskDAO extends DAO<Task, Integer>{
	boolean existsById(Integer taskId);
}

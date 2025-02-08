package com.dandaevit.edu.service.task_service;

import java.util.List;

import com.dandaevit.edu.model.task.Task;
import com.dandaevit.edu.service.Service;

public interface TaskService extends Service<Task, Integer> {
	List<Task> getTasksByUserId(Integer userId);
	void addTask(Task task, Integer userId);
}

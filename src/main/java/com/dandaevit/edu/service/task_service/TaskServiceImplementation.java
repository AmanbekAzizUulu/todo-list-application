package com.dandaevit.edu.service.task_service;

import java.util.List;
import java.util.Optional;

import com.dandaevit.edu.dao.dao_factory.DAOFactory;
import com.dandaevit.edu.dao.task_dao.TaskDAOImplementation;
import com.dandaevit.edu.model.task.Task;

public class TaskServiceImplementation implements TaskService {
	private TaskDAOImplementation taskDAOImplementation = DAOFactory.getTaskDAO();

	@Override
	public Integer save(Task entity) {
		return taskDAOImplementation.save(entity);
	}

	@Override
	public void update(Task entity) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'update'");
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'delete'");
	}

	@Override
	public Optional<Task> findById(Integer id) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'findById'");
	}

	@Override
	public List<Task> findAll() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'findAll'");
	}

	@Override
	public List<Task> getTasksByUserId(Integer userId) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getTasksByUserId'");
	}

}

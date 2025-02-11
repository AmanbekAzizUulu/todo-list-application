package com.dandaevit.edu.service.user_task_service;

import java.util.List;
import java.util.Optional;

import com.dandaevit.edu.dao.dao_factory.DAOFactory;
import com.dandaevit.edu.dao.user_task_dao.UserTaskDAOImplementation;
import com.dandaevit.edu.model.User;

public class UserTasksServiceImplementation implements UserTaskService{
	private UserTaskDAOImplementation userTaskDAOImplementation = DAOFactory.getUserTaskDAO();

	@Override
	public Integer save(User entity) {
		return 1;
	}

	@Override
	public void update(User entity) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'update'");
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'delete'");
	}

	@Override
	public Optional<User> findById(Integer id) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'findById'");
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'findAll'");
	}

	@Override
	public void addTask(Integer taskId, Integer userId) {
		userTaskDAOImplementation.addTask(taskId, userId);
	}
}

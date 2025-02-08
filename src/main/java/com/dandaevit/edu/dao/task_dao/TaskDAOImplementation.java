package com.dandaevit.edu.dao.task_dao;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

import com.dandaevit.edu.database_connection_manager.DatabaseConnectionManager;
import com.dandaevit.edu.model.task.Task;

public class TaskDAOImplementation implements TaskDAO {
	private static final Connection connection = DatabaseConnectionManager.get();

	private TaskDAOImplementation() {
	}

	public static TaskDAOImplementation getInstance() {
		return Holder.INSTANCE;
	}

	// Внутренний статический класс для ленивой загрузки Singleton'а
	private static class Holder {
		private static final TaskDAOImplementation INSTANCE = new TaskDAOImplementation();
	}

	@Override
	public void save(Task entity) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'save'");
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
	public boolean existsById(Integer taskId) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'existsById'");
	}

}

package com.dandaevit.edu.dao.task_dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dandaevit.edu.database_connection_manager.DatabaseConnectionManager;
import com.dandaevit.edu.model.task.Task;

public class TaskDAOImplementation implements TaskDAO {
	private static final Connection connection = DatabaseConnectionManager.get();
	private static final Logger LOGGER = LoggerFactory.getLogger(TaskDAOImplementation.class);

	private static final String INSERT_INTO_TASKS =
			"""
			   INSERT INTO todo_list_application.tasks
					(
						title,
						description
					)
				VALUES
					(
						?,
						?
					)
				RETURNING id;
			""";

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
	public Integer save(Task task) {
		try (var prepareStatement = connection.prepareStatement(INSERT_INTO_TASKS)) {

			prepareStatement.setString(1, task.getTitle());
			prepareStatement.setString(2, task.getDescription());

			var resultSet = prepareStatement.executeQuery();
			LOGGER.info("TASK INSERTED SUCCESSFULLY");

			int taskId = 0;

			if (resultSet.next()) {
                taskId = resultSet.getInt("id"); // Получаем ID пользователя
                LOGGER.info("USER INSERTED SUCCESSFULLY with ID: " + taskId);
            }
			return taskId;
		} catch (SQLException e) {
			throw new RuntimeException("ERROR WHEN INSERTING A TASK INTO THE TASKS TABLE", e);
		}
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

	public Connection getConnection() {
		return connection;
	}
}

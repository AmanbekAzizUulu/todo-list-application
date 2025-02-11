package com.dandaevit.edu.dao.user_task_dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dandaevit.edu.database_connection_manager.DatabaseConnectionManager;
import com.dandaevit.edu.model.UserTasks;

public class UserTaskDAOImplementation implements UserTaskDAO {
	private static final Connection connection = DatabaseConnectionManager.get();
	private static final Logger LOGGER = LoggerFactory.getLogger(UserTaskDAOImplementation.class);

	private static final String INSERT_USER_TASK = """
				INSERT INTO todo_list_application.user_tasks
					(
						user_id,
						task_id
					)
				VALUES
					(
						?,
						?
					);
			""";

	private UserTaskDAOImplementation() {
	}

	public static UserTaskDAOImplementation getInstance() {
		return Holder.INSTANCE;
	}

	// Внутренний статический класс для ленивой загрузки Singleton'а
	private static class Holder {
		private static final UserTaskDAOImplementation INSTANCE = new UserTaskDAOImplementation();
	}

	@Override
	public void addTask(Integer taskId, Integer userId) {
		try (var preparedStatement = connection.prepareStatement(INSERT_USER_TASK)) {
			preparedStatement.setInt(1, userId);
			preparedStatement.setInt(2, taskId);

			preparedStatement.executeUpdate();

			LOGGER.info("USER'S TASK WAS SUCCESSFULLY INSERTED");

		} catch (SQLException e) {
			throw new RuntimeException("Ошибка при добавлении задачи в user_task", e);
		}
	}

	@Override
	public Integer save(UserTasks entity) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'save'");
	}

	@Override
	public void update(UserTasks entity) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'update'");
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'delete'");
	}

	@Override
	public Optional<UserTasks> findById(Integer id) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'findById'");
	}

	@Override
	public List<UserTasks> findAll() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'findAll'");
	}

}

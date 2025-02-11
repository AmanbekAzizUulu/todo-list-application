package com.dandaevit.edu.dao.user_dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dandaevit.edu.database_connection_manager.DatabaseConnectionManager;
import com.dandaevit.edu.model.User;

public class UserDAOImplementation implements UserDAO {
	private static final Connection connection = DatabaseConnectionManager.get();
	private static final Logger LOGGER = LoggerFactory.getLogger(UserDAOImplementation.class);

	private static final String INSERT_INTO_USERS = """
			    INSERT INTO todo_list_application.users
					(
						first_name,
						last_name,
						email,
						password_hash
					)
			     		VALUES
					(
						?,
						?,
						?,
						?
					)
				RETURNING
					id;
			""";

	private UserDAOImplementation() {
	}

	public static UserDAOImplementation getInstance() {
		return Holder.INSTANCE;
	}

	// Внутренний статический класс для ленивой загрузки Singleton'а
	private static class Holder {
		private static final UserDAOImplementation INSTANCE = new UserDAOImplementation();
	}

	@Override
	public Integer save(User user) {
		try (var prepareStatement = connection.prepareStatement(INSERT_INTO_USERS)) {
			prepareStatement.setString(1, user.getFirstName());
			prepareStatement.setString(2, user.getLastName());
			prepareStatement.setString(3, user.getEmail());
			prepareStatement.setString(4, user.getPassword());

			var resultSet = prepareStatement.executeQuery();

			resultSet.next();

			var userId = resultSet.getInt("id"); // Получаем ID пользователя

			LOGGER.info("USER INSERTED SUCCESSFULLY WITH ID: " + userId);

			return userId;
		} catch (SQLException e) {
			throw new RuntimeException("ERROR WHEN INSERTING A USER INTO THE USERS TABLE", e);
		}
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

}

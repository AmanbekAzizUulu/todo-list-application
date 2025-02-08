package com.dandaevit.edu.dao.user_dao;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

import com.dandaevit.edu.database_connection_manager.DatabaseConnectionManager;
import com.dandaevit.edu.model.User;

public class UserDAOImplementation implements UserDAO {
	private static final Connection connection = DatabaseConnectionManager.get();

	public static UserDAOImplementation getInstance() {
		return Holder.INSTANCE;
	}

	// Внутренний статический класс для ленивой загрузки Singleton'а
	private static class Holder {
		private static final UserDAOImplementation INSTANCE = new UserDAOImplementation();
	}

	@Override
	public void save(User entity) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'save'");
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

package com.dandaevit.edu.service.user_service;

import java.util.List;
import java.util.Optional;

import com.dandaevit.edu.dao.dao_factory.DAOFactory;
import com.dandaevit.edu.dao.user_dao.UserDAOImplementation;
import com.dandaevit.edu.model.User;

public class UserServiceImplementation implements UserService{
	private UserDAOImplementation userDAOImplementation = DAOFactory.getUserDAO();

	@Override
	public Integer save(User user) {
		return userDAOImplementation.save(user);
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
	public List<User> getUserById(Integer userId) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getUserById'");
	}


}

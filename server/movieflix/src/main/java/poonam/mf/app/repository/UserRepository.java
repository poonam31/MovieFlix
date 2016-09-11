package poonam.mf.app.repository;

import java.util.List;

import poonam.mf.app.entity.User;

public interface UserRepository {

	List<User> findAll();

	User findByID(String userId);

	User findByEmail(String email);

	User create(User user);

	User update(User user);

	void remove(User existing);

}

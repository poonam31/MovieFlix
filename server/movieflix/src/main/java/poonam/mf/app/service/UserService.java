package poonam.mf.app.service;

import java.util.List;
import poonam.mf.app.entity.User;

public interface UserService {

	User findById(String userId);

	void remove(String userId);

	List<User> findAll();

	User create(User user);

	User update(String userId, User user);

}

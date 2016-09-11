package poonam.mf.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import poonam.mf.app.entity.Movie;
import poonam.mf.app.entity.User;
import poonam.mf.app.exception.EntityAlreadyExistException;
import poonam.mf.app.exception.EntityNotFoundException;
import poonam.mf.app.repository.UserRepository;

@Service
public class UserServiceImp implements UserService {

	@Autowired
	private UserRepository repository;

	@Override
	public List<User> findAll() {
		return repository.findAll();
	}

	@Override
	public User findById(String userId) {
		User user = repository.findByID(userId);
		if (user == null) {
			throw new EntityNotFoundException("User not found.");
		}
		return user;
	}

	@Override
	@Transactional
	public User create(User user) {
		User existing = repository.findByEmail(user.getEmail());
		if (existing != null) {
			throw new EntityAlreadyExistException("User already exists with this email.");
		}
		return repository.create(user);
	}

	@Override
	@Transactional
	public User update(String userId, User user) {
		User existing = repository.findByID(userId);
		if (existing == null) {
			;
			throw new EntityNotFoundException("User not found.");
		}
		return repository.update(user);
	}

	@Override
	@Transactional
	public void remove(String userId) {
		User existing = repository.findByID(userId);
		if (existing == null) {
			throw new EntityNotFoundException("User not found");
		}
		repository.remove(existing);
	}

}

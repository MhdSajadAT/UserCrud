package com.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.entity.User;
import com.user.exception.ResourceNotFoundException;
import com.user.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public void deleteUser(Long id) {
		User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found with id " + id));

		userRepository.delete(user);
	}

	@Override
	public Optional<User> getUserById(Long id) {
		 
		 return Optional.ofNullable(userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found with id " + id)));
		
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User createUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User updateUser(Long id, User userDetails) {

		User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found with id " + id));

		user.setUsername(userDetails.getUsername());
		user.setPassword(userDetails.getPassword());
		user.setActive(userDetails.isActive());

		return userRepository.save(user);
	}
}

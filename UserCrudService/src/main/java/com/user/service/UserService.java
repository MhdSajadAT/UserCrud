package com.user.service;

import java.util.List;
import java.util.Optional;

import com.user.entity.User;

public interface UserService {

   List<User> getAllUsers();
   
	User createUser(User user);

	User updateUser(Long id, User userDetails);

	void deleteUser	(Long  id);

	Optional<User> getUserById(Long id);

}


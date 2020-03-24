package com.example.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.course.entities.User;
import com.example.course.repositories.UserRepository;

//@Component //Registra a classe como componente do Spring, fazendo com que ela seja injetada automáticamente
@Service // mesma coisa que component, mas para uma classe de serviço
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public User findById(Long id) {
//		if (userRepository.existsById(id)) {
			Optional<User> obj = userRepository.findById(id);
			return obj.get();
//		} else {
//			return null;
//		}

	}
}

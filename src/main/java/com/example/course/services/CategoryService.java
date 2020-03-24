package com.example.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.course.entities.Category;
import com.example.course.repositories.CategoryRepository;

//@Component //Registra a classe como componente do Spring, fazendo com que ela seja injetada automáticamente
@Service // mesma coisa que component, mas para uma classe de serviço
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	public List<Category> findAll() {
		return categoryRepository.findAll();
	}

	public Category findById(Long id) {
//		if (userRepository.existsById(id)) {
		Optional<Category> obj = categoryRepository.findById(id);
		return obj.get();
//		} else {
//			return null;
//		}

	}
}

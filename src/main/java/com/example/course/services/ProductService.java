package com.example.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.course.entities.Product;
import com.example.course.repositories.ProductRepository;

//@Component //Registra a classe como componente do Spring, fazendo com que ela seja injetada automáticamente
@Service // mesma coisa que component, mas para uma classe de serviço
public class ProductService {

	@Autowired
	private ProductRepository userRepository;

	public List<Product> findAll() {
		return userRepository.findAll();
	}

	public Product findById(Long id) {
//		if (userRepository.existsById(id)) {
		Optional<Product> obj = userRepository.findById(id);
			return obj.get();
//		} else {
//			return null;
//		}

	}
}

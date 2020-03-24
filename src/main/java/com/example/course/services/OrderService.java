package com.example.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.course.entities.Order;
import com.example.course.repositories.OrderRepository;

//@Component //Registra a classe como componente do Spring, fazendo com que ela seja injetada automáticamente
@Service // mesma coisa que component, mas para uma classe de serviço
public class OrderService {

	@Autowired
	private OrderRepository repository;

	public List<Order> findAll() {
		return repository.findAll();
	}

	public Order findById(Long id) {
//		if (OrderRepository.existsById(id)) {
		Optional<Order> obj = repository.findById(id);
		return obj.get();
//		} else {
//			return null;
//		}

	}
}

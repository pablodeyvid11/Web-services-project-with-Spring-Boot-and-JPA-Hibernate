package com.example.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.course.entities.User;
//instancia o repositorio, que tem vários métodos para trabalhar com o User
public interface UserRepository extends JpaRepository<User, Long> { 
}
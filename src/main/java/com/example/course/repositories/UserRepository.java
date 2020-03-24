package com.example.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.example.course.entities.User;
//instancia o repositorio, que tem vários métodos para trabalhar com o User
//@Component //Registra a classe como componente do Spring, fazendo com que ela seja injetada automáticamente
@Repository // mesma coisa do component, mas para repositorio
// é opcional colocar o @Repository pois a interface JpaRepository já tem
public interface UserRepository extends JpaRepository<User, Long> { 
}
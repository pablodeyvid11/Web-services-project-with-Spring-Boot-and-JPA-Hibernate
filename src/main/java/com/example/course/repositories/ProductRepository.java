package com.example.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.course.entities.Product;

//instancia o repositorio, que tem vários métodos para trabalhar com o Product
//@Component //Registra a classe como componente do Spring, fazendo com que ela seja injetada automáticamente
@Repository // mesma coisa do component, mas para repositorio
// é opcional colocar o @Repository pois a interface Jparepository já tem
public interface ProductRepository extends JpaRepository<Product, Long> {
}
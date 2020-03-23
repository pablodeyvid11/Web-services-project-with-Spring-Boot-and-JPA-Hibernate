package com.example.course.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.course.entities.User;

//Disponibiliza um recurso WEB para a classe User

@RestController // serializa os métodos: dá segurança
@RequestMapping(value = "/users") // nome do recurso
public class UserResource {

	// ResponseEntity Tipo padrão para resposta Web

	@GetMapping // diz que o método pode ser usado no HTTP
	public ResponseEntity<User> findAll() {
		User u = new User(1L, "maria", "maria@gmail.com", "99999999", "12345");
		return ResponseEntity.ok().body(u);
		// .ok = Retornar a resposta com sucesso ao HTTP
		// .body = retornar o corpo da resposta, no caso, o objeto que é colocado no
		// parâmetro
	}
}

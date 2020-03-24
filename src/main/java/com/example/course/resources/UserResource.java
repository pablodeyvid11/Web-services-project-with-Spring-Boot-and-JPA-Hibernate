package com.example.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.course.entities.User;
import com.example.course.services.UserService;

//Disponibiliza um recurso WEB para a classe User

@RestController // serializa os métodos: dá segurança
@RequestMapping(value = "/users") // nome do recurso
public class UserResource {
	@Autowired // injeção de dependência automática
	private UserService userService;

	// ResponseEntity Tipo padrão para resposta Web

	@GetMapping // diz que o método pode ser usado no HTTP
	public ResponseEntity<List<User>> findAll() {
		List<User> users = userService.findAll();
		return ResponseEntity.ok().body(users);
		// .ok = Retornar a resposta com sucesso ao HTTP
		// .body = retornar o corpo da resposta, no caso, o objeto que é colocado no
		// parâmetro
	}

	@GetMapping(value = "/{id}") // indica que a requisição http vai passar um parâmetro, que seu nome será id

	public ResponseEntity<User> findById(
			@PathVariable /* Anotação para converter a URL no parâmetro necessário */ Long id) {
		User obj = userService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}

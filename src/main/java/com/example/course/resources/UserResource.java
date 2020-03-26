package com.example.course.resources;

import java.net.URI;
import java.util.List;

import javax.servlet.Servlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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

	@PostMapping // faz um pré processamento definindo que esse método vai receber um Post do
					// http - Usado em métodos que inserem no banco
	public ResponseEntity<User> insert(@RequestBody /* Diz que esse objeto será descerializado no Json */User obj) {
		obj = userService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		userService.delete(id);
		return ResponseEntity.noContent().build();
	}
}

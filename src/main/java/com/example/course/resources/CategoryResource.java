package com.example.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.course.entities.Category;
import com.example.course.services.CategoryService;

//Disponibiliza um recurso WEB para a classe Category

@RestController // serializa os métodos: dá segurança
@RequestMapping(value = "/categories") // nome do recurso
public class CategoryResource {
	@Autowired // injeção de dependência automática
	private CategoryService userService;

	// ResponseEntity Tipo padrão para resposta Web

	@GetMapping // diz que o método pode ser usado no HTTP
	public ResponseEntity<List<Category>> findAll() {
		List<Category> users = userService.findAll();
		return ResponseEntity.ok().body(users);
		// .ok = Retornar a resposta com sucesso ao HTTP
		// .body = retornar o corpo da resposta, no caso, o objeto que é colocado no
		// parâmetro
	}

	@GetMapping(value = "/{id}") // indica que a requisição http vai passar um parâmetro, que seu nome será id

	public ResponseEntity<Category> findById(
			@PathVariable /* Anotação para converter a URL no parâmetro necessário */ Long id) {
		Category obj = userService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}

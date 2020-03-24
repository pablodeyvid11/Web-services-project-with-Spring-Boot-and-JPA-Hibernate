package com.example.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.course.entities.Product;
import com.example.course.services.ProductService;

//Disponibiliza um recurso WEB para a classe Product

@RestController // serializa os métodos: dá segurança
@RequestMapping(value = "/products") // nome do recurso
public class ProductResource {
	@Autowired // injeção de dependência automática
	private ProductService userService;

	// ResponseEntity Tipo padrão para resposta Web

	@GetMapping // diz que o método pode ser usado no HTTP
	public ResponseEntity<List<Product>> findAll() {
		List<Product> users = userService.findAll();
		return ResponseEntity.ok().body(users);
		// .ok = Retornar a resposta com sucesso ao HTTP
		// .body = retornar o corpo da resposta, no caso, o objeto que é colocado no
		// parâmetro
	}

	@GetMapping(value = "/{id}") // indica que a requisição http vai passar um parâmetro, que seu nome será id

	public ResponseEntity<Product> findById(
			@PathVariable /* Anotação para converter a URL no parâmetro necessário */ Long id) {
		Product obj = userService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}

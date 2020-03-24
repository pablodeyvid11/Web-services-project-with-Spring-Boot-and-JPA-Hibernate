package com.example.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.course.entities.Order;
import com.example.course.entities.User;
import com.example.course.entities.enums.OrderStatus;
import com.example.course.repositories.OrderRepository;
import com.example.course.repositories.UserRepository;

@Configuration
@Profile("test")
//Classe de configuração para teste
public class TestConfig implements CommandLineRunner {

	@Autowired // injeção de dependência: Faz que que o userRepository tenha uma instanciação e
				// que o Testconfig dependa dele
	private UserRepository userRepository;
	@Autowired
	private OrderRepository orderRepository;

	// a interface CommandLineRunner faz uma nova Thread com o método: run

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		User u3 = new User(null, "Pablo Brown", "pablo@gmail.com", "9666666666", "123456");
		User u4 = new User(null, "Thiago Green", "thiago@gmail.com", "955555555", "123456");

		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1);

		userRepository.saveAll(Arrays.asList(u1, u2, u3, u4));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
	}
}

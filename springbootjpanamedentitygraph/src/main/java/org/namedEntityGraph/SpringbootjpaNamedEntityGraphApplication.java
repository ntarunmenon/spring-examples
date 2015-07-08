package org.namedEntityGraph;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringbootjpaNamedEntityGraphApplication {

	@Autowired
	private OrderRepository orderRepository;

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(
				SpringbootjpaNamedEntityGraphApplication.class, args);
		String[] beanNames = context.getBeanDefinitionNames();
		Arrays.sort(beanNames);
		for (String beanName : beanNames) {
			System.out.println(beanName);
		}
	}
}

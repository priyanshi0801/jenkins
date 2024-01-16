package com.nkdebug.jenkins;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
@RestController
@RequestMapping("/orders")
public class JenkinsApplication {

	static Logger logger = LoggerFactory.getLogger(JenkinsApplication.class);

	@PostConstruct
	public void test() {
		logger.info("Application Started");
	}
	@Autowired
	private OrderDao orderDao;

	@GetMapping
	public List<Order> fetchOrders() {
		return orderDao.getOrders().stream().
				sorted(Comparator.comparing(Order::getPrice)).collect(Collectors.toList());
	}

	public static void main(String[] args) {
		logger.info("Application executed");
		SpringApplication.run(JenkinsApplication.class, args);
	}

}

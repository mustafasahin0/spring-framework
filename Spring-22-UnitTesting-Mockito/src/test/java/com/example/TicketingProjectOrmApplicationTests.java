package com.example;

import com.example.repository.UserRepository;
import com.example.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TicketingProjectOrmApplicationTests {

	@Mock
	UserRepository userRepository;

	@InjectMocks
	UserServiceImpl userService;



	@Test
	void deleteByUserName_test() {
		userService.deleteByUserName("mikesmith@example.com");

		Mockito.verify(userRepository).deleteByUserName("mikesmith@example.com");
	}

}

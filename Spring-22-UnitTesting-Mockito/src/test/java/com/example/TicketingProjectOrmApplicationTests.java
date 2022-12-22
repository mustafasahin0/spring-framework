package com.example;

import com.example.repository.UserRepository;
import com.example.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.*;

@SpringBootTest
class TicketingProjectOrmApplicationTests {

	@Mock
	UserRepository userRepository;

	@InjectMocks
	UserServiceImpl userService;



	@Test
	void deleteByUserName_test() {
		userService.deleteByUserName("mikesmith@example.com");

		verify(userRepository).deleteByUserName("mikesmith@example.com");
		verify(userRepository).findAll();
//		//verify(userRepository, times(2)).deleteByUserName("mikesmith@example.com");
//		verify(userRepository, atLeastOnce()).deleteByUserName("mikesmith@example.com");
//		verify(userRepository, atLeast(5)).deleteByUserName("mikesmith@example.com");
//		verify(userRepository, atMostOnce()).deleteByUserName("mikesmith@example.com");
//		verify(userRepository, atMost(5)).deleteByUserName("mikesmith@example.com");

		InOrder inOrder = inOrder(userRepository);
		inOrder.verify(userRepository).deleteByUserName("mikesmith@example.com");
		inOrder.verify(userRepository).findAll();


	}

}

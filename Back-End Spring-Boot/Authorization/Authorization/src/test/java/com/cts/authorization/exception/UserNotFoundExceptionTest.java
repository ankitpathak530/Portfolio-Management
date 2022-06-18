package com.cts.authorization.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cts.authorization.model.User;
import com.cts.authorization.repository.UserRepository;

@SpringBootTest
public class UserNotFoundExceptionTest {

	
	@MockBean
	private UserRepository userRepository;
	
	
	@Test
	void testUserNotFound()
	{
		Optional<User> findById = userRepository.findById(222);	
		try {
	      throw new UserNotFoundException("User not found");
		}
		catch(UserNotFoundException e) {
			assertEquals("User not found", e.getMessage());
		}
		
	}
	
	
	
}

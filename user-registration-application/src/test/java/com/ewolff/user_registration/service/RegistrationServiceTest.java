package com.ewolff.user_registration.service;

import static org.junit.Assert.*;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ewolff.user_registration.RegistrationApplication;
import com.ewolff.user_registration.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=RegistrationApplication.class, loader=SpringApplicationContextLoader.class)
@Transactional
public class RegistrationServiceTest {

	@Autowired
	private RegistrationService registrationService; 
		
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Test
	public void simpleRegistration() {
		User user = new User("Eberhard","Wolff","eberhard.wolff@gmail.com");
		assertTrue(registrationService.register(user));
		assertNotNull(registrationService.getByEMail("eberhard.wolff@gmail.com"));
	}
	
	@Test
	public void avoidDoubleRegistrations() {
		User user = new User("Eberhard","Wolff","eberhard.wolff@gmail.com");
		assertTrue(registrationService.register(user));
		assertFalse(registrationService.register(user));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void avoidInvalidEMail() {
		User user = new User("Eberhard","Wolff","HURZ!");
		registrationService.register(user);
	}
	
	@Test
	public void userNotInitiallyRegistered() {
		assertNull(registrationService.getByEMail("eberhard.wolff@gmail.com"));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void nonExistingUserCannotBeUnregistered() {
		registrationService.unregister("eberhard.wolff@gmail.com");
	}
	
	
	@Test
	public void unregisterUser() {
		User user = new User("Eberhard","Wolff","eberhard.wolff@gmail.com");
		registrationService.register(user);
		registrationService.unregister("eberhard.wolff@gmail.com");
		assertNull(registrationService.getByEMail("eberhard.wolff@gmail.com"));
	}
	
	
}

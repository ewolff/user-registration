package com.ewolff.user_registration;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.boot.SpringApplication;

import com.ewolff.user_registration.domain.User;
import com.ewolff.user_registration.service.RegistrationService;

public class UserRegistrationSteps {

	@Autowired
	RegistrationService registrationService;

	private User user;
	private boolean fehler = false;

	public UserRegistrationSteps() {
		super();
		SpringApplication application = new SpringApplication(
				RegistrationApplication.class);
		application.setWebEnvironment(false);
		AutowiredAnnotationBeanPostProcessor autowiredAnnotationBeanPostProcessor = new AutowiredAnnotationBeanPostProcessor();
		autowiredAnnotationBeanPostProcessor.setBeanFactory(application.run()
				.getBeanFactory());
		autowiredAnnotationBeanPostProcessor.processInjection(this);
	}

	@Given("ein neuer Kunde mit EMail $email und Vorname $vorname und Name $name")
	public void gegebenKunde(String email, String vorname, String name) {
		user = new User(vorname, name, email);
	}

	@When("der Kunde sich registriert")
	public void register() {
		try {
			registrationService.register(user);
		} catch (IllegalArgumentException ex) {
			fehler = true;
		}
	}

	@Then("sollte ein Kunde mit der EMail $email existieren und es sollte kein Fehler gemeldet werden")
	public void existiert(String email) {
		assertNotNull(registrationService.getByEMail(email));
		assertFalse(fehler);
	}

	@Then("sollte ein Fehler gemeldet werden")
	public void fehler() {
		assertTrue(fehler);
	}

}

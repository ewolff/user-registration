package com.ewolff.user_registration;

import static org.junit.Assert.*;

import org.jbehave.core.annotations.BeforeStory;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.embedder.Embedder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.boot.SpringApplication;

import com.ewolff.user_registration.domain.User;
import com.ewolff.user_registration.service.RegistrationService;

public class UserRegistrationSteps extends Embedder {

	@Autowired
	RegistrationService registrationService;

	private User kunde;
	private boolean fehler = false;

	private User andererKunde;

	private boolean andererKundeRegistrierungErfolg = false;

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

	@BeforeStory
	public void cleanUp() {
		registrationService.clean();
		fehler = false;
		andererKundeRegistrierungErfolg = false;
	}

	@Given("ein neuer Kunde mit EMail $email Vorname $vorname Name $name")
	public void gegebenKunde(String email, String vorname, String name) {
		kunde = new User(vorname, name, email);
	}

	@Given("ein anderer Kunde mit EMail $email Vorname $vorname Name $name")
	public void gegebenAndererKunde(String email, String vorname, String name) {
		andererKunde = new User(vorname, name, email);
	}

	@When("der andere Kunde sich registriert")
	public void registerAndererKunde() {
		try {
			andererKundeRegistrierungErfolg = registrationService
					.register(andererKunde);
		} catch (IllegalArgumentException ex) {
			fehler = true;
		}
	}

	@When("der Kunde sich registriert")
	public void registerKunde() {
		try {
			registrationService.register(kunde);
		} catch (IllegalArgumentException ex) {
			fehler = true;
		}
	}

	@When("der Kunde dann geloescht wird")
	public void loescheKunde() {
		registrationService.unregister(kunde.getEmail());
	}

	@Then("sollte ein Kunde mit der EMail $email existieren")
	public void existiert(String email) {
		assertNotNull(registrationService.getByEMail(email));
	}

	@Then("sollte kein Kunde mit der EMail $email existieren")
	public void existiertNicht(String email) {
		assertNull(registrationService.getByEMail(email));
	}

	@Then("sollte kein Fehler gemeldet werden")
	public void keinFehler() {
		assertFalse(fehler);
	}

	@Then("sollte ein Fehler gemeldet werden")
	public void fehler() {
		assertTrue(fehler);
	}

	@Then("sollte die Registrierung des anderen Kunden nicht erfolgreich sein")
	public void andererRegistrierungNichtErfolgreich() {
		assertFalse(andererKundeRegistrierungErfolg);
	}

}

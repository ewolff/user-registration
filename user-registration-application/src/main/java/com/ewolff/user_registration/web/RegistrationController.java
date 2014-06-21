package com.ewolff.user_registration.web;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ewolff.user_registration.domain.User;
import com.ewolff.user_registration.service.RegistrationService;

@Controller
public class RegistrationController {

	private Log log = LogFactory.getLog(RegistrationController.class);

	@Autowired
	private RegistrationController(RegistrationService registrationService) {
		this.registrationService = registrationService;
	}

	private RegistrationService registrationService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String homepage() {
		return "index";
	}

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public ModelAndView createForm() {
		return new ModelAndView("user/form", "user", new User("", "", ""));
	}

	@RequestMapping(value = "/usersearch", method = RequestMethod.GET)
	public ModelAndView suche(@RequestParam("email") String email) {
		User user = registrationService.getByEMail(email);
		if (user != null) {
			return new ModelAndView("user/display", "user", user);
		} else {
			return new ModelAndView("user/not-found");
		}
	}

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public ModelAndView create(@ModelAttribute User user,
			BindingResult bindingResult, RedirectAttributes redirect) {
		if (!registrationService.validEMailAdress(user.getEmail())) {
			log.info(String.format("email=%s nicht valide", user.getEmail()));
			bindingResult.addError(new FieldError("user", "email",
					"EMail Adresse nicht valide"));
		} else {
			boolean registrationResult = registrationService.register(user);
			if (!registrationResult) {
				log.info(String
						.format("email=%s konnte nicht registriert werden - EMail Adresse schon verwendet?",
								user.getEmail()));
				bindingResult
						.addError(new FieldError("user", "email",
								"User konnte nicht registriert werden - EMail Adresse schon verwendet?"));
			}
		}
		if (bindingResult.hasErrors()) {
			log.info(String.format(
					"email=%s hatte Fehler - Formular neu anzeigen",
					user.getEmail()));
			return new ModelAndView("user/form", "user", user);
		} else {
			return new ModelAndView("user/display", "user", user);
		}
	}

	@RequestMapping(value = "/userdelete", method = RequestMethod.POST)
	public String delete(@RequestParam("email") String email) {
		registrationService.unregister(email);
		return "index";
	}

}

package net.dleguis.seedbox.presentation.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.dleguis.seedbox.common.constants.ViewConstants;

/**
 * The type Login controller.
 */
@Controller
public class LoginController {

	/**
	 * The constant LOGGER.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

	/**
	 * Login string.
	 *
	 * @param model
	 *            the model
	 * @return the string
	 */
	@RequestMapping(path = "/login", method = RequestMethod.GET)
	private String login(Model model) {

		// model.addAttribute("user", new User());
		return ViewConstants.LOGIN_PAGE;
	}
}

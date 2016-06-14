package net.dleguis.seedbox.presentation.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.dleguis.seedbox.common.constants.ViewConstants;

/**
 * The type Home controller.
 */
@Controller
public class HomeController {

	/**
	 * The constant LOGGER.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Home string.
	 *
	 * @param model
	 *            the model
	 * @return the string
	 */
	@RequestMapping(path = { "/", "index.html" }, method = RequestMethod.GET)
	private String home(Model model) {

		return ViewConstants.HOME_PAGE;
	}

	@RequestMapping(path = { "/error" }, method = RequestMethod.GET)
	private String error(Model model) {

		LOGGER.error("an error occured.");
		return ViewConstants.ERROR_PAGE;
	}
}

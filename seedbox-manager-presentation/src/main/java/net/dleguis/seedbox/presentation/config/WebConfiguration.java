package net.dleguis.seedbox.presentation.config;

import java.util.Locale;
import java.util.Set;

import org.h2.server.web.WebServlet;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import com.google.common.collect.Sets;

/**
 * The type Web config.
 */
@Configuration
public class WebConfiguration extends WebMvcConfigurerAdapter {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(localeChangeInterceptor());
	}

	/**
	 * Message source message source.
	 *
	 * @return the message source
	 */
	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("locale/messages");
		messageSource.setFallbackToSystemLocale(true);
		messageSource.setDefaultEncoding("UTF-8");
		return messageSource;
	}

	/**
	 * Locale resolver locale resolver.
	 *
	 * @return the locale resolver
	 */
	@Bean
	public LocaleResolver localeResolver() {

		Set<String> supportedLocales = Sets.newHashSet(Locale.ENGLISH.getLanguage(), Locale.FRENCH.getLanguage());

		Locale defaultLocale = Locale.getDefault();
		Locale selectedLocale = Locale.ENGLISH;

		if (supportedLocales.contains(defaultLocale.getLanguage())) {
			selectedLocale = defaultLocale;
		}

		SessionLocaleResolver slr = new SessionLocaleResolver();
		slr.setDefaultLocale(selectedLocale);
		return slr;
	}

	/**
	 * Locale change interceptor locale change interceptor.
	 *
	 * @return the locale change interceptor
	 */
	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
		LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
		lci.setParamName("lang");
		return lci;
	}

	/**
	 * H 2 servlet registration servlet registration bean.
	 *
	 * @return the servlet registration bean
	 */
	@Bean
	ServletRegistrationBean h2servletRegistration() {
		ServletRegistrationBean registrationBean = new ServletRegistrationBean(new WebServlet());
		registrationBean.addUrlMappings("/console/*");
		return registrationBean;
	}
}

package com.monteiro.cobranca;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.FixedLocaleResolver;

@SpringBootApplication
public class CobrancaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CobrancaApplication.class, args);
	}
	@Bean
	public LocaleResolver localResolver(){
		return new FixedLocaleResolver(new Locale("pt","BR"));
	}
	
	//Configura para se alguem digitar / na url , redireciona para a pagina de listagem
	
	@Configuration
	public static class MvcConfig extends WebMvcConfigurerAdapter{
		@Override
		public void addViewControllers(ViewControllerRegistry registry) {
			registry.addRedirectViewController("/", "/titulo");
		}
	}
	
}
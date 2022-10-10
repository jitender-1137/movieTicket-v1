package com.movie.movieTicket.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InternationalizationConfig implements WebMvcConfigurer {

//	@Bean
//	public LocaleResolver localeResolver() {
//		SessionLocaleResolver slr = new SessionLocaleResolver();
//		slr.setDefaultLocale(Locale.US);
//		return slr;
//	}
//
//	@Bean
//	public LocaleChangeInterceptor localeChangeInterceptor() {
//		LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
//		lci.setParamName("lang");
//		return lci;
//	}
//
//	@Override
//	public void addInterceptors(InterceptorRegistry registry) {
//		registry.addInterceptor(localeChangeInterceptor());
//	}

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:" + "i18n/messages");
        return messageSource;
    }

//    @Bean
//    public ClassLoaderTemplateResolver secondaryTemplateResolver() {
//        ClassLoaderTemplateResolver secondaryTemplateResolver = new ClassLoaderTemplateResolver();
//        secondaryTemplateResolver.setPrefix("templates/");
//        secondaryTemplateResolver.setSuffix(".html");
//        secondaryTemplateResolver.setTemplateMode(TemplateMode.HTML);
//        secondaryTemplateResolver.setCharacterEncoding("UTF-8");
//        secondaryTemplateResolver.setOrder(1);
//        secondaryTemplateResolver.setCheckExistence(true);
//
//        return secondaryTemplateResolver;
//    }
}

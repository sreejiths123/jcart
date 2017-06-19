/**
 * 
 */
package com.labs.lawcart.site.config;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.extras.springsecurity4.dialect.SpringSecurityDialect;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.resourceresolver.SpringResourceResourceResolver;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.StandardTemplateModeHandlers;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;
import org.thymeleaf.templateresolver.TemplateResolver;

/**
 * @author Siva
 *
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter
{
	@Value("${server.port:8443}")
	private int serverPort;

	@Autowired
	private MessageSource messageSource;

	@Override
	public Validator getValidator()
	{
		LocalValidatorFactoryBean factory = new LocalValidatorFactoryBean();
		factory.setValidationMessageSource(messageSource);
		return factory;
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry)
	{
		super.addViewControllers(registry);
		registry.addViewController("/login").setViewName("login");
		registry.addViewController("/register").setViewName("register");
		registry.addViewController("/myDashboard").setViewName("redirect:/dashboard/pages/index.html");
	    registry.addViewController("/myDashboard/").setViewName("forward:/dashboard/pages/index.html");
	    registry.addViewController("/matters").setViewName("redirect:/dashboard/pages/matters.html");
	    registry.addViewController("/matters/").setViewName("forward:/dashboard/pages/matters.html");
	    registry.addViewController("/matters/new").setViewName("redirect:/dashboard/pages/matters_new.html");
	    registry.addViewController("/matters/new/").setViewName("forward:/dashboard/pages/matters_new.html");
	    
		registry.addRedirectViewController("/", "/home");

	}

	@Override
	public void addInterceptors(InterceptorRegistry registry)
	{
		super.addInterceptors(registry);
	}

	@Bean
	public ClassLoaderTemplateResolver emailTemplateResolver()
	{
		ClassLoaderTemplateResolver emailTemplateResolver = new ClassLoaderTemplateResolver();
		emailTemplateResolver.setPrefix("email-templates/");
		emailTemplateResolver.setSuffix(".html");
		//https://stackoverflow.com/questions/28624768/thymeleaf-strict-html-parsing-issue
		//emailTemplateResolver.setTemplateMode("HTML5");
		emailTemplateResolver.setTemplateMode("LEGACYHTML5");
		emailTemplateResolver.setCacheable(false);  // new 
		emailTemplateResolver.setCharacterEncoding("UTF-8");
		emailTemplateResolver.setOrder(2);

		return emailTemplateResolver;
	}
	/**
	 * templateResolver ,thymeleafResourceResolver,templateEngine,viewResolver are newly added to maitain legacy html , otherwise not required
	 * @return
	 */
	@Bean 
	public ITemplateResolver templateResolver() { 
	        TemplateResolver resolver = new TemplateResolver(); 
	        resolver.setResourceResolver(thymeleafResourceResolver()); 
	       // resolver.setPrefix(this.environment.getProperty("prefix", DEFAULT_PREFIX)); 
	        resolver.setPrefix("classpath:/templates/");
	        resolver.setSuffix(".html"); 
	        resolver.setTemplateMode(StandardTemplateModeHandlers.LEGACYHTML5.getTemplateModeName()); 
	        resolver.setCharacterEncoding("UTF-8"); 
	        resolver.setCacheable(false); 
	        return resolver; 
	} 
	
	@Bean
	public SpringResourceResourceResolver thymeleafResourceResolver() {
		return new SpringResourceResourceResolver();
	}
	
	public SpringTemplateEngine templateEngine() {
		SpringTemplateEngine engine = new SpringTemplateEngine();
		engine.setTemplateResolver(templateResolver());
		return engine;
	}

	@Bean
	public ViewResolver viewResolver() {
		ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
		viewResolver.setTemplateEngine(templateEngine());
		viewResolver.setOrder(1);
		viewResolver.setViewNames(new String[] { "*" });
		viewResolver.setCache(false);
		return viewResolver;
	}
	
	
	 @Override
	    public void addResourceHandlers(ResourceHandlerRegistry registry) {
	        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
	        registry.addResourceHandler("/**").addResourceLocations("classpath:/templates/");
	        super.addResourceHandlers(registry);
	    }

	@Bean
	public SpringSecurityDialect securityDialect()
	{
		return new SpringSecurityDialect();
	}

	@Bean
	public EmbeddedServletContainerFactory servletContainer()
	{
		TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory()
		{
			@Override
			protected void postProcessContext(Context context)
			{
				SecurityConstraint securityConstraint = new SecurityConstraint();
				securityConstraint.setUserConstraint("CONFIDENTIAL");
				SecurityCollection collection = new SecurityCollection();
				collection.addPattern("/*");
				securityConstraint.addCollection(collection);
				context.addConstraint(securityConstraint);
			}
		};

		tomcat.addAdditionalTomcatConnectors(initiateHttpConnector());
		return tomcat;
	}

	private Connector initiateHttpConnector()
	{
		Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
		connector.setScheme("http");
		connector.setPort(8080);
		connector.setSecure(false);
		connector.setRedirectPort(serverPort);

		return connector;
	}

}

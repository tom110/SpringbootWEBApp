package tom.springboot.springbootwebapp.configrations;

import org.springframework.context.annotation.Configuration;

@Configuration
public class ThymeleafShiroTagConfig {

//    @Bean
//    public ServletContextTemplateResolver templateResolver(){
//        WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();
//        ServletContext servletContext = webApplicationContext.getServletContext();
//        ServletContextTemplateResolver templateResolver=new ServletContextTemplateResolver(servletContext);
//        templateResolver.setPrefix("templates/");
//        templateResolver.setSuffix(".html");
//        templateResolver.setCharacterEncoding("UTF-8");
//        return templateResolver;
//    }
//
//    @Bean
//    public SpringTemplateEngine templateEngine(){
//        SpringTemplateEngine templateEngine=new SpringTemplateEngine();
//        templateEngine.setTemplateResolver(templateResolver());
//        Set<IDialect> shiroDialects=new HashSet<IDialect>();
//        shiroDialects.add(new ShiroDialect());
//        templateEngine.setAdditionalDialects(shiroDialects);
//        return templateEngine;
//    }
//
//    @Bean
//    public ThymeleafViewResolver thymeleafViewResolver(){
//        ThymeleafViewResolver thymeleafViewResolver=new ThymeleafViewResolver();
//        thymeleafViewResolver.setTemplateEngine(templateEngine());
//        thymeleafViewResolver.setCharacterEncoding("UTF-8");
//        return thymeleafViewResolver;
//
//    }

}

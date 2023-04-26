package com.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

@Configuration
public class TemplateResolverConfigurations {
@Bean
public SpringResourceTemplateResolver TemplatesResolver_0(){
 SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
 templateResolver.setPrefix("classpath:/templates");
 templateResolver.setSuffix(".html");
 templateResolver.setTemplateMode(TemplateMode.HTML);
 templateResolver.setCharacterEncoding("UTF-8");
 templateResolver.setOrder(0);
 templateResolver.setCheckExistence(true);
 return templateResolver;
 }
 @Bean
 public ClassLoaderTemplateResolver TemplatesResolver_1(){
 ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
 templateResolver.setPrefix("templates/catalogue/");
 templateResolver.setSuffix(".html");
 templateResolver.setTemplateMode(TemplateMode.HTML);
 templateResolver.setCharacterEncoding("UTF-8");
 templateResolver.setOrder(1);
 templateResolver.setCheckExistence(true);
 return templateResolver;
 }

 @Bean
 public ClassLoaderTemplateResolver TemplatesResolver_2(){
ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
 templateResolver.setPrefix("templates/extras/");
 templateResolver.setSuffix(".html");
 templateResolver.setTemplateMode(TemplateMode.HTML);
 templateResolver.setCharacterEncoding("UTF-8");
 templateResolver.setOrder(2);
 templateResolver.setCheckExistence(true);
 return templateResolver;
}

@Bean
public ClassLoaderTemplateResolver TemplatesResolver_3(){
 ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
 templateResolver.setPrefix("templates/users/");
templateResolver.setSuffix(".html");
 templateResolver.setTemplateMode(TemplateMode.HTML);
templateResolver.setCharacterEncoding("UTF-8");
 templateResolver.setOrder(3);
 templateResolver.setCheckExistence(true);
 return templateResolver;
}

 @Bean
 public ClassLoaderTemplateResolver TemplatesResolver_4(){
  ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
  templateResolver.setPrefix("templates/base_datos/");
  templateResolver.setSuffix(".html");
  templateResolver.setTemplateMode(TemplateMode.HTML);
  templateResolver.setCharacterEncoding("UTF-8");
  templateResolver.setOrder(4);
  templateResolver.setCheckExistence(true);
  return templateResolver;
 }

 @Bean
 public ClassLoaderTemplateResolver TemplatesResolver_5(){
  ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
  templateResolver.setPrefix("templates/carrito/");
  templateResolver.setSuffix(".html");
  templateResolver.setTemplateMode(TemplateMode.HTML);
  templateResolver.setCharacterEncoding("UTF-8");
  templateResolver.setOrder(5);
  templateResolver.setCheckExistence(true);
  return templateResolver;
 }

}

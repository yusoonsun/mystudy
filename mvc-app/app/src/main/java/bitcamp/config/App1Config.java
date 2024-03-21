package bitcamp.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;

@ComponentScan("bitcamp.app1")
public class App1Config {

//  @Bean
  MultipartResolver multipartResolver() {
    return new StandardServletMultipartResolver();
    //return new CommonsMultipartResolver();
  }
}

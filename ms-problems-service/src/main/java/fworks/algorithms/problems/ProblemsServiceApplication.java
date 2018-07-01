package fworks.algorithms.problems;

import fworks.algorithms.config.SwaggerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Import;

/**
 * Problems Service spring boot application.
 * Eureka Client<br>
 * Swagger Config<br>
 * 
 * @author flaviolcastro
 *
 */
@EnableEurekaClient
@Import(SwaggerConfig.class)
@SpringBootApplication
public class ProblemsServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(ProblemsServiceApplication.class, args);
  }
}

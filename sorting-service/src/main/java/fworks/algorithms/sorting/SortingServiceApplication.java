package fworks.algorithms.sorting;

import fworks.algorithms.config.SwaggerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Import;

/**
 * Algorithms boot application.<br>
 * Eureka Client<br>
 * Swagger Config<br>
 * 
 * @author flaviolcastro
 *
 */
@EnableEurekaClient
@Import(SwaggerConfig.class)
@SpringBootApplication
public class SortingServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(SortingServiceApplication.class, args);
  }
}

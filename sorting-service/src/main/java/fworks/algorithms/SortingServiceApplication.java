package fworks.algorithms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Algorithms boot application.
 * 
 * @author flaviolcastro
 *
 */
@EnableEurekaClient
@SpringBootApplication
public class SortingServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(SortingServiceApplication.class, args);
  }
}

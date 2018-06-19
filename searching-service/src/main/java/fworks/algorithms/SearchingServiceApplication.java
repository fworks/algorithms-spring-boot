package fworks.algorithms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Searching Service spring boot application.
 * 
 * @author flaviolcastro
 *
 */
@EnableEurekaClient
@SpringBootApplication
public class SearchingServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(SearchingServiceApplication.class, args);
  }
}

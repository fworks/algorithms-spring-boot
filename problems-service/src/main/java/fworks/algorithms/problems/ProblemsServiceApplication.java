package fworks.algorithms.problems;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Problems Service spring boot application.
 * 
 * @author flaviolcastro
 *
 */
@EnableEurekaClient
@SpringBootApplication
public class ProblemsServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(ProblemsServiceApplication.class, args);
  }
}

package fworks.algorithms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * Algorithms boot application.
 * 
 * @author flaviolcastro
 *
 */
@EnableEurekaClient
@EnableZuulProxy
@SpringBootApplication
public class AlgorithmsApplication {

  public static void main(String[] args) {
    SpringApplication.run(AlgorithmsApplication.class, args);
  }
}

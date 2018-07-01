package fworks.algorithms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Service discovery application.
 * 
 * @author flaviolcastro
 *
 */
@SpringBootApplication
@EnableEurekaServer
public class ServiceDiscoveryApplication {

  public static void main(String[] args) {
    SpringApplication.run(ServiceDiscoveryApplication.class, args);
  }

}

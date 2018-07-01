package fworks.algorithms.admin;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Server admin application.
 * 
 * @author flaviolcastro
 *
 */
@EnableAdminServer
@EnableAutoConfiguration
@EnableDiscoveryClient
@SpringBootApplication
public class ServerAdminApplication {

  public static void main(String[] args) {
    SpringApplication.run(ServerAdminApplication.class, args);
  }

}

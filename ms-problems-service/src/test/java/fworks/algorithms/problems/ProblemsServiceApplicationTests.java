package fworks.algorithms.problems;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(properties = "--eureka.client.enabled=false")
public class ProblemsServiceApplicationTests {

  @Test
  public void contextLoads() {
  }

}

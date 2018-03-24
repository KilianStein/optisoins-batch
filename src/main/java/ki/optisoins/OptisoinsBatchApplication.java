package ki.optisoins;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;


@SpringBootApplication
public class OptisoinsBatchApplication {

  public static void main(String[] args) {
    SpringApplicationBuilder builder = new SpringApplicationBuilder(OptisoinsBatchApplication.class);
    builder.headless(false).run(args);
  }
}

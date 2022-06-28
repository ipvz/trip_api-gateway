package ml.ipvz.trip;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayApplication {
    @Value("${gateway.test.message}")
    private String message;
    @Value("${gateway.test.message2}")
    private String message2;

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

    @Bean
    public CommandLineRunner runner() {
        return args -> {
            System.out.println("Application version: " + getVersion());
            System.out.println(message);
            System.out.println(message2);
        };
    }

    private String getVersion() {
        String version = this.getClass().getPackage().getImplementationVersion();
        return version != null ? version : "unknown";
    }
}

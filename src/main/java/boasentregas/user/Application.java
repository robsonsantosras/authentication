package boasentregas.user;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@SpringBootApplication(scanBasePackages = { "boasentregas.user", "boasentregas.accesslogs"})
@EnableMongoRepositories({"boasentregas.user.repositories","boasentregas.accesslogs.repositories"})
public class Application {

    public static void main(String... args) {
        SpringApplication.run(Application.class, args);
    }
}

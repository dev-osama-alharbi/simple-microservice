package sa.osama_alharbi.micro.orders.prv.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
        "sa.osama_alharbi.micro.orders.prv.auth.*",
        "sa.osama_alharbi.micro.orders.core.db"
})
public class PrvAuthApplication {
    public static void main(String[] args) {
        SpringApplication.run(PrvAuthApplication.class,args);
    }
}

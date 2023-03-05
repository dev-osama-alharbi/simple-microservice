package sa.osama_alharbi.micro.orders.prv.orders;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
        "sa.osama_alharbi.micro.orders.prv.orders.*",
        "sa.osama_alharbi.micro.orders.core.db"
})
public class PrvOrdersApplication {
    public static void main(String[] args) {
        SpringApplication.run(PrvOrdersApplication.class,args);
    }
}

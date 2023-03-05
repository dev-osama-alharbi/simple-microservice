package sa.osama_alharbi.micro.orders.prv.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@SpringBootApplication(scanBasePackages = {
        "sa.osama_alharbi.micro.orders.prv.client.*",
        "sa.osama_alharbi.micro.orders.core.db"
})
//@EnableFeignClients
public class PrvClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(PrvClientApplication.class,args);
    }
}

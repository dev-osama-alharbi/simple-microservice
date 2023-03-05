package sa.osama_alharbi.micro.orders.prv.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication(scanBasePackages = {
        "sa.osama_alharbi.micro.orders.prv.payment.*",
        "sa.osama_alharbi.micro.orders.core.db"
})
@EnableFeignClients(
        basePackages = {
                "sa.osama_alharbi.micro.orders.core.feigns"
        }
)
@PropertySources({
        @PropertySource("classpath:service-host-${spring.profiles.active}.properties")
})
public class PrvPaymentApplication {
    public static void main(String[] args) {
        SpringApplication.run(PrvPaymentApplication.class,args);
    }
}

package sa.osama_alharbi.micro.orders.pub.manager.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication
@EnableFeignClients(
        basePackages = {
                "sa.osama_alharbi.micro.orders.core.feigns"
        }
)
@PropertySources({
        @PropertySource("classpath:service-host-${spring.profiles.active}.properties")
})
public class PubManagerApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(PubManagerApiApplication.class,args);
    }
}

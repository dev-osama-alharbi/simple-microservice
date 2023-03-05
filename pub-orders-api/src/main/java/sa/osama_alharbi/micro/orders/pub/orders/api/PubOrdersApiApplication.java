package sa.osama_alharbi.micro.orders.pub.orders.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableFeignClients(
        basePackages = {
                "sa.osama_alharbi.micro.orders.core.feigns"
        }
)
@PropertySources({
        @PropertySource("classpath:service-host-${spring.profiles.active}.properties")
})
@EnableWebMvc
public class PubOrdersApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(PubOrdersApiApplication.class,args);
    }
}

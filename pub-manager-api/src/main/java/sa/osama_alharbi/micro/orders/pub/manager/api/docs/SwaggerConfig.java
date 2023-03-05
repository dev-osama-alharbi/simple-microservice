package sa.osama_alharbi.micro.orders.pub.manager.api.docs;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "orders-microservice-k8s-autodevelop",
                description = "orders-microservice to k8s and make it autodevelop with your team"
        )
)
public class SwaggerConfig {
}

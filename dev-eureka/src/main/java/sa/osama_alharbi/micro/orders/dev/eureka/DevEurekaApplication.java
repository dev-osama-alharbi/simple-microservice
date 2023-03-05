package sa.osama_alharbi.micro.orders.dev.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DevEurekaApplication {
    public static void main(String[] args) {
        SpringApplication.run(DevEurekaApplication.class,args);
    }

    /* ******************************************************************** #
     | service           | HOST             | PATH                  | PORT  |
     | ******************************************************************** |
     | dev-eureka        | DEV-EUREKA       | /                     | 8761  |
     | dev-gateway       | DEV-GATEWAY      | /                     | 88    |
     | ******************************************************************** |
     | pub-client-api    | PUB-CLIENT-API   | /api/v1/client/**     | 10002 |
     | pub-manager-api   | PUB-MANAGER-API  | /api/v1/manager/**    | 10003 |
     | pub-orders-api    | PUB-MANAGER-API  | /api/v1/orders/**     | 10004 |
     | ******************************************************************** |
     | prv-payment       | PRV-PAYMENT      | /prv/payment/**       | 10005 |
     | prv-orders        | PRV-ORDERS       | /prv/orders/**        | 10006 |
     | prv-notification  | PRV-NOTIFICATION | /prv/notification/**  | 10007 |
     | prv-client        | PRV-CLIENT       | /prv/client/**        | 10008 |
     | prv-auth          | PRV-AUTH         | /prv/auth/**          | 10009 |
     # *********************************************************************/
}

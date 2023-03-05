package sa.osama_alharbi.micro.orders.prv.payment.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DBConfiguration {

    @Value("${app.db.driver}")
    private String db_driver;

    @Value("${app.db.username}")
    private String db_username;

    @Value("${app.db.password}")
    private String db_password;

    @Value("${app.db.url}")
    private String db_url;


//    @Primary
    @Bean
    public DataSource getDatasource() {

        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName(db_driver);
        dataSource.setUsername(db_username);
        dataSource.setPassword(db_password);
        dataSource.setUrl(db_url);

        return dataSource;
    }
}

package co.edu.usco.convocations.server.usco_convocations_api;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.hibernate.autoconfigure.HibernateJpaAutoConfiguration;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;
import org.springframework.boot.security.autoconfigure.SecurityAutoConfiguration;
import org.springframework.boot.security.oauth2.server.resource.autoconfigure.servlet.OAuth2ResourceServerAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(properties = {
        "APP_PORT=0"
})
@EnableAutoConfiguration(exclude = {
        DataSourceAutoConfiguration.class,
        HibernateJpaAutoConfiguration.class,
        SecurityAutoConfiguration.class,
        OAuth2ResourceServerAutoConfiguration.class
})
class UscoConvocationsApiApplicationTests {

	@Test
	void contextLoads() {

	}

}

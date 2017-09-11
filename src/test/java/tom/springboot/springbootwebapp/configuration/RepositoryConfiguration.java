package tom.springboot.springbootwebapp.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = {"tom.springboot.springbootwebapp.domain"})
@EnableJpaRepositories(basePackages = {"tom.springboot.springbootwebapp.repositories"})
@EnableTransactionManagement
public class RepositoryConfiguration {
}

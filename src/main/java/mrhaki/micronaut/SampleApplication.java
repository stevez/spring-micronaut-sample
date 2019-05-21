package mrhaki.micronaut;

import io.micronaut.context.annotation.ConfigurationProperties;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.spring.beans.MicronautBeanProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import javax.inject.Singleton;

@SpringBootApplication
public class SampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SampleApplication.class, args);
    }

    @Bean
    public MicronautBeanProcessor httpClientMicronautBeanProcessor() {
        return new MicronautBeanProcessor(Client.class);
    }

}

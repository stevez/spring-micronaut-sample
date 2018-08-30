package mrhaki.micronaut;

import io.micronaut.http.client.Client;
import io.micronaut.spring.beans.MicronautBeanProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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

package configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@ComponentScan("by.anton")
public class Myconfig {
    @Bean //используется для осуществелиня HTTP reqest
    public RestTemplate restTemplate(){

        return new RestTemplate();
    }


}

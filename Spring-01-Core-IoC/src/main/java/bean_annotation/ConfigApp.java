package bean_annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigApp {

    @Bean
    FullTimeMentor fullTimeMentor(){
        return new FullTimeMentor();
    }

    @Bean
    PartTimeMentor partTimeMentor(){
        return new PartTimeMentor();
    }
}

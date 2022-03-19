package boasentregas.user.config;

import boasentregas.accesslogs.api.Register;
import boasentregas.accesslogs.service.AccessService;
import boasentregas.accesslogs.service.implement.AccessServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RegisterConfig {

    @Bean
    public Register ConfigRegister(){
        AccessService accessService = new AccessServiceImpl() ;
        return new Register(accessService);
    }

}

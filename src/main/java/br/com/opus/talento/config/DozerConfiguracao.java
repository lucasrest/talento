package br.com.opus.talento.config;

import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DozerConfiguracao {

    @Bean
    public DozerBeanMapper mapper() {
        return new DozerBeanMapper();
    }

}
package co.pivoterra.sendemail.config;

import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.stereotype.Component;

@Component
public class ContainerCustomizer implements WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> {
    @Override
    public void customize(ConfigurableServletWebServerFactory factory) {
        if(System.getenv("PORT")!=null) {
            factory.setPort(Integer.valueOf(System.getenv("PORT")));
        }
    }
}

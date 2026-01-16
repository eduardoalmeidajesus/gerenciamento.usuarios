package br.edu.utfpr.td.tsi.webapi.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import jakarta.ws.rs.ApplicationPath;

@Configuration
@ApplicationPath("/api")
public class JerseyConfiguration extends ResourceConfig {

    public JerseyConfiguration() {
        packages("br.edu.utfpr.td.tsi.webapi.endpoint");
    }
}

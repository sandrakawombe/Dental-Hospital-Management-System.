package snakayima.miu.edu.dentalhospitalmgmtsystem.SystemConfigurations;

import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class ContentNegotiationConfig implements WebMvcConfigurer {

    @Override
    public void configureContentNegotiation (ContentNegotiationConfigurer configurer) {
        configurer
                .favorParameter(false) // Disable query parameter-based negotiation
                .ignoreAcceptHeader(false) // Enable Accept header-based negotiation
                .defaultContentType(MediaType.APPLICATION_JSON) // Default to JSON
                .mediaType("json", MediaType.APPLICATION_JSON)
                .mediaType("xml", MediaType.APPLICATION_XML);
    }
}
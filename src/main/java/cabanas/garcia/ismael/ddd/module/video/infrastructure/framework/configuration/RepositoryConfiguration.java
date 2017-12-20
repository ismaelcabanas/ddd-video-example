package cabanas.garcia.ismael.ddd.module.video.infrastructure.framework.configuration;

import cabanas.garcia.ismael.ddd.module.video.domain.VideoRepository;
import cabanas.garcia.ismael.ddd.module.video.infrastructure.repository.InMemoryVideoRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryConfiguration {

    @Bean
    public VideoRepository inMemoryVideoRepository() {
        return new InMemoryVideoRepository();
    }
}

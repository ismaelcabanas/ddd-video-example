package cabanas.garcia.ismael.ddd.module.video.infrastructure.framework.configuration;

import cabanas.garcia.ismael.ddd.module.video.application.create.VideoCreator;
import cabanas.garcia.ismael.ddd.module.video.domain.VideoRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationServiceConfiguration {
    @Bean
    public VideoCreator videoCreator(VideoRepository videoRepository) {
        return new VideoCreator(videoRepository);
    }
}

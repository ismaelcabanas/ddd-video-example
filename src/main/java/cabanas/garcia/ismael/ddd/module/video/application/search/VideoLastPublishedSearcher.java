package cabanas.garcia.ismael.ddd.module.video.application.search;

import cabanas.garcia.ismael.ddd.module.video.domain.Video;
import cabanas.garcia.ismael.ddd.module.video.domain.VideoRepository;

import java.util.Optional;

public class VideoLastPublishedSearcher {
    private final VideoRepository repository;

    public VideoLastPublishedSearcher(VideoRepository videoRepository) {
        this.repository = videoRepository;
    }

    public Optional<Video> find() {
        return this.repository.findLastPublished();
    }
}

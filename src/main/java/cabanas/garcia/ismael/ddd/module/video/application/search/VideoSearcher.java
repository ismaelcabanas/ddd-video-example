package cabanas.garcia.ismael.ddd.module.video.application.search;

import cabanas.garcia.ismael.ddd.module.video.domain.Video;
import cabanas.garcia.ismael.ddd.module.video.domain.VideoRepository;

import java.util.List;

public class VideoSearcher {
    private final VideoRepository repository;

    public VideoSearcher(VideoRepository videoRepository) {
        this.repository = videoRepository;
    }

    public List<Video> findAll() {
        return this.repository.findAll();
    }
}

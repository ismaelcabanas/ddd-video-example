package cabanas.garcia.ismael.ddd.module.video.application.search;

import cabanas.garcia.ismael.ddd.module.video.domain.Video;
import cabanas.garcia.ismael.ddd.module.video.domain.VideoRepository;

import java.util.List;

public class VideoAllSearcher {
    private final VideoRepository repository;

    public VideoAllSearcher(VideoRepository videoRepository) {
        this.repository = videoRepository;
    }

    public List<Video> findAll() {
        return this.repository.findAll();
    }
}

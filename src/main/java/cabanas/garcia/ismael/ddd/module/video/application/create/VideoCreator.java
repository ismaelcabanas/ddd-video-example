package cabanas.garcia.ismael.ddd.module.video.application.create;

import cabanas.garcia.ismael.ddd.module.video.domain.*;

public class VideoCreator {
    private final VideoRepository repository;

    public VideoCreator(VideoRepository videoRepository) {
        this.repository = videoRepository;
    }

    public void create(VideoId id, VideoTitle title, VideoDuration duration, VideoCategory category) {
        Video video = Video.builder(id, title, duration, category).build();
        this.repository.save(video);
    }
}

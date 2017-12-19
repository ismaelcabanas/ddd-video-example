package cabanas.garcia.ismael.ddd.module.video.infrastructure.framework.repository;

import cabanas.garcia.ismael.ddd.module.video.domain.Video;
import cabanas.garcia.ismael.ddd.module.video.domain.VideoRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryVideoRepository implements VideoRepository {

    private List<Video> videos = new ArrayList<>();

    @Override
    public void save(Video video) {
        videos.add(video);
    }

    @Override
    public List<Video> findAll() {
        return videos;
    }

    @Override
    public Optional<Video> findLastPublished() {
        return videos.stream()
                .filter(video -> video.isPublished())
                .max((o1, o2) -> o1.publishingDate().compareTo(o2.publishingDate()));
    }
}

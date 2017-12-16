package cabanas.garcia.ismael.ddd.module.video.domain;

import java.util.List;

public interface VideoRepository {
    void save(Video video);

    List<Video> findAll();
}

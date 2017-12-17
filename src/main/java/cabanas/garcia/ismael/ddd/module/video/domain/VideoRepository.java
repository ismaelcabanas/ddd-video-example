package cabanas.garcia.ismael.ddd.module.video.domain;

import java.util.List;
import java.util.Optional;

public interface VideoRepository {
    void save(Video video);

    List<Video> findAll();

    Optional<Video> findLastPublished();
}

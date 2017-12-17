package cabanas.garcia.ismael.ddd.module.video.domain;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class VideoRepositorySuccessSearcherStub implements VideoRepository{
    private final Video[] videos;

    public VideoRepositorySuccessSearcherStub(Video... videos) {
        this.videos = videos;
    }

    @Override
    public void save(Video video) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Video> findAll() {
        return Arrays.asList(videos);
    }

    @Override
    public Optional<Video> findLastPublished() {
        return Arrays.stream(videos)
                .filter(video -> video.publishedDate() != null)
                .max(Comparator.comparing(Video::publishedDate));
    }
}

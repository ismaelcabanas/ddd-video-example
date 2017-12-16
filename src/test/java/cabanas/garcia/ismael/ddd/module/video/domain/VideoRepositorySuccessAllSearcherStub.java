package cabanas.garcia.ismael.ddd.module.video.domain;

import java.util.Arrays;
import java.util.List;

public class VideoRepositorySuccessAllSearcherStub implements VideoRepository{
    private final Video[] videos;

    public VideoRepositorySuccessAllSearcherStub(Video... videos) {
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
}

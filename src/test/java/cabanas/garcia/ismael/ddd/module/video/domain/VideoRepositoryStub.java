package cabanas.garcia.ismael.ddd.module.video.domain;

import java.util.List;
import java.util.Optional;

public class VideoRepositoryStub implements VideoRepository {
    private final List<Video> videos;
    private final Video lastPublishedVideo;

    private VideoRepositoryStub(Builder builder) {
        this.videos = builder.videos;
        this.lastPublishedVideo = builder.lastPublishedVideo;
    }

    @Override
    public void save(Video video) {

    }

    @Override
    public List<Video> findAll() {
        return this.videos;
    }

    @Override
    public Optional<Video> findLastPublished() {
        return Optional.ofNullable(lastPublishedVideo);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private List<Video> videos;
        private Video lastPublishedVideo;

        public Builder withVideos(List<Video> videos) {
            this.videos = videos;
            return this;
        }

        public VideoRepositoryStub build() {
            return new VideoRepositoryStub(this);
        }

        public Builder withLastPublishedVideo(Video lastPublishedVideo) {
            this.lastPublishedVideo = lastPublishedVideo;
            return this;
        }

        public Builder withoutPublishedVideos() {
            this.lastPublishedVideo = null;
            return this;
        }
    }
}

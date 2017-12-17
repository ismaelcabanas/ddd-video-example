package cabanas.garcia.ismael.ddd.module.video.domain;

import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.time.LocalDateTime;

public class Video {
    private final VideoId id;
    private final VideoTitle title;
    private final VideoDuration duration;
    private final VideoCategory category;
    private final LocalDateTime publishedDate;

    private Video(Builder builder) {
        this.id = builder.id;
        this.title = builder.title;
        this.duration = builder.duration;
        this.category = builder.category;
        this.publishedDate = builder.publishedDate;
    }

    public VideoId id() {
        return this.id;
    }

    public VideoTitle title() {
        return this.title;
    }

    public VideoDuration duration() {
        return this.duration;
    }

    public VideoCategory category() {
        return this.category;
    }

    public LocalDateTime publishedDate() {
        return this.publishedDate;
    }

    public static Builder builder(VideoId id, VideoTitle title, VideoDuration duration, VideoCategory category) {
        return new Builder(id, title, duration, category);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Video video = (Video) o;

        return new org.apache.commons.lang3.builder.EqualsBuilder()
                .append(id, video.id)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .toHashCode();
    }

    public static class Builder {
        private final VideoId id;
        private final VideoTitle title;
        private final VideoDuration duration;
        private final VideoCategory category;
        private LocalDateTime publishedDate;

        public Builder(VideoId id, VideoTitle title, VideoDuration duration, VideoCategory category) {
            this.id = id;
            this.title = title;
            this.duration = duration;
            this.category = category;
        }

        public Video build() {
            return new Video(this);
        }

        public Builder withVideoPublishDate(LocalDateTime publishedDate) {
            this.publishedDate = publishedDate;
            return this;
        }
    }
}

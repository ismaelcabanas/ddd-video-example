package cabanas.garcia.ismael.ddd.module.video.domain;

import java.time.LocalDateTime;

public class VideoStub {

    private VideoStub(){}

    public static Video random() {
        return Video.builder(VideoIdStub.random(), VideoTitleStub.random(), VideoDurationStub.random(),
                VideoCategoryStub.random()).build();
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private VideoId videoId;
        private VideoTitle videoTitle;
        private VideoDuration videoDuration;
        private VideoCategory videoCategory;
        private LocalDateTime videoPublishedDate;

        public Builder withId(VideoId videoId) {
            this.videoId = videoId;
            return this;
        }

        public Builder withTitle(VideoTitle videoTitle) {
            this.videoTitle = videoTitle;
            return this;
        }

        public Builder withDuration(VideoDuration videoDuration) {
            this.videoDuration = videoDuration;
            return this;
        }

        public Builder withCategory(VideoCategory videoCategory) {
            this.videoCategory = videoCategory;
            return this;
        }

        public Builder withPublishDateAt(LocalDateTime videoPublishedDate) {
            this.videoPublishedDate = videoPublishedDate;
            return this;
        }

        public Video build() {
            return Video.builder(videoId, videoTitle, videoDuration, videoCategory)
                    .withVideoPublishDate(videoPublishedDate)
                    .build();
        }
    }
}

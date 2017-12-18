package cabanas.garcia.ismael.ddd.module.video.application.search;

import cabanas.garcia.ismael.ddd.module.video.domain.*;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class VideoLastPublishedSearcherShould {

    private final LocalDateTime REFERENCE_DATE_TIME = LocalDateTime.of(2016, 4, 1, 10, 0); //2016-04-01 at 10:00am

    @Test public void
    find_last_published_video() {
        Video oneVideo = VideoStub.random();
        oneVideo.publish(REFERENCE_DATE_TIME);
        VideoRepositoryStub videoRepositoryStub = VideoRepositoryStub.builder()
                .withLastPublishedVideo(oneVideo)
                .build();
        VideoLastPublishedSearcher videoSearcher = new VideoLastPublishedSearcher(videoRepositoryStub);

        Optional<Video> lastVideoPublished = videoSearcher.find();

        assertThat(lastVideoPublished)
                .isNotEmpty()
                .isEqualTo(Optional.ofNullable(oneVideo));
    }

    @Test public void
    return_empty_when_not_exist_published_videos() {
        VideoRepositoryStub videoRepositoryStub = VideoRepositoryStub.builder()
                .withoutPublishedVideos()
                .build();
        VideoLastPublishedSearcher videoSearcher = new VideoLastPublishedSearcher(videoRepositoryStub);

        Optional<Video> lastVideoPublished = videoSearcher.find();

        assertThat(lastVideoPublished).isEmpty();
    }
}

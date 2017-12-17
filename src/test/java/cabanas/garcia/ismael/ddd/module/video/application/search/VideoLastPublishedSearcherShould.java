package cabanas.garcia.ismael.ddd.module.video.application.search;

import cabanas.garcia.ismael.ddd.module.video.domain.*;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class VideoLastPublishedSearcherShould {

    private final LocalDateTime REFERENCE_DATE_TIME = LocalDateTime.of(2016, 4, 1, 10, 0); //2016-04-01 at 10:00am

    @Test public void
    find_last_published_video() {
        Video videoNotPublished = VideoStub.random();
        Video videoPublished = VideoStub.builder().withId(VideoIdStub.random())
                .withTitle(VideoTitleStub.random())
                .withDuration(VideoDurationStub.random())
                .withCategory(VideoCategoryStub.random())
                .withPublishDateAt(REFERENCE_DATE_TIME)
                .build();
        Video theLastvideoPublished = VideoStub.builder().withId(VideoIdStub.random())
                .withTitle(VideoTitleStub.random())
                .withDuration(VideoDurationStub.random())
                .withCategory(VideoCategoryStub.random())
                .withPublishDateAt(REFERENCE_DATE_TIME.plusDays(2))
                .build();
        VideoRepositorySuccessSearcherStub videoRepository =
                new VideoRepositorySuccessSearcherStub(videoNotPublished, videoPublished, theLastvideoPublished);
        VideoLastPublishedSearcher videoSearcher = new VideoLastPublishedSearcher(videoRepository);

        Optional<Video> lastVideoPublished = videoSearcher.find();

        assertThat(lastVideoPublished).isNotEmpty();
        assertThat(lastVideoPublished.get()).isEqualTo(theLastvideoPublished);
    }

    @Test public void
    return_empty_when_not_exist_published_videos() {
        Video videoNotPublished = VideoStub.random();
        Video anotherVideoNotPublished = VideoStub.random();
        VideoRepositorySuccessSearcherStub videoRepository =
                new VideoRepositorySuccessSearcherStub(videoNotPublished, anotherVideoNotPublished);
        VideoLastPublishedSearcher videoSearcher = new VideoLastPublishedSearcher(videoRepository);

        Optional<Video> lastVideoPublished = videoSearcher.find();

        assertThat(lastVideoPublished).isEmpty();
    }
}

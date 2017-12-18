package cabanas.garcia.ismael.ddd.module.video.application.search;

import cabanas.garcia.ismael.ddd.module.video.domain.Video;
import cabanas.garcia.ismael.ddd.module.video.domain.VideoRepositoryStub;
import cabanas.garcia.ismael.ddd.module.video.domain.VideoStub;
import org.junit.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public final class VideoLastPublishedSearcherShould {

    @Test public void
    find_last_published_video() {
        Video oneVideo = VideoStub.random();
        VideoRepositoryStub videoRepositoryStub = VideoRepositoryStub.builder()
                .withLastPublishedVideo(oneVideo)
                .build();
        VideoLastPublishedSearcher videoSearcher = new VideoLastPublishedSearcher(videoRepositoryStub);

        Optional<Video> lastVideoPublished = videoSearcher.find();

        assertThat(lastVideoPublished)
                .isNotEmpty()
                .isEqualTo(Optional.of(oneVideo));
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

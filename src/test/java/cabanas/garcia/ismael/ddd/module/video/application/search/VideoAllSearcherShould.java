package cabanas.garcia.ismael.ddd.module.video.application.search;

import cabanas.garcia.ismael.ddd.module.video.domain.Video;
import cabanas.garcia.ismael.ddd.module.video.domain.VideoRepositoryStub;
import cabanas.garcia.ismael.ddd.module.video.domain.VideoStub;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public final class VideoAllSearcherShould {

    @Test public void
    search_all_existent_videos() {
        Video oneVideo = VideoStub.random();
        Video anotherVideo = VideoStub.random();
        VideoRepositoryStub videoRepositoryStub = VideoRepositoryStub.builder()
                        .withVideos(Arrays.asList(oneVideo, anotherVideo))
                        .build();
        VideoAllSearcher videoSearcher = new VideoAllSearcher(videoRepositoryStub);

        List<Video> allVideos = videoSearcher.findAll();

        assertThat(allVideos).containsExactlyInAnyOrder(oneVideo, anotherVideo);
    }
}

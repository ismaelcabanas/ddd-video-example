package cabanas.garcia.ismael.ddd.module.video.application.search;

import cabanas.garcia.ismael.ddd.module.video.domain.Video;
import cabanas.garcia.ismael.ddd.module.video.domain.VideoRepositorySuccessAllSearcherStub;
import cabanas.garcia.ismael.ddd.module.video.domain.VideoStub;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class VideoSearchShould {

    @Test public void
    search_all_existent_videos() {
        Video oneVideo = VideoStub.random();
        Video anotherVideo = VideoStub.random();
        VideoRepositorySuccessAllSearcherStub videoRepository =
                new VideoRepositorySuccessAllSearcherStub(oneVideo, anotherVideo);
        VideoSearcher videoSearcher = new VideoSearcher(videoRepository);

        List<Video> allVideos = videoSearcher.findAll();

        assertThat(allVideos).containsExactlyInAnyOrder(oneVideo, anotherVideo);
    }
}

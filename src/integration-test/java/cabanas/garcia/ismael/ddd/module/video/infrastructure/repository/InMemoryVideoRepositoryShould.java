package cabanas.garcia.ismael.ddd.module.video.infrastructure.repository;

import cabanas.garcia.ismael.ddd.module.video.domain.Video;
import cabanas.garcia.ismael.ddd.module.video.domain.VideoPublishDate;
import cabanas.garcia.ismael.ddd.module.video.domain.VideoRepository;
import cabanas.garcia.ismael.ddd.module.video.domain.VideoStub;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class InMemoryVideoRepositoryShould {

    private final LocalDateTime REFERENCE_DATE_TIME = LocalDateTime.of(2016, 4, 1, 10, 0); //2016-04-01 at 10:00am

    @Test public void
    find_all_videos() {
        Video oneVideo = VideoStub.random();
        Video anotherVideo = VideoStub.random();
        VideoRepository videoRepository = new InMemoryVideoRepository();
        videoRepository.save(oneVideo);
        videoRepository.save(anotherVideo);

        List<Video> allVideos = videoRepository.findAll();

        assertThat(allVideos)
                .isNotEmpty()
                .containsExactly(oneVideo, anotherVideo);
    }

    @Test public void
    find_last_published_video() {
        Video oneVideo = VideoStub.random();
        Video secondVideo = VideoStub.random();
        Video thirdVideo = VideoStub.random();
        secondVideo.publish(new VideoPublishDate(REFERENCE_DATE_TIME.minusDays(2)));
        thirdVideo.publish(new VideoPublishDate(REFERENCE_DATE_TIME));
        VideoRepository videoRepository = new InMemoryVideoRepository();
        videoRepository.save(oneVideo);
        videoRepository.save(secondVideo);
        videoRepository.save(thirdVideo);

        Optional<Video> lastPublishedVideo = videoRepository.findLastPublished();

        assertThat(lastPublishedVideo)
                .isNotEmpty()
                .isEqualTo(Optional.of(thirdVideo));
    }

}

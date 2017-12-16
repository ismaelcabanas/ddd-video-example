package cabanas.garcia.ismael.ddd.module.video.application.create;

import cabanas.garcia.ismael.ddd.module.video.application.create.VideoCreator;
import cabanas.garcia.ismael.ddd.module.video.domain.Video;
import cabanas.garcia.ismael.ddd.module.video.domain.VideoRepositorySuccessStub;
import cabanas.garcia.ismael.ddd.module.video.domain.VideoStub;
import org.junit.Test;

public class VideoCreatorShould {

    @Test public void
    save_video() {
        Video video = VideoStub.random();
        VideoRepositorySuccessStub videoRepository = new VideoRepositorySuccessStub(video);
        VideoCreator videoCreator = new VideoCreator(videoRepository);

        videoCreator.create(video.id(), video.title(), video.duration(), video.category());

        videoRepository.shouldSave(video);
    }

}
package cabanas.garcia.ismael.ddd.module.video.application.create;

import cabanas.garcia.ismael.ddd.module.video.domain.Video;
import cabanas.garcia.ismael.ddd.module.video.domain.VideoRepositorySuccessCreateMock;
import cabanas.garcia.ismael.ddd.module.video.domain.VideoStub;
import org.junit.Test;

public class VideoCreatorShould {

    @Test public void
    save_video() {
        Video video = VideoStub.random();
        VideoRepositorySuccessCreateMock videoRepositoryMock = new VideoRepositorySuccessCreateMock(video);
        VideoCreator videoCreator = new VideoCreator(videoRepositoryMock);

        videoCreator.create(video.id(), video.title(), video.duration(), video.category());

        videoRepositoryMock.shouldSave(video);
    }

}

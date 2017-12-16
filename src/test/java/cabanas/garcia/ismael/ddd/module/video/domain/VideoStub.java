package cabanas.garcia.ismael.ddd.module.video.domain;

public class VideoStub {
    public static Video random() {
        return Video.builder(VideoIdStub.random(), VideoTitleStub.random(), VideoDurationStub.random(),
                VideoCategoryStub.random()).build();
    }
}

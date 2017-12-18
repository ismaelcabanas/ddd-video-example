package cabanas.garcia.ismael.ddd.module.video.domain;

public class VideoStub {

    private VideoStub(){}

    public static Video random() {
        return Video.builder(VideoIdStub.random(), VideoTitleStub.random(), VideoDurationStub.random(),
                VideoCategoryStub.random()).build();
    }

}

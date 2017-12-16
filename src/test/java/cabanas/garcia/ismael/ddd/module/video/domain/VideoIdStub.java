package cabanas.garcia.ismael.ddd.module.video.domain;

import cabanas.garcia.ismael.ddd.module.shared.UuidStub;

public class VideoIdStub {
    public static VideoId random() {
        return new VideoId(UuidStub.random().toString());
    }
}

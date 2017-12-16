package cabanas.garcia.ismael.ddd.module.video.domain;

import cabanas.garcia.ismael.ddd.module.shared.DurationStub;

public class VideoDurationStub {
    public static VideoDuration random() {
        return new VideoDuration(DurationStub.random());
    }
}

package cabanas.garcia.ismael.ddd.module.video.domain;

import cabanas.garcia.ismael.ddd.module.shared.IntStub;
import cabanas.garcia.ismael.ddd.module.shared.StringStub;

public class VideoTitleStub {
    private static int MINIMUM_CHARS = 1;
    private static int MAXIMUM_CHARS = 50;

    public static VideoTitle random() {
        return new VideoTitle(StringStub.random(IntStub.randomBetween(MINIMUM_CHARS, MAXIMUM_CHARS)));
    }
}

package cabanas.garcia.ismael.ddd.module.video.domain;

import java.time.LocalDateTime;

public class VideoPublishDate {

    private final LocalDateTime value;

    public VideoPublishDate(LocalDateTime value) {
        this.value = value;
    }

    public boolean isEmpty() {
        return false;
    }
}

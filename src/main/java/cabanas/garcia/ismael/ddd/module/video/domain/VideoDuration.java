package cabanas.garcia.ismael.ddd.module.video.domain;

import java.time.Duration;

public class VideoDuration {
    private final Duration value;

    public VideoDuration(Duration value) {
        this.value = value;
    }

    public VideoDuration(long durationInSeconds) {
        this.value = Duration.ofSeconds(durationInSeconds);
    }

    public Duration getValue() {
        return value;
    }
}

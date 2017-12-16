package cabanas.garcia.ismael.ddd.module.shared;

import java.time.Duration;

public class DurationStub {
    public static Duration random() {
        return Duration.ofSeconds(IntStub.randomUnsigned());
    }
}

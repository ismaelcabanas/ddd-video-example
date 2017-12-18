package cabanas.garcia.ismael.ddd.module.video.domain;

import java.time.LocalDateTime;
import java.util.Optional;

public class VideoPublishDate implements Comparable{

    public static final VideoPublishDate EMPTY = new VideoPublishDate();

    private Optional<LocalDateTime> value;

    public VideoPublishDate(LocalDateTime value) {
        this.value = Optional.of(value);
    }

    private VideoPublishDate() {
        this.value = Optional.empty();
    }

    public boolean isEmpty() {
        return false;
    }

    @Override
    public int compareTo(Object o) {
        VideoPublishDate anotherVideoPublishDate = (VideoPublishDate) o;

        if(!this.value.isPresent() && anotherVideoPublishDate.value.isPresent())
            return -1;

        if(this.value.isPresent() && !anotherVideoPublishDate.value.isPresent())
            return 1;

        return this.value.get().compareTo(anotherVideoPublishDate.value.get());
    }
}

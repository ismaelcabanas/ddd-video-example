package cabanas.garcia.ismael.ddd.module.video.infrastructure.framework.controller.request;

public class VideoRequestDTO {

    private String id;
    private String title;
    private String category;
    private long durationInSeconds;

    public long getDurationInSeconds() {
        return durationInSeconds;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setDurationInSeconds(long durationInSeconds) {
        this.durationInSeconds = durationInSeconds;
    }
}

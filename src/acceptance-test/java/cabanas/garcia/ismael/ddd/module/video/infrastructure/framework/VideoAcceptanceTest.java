package cabanas.garcia.ismael.ddd.module.video.infrastructure.framework;


import cabanas.garcia.ismael.ddd.module.video.domain.VideoCategoryStub;
import cabanas.garcia.ismael.ddd.module.video.domain.VideoDurationStub;
import cabanas.garcia.ismael.ddd.module.video.domain.VideoIdStub;
import cabanas.garcia.ismael.ddd.module.video.domain.VideoTitleStub;
import cabanas.garcia.ismael.ddd.module.video.infrastructure.framework.controller.response.VideoResponseDTO;
import io.restassured.http.ContentType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = Application.class)
public class VideoAcceptanceTest {

    private static final String TITLE = "title";
    private static final String DURATION_IN_SECONDS = "durationInSeconds";
    private static final String CATEGORY = "category";
    private static final String ID = "id";

    @LocalServerPort
    private int port;

    @Test public void
    create_video() {
        Map<String, Object> videoData = new HashMap<>();
        videoData.put(ID, VideoIdStub.random().getValue());
        videoData.put(TITLE, VideoTitleStub.random().getValue());
        videoData.put(DURATION_IN_SECONDS, VideoDurationStub.random().getValue().getSeconds());
        videoData.put(CATEGORY, VideoCategoryStub.random().getValue());

        given()
            .port(port)
            .basePath("/videos")
            .log().everything()
            .body(videoData)
            .contentType(ContentType.JSON)
        .when()
            .post()
        .then()
            .statusCode(201)
            .contentType(ContentType.JSON);
    }
/*
    @Test public void
    find_all_videos() {

        List<VideoResponseDTO> response =
            given()
                .port(port)
                .basePath("/videos")
                .log().everything()
                .contentType(ContentType.JSON)
            .when()
                .get()
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .extract()
                .as(List.class);

    }
*/
}

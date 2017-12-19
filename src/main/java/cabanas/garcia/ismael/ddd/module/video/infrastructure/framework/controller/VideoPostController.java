package cabanas.garcia.ismael.ddd.module.video.infrastructure.framework.controller;

import cabanas.garcia.ismael.ddd.module.video.application.create.VideoCreator;
import cabanas.garcia.ismael.ddd.module.video.domain.VideoCategory;
import cabanas.garcia.ismael.ddd.module.video.domain.VideoDuration;
import cabanas.garcia.ismael.ddd.module.video.domain.VideoId;
import cabanas.garcia.ismael.ddd.module.video.domain.VideoTitle;
import cabanas.garcia.ismael.ddd.module.video.infrastructure.framework.controller.request.VideoRequestDTO;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping(value = "/videos")
public class VideoPostController {

    private final VideoCreator videoCreator;

    public VideoPostController(VideoCreator videoCreator) {
        this.videoCreator = videoCreator;
    }

    @PostMapping
    public ResponseEntity<Void> post(@RequestBody VideoRequestDTO videoRequestDTO) {
        videoCreator.create(new VideoId(videoRequestDTO.getId()), new VideoTitle(videoRequestDTO.getTitle()),
                new VideoDuration(videoRequestDTO.getDurationInSeconds()), new VideoCategory(videoRequestDTO.getCategory()));

        return ResponseEntity
                .created(URI.create("/videos/" + videoRequestDTO.getId()))
                .contentType(MediaType.APPLICATION_JSON)
                .build();
    }
}

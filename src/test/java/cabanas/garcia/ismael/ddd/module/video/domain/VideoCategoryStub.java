package cabanas.garcia.ismael.ddd.module.video.domain;

import cabanas.garcia.ismael.ddd.module.shared.IntStub;

import java.util.Arrays;

public class VideoCategoryStub {

    private static String[] categories = new String[] {"Screencast", "Interview", "Tutorial"};

    public static VideoCategory random() {
        return new VideoCategory(categories[IntStub.randomBetween(0, categories.length-1)]);
    }
}

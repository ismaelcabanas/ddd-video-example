package cabanas.garcia.ismael.ddd.module.shared;

import org.apache.commons.lang3.RandomUtils;

public class IntStub {
    public static int randomBetween(int minimumChars, int maximumChars) {
        return RandomUtils.nextInt(minimumChars, maximumChars);
    }

    public static long randomUnsigned() {
        return randomBetween(0, Integer.MAX_VALUE);
    }
}

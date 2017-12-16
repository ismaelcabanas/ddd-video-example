package cabanas.garcia.ismael.ddd.module.shared;

import org.apache.commons.lang3.RandomStringUtils;

public class StringStub {
    public static String random(int numChars) {
        return RandomStringUtils.random(numChars);
    }
}

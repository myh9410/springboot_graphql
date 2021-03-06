package com.example.graphql;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomHelper {

    public static String randomString() {
        int leftLimit = 97;
        int rightLimit = 122;
        int targetStringLength = 10;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return generatedString;
    }

    public static int randomInt() {
        return ThreadLocalRandom.current().nextInt(100, 100+1);
    }

    public static Long randomLong() {
        return ThreadLocalRandom.current().nextLong(100, 100+1);
    }

    public static Boolean randomBoolean() {
        return ThreadLocalRandom.current().nextBoolean();
    }
}

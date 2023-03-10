package by.mich.util;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.StreamSupport;

public class Util {


    public static int[] generateArray(int limit, int lower, int upper) {
        return IntStream.generate(
            () -> ThreadLocalRandom.current().nextInt(lower, upper))
            .limit(limit)
            .toArray();
    }

    public static int[] generateArray(int limit) {
        return generateArray(limit, 0, 10);
    }
}

package solution;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CommonTermCounter {

    public List<Map.Entry<String, Long>> getCommonWordFrequencyAndCount(List<String> stems) {

        // Add freq to map
        final Map<String, Long> collect = stems.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        // Sort and map 20 words
        final List<Map.Entry<String, Long>> entries = new ArrayList<>(collect.entrySet());
        final List<Map.Entry<String, Long>> result = entries.stream()
                .sorted(Comparator.comparing(Map.Entry::getValue, Comparator.reverseOrder()))
                .limit(20)
                .collect(Collectors.toList());

        return result;
    }
}


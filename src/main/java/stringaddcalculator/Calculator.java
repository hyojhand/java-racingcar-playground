package stringaddcalculator;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Calculator {

    private static final Pattern NUMBER_PATTERN = Pattern.compile("^[0-9]*$");
    private static final Pattern CUSTOM_PATTERN = Pattern.compile("//(.*)\n(.*)");
    private static final String DEFAULT_SEPARATOR = "[,:]";

    public int calculate(String input) {
        if (isEmpty(input)) {
            return 0;
        }

        List<String> separateValues = separateValue(input);
        return addNumber(mappingNumbers(separateValues));
    }

    private List<String> separateValue(String input) {
        String value = input;
        String separator = DEFAULT_SEPARATOR;

        Matcher matcher = CUSTOM_PATTERN.matcher(input);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            separator += ("|" + customDelimiter);
            value = matcher.group(2);
        }

        return List.of(value.split(separator));
    }

    private Integer addNumber(List<Integer> numbers) {
        return numbers.stream()
                .reduce(0, Integer::sum);
    }

    private List<Integer> mappingNumbers(List<String> values) {
        return values.stream()
                .filter(value -> !value.equals(""))
                .map(this::changeInt)
                .collect(Collectors.toList());
    }

    private int changeInt(String value) {
        if (!NUMBER_PATTERN.matcher(value).matches()) {
            throw new IllegalArgumentException("숫자가 아니거나 음수입니다");
        }

        return Integer.parseInt(value);
    }

    private boolean isEmpty(String text) {
        return text == null || text.equals("");
    }
}

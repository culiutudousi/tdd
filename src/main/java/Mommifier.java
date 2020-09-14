import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Mommifier {

    public static final String VOWELS = "aeiou";
    public static final String MOMMY = "mommy";

    public String mommify(String string) {
        if (string.length() == 0) {
            return string;
        }
        if (!isVowelMoreThan(string, 0.3)) {
            return string;
        }
        List<String> splittedStrings = splitVowelSetWithNonVowelSet(string);
        return addMommyBeforeVowelSet(splittedStrings);
    }

    private String addMommyBeforeVowelSet(List<String> splittedStrings) {
        List<String> addedStrings = splittedStrings.stream()
                .map(s -> {
                    if (VOWELS.contains(Character.toString(s.charAt(0)).toLowerCase())) {
                        return MOMMY + s;
                    }
                    return s;
                })
                .collect(Collectors.toList());
        return String.join("", addedStrings);
    }

    private List<String> splitVowelSetWithNonVowelSet(String string) {
        List<String> vowelStack = new ArrayList<>();
        List<String> nonVowelStack = new ArrayList<>();
        List<String> mixedResult = new ArrayList<>();
        string.codePoints()
                .mapToObj(c -> String.valueOf((char) c))
                .forEachOrdered(s -> {
                    if (VOWELS.contains(s.toLowerCase())) {
                        addStackToResult(nonVowelStack, mixedResult);
                        vowelStack.add(s);
                    } else {
                        addStackToResult(vowelStack, mixedResult);
                        mixedResult.add(s);
                    }
                });
        addStackToResult(nonVowelStack, mixedResult);
        addStackToResult(vowelStack, mixedResult);
        return mixedResult;
    }

    private void addStackToResult(List<String> stack, List<String> result) {
        if (stack.size() > 0) {
            result.add(String.join("", stack));
            stack.clear();
        }
    }

    private Boolean isVowelMoreThan(String string, double percentage) {
        long vowelNumber = string.codePoints()
                .mapToObj(c -> String.valueOf((char) c))
                .filter(s -> VOWELS.contains(s.toLowerCase()))
                .count();
        double vowelPercentage = (double) vowelNumber / string.length();
        if (vowelPercentage > percentage) {
            return true;
        }
        return false;
    }
}

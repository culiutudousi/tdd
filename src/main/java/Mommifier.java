import java.util.ArrayList;
import java.util.List;

public class Mommifier {

    public static final String VOWELS = "aeiou";
    public static final String MOMMY = "mommy";

    public String mommify(String string) {
        if (!isVowelMoreThan(string, 0.3)) {
            return string;
        }
        List<String> vowelStack = new ArrayList<>();
        List<String> resultStringList = new ArrayList<>();
        string.codePoints()
                .mapToObj(c -> String.valueOf((char) c))
                .forEachOrdered(s -> {
                    if (VOWELS.contains(s.toLowerCase())) {
                        vowelStack.add(s);
                    } else {
                        if (vowelStack.size() > 0) {
                            resultStringList.add(MOMMY);
                            resultStringList.add(String.join("", vowelStack));
                            vowelStack.clear();
                        }
                        resultStringList.add(s);
                    }
                });
        if (vowelStack.size() > 0) {
            resultStringList.add(MOMMY);
            resultStringList.add(String.join("", vowelStack));
        }
        return String.join("", resultStringList);
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

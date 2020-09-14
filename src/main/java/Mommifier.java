import java.util.ArrayList;
import java.util.List;

public class Mommifier {

    public static final String VOWELS = "aeiou";
    public static final String MOMMY = "mommy";

    public String mommify(String string) {
        if (!isVowelMoreThan(string, 0.3)) {
            return string;
        }
        List<String> resultStringList = new ArrayList<>();
        string.codePoints()
                .mapToObj(c -> String.valueOf((char) c))
                .forEachOrdered(s -> {
                    if (VOWELS.contains(s.toLowerCase())) {
                        resultStringList.add(MOMMY);
                    }
                    resultStringList.add(s);
                });
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

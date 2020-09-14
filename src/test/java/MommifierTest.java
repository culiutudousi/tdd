import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MommifierTest {

    public static final String VOWELS_LESS_THAN_30_PERCENT = "ae23456789";
    public static final String VOWELS_EQUALS_30_PERCENT = "aei3456789";
    public static final String SEPARATE_VOWELS_MORE_THAN_30_PERCENT = "a1e3i5o6u789";
    public static final String MOMMIFIED_SEPARATE_VOWELS_MORE_THAN_30_PERCENT = "mommya1mommye3mommyi5mommyo6mommyu789";

    @Test
    void should_return_original_string_when_mommify_given_string_that_holds_vowels_less_than_30_percent() {
        Mommifier mommifier = new Mommifier();
        String mommifiedString = mommifier.mommify(VOWELS_LESS_THAN_30_PERCENT);
        assertEquals(VOWELS_LESS_THAN_30_PERCENT, mommifiedString);
    }

    @Test
    void should_return_original_string_when_mommify_given_string_that_holds_vowels_equals_30_percent() {
        Mommifier mommifier = new Mommifier();
        String mommifiedString = mommifier.mommify(VOWELS_EQUALS_30_PERCENT);
        assertEquals(VOWELS_EQUALS_30_PERCENT, mommifiedString);
    }

    @Test
    void should_return_string_with_mommy_before_every_vowel_when_mommify_given_string_that_holds_separate_vowels_more_than_30_percent() {
        Mommifier mommifier = new Mommifier();
        String mommifiedString = mommifier.mommify(SEPARATE_VOWELS_MORE_THAN_30_PERCENT);
        assertEquals(MOMMIFIED_SEPARATE_VOWELS_MORE_THAN_30_PERCENT, mommifiedString);
    }
}

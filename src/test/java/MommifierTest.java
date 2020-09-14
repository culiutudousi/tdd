import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MommifierTest {

    public static final String VOWELS_LESS_THAN_30_PERCENT = "vowels less than 30 percent.";

    @Test
    void should_return_original_string_when_mommify_given_string_that_holds_vowels_less_than_30_percent() {
        Mommifier mommifier = new Mommifier();
        String mommifiedString = mommifier.mommify(VOWELS_LESS_THAN_30_PERCENT);
        assertEquals(VOWELS_LESS_THAN_30_PERCENT, mommifiedString);
    }
}

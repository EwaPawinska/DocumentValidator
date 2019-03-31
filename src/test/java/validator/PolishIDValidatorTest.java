package validator;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PolishIDValidatorTest {


    private PolishIDValidator plID;

    @Before
    public void setUp(){
        plID = new PolishIDValidator();
    }

    @Test
    public void validateFormat_ValidFormatID() {
        String given = "ATL739719";
        boolean expected = true;

        assertEquals(expected, plID.validateFormat(given));
    }

    @Test
    public void validateFormat_emptyInput() {
        String given = "";
        boolean expected = false;

        assertEquals(expected, plID.validateFormat(given));
    }

    @Test
    public void validateFormat_InvalidLength_lessThan9chars() {
        String given = "abc";
        boolean expected = false;

        assertEquals(expected, plID.validateFormat(given));
    }

    @Test
    public void validateFormat_InvalidLength_moreThan9chars() {
        String given = "abc123456789asd";
        boolean expected = false;

        assertEquals(expected, plID.validateFormat(given));
    }

    @Test
    public void validateFormat_InvalidFormat_OnlyDigits() {
        String given = "111739719";
        boolean expected = false;

        assertEquals(expected, plID.validateFormat(given));
    }

    @Test
    public void validateFormat_InvalidFormat_OnlyLetters() {
        String given = "ATLahftAa";
        boolean expected = false;

        assertEquals(expected, plID.validateFormat(given));
    }

    @Test
    public void computeCheckSum_Valid() {
        String given = "ATL739719";
        int expected = 10*7 +29*3 +21*1 + 7*9 + 3*7 + 9*3 + 7*1 + 1*7 + 9*3;

        assertEquals(expected, plID.computeCheckSum(given));
    }

    @Test
    public void computeCheckSum_emptyInput() {
        String given = "";
        int expected = 10*7 +29*3 +21*1 + 7*9 + 3*7 + 9*3 + 7*1 + 1*7 + 9*3;

        assertEquals(expected, plID.computeCheckSum(given));
    }
}

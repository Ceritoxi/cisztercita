package bowling.service.parse;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ParsePreparerTest {

    private ParsePreparer underTest;

    @Before
    public void setUp() {
        underTest = new ParsePreparer();
    }

    @Test
    public void prepareInputForParsingShouldModifyInputToDesiredFormat() {
        String[] actual = underTest.prepareInputForParsing(new String[] { "-/", "-/", "-/", "-/", "-/", "-/", "-/", "-/", "-/", "-/-" });
        String[] expected = { "0", "0", "/", "0", "/", "0", "/", "0", "/", "0", "/", "0", "/", "0", "/", "0", "/", "0", "/", "0", "/", "0", "0", "0" };
        assertArrayEquals(expected, actual);
    }

    @Test
    public void prepareInputForParsingShouldExtendTheEndWithTwoZeroes() {
        String[] actual = underTest.prepareInputForParsing(new String[] { "-/", "-/", "-/", "-/", "-/", "-/", "-/", "-/", "-/", "-/-" });
        assertTrue(String.join("", actual).endsWith("00"));
    }

    @Test
    public void prepareInputForParsingShouldExtendTheStartWithAZero() {
        String[] actual = underTest.prepareInputForParsing(new String[] { "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x" });
        assertTrue(String.join("", actual).startsWith("0"));
    }

    @Test
    public void prepareInputForParsingShouldNotContainDashes() {
        String[] actual = underTest.prepareInputForParsing(new String[] { "-/", "-/", "-/", "-/", "-/", "-/", "-/", "-/", "-/", "-/-" });
        assertFalse(Arrays.asList(actual).contains("-"));
    }
}

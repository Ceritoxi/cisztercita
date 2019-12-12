package bowling;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AppIntegrationTest {
    private static final String[] FULL_STRIKE_INPUT = { "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X" };
    private static final String[] FULL_NINE_THEN_MISS = { "9-", "9-", "9-", "9-", "9-", "9-", "9-", "9-", "9-", "9-" };
    private static final String[] FULL_FIVE_THEN_SPARE = { "5/", "5/", "5/", "5/", "5/", "5/", "5/", "5/", "5/", "5/", "5/", "5/" };
    private PrintStream oldOutputStream;
    private ByteArrayOutputStream outputStream;

    @Before
    public void setUp() {
        outputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(outputStream);
        oldOutputStream = System.out;
        System.setOut(ps);
    }

    @After
    public void tearDown() {
        System.out.flush();
        System.setOut(oldOutputStream);
    }

    @Test
    public void verifyFullStrikeInput() {
        String expected = "300" + System.lineSeparator();
        App.main(FULL_STRIKE_INPUT);
        String actual = outputStream.toString();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void verifyFullNineThenMissInput() {
        String expected = "90" + System.lineSeparator();
        App.main(FULL_NINE_THEN_MISS);
        String actual = outputStream.toString();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void verifyFullFiveThenSpareInput() {
        String expected = "150" + System.lineSeparator();
        App.main(FULL_FIVE_THEN_SPARE);
        String actual = outputStream.toString();
        Assert.assertEquals(expected, actual);
    }
}

package bowling.service.parse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import bowling.frame.Frame;
import bowling.frame.FrameSequence;
import bowling.roll.Roll;
import bowling.roll.RollPair;
import bowling.roll.RollType;
import static org.mockito.Mockito.when;

public class BowlingSessionParserTest {

    private static final String[] TEST_INPUT = { "-/", "-/", "-/", "-/", "-/", "-/", "-/", "-/", "-/", "-/-" };
    private static final Roll SIMPLE_ROLL_OF_0 = Roll.of(0, RollType.SIMPLE);
    private static final Roll SPARE_ROLL_OF_10 = Roll.of(10, RollType.SPARE);
    private static final Frame TEST_FRAME = Frame.of(new LinkedList<>(Arrays.asList(SIMPLE_ROLL_OF_0, SPARE_ROLL_OF_10)),
        RollPair.of(SIMPLE_ROLL_OF_0, SPARE_ROLL_OF_10));

    private ParsePreparer parsePreparer;

    private BowlingSessionParser underTest;

    @Before
    public void setUp() {
        parsePreparer = Mockito.mock(ParsePreparer.class);
        underTest = new BowlingSessionParser(parsePreparer);
    }

    @Test
    public void parseShouldParseCorrectly() {
        when(parsePreparer.prepareInputForParsing(TEST_INPUT)).thenReturn(new String[]{ "0", "0", "/", "0", "/", "0", "/", "0", "/", "0", "/", "0", "/", "0", "/", "0", "/", "0", "/", "0", "/", "0", "0", "0" });
        FrameSequence expected  = new FrameSequence(createExpectedFrameList());
        FrameSequence actual = underTest.parse(TEST_INPUT);
        Assert.assertEquals(expected, actual);
    }

    private List<Frame> createExpectedFrameList() {
        List<Frame> frameList = new ArrayList<>();
        frameList.add(TEST_FRAME);
        frameList.add(TEST_FRAME);
        frameList.add(TEST_FRAME);
        frameList.add(TEST_FRAME);
        frameList.add(TEST_FRAME);
        frameList.add(TEST_FRAME);
        frameList.add(TEST_FRAME);
        frameList.add(TEST_FRAME);
        frameList.add(TEST_FRAME);
        frameList.add(Frame.of(new LinkedList<>(Arrays.asList(SIMPLE_ROLL_OF_0, SPARE_ROLL_OF_10)),
            RollPair.of(SIMPLE_ROLL_OF_0, SIMPLE_ROLL_OF_0)));
        return frameList;
    }
}

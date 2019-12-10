package bowling.frame;

import java.util.Arrays;
import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import bowling.roll.Roll;
import bowling.roll.RollPair;
import bowling.roll.RollType;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class FrameTest {

    @Mock
    Roll simpleRoll;
    @Mock
    Roll spareRoll;
    Frame frame;

    @Before
    public void setUp() {
        LinkedList<Roll> rolls = new LinkedList<>();
        rolls.add(simpleRoll);
        rolls.add(spareRoll);
        frame = Frame.of(rolls, RollPair.of(null, null));
        MockitoAnnotations.initMocks(frame);
    }

    @Test
    public void sumKnockedDownPinsShouldSumRolls() {
        Frame frame = Frame.of(new LinkedList<>(Arrays.asList(Roll.of(4, RollType.SIMPLE), Roll.of(3, RollType.SIMPLE))), RollPair.of(null, null));
        assertEquals(7, frame.sumKnockedDownPins());
    }

    @Test
    public void sumKnockedDownPinsShouldReturnZeroOnEmptyFrame() {
        Frame frame = Frame.of(new LinkedList<>(), RollPair.of(null, null));
        assertEquals(0, frame.sumKnockedDownPins());
    }

    @Test
    public void calculateScoreShouldCalculateScoreUsingItsLastRoll() {
        frame.calculateScore();
        Mockito.verify(spareRoll).getRollType();
    }
}

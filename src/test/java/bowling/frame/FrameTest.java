package bowling.frame;

import java.util.Arrays;
import java.util.LinkedList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import bowling.roll.Roll;
import bowling.roll.RollPair;
import bowling.roll.RollType;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class FrameTest {

    private static final Roll SIMPLE_ROLL_OF_4 = Roll.of(4, RollType.SIMPLE);
    private static final Roll SIMPLE_ROLL_OF_3 = Roll.of(6, RollType.SPARE);
    private static final RollPair SIMPLE_ROLL_PAIR = RollPair.of(SIMPLE_ROLL_OF_4, SIMPLE_ROLL_OF_3);

    @Test
    public void sumKnockedDownPinsShouldSumRolls() {
        Frame frame = Frame.of(new LinkedList<>(Arrays.asList(SIMPLE_ROLL_OF_4, SIMPLE_ROLL_OF_3)), SIMPLE_ROLL_PAIR);
        assertEquals(10, frame.sumKnockedDownPins());
    }

    @Test
    public void sumKnockedDownPinsShouldReturnZeroOnEmptyFrame() {
        Frame frame = Frame.of(new LinkedList<>(), SIMPLE_ROLL_PAIR);
        assertEquals(0, frame.sumKnockedDownPins());
    }

    @Test
    public void calculateScoreShouldCalculateScoreUsingItsLastRoll() {
        Roll firstMock = Mockito.mock(Roll.class);
        Roll lastMock = Mockito.mock(Roll.class);
        when(lastMock.getRollType()).thenReturn(RollType.SPARE);
        Frame frame = Frame.of(new LinkedList<>(Arrays.asList(firstMock, lastMock)), SIMPLE_ROLL_PAIR);
        frame.calculateScore();
        verify(lastMock).getRollType();
    }
}

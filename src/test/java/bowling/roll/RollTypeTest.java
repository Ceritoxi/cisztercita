package bowling.roll;

import org.junit.Test;
import org.mockito.Mockito;

import bowling.frame.Frame;
import bowling.score.Score;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class RollTypeTest {

    @Test
    public void findMatchingTypeShouldFindMathcingTypeByInputMatcherOfEnum() {
        RollType actual = RollType.findMatchingType("/");
        RollType expected = RollType.SPARE;
        assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void findMatchingTypeShouldFailWhenThereIsNoMatchingType() {
        RollType.findMatchingType("asd");
    }

    @Test
    public void inputResolverOfSimpleShouldResolveInputCorrectly() {
        RollType underTest = RollType.SIMPLE;
        int actual = underTest.resolveInput("3", "1");
        int expected = 3;
        assertEquals(expected, actual);
    }

    @Test
    public void inputResolverOfSpareShouldResolveInputCorrectly() {
        RollType underTest = RollType.SPARE;
        int actual = underTest.resolveInput("/", "2");
        int expected = 8;
        assertEquals(expected, actual);
    }

    @Test
    public void inputResolverOfStrikeShouldResolveInputCorrectly() {
        RollType underTest = RollType.STRIKE;
        int actual = underTest.resolveInput("x", "1");
        int expected = 10;
        assertEquals(expected, actual);
    }

    @Test
    public void calculateScoreOfSimpleShouldCalculateScoreCorrectly() {
        Frame frame = Mockito.mock(Frame.class);
        when(frame.sumKnockedDownPins()).thenReturn(8);
        RollType underTest = RollType.SIMPLE;
        Score actual = underTest.calculateScore(frame);
        Score expected = Score.of(8);
        assertEquals(expected, actual);

    }

    @Test
    public void calculateScoreOfSpareShouldCalculateScoreCorrectly() {
        Frame frame = Mockito.mock(Frame.class);
        RollPair rollPair = Mockito.mock(RollPair.class);
        when(frame.sumKnockedDownPins()).thenReturn(8);
        when(frame.getProceedingRollPair()).thenReturn(rollPair);
        when(rollPair.getKnockedDownPinsForFirst()).thenReturn(4);
        RollType underTest = RollType.SPARE;
        Score actual = underTest.calculateScore(frame);
        Score expected = Score.of(12);
        assertEquals(expected, actual);
    }

    @Test
    public void calculateScoreOfStrikeShouldCalculateScoreCorrectly() {
        Frame frame = Mockito.mock(Frame.class);
        RollPair rollPair = Mockito.mock(RollPair.class);
        when(frame.sumKnockedDownPins()).thenReturn(8);
        when(frame.getProceedingRollPair()).thenReturn(rollPair);
        when(rollPair.sumKnockedDownPins()).thenReturn(4);
        RollType underTest = RollType.STRIKE;
        Score actual = underTest.calculateScore(frame);
        Score expected = Score.of(12);
        assertEquals(expected, actual);
    }
}

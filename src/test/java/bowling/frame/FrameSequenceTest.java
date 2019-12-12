package bowling.frame;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import bowling.score.Score;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FrameSequenceTest {

    @Test
    public void calculateScoreShouldSumTheCalculatedScoreOfContainedFrames() {
        Frame frame1 = mock(Frame.class);
        Frame frame2 = mock(Frame.class);
        Frame frame3 = mock(Frame.class);
        when(frame1.calculateScore()).thenReturn(Score.of(5));
        when(frame2.calculateScore()).thenReturn(Score.of(15));
        when(frame3.calculateScore()).thenReturn(Score.of(10));
        FrameSequence frameSequence = new FrameSequence(Arrays.asList(frame1, frame2, frame3));
        Score expected = Score.of(30);
        Score actual = frameSequence.calculateScore();
        assertEquals(expected, actual);
    }

    @Test
    public void calculateScoreShouldReturnZeroScoreWhenTheSequenceIsEmpty() {
        FrameSequence frameSequence = new FrameSequence(new ArrayList<>());
        Score expected = Score.of(0);
        Score actual = frameSequence.calculateScore();
        assertEquals(expected, actual);
    }
}

package bowling.service;

import org.junit.Test;
import org.mockito.Mockito;

import bowling.frame.FrameSequence;

public class BowlingSessionScoreCalculatorTest {

    @Test
    public void calculateScoreShouldCallFrameSequenceToGetCalculatedScore() {
        BowlingSessionScoreCalculator underTest = new BowlingSessionScoreCalculator();
        FrameSequence frameSequence = Mockito.mock(FrameSequence.class);
        underTest.calculateScore(frameSequence);
        Mockito.verify(frameSequence).calculateScore();
    }
}

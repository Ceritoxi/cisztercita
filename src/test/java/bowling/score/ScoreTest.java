package bowling.score;

import org.junit.Test;

import static org.junit.Assert.*;

public class ScoreTest {

    @Test
    public void addShouldAddScoreToOtherScore() {
        Score base = Score.of(5);
        Score addition = Score.of(6);
        Score expected = Score.of(11);
        Score actual = base.add(addition);
        assertEquals(expected, actual);
    }
}

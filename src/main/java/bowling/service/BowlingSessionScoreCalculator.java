package bowling.service;

import bowling.frame.FrameSequence;
import bowling.score.Score;

public class BowlingSessionScoreCalculator {

    public Score calculateScore(FrameSequence frameSequence) {
        return frameSequence.calculateScore();
    }
}

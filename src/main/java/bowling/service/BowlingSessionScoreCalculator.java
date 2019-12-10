package bowling.service;

import bowling.frame.FrameSequence;
import bowling.score.Score;

public class BowlingSessionScoreCalculator {

    /**
     * Calculate the final {@link Score} of a bowling session from the received {@link FrameSequence}.
     *
     * @param frameSequence the {@link FrameSequence}
     * @return the {@link Score}
     */
    public Score calculateScore(FrameSequence frameSequence) {
        return frameSequence.calculateScore();
    }
}

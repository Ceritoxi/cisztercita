package bowling.frame;

import java.util.List;
import java.util.Objects;

import bowling.score.Score;
import lombok.EqualsAndHashCode;

/**
 * Model representing a sequence of {@link Frame}s.
 */
@EqualsAndHashCode
public class FrameSequence {

    private List<Frame> frames;

    public FrameSequence(List<Frame> frames) {
        this.frames = frames;
    }

    /**
     * Calculate the {@link Score} of the whole sequence of frames.
     *
     * @return the {@link Score} of this sequence.
     */
    public Score calculateScore() {
        return frames.stream().map(Frame::calculateScore).reduce(Score::add).orElse(Score.of(0));
    }

    @Override
    public String toString() {
        return String.valueOf(frames);
    }
}

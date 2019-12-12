package bowling.frame;

import java.util.List;
import java.util.Objects;

import bowling.score.Score;

/**
 * Model representing a sequence of {@link Frame}s.
 */
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

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        FrameSequence that = (FrameSequence) o;
        return Objects.equals(frames, that.frames);
    }

    @Override public int hashCode() {
        return Objects.hash(frames);
    }
}

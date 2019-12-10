package bowling.frame;

import java.util.List;

import bowling.score.Score;

public class FrameSequence {

    private List<Frame> frames;

    public FrameSequence(List<Frame> frames) {
        this.frames = frames;
    }

    public Score calculateScore() {
        return frames.stream().map(Frame::calculateScore).reduce(Score::add).orElse(Score.of(0));
    }

    @Override
    public String toString() {
        return String.valueOf(frames);
    }
}

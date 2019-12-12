package bowling.score;

import lombok.EqualsAndHashCode;

/**
 * Model representing a score.
 */
@EqualsAndHashCode
public class Score {
    private final int score;

    private Score(int score) {
        this.score = score;
    }

    public static Score of(int score) {
        return new Score(score);
    }

    public Score add(Score addition) {
        return Score.of(this.score + addition.score);
    }

    @Override
    public String toString() {
        return String.valueOf(score);
    }
}

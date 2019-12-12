package bowling.score;

import java.util.Objects;

/**
 * Model representing a score.
 */
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

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Score score1 = (Score) o;
        return score == score1.score;
    }

    @Override public int hashCode() {
        return Objects.hash(score);
    }
}

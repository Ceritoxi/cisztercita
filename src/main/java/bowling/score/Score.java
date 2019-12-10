package bowling.score;

/**
 * Model representing a score.
 */
public class Score {
    private int score;

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

package bowling.frame;

import java.util.Deque;
import java.util.Objects;

import bowling.roll.Roll;
import bowling.roll.RollPair;
import bowling.roll.RollType;
import bowling.score.Score;

/**
 * Model representing a frame.
 */
public class Frame {
    private Deque<Roll> rolls;
    private RollPair proceedingRollPair;

    private Frame(Deque<Roll> rolls, RollPair proceedingRollPair) {
        this.rolls = rolls;
        this.proceedingRollPair = proceedingRollPair;
    }

    public static Frame of(Deque<Roll> rolls, RollPair proceedingRollPair) {
        return new Frame(rolls, proceedingRollPair);
    }

    /**
     * Calculate the {@link Score} of this frame.
     *
     * @return the {@link Score} of this frame
     */
    Score calculateScore() {
        return getRollTypeOfLastRoll().calculateScore(this);
    }

    /**
     * Get the {@link RollType} of the last {@link Roll} in this frame.
     *
     * @return the {@link RollType} of the last {@link Roll} in this frame
     */
    private RollType getRollTypeOfLastRoll() {
        return rolls.getLast().getRollType();
    }

    /**
     * Sum the amount of knocked down pins present in this frame.
     *
     * @return the sum of the amount of knocked down pins present in this frame
     */
    public int sumKnockedDownPins() {
        return rolls.stream().mapToInt(Roll::getPinsKnockedDown).sum();
    }

    public RollPair getProceedingRollPair() {
        return proceedingRollPair;
    }

    @Override
    public String toString() {
        return rolls + ", " + proceedingRollPair;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Frame frame = (Frame) o;
        return Objects.equals(rolls, frame.rolls) &&
            Objects.equals(proceedingRollPair, frame.proceedingRollPair);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rolls, proceedingRollPair);
    }
}

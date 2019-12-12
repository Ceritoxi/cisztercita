package bowling.roll;

import java.util.Objects;

/**
 * A pair of {@link Roll}s.
 */
public class RollPair {

    private Roll first;
    private Roll second;

    private RollPair(Roll first, Roll second) {
        this.first = first;
        this.second = second;
    }

    public static RollPair of(Roll first, Roll second) {
        return new RollPair(first, second);
    }

    /**
     * Get the amount of knocked down pins in the first {@link Roll} of the pair.
     *
     * @return the amount of knocked down pins in the first {@link Roll}
     */
    int getKnockedDownPinsForFirst() {
        return first.getPinsKnockedDown();
    }

    /**
     * Sum the amount of knocked down pins in the roll pair.
     *
     * @return the sum of knocked down pins
     */
    int sumKnockedDownPins() {
        return first.getPinsKnockedDown() + second.getPinsKnockedDown();
    }

    @Override
    public String toString() {
        return first + ", " + second;
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        RollPair rollPair = (RollPair) o;
        return Objects.equals(first, rollPair.first) &&
            Objects.equals(second, rollPair.second);
    }

    @Override public int hashCode() {
        return Objects.hash(first, second);
    }
}

package bowling.roll;

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
}

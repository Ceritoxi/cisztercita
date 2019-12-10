package bowling.roll;

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

    int getKnockedDownPinsForFirst() {
        return first.getPinsKnockedDown();
    }

    int sumKnockedDownPins() {
        return first.getPinsKnockedDown() + second.getPinsKnockedDown();
    }

    @Override
    public String toString() {
        return first + ", " + second;
    }
}

package bowling.roll;

public class Roll {

    private int pinsKnockedDown;
    private RollType rollType;

    private Roll(int pinsKnockedDown, RollType rollType) {
        this.pinsKnockedDown = pinsKnockedDown;
        this.rollType = rollType;
    }

    public static Roll of(int pinsKnockedDown, RollType rollType) {
        return new Roll(pinsKnockedDown, rollType);
    }

    public int getPinsKnockedDown() {
        return pinsKnockedDown;
    }

    public RollType getRollType() {
        return rollType;
    }

    public int getMaxAmountOfRollTypeInFrame() {
        return rollType.getMaxAmountInAFrame();
    }

    @Override
    public String toString() {
        return pinsKnockedDown + ", " + rollType;
    }
}

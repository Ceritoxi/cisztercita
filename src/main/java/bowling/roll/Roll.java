package bowling.roll;

import java.util.Objects;

/**
 * Model representing a roll.
 */
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

    /**
     * Get the maximum amount of rolls that are possible in a frame of the owned {@link RollType}.
     *
     * @return the maximum amount of rolls that are possible in a frame of the owned {@link RollType}
     */
    public int getMaxAmountOfRollTypeInAFrame() {
        return rollType.getMaxAmountPossibleInAFrame();
    }

    @Override
    public String toString() {
        return pinsKnockedDown + ", " + rollType;
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Roll roll = (Roll) o;
        return pinsKnockedDown == roll.pinsKnockedDown &&
            rollType == roll.rollType;
    }

    @Override public int hashCode() {
        return Objects.hash(pinsKnockedDown, rollType);
    }
}

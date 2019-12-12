package bowling.roll;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RollTest {

    @Test
    public void getMaxAmountOfRollTypeInAFrameShouldCallRollType() {
        Roll roll = Roll.of(2, RollType.SIMPLE);
        int expected = RollType.SIMPLE.getMaxAmountPossibleInAFrame();
        int actual = roll.getMaxAmountOfRollTypeInAFrame();
        assertEquals(expected, actual);
    }
}

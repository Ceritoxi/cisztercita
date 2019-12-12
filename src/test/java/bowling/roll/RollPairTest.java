package bowling.roll;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RollPairTest {

    @Test
    public void sumKnockedDownPinsShouldSumKnockedDownPins() {
        RollPair rollpair = RollPair.of(Roll.of(2, RollType.SIMPLE), Roll.of(6, RollType.SIMPLE));
        int expected = 8;
        int actual = rollpair.sumKnockedDownPins();
        assertEquals(expected, actual);
    }

    @Test
    public void getKnockedDownPinsForFirstShouldGiveTheKnockedDownPinsOfTheFirstRoll() {
        RollPair rollpair = RollPair.of(Roll.of(2, RollType.SIMPLE), Roll.of(6, RollType.SIMPLE));
        int expected = 2;
        int actual = rollpair.getKnockedDownPinsForFirst();
        assertEquals(expected, actual);
    }
}

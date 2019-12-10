package bowling.service.parse;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import bowling.frame.Frame;
import bowling.frame.FrameSequence;
import bowling.roll.Roll;
import bowling.roll.RollPair;
import bowling.roll.RollType;

public class BowlingSessionParser {

    private static final int COUNT_OF_FRAMES = 10;

    private ParsePreparer parsePreparer;

    public BowlingSessionParser(ParsePreparer parsePreparer) {
        this.parsePreparer = parsePreparer;
    }

    public FrameSequence parse(String[] bowlingSessionToParse) {
        Queue<Roll> rolls = parseIntoRolls(parsePreparer.prepareInputForParsing(bowlingSessionToParse));
        List<Frame> frames = IntStream.range(0, COUNT_OF_FRAMES)
            .mapToObj(i -> Frame.of(getRollsInFramePart(rolls, rolls.element().getMaxAmountOfRollTypeInFrame()), getProceedingRollPairPart(rolls)))
            .collect(Collectors.toList());
        return new FrameSequence(frames);
    }

    private Queue<Roll> parseIntoRolls(String[] rawRolls) {
        return IntStream.range(1, rawRolls.length)
            .mapToObj(i -> createRollFromRawRoll(rawRolls[i], rawRolls[i - 1]))
            .collect(Collectors.toCollection(LinkedList::new));
    }

    private Roll createRollFromRawRoll(String rawRoll, String precedingRawRoll) {
        return Roll.of(RollType.findMatchingType(rawRoll).resolveInput(rawRoll, precedingRawRoll), RollType.findMatchingType(rawRoll));
    }

    private Deque<Roll> getRollsInFramePart(Queue<Roll> rolls, int times) {
        return IntStream.range(0, times)
            .mapToObj(i -> rolls.poll())
            .collect(Collectors.toCollection(LinkedList::new));
    }

    private RollPair getProceedingRollPairPart(Queue<Roll> rolls) {
        Iterator<Roll> iterator = rolls.iterator();
        return RollPair.of(iterator.next(), iterator.next());
    }

}

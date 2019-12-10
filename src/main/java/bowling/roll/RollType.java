package bowling.roll;

import java.util.Arrays;
import java.util.function.BiFunction;

import bowling.frame.Frame;
import bowling.score.Score;

public enum RollType {

    SIMPLE((frame, rollPair) -> Score.of(frame.sumKnockedDownPins()),
        (input, previousInput) -> Integer.valueOf(input),
        "^\\d$", 2),
    SPARE((frame, rollPair) -> Score.of(frame.sumKnockedDownPins() + rollPair.getKnockedDownPinsForFirst()),
        (input, previousInput) -> 10 - Integer.valueOf(previousInput),
        "/", 1),
    STRIKE((frame, rollPair) -> Score.of(frame.sumKnockedDownPins() + rollPair.sumKnockedDownPins()),
        (input, previousInput) -> 10,
        "[xX]", 1);

    private BiFunction<Frame, RollPair, Score> scoreCalculator;
    private BiFunction<String, String, Integer> rollInputResolver;
    private String inputMatcher;
    private int maxAmountInAFrame;

    RollType(BiFunction<Frame, RollPair, Score> scoreCalculator, BiFunction<String, String, Integer> rollInputResolver,
        String inputMatcher, int maxAmountInAFrame) {
        this.scoreCalculator = scoreCalculator;
        this.rollInputResolver = rollInputResolver;
        this.inputMatcher = inputMatcher;
        this.maxAmountInAFrame = maxAmountInAFrame;
    }

    public static RollType findMatchingType(String input) {
        return Arrays.stream(RollType.values())
            .filter(rollType -> input.matches(rollType.inputMatcher))
            .findFirst()
            .orElseThrow(IllegalArgumentException::new);
    }

    public int resolveInput(String input, String previousInput) {
        return rollInputResolver.apply(input, previousInput);
    }

    public Score calculateScore(Frame frame, RollPair rollPair) {
        return scoreCalculator.apply(frame, rollPair);
    }

    public int getMaxAmountInAFrame() {
        return maxAmountInAFrame;
    }
}

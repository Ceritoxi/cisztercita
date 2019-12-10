package bowling.roll;

import java.util.Arrays;
import java.util.function.BiFunction;

import bowling.frame.Frame;
import bowling.score.Score;

/**
 * Enum representing the type of a roll.
 */
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
    private int maxAmountPossibleInAFrame;

    RollType(BiFunction<Frame, RollPair, Score> scoreCalculator, BiFunction<String, String, Integer> rollInputResolver,
        String inputMatcher, int maxAmountPossibleInAFrame) {
        this.scoreCalculator = scoreCalculator;
        this.rollInputResolver = rollInputResolver;
        this.inputMatcher = inputMatcher;
        this.maxAmountPossibleInAFrame = maxAmountPossibleInAFrame;
    }

    /**
     * Find the matching {@link RollType} for a given raw input.
     *
     * @param input the raw input.
     * @return the matching {@link RollType}
     */
    public static RollType findMatchingType(String input) {
        return Arrays.stream(RollType.values())
            .filter(rollType -> input.matches(rollType.inputMatcher))
            .findFirst()
            .orElseThrow(IllegalArgumentException::new);
    }

    public int resolveInput(String input, String previousInput) {
        return rollInputResolver.apply(input, previousInput);
    }

    /**
     * Calculate the score of a {@link Frame},
     *
     * @param frame the {@link Frame}
     * @return the {@link Score}
     */
    public Score calculateScore(Frame frame) {
        return scoreCalculator.apply(frame, frame.getProceedingRollPair());
    }

    public int getMaxAmountPossibleInAFrame() {
        return maxAmountPossibleInAFrame;
    }
}

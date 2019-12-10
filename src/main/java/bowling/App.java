package bowling;

import bowling.service.BowlingSessionScoreCalculator;
import bowling.service.parse.BowlingSessionParser;
import bowling.service.parse.ParsePreparer;

public class App {

    public static void main(String[] args) {
        BowlingSessionScoreCalculator bowlingSessionScoreCalculator = new BowlingSessionScoreCalculator();
        ParsePreparer parsePreparer = new ParsePreparer();
        BowlingSessionParser bowlingSessionParser = new BowlingSessionParser(parsePreparer);
        System.out.println(bowlingSessionScoreCalculator.calculateScore(bowlingSessionParser.parse(args)));
    }
}

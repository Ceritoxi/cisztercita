package bowling.service.parse;

public class ParsePreparer {

    String[] prepareInputForParsing(String[] bowlingSession) {
        return extendWithMissesForParsing(truncateWhitespace(replaceMissesWithParsableValue(String.join(" ", bowlingSession))))
            .split("");
    }

    private String replaceMissesWithParsableValue(String bowlingSession) {
        return bowlingSession.replaceAll("-", "0");
    }

    private String truncateWhitespace(String bowlingSession) {
        return bowlingSession.replaceAll(" ", "");
    }

    private String extendWithMissesForParsing(String bowlingSession) {
        return "0" + bowlingSession + "00";
    }
}

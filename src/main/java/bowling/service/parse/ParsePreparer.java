package bowling.service.parse;

public class ParsePreparer {

    /**
     * Modify the received bowling session in a way that the parsing logic can properly use it.
     *
     * @param bowlingSession the raw unprepared bowling session
     * @return the prepared raw bowling session
     */
    String[] prepareInputForParsing(String[] bowlingSession) {
        return extendWithMissesForParsing(truncateWhitespace(replaceMissesWithParsableValue(joinByWhitespace(bowlingSession))))
            .split("");
    }

    private String joinByWhitespace(String[] bowlingSession) {
        return String.join(" ", bowlingSession);
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

package by.drob.task10.data.parser;

public class ParagraphParser extends AbstractParser {
    private static final String SENTENCE_PATTERN_REGEX = "\\s?(.+?[.!?])";

    public ParagraphParser(Parser successor) {
        super(successor);
    }
    @Override
    protected String getPattern() {
        return SENTENCE_PATTERN_REGEX;
    }
}


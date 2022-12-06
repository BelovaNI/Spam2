class TooLongTextAnalyzer implements TextAnalyzer {
    private int commentMaxLength;

    public TooLongTextAnalyzer(int commentMaxLength) {
        this.commentMaxLength = commentMaxLength;
    }

    @Override
    public Label processText(String text) {
        int a = commentMaxLength;
        if (text.length() < a) {
            return Label.OK;
        }
        return Label.TOO_LONG;
    }
}


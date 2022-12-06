class TooLongTextAnalyzer implements TextAnalyzer {
    private int maxLength;

    public TooLongTextAnalyzer(int commentMaxLength) {
        this.maxLength = commentMaxLength;
    }

    @Override
    public Label processText(String text) {
        int a = maxLength;
        if (text.length() <= a) {
            return Label.OK;
        }
        return Label.TOO_LONG;
    }
}


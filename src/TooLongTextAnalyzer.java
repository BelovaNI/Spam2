class TooLongTextAnalyzer implements TextAnalyzer {
    private static int commentMaxLength;

    public TooLongTextAnalyzer(int maxLength) {
        this.commentMaxLength = maxLength;
    }


    @Override
    public Label processText(String text) {
        return null;
    }
}


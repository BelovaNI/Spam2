class SpamAnalyzer extends KeywordAnalyzer {
    private String[] keywords;

    public SpamAnalyzer(String[] keywords) {
        this.keywords = keywords;
    }


    @Override
    protected void getKeywords() {

    }

    @Override
    protected void getLabel() {

    }
}

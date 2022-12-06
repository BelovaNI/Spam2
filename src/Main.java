import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // инициализация анализаторов для проверки в порядке данного набора анализаторов
        String[] keywords = {"spam", "bad"};
        int commentMaxLength = 40;
        TextAnalyzer[] textAnalyzers1 = {
                new SpamAnalyzer(keywords),
                new NegativeTextAnalyzer(),
                new TooLongTextAnalyzer(commentMaxLength)
        };
        TextAnalyzer[] textAnalyzers2 = {
                new SpamAnalyzer(keywords),
                new TooLongTextAnalyzer(commentMaxLength),
                new NegativeTextAnalyzer()
        };
        TextAnalyzer[] textAnalyzers3 = {
                new TooLongTextAnalyzer(commentMaxLength),
                new SpamAnalyzer(keywords),
                new NegativeTextAnalyzer()
        };
        TextAnalyzer[] textAnalyzers4 = {
                new TooLongTextAnalyzer(commentMaxLength),
                new NegativeTextAnalyzer(),
                new SpamAnalyzer(keywords)
        };
        TextAnalyzer[] textAnalyzers5 = {
                new NegativeTextAnalyzer(),
                new SpamAnalyzer(keywords),
                new TooLongTextAnalyzer(commentMaxLength)
        };
        TextAnalyzer[] textAnalyzers6 = {
                new NegativeTextAnalyzer(),
                new TooLongTextAnalyzer(commentMaxLength),
                new SpamAnalyzer(keywords)
        };
        // тестовые комментарии
        String[] text = new String[8];
        text[0] = "This comment is so good.";                            // OK
        text[1] = "This comment is so Loooooooooooooooooooooooooooong."; // TOO_LONG
        text[2] = "Very negative comment !!!!=(!!!!;";                   // NEGATIVE_TEXT
        text[3] = "Very BAAAAAAAAAAAAAAAAAAAAAAAAD comment with :|;";    // NEGATIVE_TEXT or TOO_LONG
        text[4] = "This comment is so bad....";                          // SPAM
        text[5] = "The comment is a spam, maybeeeeeeeeeeeeeeeeeeeeee!";  // SPAM or TOO_LONG
        text[6] = "Negative bad :( spam.";                               // SPAM or NEGATIVE_TEXT
        text[7] = "Very bad, very neg =(, very ..................";      // SPAM or NEGATIVE_TEXT or TOO_LONG
        TextAnalyzer[][] textAnalyzers = {textAnalyzers1, textAnalyzers2, textAnalyzers3,
                textAnalyzers4, textAnalyzers5, textAnalyzers6};
        Main testObject = new Main();
        int numberOfAnalyzer; // номер анализатора, указанный в идентификаторе textAnalyzers{№}
        int numberOfTest = 0; // номер теста, который соответствует индексу тестовых комментариев
        for (String test : text) {
            numberOfAnalyzer = 1;
            System.out.print("test #" + numberOfTest + ": ");
            System.out.println(test);
            for (TextAnalyzer[] analyzers : textAnalyzers) {
                System.out.print(numberOfAnalyzer + ": ");
                System.out.println(testObject.checkLabels(analyzers, test));
                numberOfAnalyzer++;
            }
            numberOfTest++;
        }
    }
    public Label checkLabels(TextAnalyzer[] analyzers, String text) {
        return null;
    }
}

    interface TextAnalyzer {
        Label processText(String text);
    }
        enum Label {
            SPAM, NEGATIVE_TEXT, TOO_LONG, OK
        }

        abstract class KeywordAnalyzer implements TextAnalyzer {
            public KeywordAnalyzer() {
            }

            @Override
            public Label processText(String text) {
                return null;
            }

            protected abstract void getKeywords();

            protected abstract void getLabel();
        }








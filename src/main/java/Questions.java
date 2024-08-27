public class Questions {
    // Fields of the class

    private String Question;
    private String ExpectedAnswer;
    private String Keywords;
    private String SimilarityScore;
    private String TextMatching;
    private String CompareByKeywords;

    private String ActualAnswer;

    // Constructor
    public Questions(String Question, String ExpectedAnswer, String Keywords,
                     String SimilarityScore, String TextMatching, String CompareByKeywords, String ActualAnswer) {
        this.Question = Question;
        this.ExpectedAnswer = ExpectedAnswer;
        this.Keywords = Keywords;
        this.SimilarityScore = SimilarityScore;
        this.TextMatching = TextMatching;
        this.CompareByKeywords = CompareByKeywords;
        this.ActualAnswer = ActualAnswer;
    }

    // Getters and Setters
    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String question) {
        this.Question = question;
    }

    public String getExpectedAnswer() {
        return ExpectedAnswer;
    }

    public void setExpectedAnswer(String expectedAnswer) {
        this.ExpectedAnswer = expectedAnswer;
    }

    public String getKeywords() {
        return Keywords;
    }

    public void setKeywords(String keywords) {
        this.Keywords = keywords;
    }

    public String getSimilarityScore() {
        return SimilarityScore;
    }

    public void setSimilarityScore(String similarityScore) {
        this.SimilarityScore = similarityScore;
    }

    public String getTextMatching() {
        return TextMatching;
    }

    public void setTextMatching(String textMatching) {
        this.TextMatching = textMatching;
    }

    public String getCompareByKeywords() {
        return CompareByKeywords;
    }

    public void setCompareByKeywords(String compareByKeywords) {
        this.CompareByKeywords = compareByKeywords;
    }

    public String getActualAnswer() { return ActualAnswer;}

    public void setActualAnswer(String actualAnswer) { this.ActualAnswer = actualAnswer; }

    // Optional: Override toString() method for easier printing
    @Override
    public String toString() {
        return "DataRecord{" +
                "column1='" + Question + '\'' +
                ", column2='" + ExpectedAnswer + '\'' +
                ", column3='" + Keywords + '\'' +
                ", column4='" + SimilarityScore + '\'' +
                ", column5='" + TextMatching + '\'' +
                ", column6='" + CompareByKeywords + '\'' +
                ", column7='" + ActualAnswer + '\'' +
                '}';
    }
}

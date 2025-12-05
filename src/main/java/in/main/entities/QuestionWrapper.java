package in.main.entities;

public class QuestionWrapper {

    private int qid;
    private String questionTitle;
    private String option1;
    private String option2;
    private String option3;
    private String option4;

    // no-arg constructor required by Jackson
    public QuestionWrapper() {}

    // all-args constructor for convenience
    public QuestionWrapper(int qid, String questionTitle, String option1, String option2, String option3,
            String option4) {
        this.qid = qid;
        this.questionTitle = questionTitle;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
    }

    // getters (Jackson uses these)
    public int getQid() { return qid; }
    public String getQuestionTitle() { return questionTitle; }
    public String getOption1() { return option1; }
    public String getOption2() { return option2; }
    public String getOption3() { return option3; }
    public String getOption4() { return option4; }

    // setters (optional if you don't need deserialization)
    public void setQid(int qid) { this.qid = qid; }
    public void setQuestionTitle(String questionTitle) { this.questionTitle = questionTitle; }
    public void setOption1(String option1) { this.option1 = option1; }
    public void setOption2(String option2) { this.option2 = option2; }
    public void setOption3(String option3) { this.option3 = option3; }
    public void setOption4(String option4) { this.option4 = option4; }
}


package bean;

public class QuestionBean
{
	
	private String questionId;
	private String businessSegment;
	private int questionNo;
	private String question;
	private String answer1;
	private int answerWeightage1;
	private String answer2;
	private int answerWeightage2;
	private String answer3;
	private int answerWeightage3;
	
	public String getQuestionId() {
		return questionId;
	}
	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}
	public String getBusinessSegment() {
		return businessSegment;
	}
	public void setBusinessSegment(String businessSegment) {
		this.businessSegment = businessSegment;
	}
	public int getQuestionNo() {
		return questionNo;
	}
	public void setQuestionNo(int questionNo) {
		this.questionNo = questionNo;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer1() {
		return answer1;
	}
	public void setAnswer1(String answer1) {
		this.answer1 = answer1;
	}
	public int getAnswerWeightage1() {
		return answerWeightage1;
	}
	public void setAnswerWeightage1(int answerWeightage1) {
		this.answerWeightage1 = answerWeightage1;
	}
	public String getAnswer2() {
		return answer2;
	}
	public void setAnswer2(String answer2) {
		this.answer2 = answer2;
	}
	public int getAnswerWeightage2() {
		return answerWeightage2;
	}
	public void setAnswerWeightage2(int answerWeightage2) {
		this.answerWeightage2 = answerWeightage2;
	}
	public String getAnswer3() {
		return answer3;
	}
	public void setAnswer3(String answer3) {
		this.answer3 = answer3;
	}
	public int getAnswerWeightage3() {
		return answerWeightage3;
	}
	public void setAnswerWeightage3(int answerWeightage3) {
		this.answerWeightage3 = answerWeightage3;
	}
	@Override
	public String toString() {
		return "QuestionBean [questionId=" + questionId + ", businessSegment=" + businessSegment + ", questionNo="
				+ questionNo + ", question=" + question + ", answer1=" + answer1 + ", answerWeightage1="
				+ answerWeightage1 + ", answer2=" + answer2 + ", answerWeightage2=" + answerWeightage2 + ", answer3="
				+ answer3 + ", answerWeightage3=" + answerWeightage3 + "]";
	}
	
	
	
}

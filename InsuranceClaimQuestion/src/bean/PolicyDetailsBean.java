package bean;

public class PolicyDetailsBean
{
	private long policyNumber;
	private String questionId;
	private String answer;
	
	public long getPolicyNumber()
	{
		return policyNumber;
	}
	public void setPolicyNumber(long policyNumber)
	{
		this.policyNumber = policyNumber;
	}
	public String getQuestionId()
	{
		return questionId;
	}
	public void setQuestionId(String questionId)
	{
		this.questionId = questionId;
	}
	public String getAnswer()
	{
		return answer;
	}
	public void setAnswer(String answer)
	{
		this.answer = answer;
	}
	
	@Override
	public String toString()
	{
		return "PolicyDetailsBean [policyNumber=" + policyNumber + ", questionId=" + questionId + ", answer=" + answer
				+ "]\n";
	}
	
}

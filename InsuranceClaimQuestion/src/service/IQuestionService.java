package service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import bean.ClaimBean;
import bean.PolicyDetailsBean;
import bean.QuestionBean;
import exception.QuestionException;

public interface IQuestionService
{
	boolean validateDetails(ClaimBean claimBean) throws QuestionException;

	public String getPolicy_Number(ClaimBean claimNumber) throws SQLException, QuestionException, ClassNotFoundException, Exception;
	
	public List<QuestionBean> getQuestions(String businessSegment) throws ClassNotFoundException, IOException, SQLException;
	
	public PolicyDetailsBean getPolicyDetails(PolicyDetailsBean policyDetailsBean);
}

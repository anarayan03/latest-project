package dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import bean.ClaimBean;
import bean.PolicyDetailsBean;
import bean.QuestionBean;

public interface IQuestionDao 
{
	public String getPolicy_Number(ClaimBean claimBean) throws ClassNotFoundException, SQLException, Exception;
	public List<QuestionBean> getQuestions(String businessSegment) throws ClassNotFoundException, IOException, SQLException;
	public PolicyDetailsBean getPolicyDetails(PolicyDetailsBean policyDetailsBean);
}

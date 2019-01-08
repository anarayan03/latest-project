package service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import bean.ClaimBean;
import bean.PolicyDetailsBean;
import bean.QuestionBean;
import dao.CQuestionDaoImpl;
import dao.IQuestionDao;
import exception.QuestionException;

public class QuestionServiceImpl implements IQuestionService {

	static QuestionBean questionBean = new QuestionBean();
	IQuestionDao iQuestionDao = null;

	@Override
	public List<QuestionBean> getQuestions(String businessSegment)
			throws ClassNotFoundException, IOException, SQLException {
		iQuestionDao = new CQuestionDaoImpl();
		List<QuestionBean> list = new ArrayList<>();
		list = iQuestionDao.getQuestions(businessSegment);

		return list;
	}

	@Override
	public boolean validateDetails(ClaimBean claimBean) throws QuestionException {
		List<String> list = new ArrayList<>();

		boolean result = true;

		// if (!isNumberValid(claimBean.getClaim_Number())) {
		//
		// list.add("Claim Number should be greater that 0");
		// }
		if (!isReasonValid(claimBean.getClaimReason())) {
			list.add("claim reason should be valid");
		}
		if (!isAccidentLocationValid(claimBean.getAccidentLocationStreet())) {
			list.add("Location should be valid without numerics");
		}
		if (!isAccidentCityValid(claimBean.getAccidentCity())) {
			list.add("city should be valid without numerics");
		}
		if (!isAccidentStateValid(claimBean.getAccidentState())) {
			list.add("state should be valid without numerics");
		}
		if (!isAccidentZipValid(claimBean.getAccidentZip())) {
			list.add("Enter valid ZIP Code");
		}
		// if (!isClaimTypeValid(claimBean.getClaim_Type())) {
		// list.add("enter valid claim type");
		// }
		if (!isPolicyNumberValid(claimBean.getPolicyNumber())) {
		list.add("policy number should be greater than 0");
		 }
		if (!list.isEmpty()) {

			System.out.println("Errors" + list);
			result = false;
		}

		return result;

	}

	private boolean isPolicyNumberValid(long l) {

		return l > 0;
	}

	/*private boolean isClaimTypeValid(String claim_Type) {
		String RegEx = "[a-z]{3,20}";
		Pattern pattern = Pattern.compile(RegEx);

		Matcher matcher = pattern.matcher(claim_Type);
		return matcher.matches();
	}*/

	private boolean isAccidentZipValid(String accidentZip) {
		String RegEx = "^[1-9][0-9]{5}$";
		Pattern pattern = Pattern.compile(RegEx);
		Matcher matcher = pattern.matcher(accidentZip);
		return matcher.matches();
		
	}

	private boolean isAccidentStateValid(String accidentState) {
		String RegEx = "^[A-Z][a-z]{3,20}$";
		Pattern pattern = Pattern.compile(RegEx);
		Matcher matcher = pattern.matcher(accidentState);
		return matcher.matches();
	}

	private boolean isAccidentCityValid(String accidentCity) {
		String RegEx = "^[A-Z][a-z]{3,20}$";
		Pattern pattern = Pattern.compile(RegEx);
		Matcher matcher = pattern.matcher(accidentCity);
		return matcher.matches();
	}

	private boolean isAccidentLocationValid(String accidentLocation) {
		String RegEx = "^[A-Z][a-z]{3,20}$";
		Pattern pattern = Pattern.compile(RegEx);
		Matcher matcher = pattern.matcher(accidentLocation);
		return matcher.matches();
	}

	private boolean isReasonValid(String claimReason) {
		String RegEx = "^[A-Z][a-z]{3,20}$";
		Pattern pattern = Pattern.compile(RegEx);
		Matcher matcher = pattern.matcher(claimReason);
		return matcher.matches();
	}

	/*private boolean isNumberValid(int claim_Number) {

		return claim_Number > 0;
	}*/

	@Override
	public String getPolicy_Number(ClaimBean claimBean) throws ClassNotFoundException, Exception {
		iQuestionDao = new CQuestionDaoImpl();
		return iQuestionDao.getPolicy_Number(claimBean);
	}

	@Override
	public PolicyDetailsBean getPolicyDetails(PolicyDetailsBean policyDetailsBean)
	{
		// TODO Auto-generated method stub
		return null;
	}
}

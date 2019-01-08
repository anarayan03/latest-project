package pl;

import java.util.ArrayList;
import java.util.InputMismatchException;

import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

import bean.ClaimBean;
import bean.PolicyDetailsBean;
import bean.QuestionBean;
import exception.QuestionException;
import service.IQuestionService;
import service.QuestionServiceImpl;

public class QuestionClient {

	static Scanner scanner = new Scanner(System.in);
	static IQuestionService iQuestionService = null;
	static PolicyDetailsBean policyDetailsBean = null;
	static QuestionServiceImpl questionServiceImpl = null;
	static QuestionBean questionBean = new QuestionBean();
	static ClaimBean claimBean = new ClaimBean();

	public static void main(String[] args) throws Exception {
		int weightage = 0;
		String str = null;
		String claimNo = null;
		String claimNumber = null;
		System.out.println("Enter Details To avail Claim");

		System.out.println("Enter claim Reason");
		claimBean.setClaimReason(scanner.next());
		System.out.println("Enter Accident Location");
		claimBean.setAccidentLocationStreet(scanner.next());
		System.out.println("Enter Accident City");
		claimBean.setAccidentCity(scanner.next());
		System.out.println("Enter Accident State");
		claimBean.setAccidentState(scanner.next());
		System.out.println("Enter Accident Zip");
		claimBean.setAccidentZip(scanner.next());
		System.out.println("Choose the below optoin to select the claim type");
		int key = 0;
		loop: do {
			try {

				System.out.println("1.Road Accident Claims");
				System.out.println("2.Medical Negligence Claims");
				System.out.println("3.Trip Accident Claims");

				key = scanner.nextInt();
				switch (key) {
				case 1:
					str = "Road Accident Claims";
					claimBean.setClaimType(str);

					break;
				case 2:
					str = "Medical Negligence Claims";
					claimBean.setClaimType(str);

					break;
				case 3:
					str = "Trip Accident Claims";
					claimBean.setClaimType(str);

					break;
				default:

					System.out.println("Please enter from the above options again");
					break;
				}

			} catch (InputMismatchException e) {
				System.out.println(e.getMessage());
				System.out.println("try again...");
				scanner.nextLine();
				continue loop;

			}
		} while (key > 3);
		System.out.println("Enter Policy Number");
		try {
			claimBean.setPolicyNumber(scanner.nextInt());
		} catch (Exception e) {
			System.out.println(e);
		}
		iQuestionService = new QuestionServiceImpl();
		try {
			boolean a = iQuestionService.validateDetails(claimBean);
			if (a == true) {

				System.out
						.println("Enter Business Segment from Business Auto, Apartment, Restaurant, General Merchant");

				System.out.println("1.	Business Auto" + "\n" + "2.	Apartment" + "\n" + "3.	Restaurant" + "\n"
						+ "4.	General Merchant" + "\n");
				int ch1 = scanner.nextInt();

				switch (ch1) {
				case 1:

					str = "Business Auto";
					questionBean.setQuestion(str);
					break;

				case 2:

					str = "Apartment";
					questionBean.setQuestion(str);
					break;

				case 3:

					str = "Restaurant";
					questionBean.setQuestion(str);
					break;

				case 4:

					str = "General Merchant";
					questionBean.setQuestion(str);
					break;

				default:

					System.out.println("Wrong choice");
					break;
				}

				questionBean = new QuestionBean();
				questionServiceImpl = new QuestionServiceImpl();
				List<QuestionBean> list = new ArrayList<>();
				list = questionServiceImpl.getQuestions(str);

				if (list.isEmpty()) {
					System.out.println("No questions....");
				} else {
					List<PolicyDetailsBean> policyDetailsList = new ArrayList<>();
					ListIterator<QuestionBean> iterator = list.listIterator();
					// Iterator<QuestionBean> iterator = list.iterator();
					while (iterator.hasNext()) {
						policyDetailsBean = new PolicyDetailsBean();
						QuestionBean questionBean1 = new QuestionBean();
						questionBean1 = iterator.next();
						System.out.println(questionBean1.getQuestion() + "?");
						policyDetailsBean.setPolicyNumber(claimBean.getPolicyNumber());
						policyDetailsBean.setQuestionId(questionBean1.getQuestionId());
						System.out.println("1.	" + questionBean1.getAnswer1());
						System.out.println("2.	" + questionBean1.getAnswer2());
						System.out.println("3.	" + questionBean1.getAnswer3());
						int choice;
						System.out.println("Select your answer");
						choice = scanner.nextInt();
						switch (choice) {
						case 1:

							weightage = weightage + questionBean1.getAnswerWeightage1();
							policyDetailsBean.setAnswer(questionBean1.getAnswer1());
							System.out.println(weightage + "\n");
							policyDetailsList.add(policyDetailsBean);
							break;

						case 2:

							weightage = weightage + questionBean1.getAnswerWeightage2();
							policyDetailsBean.setAnswer(questionBean1.getAnswer2());
							System.out.println(weightage + "\n");
							policyDetailsList.add(policyDetailsBean);
							break;

						case 3:

							weightage = weightage + questionBean1.getAnswerWeightage3();
							policyDetailsBean.setAnswer(questionBean1.getAnswer3());
							System.out.println(weightage + "\n");
							policyDetailsList.add(policyDetailsBean);
							break;

						default:

							System.out.println("wrong answer");
							iterator.previous();
							break;
						}

					}

					System.out.println(policyDetailsList);

					if (weightage >= 1600 && weightage <= 2600) {
						claimNo = "A";
						System.out.println(claimNo);
					} else if (weightage > 2600 && weightage <= 3600) {
						claimNo = "B";
						System.out.println(claimNo);
					} else if (weightage > 3600 && weightage <= 4600) {
						claimNo = "C";
						System.out.println(claimNo);
					} else if (weightage > 4600 && weightage <= 5600) {
						claimNo = "D";
						System.out.println(claimNo);
					} else if (weightage > 5600) {
						claimNo = "E";
						System.out.println(claimNo);
					} else {
						claimNo = null;
					}
					claimBean.setClaimNumber(claimNo);
				}
				claimNumber = iQuestionService.getPolicy_Number(claimBean);
				System.out.println("data inserted successfully your claim number is " + claimNumber);
			}

		} catch (QuestionException e) {
			e.printStackTrace();
		}

	}
}

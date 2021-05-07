package com.capgemini.quote.user;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.capgemini.qoute.dao.IAccountDao;
import com.capgemini.qoute.dao.IBusinessSegmentDao;
import com.capgemini.qoute.dao.IPolicyDao;
import com.capgemini.qoute.dao.IPolicyQuestionsDao;
import com.capgemini.qoute.dao.IUserRoleDao;
import com.capgemini.qoute.dao.ImplAccountDao;
import com.capgemini.qoute.dao.ImplBusinessSegmentDao;
import com.capgemini.qoute.dao.ImplPolicyDao;
import com.capgemini.qoute.dao.ImplPolicyQuestionDao;
import com.capgemini.qoute.dao.ImplUserRoleDao;
import com.capgemini.quote.entity.Account;
import com.capgemini.quote.entity.Policy;
import com.capgemini.quote.entity.Role;
import com.capgemini.quote.entity.User;

public class TestUser {
	static IUserRoleDao dao = new ImplUserRoleDao();
	static IAccountDao daoAccount = new ImplAccountDao();
	static IBusinessSegmentDao daoBusiness = new ImplBusinessSegmentDao();
	static IPolicyQuestionsDao daoPolQues = new ImplPolicyQuestionDao();
	static IPolicyDao daoPolicy = new ImplPolicyDao();
	static List<Account> accountObject;
	static Account accountObj;
	static String userName = null, cont = null;
	static Scanner sc;

	public static void main(String[] args) {

		sc = new Scanner(System.in);

		userVerification();

//		System.out.println(dao.getRoleList());
//		String userType = sc.next();
//
//		System.out.println("Please Enter Your RoleCode");		
//		if (userType.equals("1")) {
//			methodInsured();
//		} else if (userType.equals("2")) {
//			methodAgent();
//		} else if(userType.equals("3")) {
//			methodAdmin();
//		}

//		User user = new User("Monu","Monu123","1");
//		dao.createUser(user);
//		System.out.println(dao.getUserById("Monu"));

//		acc = new Account(1111111112,"ABCd","street1","mumbaid","maharastra","424001","BUSINESSAUTO","kunal");
//		daoAccount.createAccount(acc);

//		System.out.println(daoAccount.showAccount(1111111111));

//		System.out.println(daoBusiness.showBusinessSegmentList());

//		int weightage = 0;
//		for (int i = 1; i <= 10; i++) {
//			System.out.println(daoPolQues.showPolicyQuestions(i));
//			System.out.println("Enter Your Choice");
//			int option = sc.nextInt();
//
//			if (option == 1)
//				weightage = weightage + 200;
//			else if (option == 2)
//				weightage = weightage + 400;
//			else if (option == 3)
//				weightage = weightage + 600;
//			else {
//				i--;
//				System.out.println("Invalid answer");
//			}
//		}
//		System.out.println("Total:" + weightage);

	}

	public static void userVerification() {
		do {
			User u = dao.Login();
			if (u == null) {
				System.out.println("Do you want to continue enter 'yes' or 'no'");
				cont = sc.next();
			} else {
				if (u.getRoleCode().equals("1")) {
					System.out.println(u.getUserName() + " You have loged in as Insured ");
					methodInsured(u);
				} else if (u.getRoleCode().equals("2")) {
					System.out.println(u.getUserName() + " You have loged in as Agent");
					methodAgent(u);
				} else if (u.getRoleCode().equals("3")) {
					System.out.println(u.getUserName() + " You have loged in as Admin ");
					methodAdmin();
				}
			}

		} while (cont.equals("yes"));
	}

	public static void findingUserType(String userName, String password) {
	}

	public static void methodInsured(User user) {
		do {
			System.out.println("1. View Policy");
			System.out.println("2. Create Account (if account not created)");
			System.out.println("3. Show Account");
			System.out.println("4. Exit");
			System.out.println("Enter Your Choice");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				accountObject = daoAccount.showAccountByUserName(user.getUserName());
				System.out.println(daoPolicy.showPolicyByUserName(accountObject.get(0).getAccount_Number()));
				break;
			case 2:
				String account_Number, insured_Name, insured_Street, insured_City, insured_State;
				String insured_Zip, business_Segment_Name, user_Name;
				if (user == null) {
					System.out.println(daoBusiness.showBusinessSegmentList());
					System.out.println("Enter Account Number : ");
					account_Number = sc.next();
					System.out.println("Enter Name : ");
					insured_Name = sc.next();
					System.out.println("Enter Street : ");
					insured_Street = sc.next();
					System.out.println("Enter City : ");
					insured_City = sc.next();
					System.out.println("Enter State : ");
					insured_State = sc.next();
					System.out.println("Enter Zip Code : ");
					insured_Zip = sc.next();

					System.out.println("\nAvailable Business");
					System.out.println(daoBusiness.showBusinessSegmentList());
					System.out.println("\nEnter Business Segment Name : ");
					business_Segment_Name = sc.next();
					user_Name = user.getUserName();

					// If user name already exists TRY CATCH
					Account account = new Account(account_Number, insured_Name, insured_Street, insured_City,
							insured_State, insured_Zip, business_Segment_Name, user_Name);
					daoAccount.createAccount(account);
				} else {
					System.out.println("Account Already Exists");
					methodInsured(user);
				}

				break;
			case 3:
				accountObject = daoAccount.showAccountByUserName(user.getUserName());
				System.out.println(accountObject);
				break;
			case 4:
				System.out.println("Successfully Exited");
				userVerification();
				break;
			default:
				System.out.print("You have entered wrong choice\nPlease try again...");
				methodInsured(user);
				break;
			}
			System.out.println("Do you want to continue enter 'yes' or 'no'");
			cont = sc.next();
		} while (cont.equals("yes"));

		System.out.println("Thank You For Using Our System");
	}

	public static void methodAgent(User user) {
		do {
			System.out.println("1. Create Insured Account");
			System.out.println("2. Show My Insured Account");
			System.out.println("3. Create Insured Policy");
			System.out.println("4. Show Insured Policy");
			System.out.println("5. Exit");
			System.out.println("Enter Your Choice");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				String account_Number, insured_Name, insured_Street, insured_City, insured_State;
				String insured_Zip, business_Segment_Name, user_Name;

				System.out.println("Enter User Name : ");
				user_Name = sc.next();
				User u = dao.getUserById(user_Name);
				if (u == null) {
					System.out.println("Invalid User Name");
					break;
				} else {
					System.out.println("Enter Account Number : ");
					account_Number = sc.next();
					
					if (daoAccount.getUserByAccountNumber(account_Number) == null) {
						System.out.println("Enter Name : ");
						insured_Name = sc.next();
						System.out.println("Enter Street : ");
						insured_Street = sc.next();
						System.out.println("Enter City : ");
						insured_City = sc.next();
						System.out.println("Enter State : ");
						insured_State = sc.next();
						System.out.println("Enter Zip Code : ");
						insured_Zip = sc.next();

						System.out.println("\nAvailable Business");
						System.out.println(daoBusiness.showBusinessSegmentList());
						System.out.println("\nEnter Business Segment Name : ");
						business_Segment_Name = sc.next();

						// If user name already exists TRY CATCH
						Account account = new Account(account_Number, insured_Name, insured_Street, insured_City, insured_State,
								insured_Zip, business_Segment_Name, user_Name,user.getUserName());
						daoAccount.createAccount(account);
						break;
					} else {
						System.out.println("Account Number Already Exists");
						break;
					}					
				}			

			case 2:
				System.out.println(daoAccount.showAccountCreatedById(user.getUserName()));
				break;
			case 3:
				
				break;
			case 4:

				break;

			case 5:
				System.out.println("Successfully Exited");
				userVerification();
				break;
			default:
				System.out.print("You have entered wrong choice\nPlease try again...\n");
				methodAgent(user);
				break;
			}
			System.out.println("Do you want to continue enter 'yes' or 'no'");
			cont = sc.next();
		} while (cont.equals("yes"));

		System.out.println("Thank You For Using Our System");
	}

	public static void methodAdmin() {
		do {
			System.out.println("1. Role List");
			System.out.println("2. Get User Details");
			System.out.println("3. Login");
			System.out.println("4. Create User");
			System.out.println("Enter Your Choice");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Role List:\n" + dao.getRoleList());
				break;
			case 2:
				System.out.println("Enter User Name : ");
				userName = sc.next();
				User u = dao.getUserById(userName);
				if (u == null) {
					System.out.println("User Not Found");
				} else {
					System.out.println(u);
				}
				break;
			case 3:
				System.out.print("Enter User Name : ");
				userName = sc.next();
				System.out.print("Enter Password : ");
				String password = sc.next();
				System.out.print("Enter RoleCode : ");
				String roleCode = sc.next();
				break;
			case 4:

				break;
			default:
				System.out.print("You have entered wrong choice\nPlease try again...\n");
				methodAdmin();
				break;
			}
			System.out.println("Do you want to continue enter 'yes' or 'no'");
			cont = sc.next();
		} while (cont.equals("yes"));

		System.out.println("Thank You For Using Our System");
	}
}

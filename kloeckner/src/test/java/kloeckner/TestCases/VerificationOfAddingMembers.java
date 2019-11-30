package kloeckner.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import kloeckner.Base.BaseClass;
import kloeckner.Pages.BoardListPage;
import kloeckner.Pages.LoginPage;
import kloeckner.Pages.MyBoardPage;

public class VerificationOfAddingMembers extends BaseClass {

	LoginPage loginPage;
	BoardListPage boardListPage;
	MyBoardPage myBoardPage;

	@BeforeMethod
	public void setUp() {
		StartBrowser();
		loginPage = new LoginPage();
		boardListPage = new BoardListPage();
		myBoardPage = new MyBoardPage();
	}

	// *****************************************************************************************************************
	//
	// * Project : Kloeckner Automation Challenge
	// * TestCase1 : Verify user is able to add the people to the Board by inviting members from invite section
	// * Author : Sriram Gatiganti
	//
	// *****************************************************************************************************************
	/*
	 * Test Steps Step 1. Login into Application Step 
	 * 2. Get Board Name Step 
	 * 3. If expected board name is presented then go to the Board Step 
	 * 4.Click My Board 
	 * 5.Click invite button
	 * 6.Enter Valid Mail Id
	 * 7.Click on Send Invite button
	 * 8.Click on added invitee intail from members list
	 * 9.Verify member Name and email is displaying as expectimg on invitee form.
	 * 10.Click on Remove link
	 * 11.Click on Remove Member button on Remove Member confirmation
	 */

	@Test(priority = 0,enabled = true)
	public void VerificationofAddingMembersToBoard() throws InterruptedException {

		// 1.Login into Application
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
		// 2.Get My Board name
		String MyBoardName = boardListPage.getMyboardName();

		// 3.If expected board name is presented then go to the Board
		if (MyBoardName.equals(prop.getProperty("myBoardName"))) {

			// 4.Click My Board
			boardListPage.clickMyBoard();

			// 5.Click invite button
			myBoardPage.ClickInviteButton();

			// 6.Enter Valid Mail Id
			myBoardPage.EnterEmail(prop.getProperty("Email"));

			// 7.Click on Send Invite button
			myBoardPage.ClickSendInviteeButton();
			Thread.sleep(1000);

			// 8.Click on added invitee intail from members list
			myBoardPage.ClickInviteeOnBoard();

			// 9.Verify member Name and email is displaying as expectimg on invitee form.
			String strMemberNameOnInviteeForm = myBoardPage.GetMemberNameOnInviteeform();
			Assert.assertEquals(strMemberNameOnInviteeForm, prop.getProperty("FullName"));

			String strMemberEmailOnInviteeForm = myBoardPage.GetMemberEmailOnInviteeform();
			Assert.assertEquals(strMemberEmailOnInviteeForm, prop.getProperty("Email"));

			// 10.Click on Remove link
			myBoardPage.ClickRemoveOnInviteeForm();

			// 11.Click on Remove Member button on Remove Member confirmation
			myBoardPage.ClickRemoveButtonConfirmation();

		}

	}

	// *****************************************************************************************************************
	//
	// * Project : Kloeckner Automation Challenge
	// * TestCase2 : Verify user is able to add the people to the Card by adding memebers from ADD TO CARD section of Card
	// * Author : Sriram Gatiganti
	//
	// *****************************************************************************************************************
	/*
	 * Test Steps Step 1. Login into Application Step 
	 * 2. Get Board Name Step 
	 * 3. If expected board name is presented then go to the Board Step 
	 * 4. Click on desired card from list of cards Step 
	 * 5.Click on Members button on Add to card secction
	 * 6.Enter Valid Mail Id
	 * 7.Verify Full Name is displayed from entered mail id
	 * 8.Click on send button
	 * 9.Click added member intial from Members list on card
	 * 10.Verify member Name and email is displaying as expectimg on member form.
	 * 11.Remove member from list
	 */

	@Test(priority = 1,enabled = true)
	public void VerificationofAddingMembersToCard() throws InterruptedException {

		// 1.Login into Application
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		

		// 2.Get My Board name
		String MyBoardName = boardListPage.getMyboardName();

		// 3.If expected board name is presented then go to the Board
		if (MyBoardName.equals(prop.getProperty("myBoardName"))) {
			boardListPage.clickMyBoard();

			// 4.Click on desired card from list of cards
			myBoardPage.clickMyCard(prop.getProperty("myCarddName"));

			// 5.Click on Members button on Add to card secction
			myBoardPage.ClickOnAddToCardButton("Members");

			// 6.Enter Valid Mail Id
			myBoardPage.EnterEmailOnAddMembersOnCard(prop.getProperty("Email"));	
			
			//7.Verify Full Name is displayed from entered mail id
			String strFullName=myBoardPage.GetTextFromFullName();
			Assert.assertEquals(strFullName, prop.getProperty("FullName"));
			
			//8.Click on send button
			myBoardPage.ClickSendButton();	
			Thread.sleep(1000);

			// 9.Click added member intial from Members list on card
			myBoardPage.clickAddedMemberIntail(prop.getProperty("MemberInitial"));

			// 10.Verify member Name and email is displaying as expectimg on member form.
			String strMemberName = myBoardPage.GetMemberName();
			Assert.assertEquals(strMemberName, prop.getProperty("FullName"));

			String strMemberEmail = myBoardPage.GetMemberEmail();
			Assert.assertEquals(strMemberEmail, prop.getProperty("Email"));

			// 11.Remove member from list
			myBoardPage.ClickRemoveOnMemberForm();

		}

	}
	
	// *****************************************************************************************************************
	//
	// * Project : Kloeckner Automation Challenge
	// * TestCase3 : Verify added member at Card is displaying at Board members
	// * Author : Sriram Gatiganti
	//
	// *****************************************************************************************************************
	/*
	 * Test Steps Step 
	 * 1. Login into Application Step 
	 * 2. Get Board Name  
	 * 3. If expected board name is presented then go to the Board Step 
	 * 4. Click on desired card from list of cards 
	 * 5. Click on Members button on Add to card secction
	 * 6. Enter Valid Mail Id
	 * 7. Click on send button
	 * 8.Close the Card form
	 * 9.Click on added invitee intail from Board members list
	 * 10.Verify member Name and email is displaying as expectimg on invitee form
	 * 11.Click on Remove link
	 * 12.Click on Remove Member button on Remove Member confirmation
	 */
	@Test(priority = 2,enabled = true)
	public void VerificationofAddedMemberatCardAndBoard() throws InterruptedException {

		// 1.Login into Application
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		

		// 2.Get My Board name
		String MyBoardName = boardListPage.getMyboardName();

		// 3.If expected board name is presented then go to the Board
		if (MyBoardName.equals(prop.getProperty("myBoardName"))) {
			boardListPage.clickMyBoard();

			// 4.Click on desired card from list of cards
			myBoardPage.clickMyCard(prop.getProperty("myCarddName"));

			// 5.Click on Members button on Add to card secction
			myBoardPage.ClickOnAddToCardButton("Members");

			// 6.Enter Valid Mail Id
			myBoardPage.EnterEmailOnAddMembersOnCard(prop.getProperty("Email"));	
					
			//7.Click on send button
			myBoardPage.ClickSendButton();	
			Thread.sleep(1000);
			
			//8.Close the Card form
			myBoardPage.ClickCloseCard();
			Thread.sleep(1000);

			// 9.Click on added invitee intail from Board members list
			myBoardPage.ClickInviteeOnBoard();

			// 10.Verify member Name and email is displaying as expectimg on invitee form.
			String strMemberNameOnInviteeForm = myBoardPage.GetMemberNameOnInviteeform();
			Assert.assertEquals(strMemberNameOnInviteeForm, prop.getProperty("FullName"));

			String strMemberEmailOnInviteeForm = myBoardPage.GetMemberEmailOnInviteeform();
			Assert.assertEquals(strMemberEmailOnInviteeForm, prop.getProperty("Email"));

			// 11.Click on Remove link
			myBoardPage.ClickRemoveOnInviteeForm();

			// 12.Click on Remove Member button on Remove Member confirmation
			myBoardPage.ClickRemoveButtonConfirmation();

		}

	}

	@AfterMethod
	public void tearDown() {
		CloseDriver();
	}

}

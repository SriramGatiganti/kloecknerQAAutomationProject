package kloeckner.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import kloeckner.Base.BaseClass;
import kloeckner.Pages.BoardListPage;
import kloeckner.Pages.LoginPage;
import kloeckner.Pages.MyBoardPage;

public class VerficationOfCardDetails extends BaseClass {

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
	// * TestCase1 : Verify user is able to see the name of the list on Card form
	// * Author : Sriram Gatiganti
	//
	// *****************************************************************************************************************
	/*
	 * Test Steps Step 
	 * 1. Login into Application Step 
	 * 2. Get Board Name Step
	 * 3. If expected board name is presented then go to the Board Step 
	 * 4. Click on desired card from list of cards Step 
	 * 5. Verify My List name on card same as list name of the board
	 */

	@Test(priority = 0, enabled = true)
	public void VerificationofListNameOnCard() throws InterruptedException {

		// 1.Login into Application
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));

		// 2.Get My Board name
		String MyBoardName = boardListPage.getMyboardName();

		// 3.If expected board name is presented then go to the Board
		if (MyBoardName.equals(prop.getProperty("myBoardName"))) {
			boardListPage.clickMyBoard();

			// 4.Click on desired card from list of cards
			myBoardPage.clickMyCard(prop.getProperty("myCarddName"));

			// 5.Verify My List name on card same as list name
			String MyListNameOnCardForm = myBoardPage.getListNameOnCard();
			Assert.assertEquals(MyListNameOnCardForm, prop.getProperty("myListName"));

		}

	}

	// *****************************************************************************************************************
	//
	// * Project : Kloeckner Automation Challenge
	// * TestCase2 : Verify user is able to see the name of the list on Card form
	// * Author : Sriram Gatiganti
	//
	// *****************************************************************************************************************
	/*
	 * Test Steps 
	 * 1.Login into Application Step 
	 * 2.Get Board Name Step 
	 * 3. If expected board name is presented then go to the Board Step 
	 * 4. Click on desired card from list of cards Step 
	 * 5. Verify My Card name on card same as Expected Card name
	 */
	@Test(priority = 1, enabled = true)
	public void VerificationofCardNameOnCard() throws InterruptedException {

		// 1.Login into Application
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));

		// 2.Get My Board name
		String MyBoardName = boardListPage.getMyboardName();

		// 3.If expected board name is presented then go to the same Board
		if (MyBoardName.equals(prop.getProperty("myBoardName"))) {
			boardListPage.clickMyBoard();

			// 4.Click on my card from list of cards
			myBoardPage.clickMyCard(prop.getProperty("myCarddName"));

			// 5.Verify My Card name on card same as Expected Card name
			String MyCardNameOnCardForm = myBoardPage.getCardNameOnCard();
			Assert.assertEquals(MyCardNameOnCardForm, prop.getProperty("myCarddName"));
		}
	}

	@AfterMethod
	public void tearDown() {
		CloseDriver();
	}

}

package kloeckner.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import kloeckner.Base.BaseClass;

public class BoardListPage extends BaseClass {

	// Page Factory - OR:
	@FindBy(xpath = "//h3[contains(text(),'Personal Boards')]")
	WebElement personalBoards;

	@FindBy(xpath = "//div[contains(@class,'board-tile-details-name')]//div[contains(text(),'Klockener_Challange')]")
	WebElement myBoardList;

	// Initializing the Page Objects:
	public BoardListPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions:

	// Get my Board Name
	public String getMyboardName() {
		return myBoardList.getText();
	}

	// Click My Board
	public void clickMyBoard() {
		myBoardList.click();
	}

}

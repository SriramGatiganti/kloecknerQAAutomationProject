package kloeckner.Pages;

import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import kloeckner.Base.BaseClass;

public class MyBoardPage extends BaseClass {

	// Page Factory - OR:
	@FindBy(xpath = "//div[contains(@class,\"list-header-target js-editing-target\")]")
	WebElement myListName;

	@FindBy(xpath = "//a[contains(@class,'js-open-move-from-header')]")
	WebElement ListNameOnCardForm;

	@FindBy(xpath = "//textarea[contains(@class,'mod-card-back-title js-card-detail-title-input')]")
	WebElement CardNameOnCardForm;

	@FindBy(xpath = "//input[contains(@class,'autocomplete-input')]")
	WebElement EnterEmailOnInviteBox;

	@FindBy(xpath = "//input[contains(@class,'js-search-mem js-autofocus')]")
	WebElement EnterEmailOnAddMembersBox;

	@FindBy(xpath = "//span[contains(text(),'(test18210301)')]")
	WebElement RetreivedBoardMember;

	@FindBy(xpath = "//input[contains(@class,'js-autofocus js-full-name')]")
	WebElement FullNameField;

	@FindBy(xpath = "//input[contains(@class,'wide primary js-send-email-invite')]")
	WebElement SendButton;

	@FindBy(xpath = "//a[contains(@class,'mini-profile-info-title-link js-profile')]")
	WebElement MemberNameOnMemberFrom;

	@FindBy(xpath = "//p[contains(@class,'u-bottom quiet')]")
	WebElement MemberEmailOnMemberFrom;

	@FindBy(xpath = "//a[contains(@class,'js-remove-member')]")
	WebElement RemoveLinkOnMemberForm;

	@FindBy(xpath = "//a[contains(@class,'invite board')]")
	WebElement InviteButtonOnMemberForm;

	@FindBy(xpath = "//button[contains(@class,'autocomplete-btn primary')]")
	WebElement SendInvitationButton;

	@FindBy(xpath = "//div[contains(@class,'virtual-invitee')]//span[contains(@class,'member-initials')]")
	WebElement InviteeMemberOnBoard;

	@FindBy(xpath = "//a[contains(@class,'mini-profile')]")
	WebElement MemberNameOnInviteeFrom;

	@FindBy(xpath = "//p[contains(@class,'u-bottom quiet')]")
	WebElement MemberEmailOnInviteeFrom;

	@FindBy(xpath = "//a[contains(@class,'js-remove-member')]")
	WebElement RemoveLinkOnInviteeForm;

	@FindBy(xpath = "//input[contains(@class,'js-confirm full negate')]")
	WebElement RemoveMemberConfirmationButtton;

	@FindBy(xpath = "//a[contains(@class,'close-window')]")
	WebElement CloseCard;

	// Initializing the Page Objects:
	public MyBoardPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions:

	// Get my ListName
	public String getMyListName() {
		return myListName.getText();
	}

	// Click on my Card
	public void clickMyCard(String MyCard) throws InterruptedException {

		// store the Card Names (web elements) into the linkedlist
		List<WebElement> MyCardList = new LinkedList<WebElement>();
		Thread.sleep(5000);
		MyCardList = driver.findElements(By.xpath("//span[contains(@class,'list-card-title js-card-name')]"));

		for (int i = 0; i <= MyCardList.size() - 1; i++) {
			String s = MyCardList.get(i).getText();
			if (s.equals(MyCard)) {
				driver.findElement(By.xpath("//span[contains(text(),'" + MyCard + "')]")).click();
			}

		}

	}

	// Get List Name on Cardform
	public String getListNameOnCard() {
		return ListNameOnCardForm.getText();
		// return ListNameOnCardForm.getAttribute("value");
	}

	// Get Card Name on Cardform
	public String getCardNameOnCard() {
		return CardNameOnCardForm.getAttribute("value");
	}

	// Click on desired Add To Card button on Card
	public void ClickOnAddToCardButton(String buttonNameOnCard) {
		driver.findElement(By.xpath("//span[contains(text(),'" + buttonNameOnCard + "')]")).click();
	}

	// Enter Email id in Invite members form
	public void EnterEmail(String email) {
		EnterEmailOnInviteBox.sendKeys(email);

	}

	// Enter Email id in Add members on Card form
	public void EnterEmailOnAddMembersOnCard(String email) {
		EnterEmailOnAddMembersBox.sendKeys(email);

	}

	// Click on retreived value from search box
	public void ClickOnRetreivedValue() {
		RetreivedBoardMember.click();

	}

	// Get text from fullName field
	public String GetTextFromFullName() {
		return FullNameField.getAttribute("value");
	}

	// Click Send button
	public void ClickSendButton() {
		SendButton.click();
	}

	// Click added memeber based on Intial on Card from
	public void clickAddedMemberIntail(String addedMemberIntial) {

		// store the Card Names (web elements) into the linkedlist
		List<WebElement> MemberList = new LinkedList<WebElement>();

		MemberList = driver
				.findElements(By.xpath("//div[@class='js-card-detail-members-list']//span[@class='member-initials']"));

		for (int i = 0; i <= MemberList.size() - 1; i++) {
			String s = MemberList.get(i).getText();
			if (s.equals(addedMemberIntial)) {
				driver.findElement(By.xpath(
						"//div[@class='js-card-detail-members-list']//span[@class='member-initials'][contains(text(),'"
								+ addedMemberIntial + "')]"))
						.click();
			}

		}

	}

	// Get Member name on Member form
	public String GetMemberName() {
		return MemberNameOnMemberFrom.getText();
	}

	// Get Member Emailon Member form
	public String GetMemberEmail() {
		return MemberEmailOnMemberFrom.getText();
	}

	// Remove Member from Member form
	public void ClickRemoveOnMemberForm() {
		RemoveLinkOnMemberForm.click();
	}

	// Click invite button
	public void ClickInviteButton() {
		InviteButtonOnMemberForm.click();
	}

	// Click invitee member
	public void ClickInviteeOnBoard() {
		InviteeMemberOnBoard.click();
	}

	// Click Send Invite Button
	public void ClickSendInviteeButton() {
		SendInvitationButton.click();
	}

	// Get Name on Invitee form
	public String GetMemberNameOnInviteeform() {
		return MemberNameOnInviteeFrom.getText();
	}

	// Get Email on Invitee form
	public String GetMemberEmailOnInviteeform() {
		return MemberEmailOnInviteeFrom.getText();
	}

	// Remove Member from Invitee form
	public void ClickRemoveOnInviteeForm() {
		RemoveLinkOnInviteeForm.click();
	}

	// Remove Member confirmation Button
	public void ClickRemoveButtonConfirmation() {
		RemoveMemberConfirmationButtton.click();
	}

	// Close the card
	public void ClickCloseCard() {
		CloseCard.click();
	}

}

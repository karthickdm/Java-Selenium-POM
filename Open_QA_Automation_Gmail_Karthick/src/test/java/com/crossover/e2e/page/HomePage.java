package test.java.com.crossover.e2e.page;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	/// Home page Locator declaration  
	@FindBy(css="div[class=\"z0\"] > div[role=\"button\"]")
	WebElement composeButton;
	
	@FindBy(name= "to")
	WebElement emailTo;
	
	@FindBy(css="form > div:nth-child(3) > input[name=\"subjectbox\"]")
	WebElement emailSubject;
	
	@FindBy(css = "div[aria-label=\"Message Body\"]")
	WebElement emailMessage;
	
	@FindBy(xpath = "//*[@role='button' and text()='Send']")
	WebElement sendButton;
	
	@FindBy(css="div[class='xS'] > div > span")
	List<WebElement> emailMessageList;
	
	@FindBy(css="div[class='xS'] > div > div> span")
	List<WebElement> emailSubjectList;
	
	@FindBy(css="div.bAK > div:nth-child(1)")
	WebElement attachButton;
	
	
	/// Business action implementation
	public void clickEmailComposeButton()
	{
		composeButton.click();
	}
	
	public void enterEmailTo(String mail)
	{
		emailTo.clear();
		emailTo.sendKeys(mail);
	}
	
	public void enterEmailSubject(String subject)
	{
		emailSubject.clear();
		emailSubject.sendKeys(subject);
	}
	
	public void enterEmailMessage(String message) 
	{
		emailMessage.clear();
		emailMessage.sendKeys(message);
	}
	
	public void clickAttachment() throws IOException, InterruptedException
	{
		attachButton.sendKeys("C:\\Users\\karth\\eclipse-workspace\\Open_QA_Automation_Gmail\\attch.txt");
		Thread.sleep(5000);
	}
	
	public void clickSendButton() throws InterruptedException
	{
		sendButton.click();
		Thread.sleep(20000);
	}
	
	public String validate_emailMessage() throws InterruptedException
	{	
		String Message = emailMessageList.get(0).getText();
		String emailMessage = Message.replaceAll("-", "").trim();
		return emailMessage;
	}
	
	public String validate_emailSubject() 
	{
		String subject_value = emailSubjectList.get(0).getText();
		return subject_value;
	}
	
}

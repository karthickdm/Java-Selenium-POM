package test.java.com.crossover.e2e.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	/// Home page Locator declaration
	@FindBy(id ="identifierId")
	WebElement userName;
	
	@FindBy(id ="identifierNext")
	WebElement nextButton;
	
	@FindBy(name ="password")
	WebElement passWord;
	
	@FindBy(id = "passwordNext")
	WebElement submitButton;
	
	/// Business actions implementation 
	public void enterUserNameAndPassWord(String name, String pass)
	{
		userName.sendKeys(name);
		clickNextButton();
		passWord.sendKeys(pass);
	}
	
	public void clickNextButton()
	{
		nextButton.click();
	}
		
	public void pressSubmitButton() {
		submitButton.click();
	}
	
	public void navigatetoGmail(String url)
	{
		driver.get(url);
	}

}

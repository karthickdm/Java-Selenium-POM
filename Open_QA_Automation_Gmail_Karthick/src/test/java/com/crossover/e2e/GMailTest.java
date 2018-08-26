package test.java.com.crossover.e2e;

import java.util.Properties;
import java.util.concurrent.TimeUnit;
import test.java.com.crossover.e2e.page.HomePage;
import test.java.com.crossover.e2e.page.LoginPage;
import test.java.com.crossover.e2e.pageValidator.HomePageValidator;
import org.junit.Test;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.FileInputStream;
import java.io.InputStream;

public class GMailTest {
	
	private static WebDriver driver;
    private static Properties properties = new Properties();
    private static InputStream input = null;
    
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);
    HomePageValidator homepageValidaator = new HomePageValidator();
    
    
    @BeforeClass
    public static void setUp() throws Exception 
    {
    	input = new FileInputStream("test.properties");
        properties.load(input);
    	
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\karth\\workspace\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    
    @AfterClass
    public static void tearDown()
    {
        driver.quit();
    }
    
    @Test
    public void testSendEmail() throws Exception
    {
    	// Test data
    	String userName = properties.getProperty("username");
        String passWord = properties.getProperty("password");
        String email = String.format("%s@gmail.com", userName);
        String subject = properties.getProperty("emailsubject");
        String message = properties.getProperty("emailcontent");
        
        // Login page test steps
        loginPage.navigatetoGmail("https://mail.google.com/");
    	loginPage.enterUserNameAndPassWord(userName, passWord);
    	loginPage.pressSubmitButton();
    	
    	// Home page test steps
    	homePage.clickEmailComposeButton();
    	homePage.enterEmailTo(email);
    	homePage.enterEmailSubject(subject);
    	homePage.enterEmailMessage(message);
    	homePage.clickAttachment();
    	homePage.clickSendButton();
    	
    	// Validate email subject
    	String actual_result = homePage.validate_emailSubject();
    	homepageValidaator.validateActualAndExpectedResultAreEqual(subject, actual_result);
    	
    	// Validate email message
    	String email_message = homePage.validate_emailMessage();
    	homepageValidaator.validateActualAndExpectedResultAreEqual(message, email_message);
    }
}

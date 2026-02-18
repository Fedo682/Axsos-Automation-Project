package AutomationPRJ.OrangHRM;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangHRMTest {
	
	WebElement dashboard;
	WebDriver driver;
	OrangHRM oranghrm;
	
	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		oranghrm = new OrangHRM(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));	
	}
	
	@Test (priority = 1)
	public void testLoginValidCredintials() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));	
		oranghrm.login("Admin","admin123");	
		System.out.println(driver.findElement(By.xpath("//h6[contains(@class,'oxd-topbar-header-breadcrumb')]")).getText());
		Assert.assertTrue(true, "Login successful");
	}
	

	@Test (priority = 2)
	public void testLoginInValidCredintials() throws InterruptedException {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
    Thread.sleep(3000);
	oranghrm.login("addddd","gfhjj");
	System.out.println(driver.findElement(By.xpath("//p[contains(@class,'oxd-alert-content-text')]")).getText());
	Assert.assertFalse(false, "Invalid credentials");
	}
	
	@Test (priority = 3)
    public void testLoginEmpty () throws InterruptedException {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	
    Thread.sleep(3000);
    oranghrm.login("" ,"");
    }
    
	@Test (priority = 4)
    public void testLoginCapitalUserName () throws InterruptedException  {
    Thread.sleep(3000);
    oranghrm.login("ADMIN" ,"admin123" );
    dashboard = driver.findElement(By.xpath("//h6[contains(@class,'oxd-topbar-header-breadcrumb')]"));
    if(dashboard.isDisplayed()) 
    {
    	Assert.assertFalse(false, "didnt handle the capital letters in username");
    }
	}

	@Test (priority = 5)
	public void testLoginCapitalPass () throws InterruptedException  {	
    Thread.sleep(3000);		
    oranghrm.login("Admin" ,"ADMIN123" );
    Assert.assertFalse(false, "didnt handle the capital letters in password");
	}
	
	@Test (priority = 6)
	public void testLoginUserNameWithExtraSpace () throws InterruptedException   {	
    Thread.sleep(3000);		
    oranghrm.login("Admin " ,"admin123" );
    dashboard = driver.findElement(By.xpath("//h6[contains(@class,'oxd-topbar-header-breadcrumb')]"));
    if(dashboard.isDisplayed()) {
    Assert.assertFalse(false, "didnt handle the extra space in username");
    }
	}
	
	@Test (priority = 7)
	public void testLoginPassWithExtraSpace () throws InterruptedException   {	
    Thread.sleep(3000);		
    oranghrm.login("Admin" ,"admin123 " );
    Assert.assertFalse(false, "didnt handle the extra space in password");
	}

	@Test (priority = 8)
	public void testAdminAddEmploye() throws InterruptedException {
        Thread.sleep(3000);		

	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
	Thread.sleep(3000);
	oranghrm.login("Admin","admin123");	
	
	oranghrm.addEmployee();
	oranghrm.addEmployeeFields("FirstName", "LastName");
	Assert.assertTrue(true, "Employee added successfully");
	
     }
	
	@Test (priority = 10)
	public void testCancelPIMButton() {
        oranghrm.login("ADMIN" ,"admin123" );
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));	
		oranghrm.addEmployee();
		oranghrm.addEmployeeFields("laith", "faheem");
		oranghrm.cancelPIMButton();
		WebElement empInfo = driver.findElement(By.xpath("//h5[text()='Employee Information']"));
		if(empInfo.isDisplayed()) {
        	Assert.assertNotNull(empInfo, "redirected to employee info page");
		}
	}
	
	@Test	(priority = 11)
	public void testNameLongerThan30Chars() {
    oranghrm.login("ADMIN" ,"admin123" );
    oranghrm.addEmployee();
    oranghrm.addEmployeeFields("test123456789011121314151617181920", "laith");
    WebElement exceedMsg = driver.findElement(By.xpath("//span[text()='Should not exceed 30 characters']"));
    if(exceedMsg.isDisplayed()) {
    	Assert.assertEquals(exceedMsg.getText(), "Should not exceed 30 characters");
    }
    
	}
	
	@Test	(priority = 12)
	public void testEnableCreateLoginDetailsToggle() {
    oranghrm.login("ADMIN" ,"admin123" );
    oranghrm.addEmployee();
    oranghrm.enableCreateLoginDetailsToggle();
    WebElement toggleOn = driver.findElement(By.xpath("//span[@class='oxd-switch-input oxd-switch-input--active --label-right']"));
    if(toggleOn.isEnabled()) {
    	Assert.assertNotNull(toggleOn,"toggle ON isdisplayed");
    }
	}
	
	@Test		(priority = 13)
	public void testDisableCreateLoginDetailsToggle() {
    oranghrm.login("ADMIN" ,"admin123" );
    oranghrm.addEmployee();
    WebElement toggleOff = driver.findElement(By.xpath("//span[@class='oxd-switch-input oxd-switch-input--active --label-right']"));
    if(toggleOff.isDisplayed()) {
    	Assert.assertNotNull(toggleOff,"toggle off isdisplayed");
    }
	}
	
	@Test		(priority = 14)
	public void testValidCreateLoginDetailsToggle() {
    oranghrm.login("ADMIN" ,"admin123" );
    oranghrm.addEmployee();
    oranghrm.enableCreateLoginDetailsToggle();
    oranghrm.addEmployeeFields("Mariam", "Mariam");
    oranghrm.fillCreateLoginDetailsForm("mariam01", "Admin@123", "Admin@123");
    oranghrm.ClickSaveButtonAddEmployee();
    Assert.assertTrue(true, "Employee added successfully with valid login details");
    
	}
	
	@Test ( priority = 15, dependsOnMethods = { "testValidCreateLoginDetailsToggle" })
	public void testLogInMultipleTimes() throws InterruptedException   {	
    
    int counter = 2;
    while (counter!=0) {
    oranghrm.login("Admin" ,"123456789aa" );
    Thread.sleep(4000);		
    counter--;
    }
    oranghrm.login("Admin" ,"admin123" );
    Thread.sleep(3000);		
	dashboard = driver.findElement(By.xpath("//h6[contains(@class,'oxd-topbar-header-breadcrumb')]"));
    if (dashboard.isDisplayed()) {
    System.out.println("The Account is not locked");
    Assert.fail("The Account is not locked after multiple failed login attempts");
    }
    Thread.sleep(3000);		
	}
	
	@Test		(priority = 16)
	public void testEmptyCreateLoginDetailsToggle() {
		oranghrm.login("ADMIN" ,"admin123" );
        oranghrm.addEmployee();
        oranghrm.enableCreateLoginDetailsToggle();
        oranghrm.ClickSaveButtonAddEmployee();
        WebElement requieredMsg = driver.findElement(By.xpath("//span[text()='Required']"));
        if(requieredMsg.isDisplayed()) {
        	Assert.assertEquals(requieredMsg.getText(), "Required");
        }
	}
	
	@Test	(priority = 17)
	public void testMismatchConfirmPassword() {
		oranghrm.login("ADMIN" ,"admin123" );
        oranghrm.addEmployee();
        oranghrm.enableCreateLoginDetailsToggle();
        oranghrm.addEmployeeFields("Mariam", "Mariam");
        oranghrm.fillCreateLoginDetailsForm("fadii", "1234fadi", "4321Fadi");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        try {
        	Thread.sleep(2000);
        } catch (InterruptedException e) {
        	e.printStackTrace();
        }
        
        WebElement passwordNotMatchMsg = null;
        	passwordNotMatchMsg = driver.findElement(By.xpath("//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']"));
        
        
        Assert.assertTrue(passwordNotMatchMsg.isDisplayed(), "Password mismatch error message should be displayed");
        System.out.println("Error message found: " + passwordNotMatchMsg.getText());
	}
	
	@Test (priority = 18)
	public void testUpdateContactDetailsValidData() {
		oranghrm.login("Admin", "admin123");
		oranghrm.goToMyInfo();
		oranghrm.updateContactDetails("test@example.com", "1234567890", "0987654321");
		oranghrm.saveContactDetails();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		Assert.assertEquals(oranghrm.getWorkEmail(), "test@example.com");
		Assert.assertEquals(oranghrm.getHomeTelephone(), "1234567890");
		Assert.assertEquals(oranghrm.getMobile(), "0987654321");
	}

	@Test (priority = 19)
	public void testUpdateContactDetailsInvalidEmail() {
		oranghrm.login("Admin", "admin123");
		oranghrm.goToMyInfo();
		oranghrm.updateContactDetails("invalid-email", "", "");
		oranghrm.saveContactDetails();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		WebElement errorMessage = driver.findElement(By.xpath("//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']"));
		Assert.assertTrue(errorMessage.isDisplayed());
	}

	@Test (priority = 20)
	public void testUpdateContactDetailsPhoneNumberWithLetters() {
		oranghrm.login("Admin", "admin123");
		oranghrm.goToMyInfo();
		oranghrm.updateContactDetails("", "abcdefgh", "");
		oranghrm.saveContactDetails();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		WebElement errorMessage = driver.findElement(By.xpath("//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']"));
		Assert.assertTrue(errorMessage.isDisplayed());
	}

	@Test (priority = 21)
	public void testUpdateContactDetailsShortPhoneNumber() {
		oranghrm.login("Admin", "admin123");
		oranghrm.goToMyInfo();
		oranghrm.updateContactDetails("", "123", "");
		oranghrm.saveContactDetails();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		WebElement errorMessage = driver.findElement(By.xpath("//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']"));
		Assert.assertTrue(errorMessage.isDisplayed());
	}

	@Test (priority = 22)
	public void testUpdateMultipleContactFields() {
		oranghrm.login("Admin", "admin123");
		oranghrm.goToMyInfo();
		oranghrm.updateContactDetails("multiple@example.com", "1122334455", "5544332211");
		oranghrm.saveContactDetails();
		driver.navigate().refresh();
		oranghrm.goToMyInfo();
		Assert.assertEquals(oranghrm.getWorkEmail(), "multiple@example.com");
		Assert.assertEquals(oranghrm.getHomeTelephone(), "1122334455");
		Assert.assertEquals(oranghrm.getMobile(), "5544332211");
	}

	@Test (priority = 23)
	public void testCancelContactDetailsUpdate() {
		oranghrm.login("Admin", "admin123");
		oranghrm.goToMyInfo();
		String originalEmail = oranghrm.getWorkEmail();
		oranghrm.updateContactDetails("shouldnotbesaved@example.com", "", "");
		oranghrm.cancelContactDetails();
		driver.navigate().refresh();
		oranghrm.goToMyInfo();
		Assert.assertEquals(oranghrm.getWorkEmail(), originalEmail);
	}
	
	@AfterMethod
    public void logoutsession() {
    	try {
    		WebElement dashboard = driver.findElement(By.xpath("//h6[contains(@class,'oxd-topbar-header-breadcrumb')]"));
    		if(dashboard.isDisplayed()) {
    			oranghrm.logout();
    		}
    	}
    	catch(Exception e) {
    		System.out.println("Not logged in, no need to logout.");
    	}
    }
    
	@AfterTest
    public void teardown() {
        driver.quit();
    }
}

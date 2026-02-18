package AutomationPRJ.OrangHRM;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrangHRM {
	
	WebDriver driver;
	WebDriverWait wait ;

	public OrangHRM(WebDriver driver) {
		super();
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	By username = By.name("username");
	By password = By.name("password");
	By loginButton = By.xpath("//button[@type='submit']");
	By arrow = By.xpath("//span[@class='oxd-userdropdown-tab']");
	By logoutButton = By.xpath("//a[text()='Logout']");
	By pim = By.xpath("//span[text()='PIM']");
	By addEmploy = By.xpath("//a[text()='Add Employee']");
	By firstName = By.name("firstName");
	By lastName = By.name("lastName");
	By cancelButton = By.xpath("//button[text()=' Cancel ']");
	By createLoginToggleOff = By.xpath("//span[@class='oxd-switch-input oxd-switch-input--active --label-right']");	
	By userNameAddEmployee = By.xpath("//label[text()='Username']/parent::div/following-sibling::div/input");
	By statusEnableRadio = By.xpath("//label[text()='Enabled']");
	By passwordAddEmployee = By.xpath("(//input[@type='password'])[1]");
	By confirmPassworAddEmployee = By.xpath("(//input[@type='password'])[2]");
	By saveButtonAddEmployee = By.xpath("//button[@type='submit']");
	By myInfo = By.xpath("//span[text()='My Info']");
	By contactDetailsLink = By.xpath("//a[text()='Contact Details']");
	By workEmail = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[3]/div/div[1]/div/div[2]/input");
	By homeTelephone = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[2]/div/div[1]/div/div[2]/input");
	By mobile = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[2]/div/div[2]/div/div[2]/input");
	By contactDetailsSaveButton = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[4]/button");
	By contactDetailsCancelButton = By.xpath("//button[contains(text(),'Cancel')]");

	public void fillCreateLoginDetailsForm(String uName, String pass,String confPass) {
		// Fill username
		wait.until(ExpectedConditions.elementToBeClickable(userNameAddEmployee)).clear();
		driver.findElement(userNameAddEmployee).sendKeys(uName);
		
		// Click Enabled status
		wait.until(ExpectedConditions.elementToBeClickable(statusEnableRadio)).click();
		
		// Wait for password fields to be visible and interactable
		wait.until(ExpectedConditions.visibilityOfElementLocated(passwordAddEmployee));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		
		// Fill password
		wait.until(ExpectedConditions.elementToBeClickable(passwordAddEmployee)).clear();
		driver.findElement(passwordAddEmployee).sendKeys(pass);
		
		// Fill confirm password
		wait.until(ExpectedConditions.elementToBeClickable(confirmPassworAddEmployee)).clear();
		driver.findElement(confirmPassworAddEmployee).sendKeys(confPass);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	}
	public void ClickSaveButtonAddEmployee() {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		driver.findElement(saveButtonAddEmployee).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
	}
	public void enableCreateLoginDetailsToggle() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));	
		driver.findElement(createLoginToggleOff).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));	
	}
	public void cancelPIMButton() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));	
		driver.findElement(cancelButton).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));			
	}
	public void addEmployee() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));	
		driver.findElement(pim).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));	
		driver.findElement(addEmploy).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));	
	}
	public void addEmployeeFields(String fName,String lName) {
		
		driver.findElement(firstName).clear();
		driver.findElement(firstName).sendKeys(fName);
		driver.findElement(lastName).clear();
		driver.findElement(lastName).sendKeys(lName);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));	
	}
	public void login(String uName, String pass) {
		// TODO Auto-generated method stub
		driver.manage().window().maximize(); 

		driver.findElement(username).sendKeys(uName);
		wait.until(ExpectedConditions.textToBePresentInElementValue(username, uName));
		driver.findElement(password).sendKeys(pass);
		wait.until(ExpectedConditions.textToBePresentInElementValue(password, pass));
		 driver.findElement(loginButton).click();
		
	}



	public void logout() {
		// TODO Auto-generated method stub
		driver.findElement(arrow).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));	
		driver.findElement(logoutButton).click();

	}
	public void goToMyInfo() {
		wait.until(ExpectedConditions.elementToBeClickable(myInfo)).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(contactDetailsLink)).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[text()='Contact Details']")));
		// Wait for the form to be fully loaded - wait for all input fields
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//input[@class='oxd-input oxd-input--active']")));
	}

	public void updateContactDetails(String email, String telephone, String mobileNumber) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		org.openqa.selenium.JavascriptExecutor js = (org.openqa.selenium.JavascriptExecutor) driver;
		
		if (!email.isEmpty()) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(workEmail));
			org.openqa.selenium.WebElement emailField = driver.findElement(workEmail);
			// Force clear and fill using JavaScript
			js.executeScript("arguments[0].value='';", emailField);
			try { Thread.sleep(300); } catch (InterruptedException e) {}
			js.executeScript("arguments[0].value=arguments[1];", emailField, email);
			try { Thread.sleep(300); } catch (InterruptedException e) {}
		}
		
		if (!telephone.isEmpty()) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(homeTelephone));
			org.openqa.selenium.WebElement telField = driver.findElement(homeTelephone);
			// Force clear and fill using JavaScript
			js.executeScript("arguments[0].value='';", telField);
			try { Thread.sleep(300); } catch (InterruptedException e) {}
			js.executeScript("arguments[0].value=arguments[1];", telField, telephone);
			try { Thread.sleep(300); } catch (InterruptedException e) {}
		}

		if (!mobileNumber.isEmpty()) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(mobile));
			org.openqa.selenium.WebElement mobField = driver.findElement(mobile);
			// Force clear and fill using JavaScript
			js.executeScript("arguments[0].value='';", mobField);
			try { Thread.sleep(300); } catch (InterruptedException e) {}
			js.executeScript("arguments[0].value=arguments[1];", mobField, mobileNumber);
			try { Thread.sleep(300); } catch (InterruptedException e) {}
		}
	}
	
	public void saveContactDetails() {
		wait.until(ExpectedConditions.elementToBeClickable(contactDetailsSaveButton)).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		// Wait for save to complete
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void cancelContactDetails() {
		wait.until(ExpectedConditions.elementToBeClickable(contactDetailsCancelButton)).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	}

	public String getWorkEmail() {
		return driver.findElement(workEmail).getAttribute("value");
	}

	public String getHomeTelephone() {
		return driver.findElement(homeTelephone).getAttribute("value");
	}

	public String getMobile() {
		return driver.findElement(mobile).getAttribute("value");
	}

}

package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountSettingUpdatePage extends BasePage {
	
	
	     // Constructor
         public AccountSettingUpdatePage(WebDriver driver)
         {
         super(driver);
         }
	

	    // Locators for Profile Page
         
	    By profileImage = By.xpath("//div[@class='profile_user_section']//img");
	    By editButton = By.xpath("//button[@class='edit_button']");
	    By nameField = By.xpath("//body/div[@id='root']/div[@class='root-app']/div[@class='desk-version']/div[@class='parent_component']/div[@class='display_routes']/div[@class='main_grid']/div[@class='two_divs']/div[@class='div_two']/div[contains(@class,'container')]/div[@class='part2']/div[@class='Personal_details_container']/div[@class='main_container']/div[@class='form_container']/div[1]/input");
	    By phoneField = By.xpath("//div[@class='input_label']//div[@class='phone__number__container success']/input");
	    By saveButton = By.xpath("//span[@class='save_button_text']");
	    By homeButton = By.xpath("//span[normalize-space()='Home']");
	    By userNameDisplay = By.xpath("//p[@class='profile_user_name Lg-heading-02-semibold prussian-80']");

	    

	    // Actions

	    // Click on profile image to open profile
	    public void openProfile() {
	    	WebElement profileImg=driver.findElement(profileImage);
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].click();", profileImg);
	    }

	    // Click on the Edit button
	    public void clickEditButton() {
	    	driver.findElement(editButton).click();
	    }

	    // Enter a new name in the name field
	    public void enterName(String name) {
	    	WebElement nameElement=driver.findElement(nameField);
	    	nameElement.clear();
	    	nameElement.sendKeys(name);
	    }

	    // Enter a new phone number in the phone field
	    public void enterPhone(String phone) {
	    
	    	WebElement phoneElement = driver.findElement(phoneField);
	        phoneElement.clear();  // Clear the previous phone number
	        phoneElement.sendKeys(phone); 
	    }

	    // Click on the Save button
	    public void saveProfile() {
	    	driver.findElement(saveButton).click();
	    }

	    // Navigate back to Home page
	    public void goToHome() {
	    	driver.findElement(homeButton).click();
	    }

	    // Verify if the user profile name is displayed
	    public boolean isUserNameDisplayed() {
	    	boolean status=driver.findElement(userNameDisplay).isDisplayed();
	        return status;
	    }


}

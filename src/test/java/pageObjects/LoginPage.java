package pageObjects;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage{
	
	//constructor..
	
	public LoginPage(WebDriver driver) {
        super(driver);
    }
	


	// Locators
     By emailInputField = By.xpath("//div[@class='login__email']/input");
     By submitButton = By.xpath("//button[@id='t2']");

    

    public void enterEmail(String email) {
        WebElement emailField = driver.findElement(emailInputField);
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void clickSubmit() {
        driver.findElement(submitButton).click();
    }
}

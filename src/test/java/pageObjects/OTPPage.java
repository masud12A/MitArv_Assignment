package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OTPPage extends BasePage{

    
	public OTPPage(WebDriver driver) 
	{
        super(driver);
    }

    // Locators
	
    By otpInputField = By.xpath("//div[@class='I17__otp__box']//input");
    By submitButton = By.xpath("//button[@id='t2']");


    public void enterOTP(String otp) {
        WebElement otpField = driver.findElement(otpInputField);
        otpField.sendKeys(otp);
    }

    public void clickSubmit() {
        driver.findElement(submitButton).click();
    }
}

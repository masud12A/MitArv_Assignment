package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class ProfilePage extends BasePage{
	
	public ProfilePage(WebDriver driver)
	{
        super(driver);
    }


    // Locators
     By nameInputField = By.xpath("//input[@placeholder='Jane Doe']");
     By countryDropdown = By.xpath("//div[@class='DD15__Container']//img");
     By countryOptions = By.xpath("//div[@class='country-list']//p[1]");
     By phoneNumberField = By.xpath("//div[@class='phone__number__container success']/input");
     By saveButton = By.xpath("//button[@id='t2']");
     By lgButton = By.xpath("//div[@class='Lg-body-02-semibold forge_btn']");
     By closeButton = By.xpath("//img[@class='cross_icon']");

    

    public void enterName(String name) {
        WebElement nameField = driver.findElement(nameInputField);
        nameField.sendKeys(name);
    }

    public void selectCountry(String country) {
        driver.findElement(countryDropdown).click();
        List<WebElement> options = driver.findElements(countryOptions);
        for (WebElement option : options) {
            if (option.getText().equalsIgnoreCase(country)) {
                option.click();
                break;
            }
        }
    }

    public void enterPhoneNumber(String phoneNumber) {
        WebElement phoneField = driver.findElement(phoneNumberField);
        phoneField.clear();
        phoneField.sendKeys(phoneNumber);
    }

    public void saveProfile() {
        driver.findElement(saveButton).click();
    }
    
    public void clickLGButton() {
        driver.findElement(lgButton).click();
    }

    public void closeProfile() {
        driver.findElement(closeButton).click();
    }
}

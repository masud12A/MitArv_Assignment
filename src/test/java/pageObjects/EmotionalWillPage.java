package pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class EmotionalWillPage extends BasePage {

	// Constructor
    public EmotionalWillPage(WebDriver driver)
    {
        super(driver);
    }
	
    // Locators
     By emotionalWillLink = By.xpath("//p[normalize-space()='Emotional Will']");
     By newTextWillLink = By.xpath("//p[normalize-space()='New Text Will']");
     By addMoreButton = By.xpath("//div[@class='addmore_button']");
     By addConnectionChip = By.xpath("//div[@class='add_connection_chip']/p");
     By nameField = By.xpath("//input[@placeholder='John Doe']");
     By emailField = By.xpath("//input[@placeholder='jane-doe@example.com']");
     By nextButton = By.xpath("//button[normalize-space()='Next']");
     By phoneField = By.xpath("//input[@placeholder='0000000000']");
     By countryDropdown = By.xpath("//div[@class='DD15__Container']//img");
     By countryOptions = By.xpath("//div[@class='country-list']//p[1]");
     By otherOptionDropdown = By.xpath("//body/div[@role='presentation']/div[@role='presentation']/div[@role='dialog']/div[@class='pu-add-new-contact']/div[@class='add_new_contact_container side_height_responsive']/div[@class='add_new_contact']/div[@class='new_contact_dropdown']/div[@class='dropdown_container']/div[@class='dropdown__wrapper']/div[@class='dropdown_text']/img[1]");
     By otherOption = By.xpath("//div[@class='dropdown']//p");
     By specifyField = By.xpath("//input[@placeholder='Specify']");
     By chkbox=By.xpath("//div[@class='add_new_contact']//div[1]//div[1]//span[1]//input[1]");
     By doneButton = By.xpath("//button[normalize-space()='Done']");
     By button = By.xpath("//button[@id='t2']");
     By subjectField = By.xpath("//input[@class='subject_input_field']");
     By preserveMemoriesField = By.xpath("//div[@data-placeholder='Preserve memories, pen wisdom, leave a written legacy that lasts forever']");
     By ewBtn = By.xpath("//div[@class='ew-btn']");
     By understandButton = By.xpath("//div[normalize-space()='I understand']");
     By saveButton = By.xpath("//button[normalize-space()='Save Emotional Will']");
     By statusElement = By.xpath("//p[@class='t173']");
     By status2Element = By.xpath("//div[@class='ew__card__left']");

    

    // Actions
    public  void navigateToEmotionalWill() {
    	driver.findElement(emotionalWillLink).click();
    }
    

    public void selectNewTextWill() {
    	driver.findElement(newTextWillLink).click();
    }

    public void addMoreConnection() {
    	driver.findElement(addMoreButton).click();
    	driver.findElement(addConnectionChip).click();
    }

    public void enterName(String name) {
    	driver.findElement(nameField).sendKeys(name);
    }

    public void enterEmail(String email) {
    	driver.findElement(emailField).sendKeys(email);
    }

    public void clickNext() {
    	driver.findElement(nextButton).click();
    }

    public void enterPhone(String phone) {
    	driver.findElement(phoneField).sendKeys(phone);
    }

    public void selectCountry(String countryName) {
    	driver.findElement(countryDropdown).click();
        List<WebElement> options = driver.findElements(countryOptions);
        for (WebElement option : options) {
            if (option.getText().equals(countryName)) {
                option.click();
                break;
            }
        }
    }

    public void selectOtherOption() {
    	driver.findElement(otherOptionDropdown).click();
        List<WebElement> lists = driver.findElements(otherOption);
        for (WebElement list : lists) {
            if (list.getText().equals("Other")) {
                list.click();
                break;
            }
        }
    }

    public void enterSpecify(String text) {
    	driver.findElement(specifyField).sendKeys(text);
    }

    public void clickchkBox() {
    	driver.findElement(chkbox).click();
    }
    
    public void clickDone() {
    	driver.findElement(doneButton).click();
    }
    
    public void clickButton() {
    	driver.findElement(button).click();
    }

    public void enterSubject(String subject) {
    	driver.findElement(subjectField).sendKeys(subject);
    }

    public void enterPreserveMemories(String memories) {
    	driver.findElement(preserveMemoriesField).sendKeys(memories);
    }

    public void clickEwBtn() {
    	driver.findElement(ewBtn).click();
    }

    public void clickUnderstand() {
    	driver.findElement(understandButton).click();
    }

    public void saveEmotionalWill() {
    	driver.findElement(saveButton).click();
    }

    public boolean isEmotionalWillSaved() {
        
       boolean status=driver.findElement(statusElement).isDisplayed();
       return status;
    }

    public boolean isCardDisplayed() {
    	 boolean status2=driver.findElement(status2Element).isDisplayed();
    	 return status2;
    }
}

package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mailosaur.MailosaurException;

import pageObjects.LoginPage;
import pageObjects.EmotionalWillPage;
import pageObjects.OTPPage;
import pageObjects.ProfilePage;
import testBase.BaseClass;
import utilities.EmailUtils;

public class TC_002_EmotionalWillPage extends BaseClass{
	
	@Test
	public void testEmotionalWill() throws MailosaurException, IOException, InterruptedException
	{
        String email = EmailUtils.getRandomEmail();
        
        // Login Page Interaction
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail(email);
        loginPage.clickSubmit();

        // Fetch OTP from Email
        String otp = EmailUtils.fetchOTP(email);
        
        // OTP Page Interaction
        OTPPage otpPage = new OTPPage(driver);
        otpPage.enterOTP(otp);
        otpPage.clickSubmit();

        // Profile Page Interaction
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.enterName(randomeString());
        profilePage.selectCountry("India");
        profilePage.enterPhoneNumber(randomeNumber());
        profilePage.saveProfile();
        profilePage.clickLGButton();

        // Close the profile
        profilePage.closeProfile();
        
        Assert.assertEquals(driver.getTitle(), "Mitt Arv | Post Login");
        Thread.sleep(3000);
        driver.navigate().refresh();
        
        EmotionalWillPage emotionalWillPage = new EmotionalWillPage(driver);
        emotionalWillPage.navigateToEmotionalWill();
        emotionalWillPage.selectNewTextWill();
        emotionalWillPage.addMoreConnection();
        emotionalWillPage.enterName(randomeString());
        emotionalWillPage.enterEmail(randomeString()+"@gmail.com");
        emotionalWillPage.clickNext();
        emotionalWillPage.enterPhone(randomeNumber());
        emotionalWillPage.selectCountry("India");
        emotionalWillPage.selectOtherOption();
        emotionalWillPage.enterSpecify(randomeString());
        emotionalWillPage.clickchkBox();
        emotionalWillPage.clickDone();
        emotionalWillPage.clickButton();
        emotionalWillPage.enterSubject(randomeString());
        emotionalWillPage.enterPreserveMemories(randomeString());
        emotionalWillPage.clickEwBtn();
        emotionalWillPage.clickUnderstand();
        Thread.sleep(2000); 
        emotionalWillPage.saveEmotionalWill();

        Assert.assertTrue(emotionalWillPage.isEmotionalWillSaved(), "Emotional Will not saved successfully");
        emotionalWillPage.clickDone();

        Assert.assertTrue(emotionalWillPage.isCardDisplayed(), "Card not displayed correctly");
        
	}

}

package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mailosaur.MailosaurException;

import pageObjects.LoginPage;
import pageObjects.AccountSettingUpdatePage;
import pageObjects.OTPPage;
import pageObjects.ProfilePage;
import testBase.BaseClass;
import utilities.EmailUtils;

public class TC_003_AccountSettingUpdate extends BaseClass{
	
	@Test
	public void test_accountsettingUpdate() throws MailosaurException, IOException, InterruptedException
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
	    //driver.navigate().refresh();
	    
	    
	    AccountSettingUpdatePage accountupdate=new AccountSettingUpdatePage(driver);
        
        
        // Open profile
	    accountupdate.openProfile();

        // Click on the Edit button
	    accountupdate.clickEditButton();

        // Enter new name
	    accountupdate.enterName(randomeString());

        // Enter new phone number
	    accountupdate.enterPhone(randomeNumber());

        // Save profile
	    accountupdate.saveProfile();

        // Navigate back to Home
	    accountupdate.goToHome();

        // Verify that the user name is displayed correctly after saving
        Assert.assertTrue(accountupdate.isUserNameDisplayed(), "User name is not displayed correctly on the Home page");
    }
	

}

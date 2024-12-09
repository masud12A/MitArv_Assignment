package testCases;


import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;
import com.mailosaur.MailosaurException;

import utilities.EmailUtils;
import pageObjects.LoginPage;
import pageObjects.OTPPage;
import pageObjects.ProfilePage;
import testBase.BaseClass;

public class TC_001_LoginTest extends BaseClass{

    @Test
    public void testLogin() throws IOException, MailosaurException, InterruptedException {
    	
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
        
        
        

    }
}

package hyphenweb.pages;

import hyphenweb.base.BasePage;
import org.openqa.selenium.By;

public class SignInPage extends BasePage {
    private By emailTextBoxBy = By.id("inputGroupField");
    private By sendVerificationCodeButtonBy = By.xpath("//span[contains(text(),'Send me a verification code')]");

    public void enterEmailId(String email) {
        driver.findElement(emailTextBoxBy).sendKeys(email);
    }

    public ConfirmPage clickSendMeVerificationCode() {
        driver.findElement(sendVerificationCodeButtonBy).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new ConfirmPage();
    }
}

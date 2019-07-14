package hyphenweb.pages;

import hyphenweb.base.BasePage;
import org.openqa.selenium.By;

public class ConfirmPage extends BasePage {
    private By verificationCodeTextBoxBy = By.id("inputGroupField");
    private By loginButtonBy = By.xpath("//button[text()='Log In']");

    public void enterVerificationCode(String code) {
        driver.findElement(verificationCodeTextBoxBy).sendKeys(code);
    }

    public HomePage clickLogin() {
        driver.findElement(loginButtonBy).click();
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new HomePage();
    }
}

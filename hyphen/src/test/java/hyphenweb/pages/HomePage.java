package hyphenweb.pages;

import hyphenweb.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class HomePage extends BasePage {
    private By createNewPostButtonBy = By.id("create-button");
    private By openButtonBy = By.xpath("//button[text()='OPEN']");
    private By selectGroupDropDownBy = By.xpath("//input[@role='combobox']");
    private By selectButtonBy = By.xpath("//button[@type='submit']");
    private By postTextBoxBy = By.id("textAreaField");
    private By publishPostButtonBy = By.xpath("//button[text()='Publish post']");
    private By latestPostBy = By.xpath("//span[contains(@class,'questionText')][1]/span");

    public boolean isCreateNewPostButtonDisplayed() {
        return driver.findElement(createNewPostButtonBy).isDisplayed();
    }

    public void clickCreateNewPostButton() {
        driver.findElement(createNewPostButtonBy).click();
    }

    public void clickOpenButton() {
        driver.findElement(openButtonBy).click();
    }

    public void clickSelectButton() {
        driver.findElement(selectButtonBy).click();
    }

    public void enterTextInPost(String text) {
        driver.findElement(postTextBoxBy).sendKeys(text);
    }

    public void clickPublishPostButton() {
        driver.findElement(publishPostButtonBy).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getLatestPost() {
        return driver.findElement(latestPostBy).getText();
    }

    public void selectAskHrAnything() {
        driver.findElement(selectGroupDropDownBy).sendKeys("");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(selectGroupDropDownBy).sendKeys("Ask");
        driver.findElement(selectGroupDropDownBy).sendKeys(Keys.ENTER);
    }
}

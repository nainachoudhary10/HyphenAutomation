package hyphenweb.base;

import hyphenweb.pages.ConfirmPage;
import hyphenweb.pages.HomePage;
import hyphenweb.pages.SignInPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    private String baseUrl = "https://app.gethyphen.com/signin";
    private String driverPath = "D:\\hyphen\\src\\test\\resources\\chromedriver.exe";
    WebDriver driver;

    //Pages
    protected static SignInPage signInPage;
    protected static HomePage homePage;
    protected static ConfirmPage confirmPage;

    public SignInPage navigateToLogin() {
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(baseUrl);
        driver.manage().window().maximize();
        BasePage.driver = driver;
        return new SignInPage();
    }

    protected void log(String step) {
        System.out.println(step);
    }

    public void closeBrowser() {
        driver.quit();
    }
}

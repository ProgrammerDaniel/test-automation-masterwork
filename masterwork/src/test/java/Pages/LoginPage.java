package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("http://test-automation-shop1.greenfox.academy/login?back=my-account");
    }

    @FindBy(name = "email")
    private WebElement email;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(id = "submit-login")
    private WebElement signInButton;

    @FindBy(xpath = "//*[@id=\"content\"]/section/div/ul/li")
    private WebElement loginErrorMessage;

    @FindBy(partialLinkText = "Sign out")
    private WebElement signOut;

    public void userSignIn(String email, String password) {
        this.email.sendKeys(email);
        this.password.sendKeys(password);
        this.signInButton.click();
    }

    public WebElement returnSignOut() {
        return signOut;
    }

    public WebElement returnLoginErrorMessage() {
        return loginErrorMessage;
    }
}
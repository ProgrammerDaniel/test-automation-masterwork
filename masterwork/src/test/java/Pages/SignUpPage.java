package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPage {
    WebDriver driver;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("http://test-automation-shop1.greenfox.academy/login?create_account=1");
    }

    @FindBy(xpath = "//*[@id='customer-form']/section/div[1]/div[1]/label[1]/span/input")
    private WebElement MrBox;

    @FindBy(xpath = "//*[@id='customer-form']/section/div[1]/div[1]/label[2]/span/input")
    private WebElement MrsBox;

    @FindBy(name = "firstname")
    private WebElement firstName;

    @FindBy(name = "lastname")
    private WebElement lastName;

    @FindBy(name = "email")
    private WebElement email;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(name = "birthday")
    private WebElement birthDate;

    @FindBy(name = "optin")
    private WebElement offersBox;

    @FindBy(name = "customer_privacy")
    private WebElement customerDataPrivacyBox;

    @FindBy(name = "newsletter")
    private WebElement newsletterBox;

    @FindBy(name = "psgdpr")
    private WebElement privacyPolicyBox;

    @FindBy(xpath = "//*[@id=\"customer-form\"]/footer/button")
    private WebElement submitButton;

    @FindBy(xpath = "//*[@id=\"customer-form\"]/section/div[4]/div[1]/div/ul/li")
    private WebElement emailErrorMessage;

    @FindBy (linkText = "terms and conditions and the privacy policy")
    private WebElement privacyStatementLink;

    public void signUp(String prefix, String firstName, String lastName, String email,
                       String password, String birthDate, boolean offers,
                       boolean customerDataPrivacy, boolean newsletter, boolean privacyPolicy) throws InterruptedException {
        if (prefix.equals("Mrs")) {
            this.MrsBox.click();
        } else {
            this.MrBox.click();
        }
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.email.sendKeys(email);
        this.password.sendKeys(password);
        this.birthDate.sendKeys(birthDate);
        this.offersBox.click();
        this.customerDataPrivacyBox.click();
        this.newsletterBox.click();
        this.privacyPolicyBox.click();
        this.submitButton.click();

    }

    public WebElement getPrivacyStatementLink() {
        return privacyStatementLink;
    }
    public WebElement getPrivacyPolicyBox() {
        return privacyPolicyBox;
    }

    public WebElement getEmailErrorMessage() {
        return emailErrorMessage;
    }
}
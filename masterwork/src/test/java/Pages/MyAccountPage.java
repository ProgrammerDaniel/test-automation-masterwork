package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MyAccountPage {
    WebDriver driver;

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
    }
    @FindBy (xpath = "//a[@id='identity-link']/span/i")
            private WebElement informations;

    @FindBy (name = "birthday")
    private WebElement birthDateField;

    @FindBy (name = "customer_privacy")
    private WebElement CustomerDataBox;

    @FindBy (name = "psgdpr")
    private WebElement privacyStatementBox;

    @FindBy (name = "password")
    private WebElement password;

    @FindBy (xpath = "//form[@id='customer-form']/footer/button")
    private WebElement saveButton;

    @FindBy (name = "lastname")
    private WebElement lastnameField;

    @FindBy (partialLinkText = "Addresses")
    private WebElement addresses;

    @FindBy (className = "address-footer")
    private List<WebElement> addressList;

    @FindBy (partialLinkText = "Delete")
    private WebElement addressDeleteButton;


    public WebElement getInformations() {
        return informations;
    }

    public WebElement getBirthDateField() {
        return birthDateField;
    }

    public WebElement getCustomerDataBox() {
        return CustomerDataBox;
    }

    public WebElement getPrivacyStatementBox() {
        return privacyStatementBox;
    }

    public WebElement getPassword() {
        return password;
    }

    public WebElement getSaveButton() {
        return saveButton;
    }

    public WebElement getLastnameField() {
        return lastnameField;
    }

    public WebElement getAddresses() {
        return addresses;
    }

    public List<WebElement> getAddressList() {
        return addressList;
    }

    public WebElement getAddressDeleteButton() {
        return addressDeleteButton;
    }
}
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
            private WebElement information;

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

    @FindBy (partialLinkText = "Create new address")
    private WebElement createAddressButton;

    @FindBy (name = "address1")
    private WebElement addressField;

    @FindBy (name = "city")
    private WebElement cityField;

    @FindBy (name = "id_state")
    private WebElement stateField;

    @FindBy (name = "postcode")
    private WebElement postcodeField;

    @FindBy (xpath = "//section[@id='content']/div/div/form/footer/button")
    private WebElement newAddressSave;


    public WebElement getInformation() {
        return information;
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

    public WebElement getCreateAddressButton() {
        return createAddressButton;
    }

    public WebElement getAddressField() {
        return addressField;
    }

    public WebElement getCityField() {
        return cityField;
    }

    public WebElement getStateField() {
        return stateField;
    }

    public WebElement getPostcodeField() {
        return postcodeField;
    }

    public WebElement getNewAddressSave() {
        return newAddressSave;
    }
}
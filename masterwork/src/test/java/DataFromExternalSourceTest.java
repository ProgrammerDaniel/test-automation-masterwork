import Pages.HomePage;
import Pages.LoginPage;
import Pages.MyAccountPage;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

@DisplayName("Data Input From External Source test")
public class DataFromExternalSourceTest extends BaseTest {

    @ParameterizedTest
    @Tag("TC_09")
    @CsvFileSource(resources = "/address.csv", numLinesToSkip = 1)
    @Description ("Creating a new address with repetitive data entry from external source")
    @Feature("Address management")
    public void createAddress(String address, String city, String zip, String state) {
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.open();
        homePage.getSignInButton().click();
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.userSignIn("registereduser@testmail.com", "registered123123");
        MyAccountPage myAccountPage = PageFactory.initElements(driver, MyAccountPage.class);
        myAccountPage.getAddresses().click();
        int originalNumberOfAddresses = myAccountPage.getAddressList().size();
        myAccountPage.getCreateAddressButton().click();
        myAccountPage.getAddressField().click();
        myAccountPage.getAddressField().sendKeys(address);
        myAccountPage.getCityField().click();
        myAccountPage.getCityField().sendKeys(city);
        myAccountPage.getPostcodeField().click();
        myAccountPage.getPostcodeField().sendKeys(zip);
        myAccountPage.getStateField().click();
        new Select(myAccountPage.getStateField()).selectByVisibleText(state);
        myAccountPage.getNewAddressSave().click();
        Assertions.assertThat(myAccountPage.getAddressList().size()).isEqualTo(originalNumberOfAddresses + 1);
    }
}

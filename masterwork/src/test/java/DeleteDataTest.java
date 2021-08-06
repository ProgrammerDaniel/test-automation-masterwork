import Pages.HomePage;
import Pages.LoginPage;
import Pages.MyAccountPage;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;

@DisplayName("Delete Data Test")
public class DeleteDataTest extends BaseTest {

    @Test
    @Tag("TC_11")
    @Description ("Deleting the first address from the addresses of the user")
    @Feature("Address management")
    public void deleteAddress() {
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.open();
        homePage.getSignInButton().click();
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.userSignIn("registereduser@testmail.com", "registered123123");
        MyAccountPage myAccountPage = PageFactory.initElements(driver, MyAccountPage.class);
        myAccountPage.getAddresses().click();
        int originalNumberOfAddresses = myAccountPage.getAddressList().size();
        myAccountPage.getAddressDeleteButton().click();
        Assertions.assertThat(myAccountPage.getAddressList().size()).isEqualTo(originalNumberOfAddresses - 1);
    }
}

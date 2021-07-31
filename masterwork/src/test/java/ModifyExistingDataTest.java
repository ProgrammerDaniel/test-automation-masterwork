import Pages.HomePage;
import Pages.LoginPage;
import Pages.MyAccountPage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;

public class ModifyExistingDataTest extends BaseTest {
    @Test
    @DisplayName("Add character E to the last name")
    public void modifyLastname() {
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.open();
        homePage.getSignInButton().click();
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.userSignIn("registereduser@testmail.com", "registered123123");
        MyAccountPage myAccountPage = PageFactory.initElements(driver, MyAccountPage.class);
        myAccountPage.getInformations().click();
        String originalLastname = myAccountPage.getLastnameField().getAttribute("Value");
        myAccountPage.getLastnameField().click();
        myAccountPage.getLastnameField().sendKeys("E");
        myAccountPage.getPassword().click();
        myAccountPage.getPassword().sendKeys("registered123123");
        myAccountPage.getCustomerDataBox().click();
        myAccountPage.getPrivacyStatementBox().click();
        myAccountPage.getSaveButton().click();
        Assertions.assertThat(myAccountPage.getLastnameField().getAttribute("Value")).isEqualTo(originalLastname + "E");
    }
}

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

@DisplayName("Modify Data Test")
public class ModifyExistingDataTest extends BaseTest {

    @Test
    @Tag("TC_10")
    @Description("Add character E to the last name")
    @Feature("Personal information management")
    public void modifyLastname() {
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.open();
        homePage.getSignInButton().click();
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.userSignIn("registereduser@testmail.com", "registered123123");
        MyAccountPage myAccountPage = PageFactory.initElements(driver, MyAccountPage.class);
        myAccountPage.getInformation().click();
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

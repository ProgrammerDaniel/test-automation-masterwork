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

@DisplayName("Data Input Test")
public class DataInputTest extends BaseTest {

    @Test
    @Tag("TC_08")
    @Description("Add birthdate to the personal information")
    @Feature("Personal information management")
    public void addBirthdate() {
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.open();
        homePage.getSignInButton().click();
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.userSignIn("registereduser@testmail.com", "registered123123");
        MyAccountPage myAccountPage = PageFactory.initElements(driver, MyAccountPage.class);
        myAccountPage.getInformation().click();
        myAccountPage.getBirthDateField().click();
        String birthDateToInput = "06/15/1990";
        myAccountPage.getBirthDateField().sendKeys(birthDateToInput);
        myAccountPage.getPassword().click();
        myAccountPage.getPassword().sendKeys("registered123123");
        myAccountPage.getCustomerDataBox().click();
        myAccountPage.getPrivacyStatementBox().click();
        myAccountPage.getSaveButton().click();
        Assertions.assertThat(myAccountPage.getBirthDateField().getAttribute("Value")).isEqualTo(birthDateToInput);
    }
}

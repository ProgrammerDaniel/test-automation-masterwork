import Pages.HomePage;
import Pages.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;

@DisplayName("Logout Test")
public class LogoutTest extends BaseTest{

    @Test
    @Tag("TC_13")
    @Description("Logout successfully after a successful login")
    @Feature("Logout")
    public void successfulLogin() {
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.open();
        homePage.getSignInButton().click();
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.userSignIn("registereduser@testmail.com", "registered123123");
        loginPage.returnSignOut().click();
        Assertions.assertThat(driver.getTitle()).isEqualTo("Login");
    }
}

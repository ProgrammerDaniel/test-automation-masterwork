import Pages.HomePage;
import Pages.LoginPage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;

public class LogoutTest extends BaseTest{
    @Test
    @DisplayName("Logout successfully after a successful login")
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

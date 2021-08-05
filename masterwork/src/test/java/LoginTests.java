import Pages.HomePage;
import Pages.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;

@DisplayName("Login Tests")
public class LoginTests extends BaseTest {

    @Test
    @Tag("TC_03")
    @Description("Unsuccessful login because the user does not exist")
    @Feature("Login")
    public void unSuccessfulLogin() {
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.open();
        homePage.getSignInButton().click();
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.userSignIn("notregistereduser@testmail.com", "Notregistered123");
        Assertions.assertThat(loginPage.returnLoginErrorMessage().getText())
                .isEqualTo("Authentication failed.");
    }

    @Test
    @Tag("TC_04")
    @Description("Log in successfully with existing user's data")
    @Feature("Login")
    public void successfulLogin() {
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.open();
        homePage.getSignInButton().click();
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.userSignIn("registereduser@testmail.com", "registered123123");
        Assertions.assertThat(driver.getTitle()).isEqualTo("My account");
    }
}

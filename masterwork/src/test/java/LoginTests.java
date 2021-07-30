import Pages.LoginPage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;

public class LoginTests extends BaseTest {

    @Test
    @DisplayName("Unsuccessful login because the user does not exist")
    public void unSuccessfulLogin() {
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.open();
        loginPage.userSignIn("notregistereduser@testmail.com", "Notregistered123");
        Assertions.assertThat(loginPage.returnLoginErrorMessage().getText())
                .isEqualTo("Authentication failed.");
    }

    @Test
    @DisplayName("Log in successfully with existing user's data")
    public void successfulLogin() {
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.open();
        loginPage.userSignIn("registereduser@testmail.com", "registered123123");
        Assertions.assertThat(driver.getTitle()).isEqualTo("My account");
    }
}

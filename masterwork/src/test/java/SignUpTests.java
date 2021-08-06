import Pages.HomePage;
import Pages.SignUpPage;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;

@DisplayName("Registration Tests")
public class SignUpTests extends BaseTest {

    @Test
    @Tag("TC_01")
    @Description("Successful registration of a new user")
    @Feature("Registration")
    public void successfulSignUp()
            throws InterruptedException {
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.open();
        homePage.getSignInButton().click();
        homePage.getCreateAccountButton().click();
        SignUpPage signUpPage = PageFactory.initElements(driver, SignUpPage.class);
        signUpPage.signUp("Mr", "John", "Smith",
                "testuser2223@testmail.com", "Testpassword123123",
                "06/15/1990", true, true, true, true);
        Assertions.assertThat(driver.getTitle()).isEqualTo("PrestaShop");
    }

    @Test
    @Tag("TC_02")
    @Description("Unsuccessful Registration because email is already in use")
    @Feature("Registration")
    public void unSuccessfulSignUp()
            throws InterruptedException {
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.open();
        homePage.getSignInButton().click();
        homePage.getCreateAccountButton().click();
        SignUpPage signUpPage = PageFactory.initElements(driver, SignUpPage.class);
        signUpPage.signUp("Mr", "John", "Smith",
                "registereduser@testmail.com", "registered123123",
                "06/15/1990", true, true, true, true);
        Assertions.assertThat(signUpPage.getEmailErrorMessage().getText())
                .isEqualTo("The email is already used, please choose another one or sign in");
    }
}

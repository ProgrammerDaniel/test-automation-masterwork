import Pages.HomePage;
import Pages.SignUpPage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class SignUpTests extends BaseTest {

    @Test
    @DisplayName("Successful registration of a new user")
    public void successfulSignUp()
            throws InterruptedException {
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.open();
        homePage.getSignInButton().click();
        homePage.getCreateAccountButton().click();
        SignUpPage signUpPage = PageFactory.initElements(driver, SignUpPage.class);
        signUpPage.signUp("Mr", "John", "Smith",
                "testuser176645@testmail.com", "Testpassword123123",
                "06/15/1990", true, true, true, true);
        Assertions.assertThat(driver.getTitle()).isEqualTo("PrestaShop");
    }

    @Test
    @DisplayName("Unsuccessful Registration because email is already in use")
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
        Assertions.assertThat(signUpPage.returnEmailErrorMessage().getText())
                .isEqualTo("The email is already used, please choose another one or sign in");

    }


}

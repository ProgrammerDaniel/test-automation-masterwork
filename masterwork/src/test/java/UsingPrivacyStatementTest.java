import Pages.HomePage;
import Pages.SignUpPage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

public class UsingPrivacyStatementTest extends BaseTest {
    @Test
    @DisplayName("Open the Privacy Statements and accept them in the checkbox")
    public void openAndCheckPrivacyStatement() {
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.open();
        homePage.getSignInButton().click();
        homePage.getCreateAccountButton().click();
        SignUpPage signUpPage = PageFactory.initElements(driver, SignUpPage.class);
        signUpPage.getPrivacyStatementLink().click();
        ArrayList<String> tabs = new ArrayList<> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
        signUpPage.getPrivacyPolicyBox().click();
        Assertions.assertThat(driver.getTitle()).isEqualTo("Login");
        Assertions.assertThat(tabs.size()).isEqualTo(2);
    }
}


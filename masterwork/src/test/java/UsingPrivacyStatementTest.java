import Pages.HomePage;
import Pages.SignUpPage;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

@DisplayName("Privacy Statement Test")
public class UsingPrivacyStatementTest extends BaseTest {
    @Test
    @Tag("TC_05")
    @Description("Open the Privacy Statement and then accept it in the checkbox")
    @Feature("Registration")
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


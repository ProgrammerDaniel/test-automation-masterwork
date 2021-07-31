import Pages.HomePage;
import Pages.LoginPage;
import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class PaginationTest extends BaseTest {

    @Test
    @DisplayName("Listing all the products and navigate to the second page of the list")
    public void navigateToSecondPageOfProductsFromHomePage() throws InterruptedException {
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.open();
        homePage.getListAll().click();
        String nameOfFirstItem = homePage.getFirstProduct().getText();
        homePage.getNextPage().click();
        Thread.sleep(800);
        String nameOfSecondItem = homePage.getFirstProduct().getText();
        Assertions.assertThat(nameOfFirstItem).isNotEqualTo(nameOfSecondItem);


    }
}

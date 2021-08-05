import Pages.HomePage;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@DisplayName("Pagination Test")
public class PaginationTest extends BaseTest {

    @Test
    @Tag("TC_07")
    @Description("Listing all the products and navigate to the second page of the list")
    @Feature("Listing products")
    public void navigateToSecondPageOfProductsFromHomePage() throws InterruptedException {
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.open();
        homePage.getListAll().click();
        String nameOfFirstItem = homePage.getFirstProduct().getText();
        homePage.getNextPage().click();
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.textToBe(homePage.getPageNumber(), "2"));
        String nameOfSecondItem = homePage.getFirstProduct().getText();
        Assertions.assertThat(nameOfFirstItem).isNotEqualTo(nameOfSecondItem);
    }
}

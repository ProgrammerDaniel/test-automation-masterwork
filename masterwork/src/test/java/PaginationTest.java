import Pages.HomePage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;


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

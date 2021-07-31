import Pages.HomePage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import java.util.Iterator;


public class ListingDataTest extends BaseTest {

    @Test
    @DisplayName("Listing all the products and make the order from cheapest to most expensive")
    public void ListingDataInLowToHighPriceOrder() throws InterruptedException {
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.open();
        homePage.getListAll().click();
        homePage.getDropdownForSortBy().click();
        homePage.getLowToHigh().click();
        Thread.sleep(1000);
        double firstProduct = Double.parseDouble(homePage.getPriceOfFirstProduct().getText().substring(1));
        System.out.println("original " + firstProduct);
        boolean firstIsTheSmallest = true;
        Iterator<WebElement> itr = homePage.getPricesOfProducts().iterator();
        while (itr.hasNext()) {
            double num = Double.parseDouble(itr.next().getText().substring(1));
            System.out.println("num input " + num);
            if (num < firstProduct) {
                firstIsTheSmallest = false;
                System.out.println("new smallest " + firstProduct);
                break;
            }
        }
        Assertions.assertThat(firstIsTheSmallest).isTrue();
    }
}

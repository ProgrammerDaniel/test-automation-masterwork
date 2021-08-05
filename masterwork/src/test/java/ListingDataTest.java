import Pages.HomePage;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.Iterator;

@DisplayName("Data Listing Test")
public class ListingDataTest extends BaseTest {

    @Test
    @Tag("TC_06")
    @Description("Listing all the products and make the order from cheapest to most expensive")
    @Feature("Listing products")
    public void ListingDataInLowToHighPriceOrder() throws InterruptedException {
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.open();
        homePage.getListAll().click();
        homePage.getDropdownForSortBy().click();
        homePage.getLowToHigh().click();
        System.out.println(homePage.getPriceOfFirstProduct().getText());
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.textToBe(homePage.getLowToHighBox(), homePage.getLowToHighExpectedText()));
        System.out.println(homePage.getPriceOfFirstProduct().getText());
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

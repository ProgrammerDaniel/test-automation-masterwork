package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("http://test-automation-shop1.greenfox.academy");
    }
    @FindBy (xpath = "//*[@id=\"content\"]/section/a")
    private WebElement listAll;

    @FindBy (xpath = "//*[@id=\"js-product-list\"]/nav/div[2]/ul/li[3]/a")
    private WebElement nextPage;

    public WebElement getListAll() {
        return listAll;
    }

    public WebElement getNextPage() {
        return nextPage;
    }
    @FindBy (xpath = "//*[@id=\"js-product-list\"]/div[1]/div[1]/article/div/div[1]/h2/a")
    private WebElement firstProduct;

    public WebElement getFirstProduct() {
        return firstProduct;
    }
}

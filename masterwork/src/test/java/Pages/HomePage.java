package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("http://test-automation-shop1.greenfox.academy");
    }
    @FindBy (xpath = "//div[@id='_desktop_user_info']/div/a/span")
    private WebElement signInButton;

    @FindBy (linkText = "No account? Create one here")
    private WebElement createAccountButton;

    public WebElement getSignInButton() {
        return signInButton;
    }

    public WebElement getCreateAccountButton() {
        return createAccountButton;
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

    @FindBy (xpath = "//div[@id='js-product-list-top']/div[2]/div/div/button")
    private WebElement dropdownForSortBy;

    public WebElement getDropdownForSortBy() {
        return dropdownForSortBy;
    }

    @FindBy (linkText = "Price, low to high")
    private WebElement lowToHigh;


    public WebElement getLowToHigh() {
        return lowToHigh;
    }

    @FindBy (xpath = "//span[@class='price']")
    private List<WebElement> pricesOfProducts;

    @FindBy (xpath = "//span[@class='price']")
    private WebElement priceOfFirstProduct;

    public WebElement getPriceOfFirstProduct() {
        return priceOfFirstProduct;
    }

    public List<WebElement> getPricesOfProducts() {
        return pricesOfProducts;
    }

    @FindBy (xpath = "//li[@id='category-3']/a")
    private WebElement clothes;

    public WebElement getClothes() {
        return clothes;
    }
    @FindBy (xpath = "//*[@class=\"h3 product-title\"]/a")
    private List<WebElement> items;

    public List<WebElement> getItems() {
        return items;
    }
}


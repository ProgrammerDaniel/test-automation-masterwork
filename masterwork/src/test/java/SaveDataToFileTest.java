import Pages.HomePage;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@DisplayName("Extract Data Test")
public class SaveDataToFileTest extends BaseTest {

    List<String> listOfClothes = new ArrayList<>();
    ArrayList<String> fileContent = null;

    @Test
    @Tag("TC_12")
    @Description("Write the name of the clothes to a txt file")
    @Feature("Listing Products")
    public void WriteProductNamesToFile() {

        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.open();
        homePage.getClothes().click();
        Iterator<WebElement> itr = homePage.getItems().iterator();
        while (itr.hasNext()) {
            listOfClothes.add(itr.next().getText());
        }
        writeFile();
        try {
            fileContent = new ArrayList<>(Files.readAllLines(Paths.get("src/test/resources/Testfile.txt")));
        } catch (IOException e) {
            System.out.println("File path error");
        }
        Assertions.assertThat(listOfClothes.equals(fileContent));
    }

    public void writeFile() {
        Path testFile = Paths.get("src/test/resources/Testfile.txt");
        try {
            Files.write(testFile, listOfClothes);
        } catch (IOException e) {
            System.out.println("Write error");
        }
    }
}

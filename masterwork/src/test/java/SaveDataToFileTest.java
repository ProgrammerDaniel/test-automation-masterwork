import Pages.HomePage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
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

public class SaveDataToFileTest extends BaseTest {
    List<String> listOfClothes = new ArrayList<>();
    ArrayList<String> fileContent = null;
    @Test
    @DisplayName("Write the name of the clothes to a txt file")
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

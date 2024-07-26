import Base.BaseTest;
import com.orange.enums.SideBarMenuEnum;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class SideBArMenuTest extends BaseTest {


    public static WebDriver loadChromeWebDriver() {
        WebDriverManager.chromedriver().setup();
        return driver;
    }

    @Test
    void sideBarMenuTest(){
        loginPage.doLogin();
        SideBarMenuEnum randomSideBarMenu = webElementActions.getRandomEnumValue(SideBarMenuEnum.class);
        sideBarMenuPage.chooseSideBarMenu(randomSideBarMenu);
    }
}

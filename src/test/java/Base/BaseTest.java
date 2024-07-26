package Base;

import com.orange.drivers.DriverManager;
import com.orange.helper.AlertHelper;
import com.orange.helper.BrowserHelper;
import com.orange.helper.IframeHelper;
import com.orange.helper.WebElementActions;
import com.orange.pages.LoginPage;
import com.orange.pages.SideBarMenuPage;
import com.orange.pages.admin.pages.TopBarMenuPage;
import com.orange.utils.RandomUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    protected static WebDriver driver;
    protected RandomUtils randomUtils;
    protected WebElementActions webElementActions;

    protected AlertHelper alertHelper;
    protected BrowserHelper browserHelper;
    protected IframeHelper iframeHelper;

    protected LoginPage loginPage;
    protected SideBarMenuPage sideBarMenuPage;
    protected TopBarMenuPage topBarMenuPage;

    @BeforeClass(alwaysRun = true)
    public void setUp(){
        driver = DriverManager.getDriver();
        randomUtils = new RandomUtils();
        webElementActions = new WebElementActions(driver);

        alertHelper = new AlertHelper(driver);
        browserHelper = new BrowserHelper(driver);
        iframeHelper = new IframeHelper(driver);

        loginPage = new LoginPage();
        sideBarMenuPage = new SideBarMenuPage(driver);
        topBarMenuPage = new TopBarMenuPage(driver,webElementActions);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown(){
        DriverManager.closeDriver();
    }
}
import Base.BaseTest;
import com.orange.enums.SideBarMenuEnum;
import com.orange.utils.ConfigReader;
import org.testng.annotations.Test;

public class SideBArMenuTest extends BaseTest {

    @Test
    void sideBarMenuTest(){
        loginPage.doLogin();
        SideBarMenuEnum randomSideBarMenu = webElementActions.getRandomEnumValue(SideBarMenuEnum.class);
        sideBarMenuPage.chooseSideBarMenu(randomSideBarMenu);
    }
}

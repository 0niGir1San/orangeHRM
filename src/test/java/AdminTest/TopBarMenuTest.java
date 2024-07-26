package AdminTest;

import Base.BaseTest;
import com.orange.enums.SideBarMenuEnum;
import com.orange.pages.admin.enums.TopBarMenuEnum;
import org.testng.annotations.Test;

public class TopBarMenuTest extends BaseTest {

    @Test
    void topBarMenuTest(){
        loginPage.doLogin();
        sideBarMenuPage.chooseSideBarMenu(SideBarMenuEnum.ADMIN);
        TopBarMenuEnum randomTopBarMenu = webElementActions.getRandomEnumValue(TopBarMenuEnum.class);
        topBarMenuPage.chooseAndClickMenu(randomTopBarMenu);
    }
}

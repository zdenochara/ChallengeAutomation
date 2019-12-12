package negTest;
import core.BaseTest;
import org.testng.annotations.Test;
import page.objects.*;


public class negTest extends BaseTest {
    HomePage homePage;
    LoginPage loginPage;
    RegistrationPage registrationPage;
    ItemPage itemPage;
    ShoppingCartPage shoppingCartPage;

    public negTest() {
        super();
        this.homePage = new HomePage(getDriver());
        this.loginPage = new LoginPage(getDriver());
        this.registrationPage = new RegistrationPage(getDriver());
        this.itemPage = new ItemPage(getDriver());
        this.shoppingCartPage = new ShoppingCartPage(getDriver());
    }

    @Test
    public void TC_6() {
        this.homePage.navigateToURL();
        this.homePage.signBTN();
        this.loginPage.loginUser();

    }

}
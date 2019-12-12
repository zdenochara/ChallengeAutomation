package UItestSuites;

import core.BaseTest;
import org.testng.annotations.Test;
import page.objects.*;


public class UItestCases extends BaseTest {
    HomePage homePage;
    LoginPage loginPage;
    RegistrationPage registrationPage;
    ItemPage itemPage;
    ShoppingCartPage shoppingCartPage;

    public UItestCases(){
        super();
        this.homePage = new HomePage(getDriver());
        this.loginPage = new LoginPage(getDriver());
        this.registrationPage = new RegistrationPage(getDriver());
        this.itemPage = new ItemPage(getDriver());
        this.shoppingCartPage = new ShoppingCartPage(getDriver());
    }

    @Test
    public void TC_1() {
        this.homePage.navigateToURL();
    }

    @Test
    public void TC_2() {
        this.homePage.navigateToURL();
        this.homePage.signBTN();
        this.loginPage.createACC();
        this.registrationPage.personalInfo();
        this.registrationPage.validatResult();
    }

    @Test
    public void TC_3() {
        this.homePage.navigateToURL();
        this.homePage.numerOfPopular();
        this.homePage.numerOfbestSellers();
    }

    @Test
    public void TC_4() {
        this.homePage.navigateToURL();
        this.homePage.inputSearch();
        this.homePage.getTxtFile();
    }

    @Test
    public void TC_5() {
        this.homePage.navigateToURL();
        this.homePage.inputSearch();
        this.homePage.clickOnPicture();
        this.itemPage.verifyBTNsPresent();
        this.itemPage.verifyDiscount();
        this.itemPage.editFilter();
        this.itemPage.verifyOrder();
        this.itemPage.proceed();
        this.shoppingCartPage.verifyPage1();
        this.shoppingCartPage.proceedBTN1();
        this.loginPage.createACC();
        this.registrationPage.personalInfo();
        this.shoppingCartPage.verifyPage2();
        this.shoppingCartPage.verifyPage3();
        this.shoppingCartPage.proceedBTN2();
        this.shoppingCartPage.verifyPage4();
        this.shoppingCartPage.clickCheckBox();
        this.shoppingCartPage.proceedBTN3();
        this.shoppingCartPage.payByBank();
        this.shoppingCartPage.verifyTitlePresent();
    }


}

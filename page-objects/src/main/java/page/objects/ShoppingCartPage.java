package page.objects;

import core.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoppingCartPage extends BasePage {
    public ShoppingCartPage(WebDriver driver){
        super(driver);
    }

    public void verifyPage1(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"product_5_24_0_0\"]/td[2]/p/a")));
        String text = driver.findElement(By.xpath("//*[@id=\"product_5_24_0_0\"]/td[2]/p/a")).getText();
        Assert.assertEquals("Printed Summer Dress", text);
    }

    public void proceedBTN1(){
        driver.findElement(By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]")).click();
    }

    public void verifyPage2(){
        driver.findElement(By.xpath("//*[@id=\"order_step\"]/li[2]/a")).click();
        String text = driver.findElement(By.xpath("//*[@id=\"address_delivery\"]/li[2]")).getText();
        Assert.assertEquals("Kemal Hasic",text);
    }

    public void verifyPage3(){
        driver.findElement(By.xpath("//*[@id=\"order_step\"]/li[3]/span")).click();
        String text = driver.findElement(By.xpath("//*[@id=\"address_invoice\"]/li[4]")).getText();
        Assert.assertEquals("New York1, California 98654",text);
    }

    public void verifyPage4(){
        String text = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div[2]/div[1]/div/div/table/tbody/tr/td[4]/div")).getText();
        Assert.assertEquals("$2.00",text);
        }

    public void proceedBTN2(){
        driver.findElement(By.xpath("//*[@id=\"center_column\"]/form/p/button")).click();
    }

    public void clickCheckBox(){
        driver.findElement(By.xpath("//*[@id=\"uniform-cgv\"]/span")).click();
    }

    public void proceedBTN3(){
        driver.findElement(By.xpath("//*[@id=\"form\"]/p/button")).click();
    }

    public void payByBank(){
        driver.findElement(By.xpath("//*[@id=\"HOOK_PAYMENT\"]/div[1]/div/p/a")).click();
        driver.findElement(By.xpath("//*[@id=\"cart_navigation\"]/button")).click();
    }

    public void verifyTitlePresent(){
        String text = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/p/strong")).getText();
        Assert.assertEquals("Your order on My Store is complete.", text);
    }


}

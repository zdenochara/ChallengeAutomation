package page.objects;

import core.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ItemPage extends BasePage {
    public ItemPage(WebDriver driver){
        super(driver);
    }

    public void verifyBTNsPresent(){
        driver.findElement(By.xpath("//*[@id=\"social_block\"]/ul/li[1]/a")).isDisplayed();
        driver.findElement(By.xpath("//*[@id=\"social_block\"]/ul/li[2]/a")).isDisplayed();
        driver.findElement(By.xpath("//*[@id=\"social_block\"]/ul/li[3]/a")).isDisplayed();
        driver.findElement(By.xpath("//*[@id=\"social_block\"]/ul/li[4]/a")).isDisplayed();
    }

    public void verifyDiscount(){
        String text = driver.findElement(By.id("reduction_percent_display")).getText();
        Assert.assertEquals("-5%",text);
    }

    public void editFilter(){
        driver.findElement(By.id("quantity_wanted")).clear();
        driver.findElement(By.id("quantity_wanted")).sendKeys("3");
        driver.findElement(By.id("group_1")).click();
        driver.findElement(By.xpath("//*[@id=\"group_1\"]/option[2]")).click();
        driver.findElement(By.id("color_14")).click();
        driver.findElement(By.xpath("//*[@id=\"add_to_cart\"]/button")).click();
    }

    public void verifyOrder(){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[1]/div[2]")));
        String text1 = driver.findElement(By.id("layer_cart_product_attributes")).getText();
        String text2 = driver.findElement(By.id("layer_cart_product_quantity")).getText();
        Assert.assertEquals("Blue, M", text1);
        Assert.assertEquals("3",text2 );
    }

    public void proceed(){
        driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a")).click();
    }

}

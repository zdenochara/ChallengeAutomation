package page.objects;

import core.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.text.SimpleDateFormat;
import java.util.Date;


public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void createACC(){
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

        driver.findElement(By.id("email_create")).sendKeys("username"+ timeStamp +"@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"SubmitCreate\"]/span")).click();
    }

    public void loginUser(){
        driver.findElement(By.id("email")).sendKeys("failTedfst@gmail.com");
        driver.findElement(By.id("passwd")).sendKeys("badPaswoordff");
        driver.findElement(By.id("SubmitLogin")).click();
        String text = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/ol/li")).getText();
        Assert.assertNotEquals("Authentication failed.", text);


    }



}
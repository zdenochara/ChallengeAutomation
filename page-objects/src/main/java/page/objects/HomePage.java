package page.objects;

import core.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import sun.util.calendar.LocalGregorianCalendar;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PushbackInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class HomePage extends BasePage {

    public HomePage(WebDriver driver){
        super(driver);
    }

    public void navigateToURL(){
        driver.get("http://automationpractice.com/");
        driver.manage().window().maximize();
    }

    public void signBTN(){
        driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).click();
    }

    public void numerOfPopular(){
        List<WebElement> buttons = driver.findElements(By.cssSelector("ul.homefeatured li"));
        System.out.println("List size is: " + buttons.size());
        if(buttons.size() != 7) Assert.fail();
    }

    public void numerOfbestSellers(){
        List<WebElement> buttons = driver.findElements(By.cssSelector("ul.blockbestsellers li"));
        System.out.println("List size is: " + buttons.size());
        if(buttons.size() != 7) Assert.fail();
    }

    public void inputSearch(){
        driver.findElement(By.id("search_query_top")).sendKeys("Printed dresses");
        driver.findElement(By.xpath("//*[@id=\"searchbox\"]/button")).click();
    }

    public void getTxtFile() {
        WebElement industries = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul"));
        List<WebElement> links = industries.findElements(By.cssSelector("a.product-name"));

        for (int i = 0; i < links.size(); i++)
        {
            System.out.println(links.get(i).getText());
            try {
                String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
                FileWriter writer = new FileWriter(timeStamp+".txt", true);

                writer.write(links.get(i).getText());
                writer.write("\r\n");
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void clickOnPicture(){
        driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[1]/div/a[1]/img")).click();
    }


}

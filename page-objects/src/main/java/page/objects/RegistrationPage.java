package page.objects;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


    public class RegistrationPage extends BasePage {
        public RegistrationPage(WebDriver driver) {
            super(driver);
        }

        public void personalInfo(){
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("id_gender1")));
            driver.findElement(By.id("id_gender1")).click();
            driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/form/div[1]/div[2]/input")).sendKeys("Kemal");
            driver.findElement(By.id("customer_lastname")).sendKeys("Hasic");
            driver.findElement(By.id("passwd")).sendKeys("zdeno");
            driver.findElement(By.id("uniform-days")).click();
            driver.findElement(By.xpath("//*[@id=\"days\"]/option[2]")).click();
            driver.findElement(By.id("months")).click();
            driver.findElement(By.xpath("//*[@id=\"months\"]/option[6]")).click();
            driver.findElement(By.id("years")).click();
            driver.findElement(By.xpath("//*[@id=\"years\"]/option[7]")).click();
            driver.findElement(By.id("address1")).sendKeys("New York");
            driver.findElement(By.id("city")).sendKeys("New York1");
            driver.findElement(By.id("id_state")).click();
            driver.findElement(By.xpath("//*[@id=\"id_state\"]/option[6]")).click();
            driver.findElement(By.id("postcode")).sendKeys("98654");
            driver.findElement(By.id("id_country")).click();
            driver.findElement(By.id("phone_mobile")).sendKeys("543464533");
            driver.findElement(By.id("alias")).sendKeys("adreshhh");
            driver.findElement(By.id("submitAccount")).click();
        }

        public void validatResult(){
            driver.findElement(By.className("logout")).isDisplayed();
        }

    }


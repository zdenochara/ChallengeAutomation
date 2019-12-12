package core;

import org.apache.commons.io.FileUtils;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class BaseTest {

    private WebDriver driver;

    public BaseTest (){

        String os = System.getProperty("os.name").toLowerCase();

        switch (os) {
            case ("linux"):
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +"/Drivers/chromedriver");
                break;
            case ("windows"):
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/Drivers/chromedriver.exe");
                break;
            case ("windows 10"):
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/Drivers/chromedriver.exe");
                break;
            case ("mac"):
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/Drivers/chromedrivermac");
                break;
        }

        driver = new ChromeDriver();
    }

    // for TC 6, not implemented...
    public static void send(String fileName)
    {
        //Create Attachment
        EmailAttachment emailAttachment=new EmailAttachment();
        emailAttachment.setPath(fileName);
        emailAttachment.setDisposition(EmailAttachment.ATTACHMENT);
        emailAttachment.setDescription("Picture Attachment");
        emailAttachment.setName("Picture");
        //Initialize a new multi part email instance
        MultiPartEmail email=new MultiPartEmail();
        //Set email host
        email.setHostName("smtp.gmail.com");
        //Set email authentication username and password
        email.setAuthenticator(new DefaultAuthenticator("deniz_kesten@hotmail.com","xxxxxxxxxx"));
        //Set email host SSL to true
        email.setSSL(true);
        try {
            //Set From email address
            email.setFrom("deniz_kesten@hotmail.com");
        } catch (EmailException e) {
            e.printStackTrace();
        }
        //Set email Subject line
        email.setSubject("Java Test Email");
        try {
            //Set Email Message
            email.setMsg("This is a test from Java Email");
        } catch (EmailException e) {
            e.printStackTrace();
        }
        try {
            //Set Email To Address
            email.addTo("symphony@mailinator.com");
        } catch (EmailException e) {
            e.printStackTrace();
        }
        //add the attachment
        try {
            email.attach(emailAttachment);
        } catch (EmailException e) {
            e.printStackTrace();
        }
        try {
            //Send Email
            email.send();
        } catch (EmailException e) {
            e.printStackTrace();
        }

    }

   @AfterSuite
    public void afterSuite() {
        if(null != driver) {
            driver.close();
            driver.quit();
        }
    }

//here I can use the send method after every screen shot
    @AfterMethod
    public void takeScreenShotOnFailure(ITestResult testResult) throws IOException {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        if (testResult.getStatus() == ITestResult.FAILURE) {
            System.out.println(testResult.getStatus());
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String filePat = "errorScreenshots\\" + testResult.getName() + timeStamp + Arrays.toString(testResult.getParameters()) + ".jpg";
            FileUtils.copyFile(scrFile, new File(filePat));
            //------> send(filePat);
        }

    }
    public WebDriver getDriver() {
        return driver;
    }
}

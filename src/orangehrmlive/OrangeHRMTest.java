package orangehrmlive;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class OrangeHRMTest {
    static String browser = "Chrome";
    static String baseurl = "https://opensource-demo.orangehrmlive.com/";
    static WebDriver driver;


    public static void main(String[] args) throws InterruptedException {

        //Setup multi browser
        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("FireFox")) {
            driver = new FirefoxDriver();
        }else{
            System.out.println("Wrong browser name");

        }
        //System.setProperty("webdriver.chrome.driver" ,"chromedriver.exe");

        // Open the url into the browser
        driver.get(baseurl);
        Thread.sleep(4000);

        //Maximize the browser
        driver.manage().window().maximize();

        //we give implicit wait to driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Get the title of the page
        String title = driver.getTitle();
        System.out.println(title);

        //Get the current url
        System.out.println("The current url : " + driver.getCurrentUrl());

        // Get the page source code
        System.out.println(driver.getPageSource());

        // Click on 'Forget' your password link
         WebElement forgotYourPwd = driver.findElement(By.className("orangehrm-login-forgot"));
        forgotYourPwd.click();
        Thread.sleep(4000);

        //print the current url
       System.out.println(driver.getCurrentUrl());

       driver.navigate().back();
        Thread.sleep(4000);

       driver.navigate().refresh();
        Thread.sleep(4000);


        //Enter the email to email field
        WebElement userName = driver.findElement(By.name("username"));
        userName.sendKeys("Admin");
        Thread.sleep(4000);

        //driver.navigate().refresh();
        //Thread.sleep(4000);



        // Find Password Field Element and Type Password
        WebElement pwd = driver.findElement(By.name("password"));
        pwd.sendKeys("admin123");
        Thread.sleep(4000);

       //Click on Login button
        WebElement login = driver.findElement(By.xpath("//div[@class='oxd-form-actions orangehrm-login-action']"));
        login.click();
        Thread.sleep(4000);

        //Close the browser
        driver.quit();

    }
}

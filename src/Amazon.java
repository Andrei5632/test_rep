import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class Amazon {

    WebDriver driver;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\temp\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        login();
    }

    public void login() {
        String login_url = "https://amazon.com/";
        driver.get(login_url);

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Dickies shirt");
        driver.findElement(By.id("nav-search-submit-button")).click();


    }

    @Test
    public void dashboard() {

        driver.findElement(By.id("menu_dashboard_index")).click();
        String textPresent = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/h1")).getText();

        String textToBePresent = "DashBoard";
        assertEquals(textPresent, textToBePresent);
        textToBePresent = "Dashboard";
        assertEquals(textPresent, textToBePresent);
    }

    @Test
    public void dashboard2() {

        driver.findElement(By.id("menu_dashboard_index")).click();
        String textPresent = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/h1")).getText();

        String textToBePresent = "Dashboard";
        assertEquals(textPresent, textToBePresent);
    }

    @AfterTest
    public void tearDown() {
        //driver.quit();
    }
}

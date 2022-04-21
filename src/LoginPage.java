package Pages;
import static org.testng.Assert.assertEquals;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class LoginPage {

    WebDriver driver;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\temp\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        login();
    }

    public void login() {
        String login_url = "https://opensource-demo.orangehrmlive.com/";
        driver.get(login_url);

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("admin123");
        System.out.println(driver.getTitle());

        driver.findElement(By.id("btnLogin")).click();


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

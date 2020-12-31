import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.JavascriptExecutor;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;
public class LocalhostTestTest {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;
    @Before
    public void setUp() throws MalformedURLException {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
         driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
    }
    @After
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void navigationTest() {
        driver.get("http://localhost:3000/student");
        driver.manage().window().setSize(new Dimension(1936, 1056));
        js.executeScript("window.scrollTo(0,0)");
        driver.findElement(By.cssSelector(".MuiButtonBase-root:nth-child(4) .MuiTypography-root")).click();
        {
            WebElement element = driver.findElement(By.cssSelector(".MuiButtonBase-root:nth-child(3) .MuiTypography-root"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
        }
        driver.findElement(By.cssSelector(".MuiButtonBase-root:nth-child(3) .MuiTypography-root")).click();
        js.executeScript("window.scrollTo(0,0)");
        {
            WebElement element = driver.findElement(By.tagName("body"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element, 0, 0).perform();
        }
        driver.findElement(By.cssSelector(".MuiButtonBase-root:nth-child(2) .MuiTypography-root")).click();
    }
}

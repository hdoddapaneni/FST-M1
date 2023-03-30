package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class Activity1 {
    WebDriver driver;
    WebDriverWait wait;
    @BeforeClass
    public void setup() {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/lms/");

    }
    @Test
    public void homePageTest() {
        Assert.assertEquals(driver.getTitle(),"Training support");
        driver.findElement(By.id("about-link")).click();
    }

    @Test
    public void aboutPageTest() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.tagName("h1")));
        Assert.assertEquals(driver.getTitle(),"About Training support");
    }

    @AfterClass
    public void tearDown()
    {
        driver.quit();
    }
}

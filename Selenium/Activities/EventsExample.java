package examples;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;


public class EventsExample {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/drag-drop");
        Actions builder = new Actions(driver);
        WebElement football =driver.findElement(By.id("draggable"));
        WebElement droppable =driver.findElement(By.id("droppable"));
        WebElement dropzone2 =driver.findElement(By.id("dropzone2"));
        builder.clickAndHold(football).moveToElement(droppable).release().build().perform();

        driver.quit();


    }
}
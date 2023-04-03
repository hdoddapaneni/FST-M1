package activities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
public class Activity3 {
    public static void main(String[] args){
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://training-support.net/selenium/simple-form");
        String title = driver.getTitle();
        System.out.println(title);
        WebElement firstName = driver.findElement(By.id("firstName"));
        WebElement lastName = driver.findElement(By.id("lastName"));
        firstName.sendKeys("Hema");
        lastName.sendKeys("latha");
        driver.findElement(By.id("email")).sendKeys("hema.1205@gmail.com");
        driver.findElement(By.id("number")).sendKeys("9611206178");
        driver.findElement(By.cssSelector(".ui.green.button")).click();
        driver.close();
    }
}



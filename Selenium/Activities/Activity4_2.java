package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4_2 {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/simple-form");
        String pageTitle = driver.getTitle();
        System.out.println(pageTitle);
        WebElement firstName = driver.findElement(By.xpath("//input[@id = 'firstName']"));
        WebElement lastName = driver.findElement(By.xpath("//input[@id = 'lastName']"));
        firstName.sendKeys("Hema");
        lastName.sendKeys("latha");
        driver.findElement(By.xpath("//input[@id = 'email']")).sendKeys("hema.test@gmail.com");
        driver.findElement(By.xpath("//input[@id = 'number']")).sendKeys("9611206178");
        driver.findElement(By.xpath("//textarea")).sendKeys("This is just for testing");
        driver.findElement(By.xpath("//input[contains(@class, 'green')]")).click();
    }
}

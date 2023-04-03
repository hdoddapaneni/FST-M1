package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity2 {
    public static void main(String[] args){
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/");
        String title = driver.getTitle();
        System.out.println(title);
        String text =driver.findElement(By.id("about-link")).getText();
        String text1=driver.findElement(By.className("inverted")).getText();
        String text2=driver.findElement(By.linkText("about")).getText();
        System.out.println(text);
        System.out.println(text1);
        System.out.println(text2);
        driver.quit();
    }
}

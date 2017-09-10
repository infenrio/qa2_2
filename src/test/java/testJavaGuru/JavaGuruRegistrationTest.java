package testJavaGuru;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

/*
 *  Homework after QA2_2
 */
public class JavaGuruRegistrationTest {

    // The only test, checks whether the form is available and capable to register new user.
    @Test
    public void registerNewUser() throws InterruptedException {
        // Start driver, window and open project.
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://javaguru.lv");

        // Check that necessary elements are present.
        Assert.assertTrue(driver.findElement(By.xpath("//img[@class='logoImg']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("(//div[@class='regCup'])[4]")).isDisplayed());

        // Move to the second tab, for registration.
        driver.findElement(By.xpath("(//div[@class='regCup'])[4]")).click();
        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        // Check that registration form has necessary elements.
        Assert.assertTrue(driver.findElement(By.xpath("//h1[@class='ss-form-title']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.id("ss-submit")).isDisplayed());

        // Fill the form and submit.
        driver.findElement(By.xpath("(//input[@type='text'])[1]")).clear();
        driver.findElement(By.xpath("(//input[@type='text'])[1]")).sendKeys("Testname");
        driver.findElement(By.xpath("(//input[@type='text'])[2]")).clear();
        driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("Testsurname");
        driver.findElement(By.xpath("(//input[@type='text'])[3]")).clear();
        driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys("12345678");
        driver.findElement(By.xpath("(//input[@type='text'])[4]")).clear();
        driver.findElement(By.xpath("(//input[@type='text'])[4]")).sendKeys("test@test.com");
        driver.findElement(By.xpath("//input[@value='QA 2']")).click();
        driver.findElement(By.xpath("(//textarea)[1]")).clear();
        driver.findElement(By.xpath("(//textarea)[1]")).sendKeys("I am the test robot, so, my programming language is binary");
        driver.findElement(By.xpath("//input[@value='Да, смогу приходить со своим ноутбуком']")).click();
        driver.findElement(By.xpath("(//textarea)[2]")).clear();
        driver.findElement(By.xpath("(//textarea)[2]")).sendKeys("Dobrij tovari6 rekomendoval, ego e-mail: test@test.com");
        driver.findElement(By.xpath("(//textarea)[3]")).clear();
        driver.findElement(By.xpath("(//textarea)[3]")).sendKeys("Pustj u vseh vsjo budet horo6o, ladno?");
        driver.findElement(By.id("ss-submit")).click();

        // Check that confirmation is displayed.
        Assert.assertTrue(driver.findElement(By.xpath("//h1[@class='ss-confirmation']")).isDisplayed());

        // Finishing the test - closing the driver.
        driver.quit();
    }
}

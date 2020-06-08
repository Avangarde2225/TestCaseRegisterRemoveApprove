import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class registerToEntranceExams {
    private WebDriver driver;


    @BeforeClass
    @Parameters({"username","password","path"})
    public void setUp(String username, String password, String path) {

        System.setProperty("webdriver.chrome.driver", path);
        driver = new ChromeDriver();
        driver.get("https://basqar.techno.study/");
        driver.manage().window().maximize();

        driver.findElement(By.cssSelector("div.cc-compliance > a")).click();
        driver.findElement(By.cssSelector("input[placeholder='Username']")).sendKeys(username);
        driver.findElement(By.cssSelector("[formcontrolname=\"password\"]")).sendKeys(password);
        driver.findElement(By.cssSelector("button[aria-label=\"LOGIN\"]")).click();
        driver.manage().timeouts().implicitlyWait( 3, TimeUnit.SECONDS );
    }
    @AfterClass
    public void quit(){
        //driver.quit();
    }

    @Test
    public void examRegistration(){
        driver.findElement(By.xpath("//div//fuse-nav-vertical-collapsable//span[@class='nav-link-title ng-tns-c104-14 ng-star-inserted']")).click(); //Click on entrace exams
        driver.findElement(By.xpath("//fuse-nav-vertical-group//div//fuse-nav-vertical-collapsable//span[text()='Registration Approve']")).click(); // click on registration approve
        //click on plus button
        driver.findElement(By.cssSelector("ms-add-button[tooltip='GENERAL.BUTTON.ADD']")).click();




    }


}

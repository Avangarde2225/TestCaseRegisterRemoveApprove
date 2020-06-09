import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

        //selecting from the pre-approval list
        driver.findElement(By.xpath("//div//mat-select//div[@class='mat-select-value ng-tns-c211-62']")).click();
        //selecting 9th grade
        driver.findElement(By.xpath("//div//div[@class='ng-tns-c211-62 ng-trigger ng-trigger-transformPanel mat-select-panel mat-primary']//child::mat-option[5]")).click();
        //click on choose exam
        driver.findElement(By.xpath("//div[@class='mat-select-value ng-tns-c211-64']")).click();
        //selecting exam
        driver.findElement(By.xpath("//mat-option[@class='mat-option mat-focus-indicator mat-active ng-tns-c211-64 ng-star-inserted']//child::span")).click();

        //selecting student information tab
        driver.findElement(By.cssSelector("div.mat-tab-labels>div:nth-child(2)")).click();
        //enter lastname
        driver.findElement(By.cssSelector("ms-text-field[placeholder='GENERAL.FIELD.LAST_NAME']")).sendKeys("Abuzer");
        //enter firstname
        driver.findElement(By.cssSelector("ms-text-field[formcontrolname='firstName']")).sendKeys("Kadayif");
        //DOB
        driver.findElement(By.cssSelector("input[placeholder='Date of Birth']")).sendKeys("08/02/2005");
        //personal ID
        driver.findElement(By.cssSelector("ms-text-field[formcontrolname='personalID']")).sendKeys("1000000004");
        //gender
        driver.findElement(By.xpath("//span[text()='Gender']")).click();
        //select gender
        driver.findElement(By.xpath("//span[text()='Male']")).click();
        //citizenship
        driver.findElement(By.xpath("//span[text()='Citizenship']")).click();
        //select citizenship
        driver.findElement(By.xpath("//span[text()='Ukraine']")).click();
        //nationality
        driver.findElement(By.xpath("//span[text()='Nationality']")).click();
        //select nationality
        driver.findElement(By.xpath("//span[text()='Ukrainian']")).click();

        //click on relative info
        driver.findElement(By.cssSelector("div.mat-tab-labels>div:nth-child(3)")).click();
    }


}

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
    public void examRegistration() throws InterruptedException {
        driver.findElement(By.xpath("//div//fuse-nav-vertical-collapsable//span[@class='nav-link-title ng-tns-c104-14 ng-star-inserted']")).click(); //Click on entrance exams
        driver.findElement(By.xpath("//fuse-nav-vertical-group//div//fuse-nav-vertical-collapsable//span[text()='Registration Approve']")).click(); // click on registration approve
        //click on plus button
        driver.findElement(By.cssSelector("ms-add-button[tooltip='GENERAL.BUTTON.ADD']")).click();

        //selecting from the pre-approval list
        driver.findElement(By.xpath("//span[text()='Grade Level of Registration']")).click();
        //selecting 9th grade
        driver.findElement(By.xpath("//span[text()=' 9th Grade ']")).click();
        //click on choose exam
        driver.findElement(By.xpath("//span[text()='Choose Exam']")).click();
        //selecting exam
        driver.findElement(By.xpath("//mat-option//span[text()=' 9th Grade Entrance Exam ']")).click();

        //selecting student information tab
        driver.findElement(By.cssSelector("div.mat-tab-labels>div:nth-child(2)")).click();

        //enter lastname

//        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.cssSelector("ms-text-field[placeholder='GENERAL.FIELD.LAST_NAME']"))).click();

        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//ms-text-field[@formcontrolname='lastName']/input"))).click();

        driver.findElement(By.xpath("//ms-text-field[@formcontrolname='lastName']/input")).sendKeys("Doe");

        //enter firstname
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//ms-text-field[@formcontrolname='firstName']/input"))).click();

        driver.findElement(By.xpath("//ms-text-field[@formcontrolname='firstName']/input")).sendKeys("John");

        //DOB
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Date of Birth']"))).click();
        driver.findElement(By.xpath("//input[@placeholder='Date of Birth']")).sendKeys("08/02/2005");
        //driver.findElement(By.xpath("//button[@aria-label='Open calendar']/span")).click();

        //personal ID
        //new WebDriverWait(driver,10).until((ExpectedConditions.elementToBeClickable(By.xpath("//ms-text-field[@placeholder='GENERAL.FIELD.PERSONAL_ID']"))));
       //driver.findElement(By.xpath("//ms-text-field[@placeholder='GENERAL.FIELD.PERSONAL_ID']")).click();
        WebElement element = driver.findElement(By.xpath("//ms-text-field[@placeholder='GENERAL.FIELD.PERSONAL_ID']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();

        driver.findElement(By.xpath("//ms-text-field[@placeholder='GENERAL.FIELD.PERSONAL_ID']//input")).sendKeys("1000000004");

        //gender
        driver.findElement(By.xpath("//span[text()='Gender']")).click();
        //select gender
        driver.findElement(By.xpath("//span[text()=' Male ']")).click();
        //citizenship
        driver.findElement(By.xpath("//span[text()='Citizenship']")).click();
        //select citizenship
        driver.findElement(By.xpath("//span[text()=' Ukraine ']")).click();
        //nationality
        driver.findElement(By.xpath("//span[text()='Nationality']")).click();
        //select nationality
        driver.findElement(By.xpath("//span[text()=' Ukrainian ']")).click();

        //click on relative info
        WebDriverWait wait = new WebDriverWait(driver,20);

       driver.findElement(By.cssSelector("div.mat-tab-labels>div:nth-child(3)")).click();
        //click on representative
        driver.findElement(By.xpath("(//*[@aria-label=\"Representative\"]//following::span)[1]")).click();
        wait.until( ExpectedConditions.visibilityOfElementLocated( By.cssSelector(".cdk-overlay-pane") ) );

        //select representative
        driver.findElement(By.xpath("//*[@id=\"mat-option-73\"]")).click();

        wait.until( ExpectedConditions.invisibilityOfElementLocated( By.cssSelector(".cdk-overlay-pane") ) );

    }


}

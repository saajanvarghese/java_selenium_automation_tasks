/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package java_selenium_automation_tasks;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class App {
// Amazon Search to get mobiles title of 4 products from the list in the search results
    public static void TestCase01(WebDriver driver) throws InterruptedException{

        driver.get("https://www.amazon.in/");

        // Thread.sleep(20000);

        WebElement amazonSearchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        amazonSearchBox.click();

        Thread.sleep(2000);

        amazonSearchBox.sendKeys("mobiles");

        Thread.sleep(1000);

        WebElement amazonSearchbtn = driver.findElement(By.id("nav-search-submit-button"));
        amazonSearchbtn.click();

        Thread.sleep(2000);


        List <WebElement> list = driver.findElements(By.xpath("//div[@class=\"puisg-col-inner\"]//div[@data-cy=\"title-recipe\"]//h2//a//span"));

        System.out.println(list.size());

        for(int i=0;i<list.size()-20;i++){// to list 4 products title we used -20 out of 24 total products
            String listitem= list.get(i).getText();
            System.out.println(listitem);
        }
    }
   

    //Amazon Product search -  To get Iphone products which contains 128GB Internal storage only
    public static void TestCase02(WebDriver driver) throws InterruptedException{

        driver.get("https://www.amazon.in/");

        WebElement amazonSearchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        amazonSearchBox.click();

        Thread.sleep(2000);

        amazonSearchBox.sendKeys("iphone");

        Thread.sleep(1000);

        WebElement amazonSearchbtn = driver.findElement(By.id("nav-search-submit-button"));
        amazonSearchbtn.click();

        Thread.sleep(2000);

        List<WebElement> list = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));

        System.out.println(list.size());

        int count =0;

        for(int i=0; i<list.size()-2; i++){

            String item_name = list.get(i).getText();
            if(item_name.contains("128")){
                count++;
                System.out.println(item_name);
            }
            Thread.sleep(100);
            //System.out.println(count);
        }

        System.out.println(count);
    }

    // Wikipedia Task - To search for Apple.Inc and retrieve the Founders list of Apple.Inc
    public static void TestCase03(WebDriver driver) throws InterruptedException{

        driver.get("https://www.wikipedia.org/");

        WebElement searchbox_click = driver.findElement(By.xpath("//input[@id=\"searchInput\" and @name=\"search\"]"));
        searchbox_click.click();

        searchbox_click.sendKeys("Apple");
        Thread.sleep(1000);

        WebElement searchbox_drop_down_options = driver.findElement(By.xpath("//div[@class=\"suggestions-dropdown\"]//a[2]"));
        searchbox_drop_down_options.click();

        Thread.sleep(1000);

        List<WebElement> list = driver.findElements(By.xpath("//tr[9]//td//div[@class=\"plainlist\"]//ul//li//a"));

        System.out.println(list.size());

        for(int i=0; i<list.size(); i++){

            String element_name = list.get(i).getText();
            
                System.out.println("Founders of Apple.Inc "+element_name);
            
            Thread.sleep(100);
        }
    }

    public static void TestCase04(WebDriver driver) throws InterruptedException{

        driver.get("https://jqueryui.com/datepicker/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe[@class='demo-frame']")));
        
        WebElement iframe = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
        driver.switchTo().frame(iframe);

        System.out.println("I am here");

        WebDriverWait date_picker_wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        date_picker_wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='hasDatepicker']")));

        WebElement date_picker = driver.findElement(By.xpath("//input[@class='hasDatepicker']"));
        date_picker.click();

        List<WebElement> dates = driver.findElements(By.className("ui-datepicker-week-end"));

        int getdates =dates.size()-1;

        for(int i =3; i<=getdates;){

            if(i%2==0){
                WebElement Sunday = driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']//th[1]"));
                String getSundaytxt = Sunday.getText();
                System.out.println(getSundaytxt+" : "+dates.get(i).getText());  
                i++;
            }
            else if(i%2!=0){
                WebElement Saturday = driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']//th[7]"));
                String getSaturdaytxt = Saturday.getText();
                System.out.println(getSaturdaytxt+" : "+dates.get(i).getText());
                i++;
            }
            else{
                System.out.println("Invalid Dates");
            }


        }
        driver.switchTo().defaultContent();
        
    }

   public static void main(String[] args) throws InterruptedException {
        ChromeOptions chromeOptions = new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(chromeOptions);

        //########################################################################################
        //Please Note for Executing a particular TestCase for Example If you want to Execute TestCase 02, Comment the Other TestCases other
        // TestCase02 and Execute.
        //#########################################################################################

        // Amazon Search to get mobiles title of 4 products from the list in the search results
        TestCase01(driver);

        //Amazon Product search -  To get Iphone products which contains 128GB Internal storage only
        //TestCase02(driver);

        // Wikipedia Task - To search for Apple.Inc and retrieve the Founders list of Apple.Inc
        //TestCase03(driver);

        // DatePicker Element- Selenium Task To Display Weekends for the current month only using JQueryUI website
        TestCase04(driver);
   }
}

package java_selenium_automation_tasks;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Wikipedia {
    
    static WebDriver driver;


    public void Task01_Search_Apple_founders_list(String product) throws InterruptedException{

         driver.get("https://www.wikipedia.org/");

        WebElement searchbox_click = driver.findElement(By.xpath("//input[@id=\"searchInput\" and @name=\"search\"]"));
        searchbox_click.click();

        searchbox_click.sendKeys(product);
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

        System.out.println("End of Tasks");
    }

    public void Task02_Search_Celebrity_Academy_Awards(String product) throws InterruptedException{

    }

    
}

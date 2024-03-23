package java_selenium_automation_tasks;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Wikipedia {
    WebDriver driver;

    String url = "https://www.wikipedia.org/";

    public Wikipedia(WebDriver driver) {
        this.driver = driver;
    }

    public Boolean navigateToWikipediaPage(){

        if (!driver.getCurrentUrl().equals(this.url)) {
            driver.get(this.url);
        }
        return false;

    }


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

    public void Task02_Search_Celebrity_Academy_Awards(String celebrityName, String AwardName, String year) throws InterruptedException{

        driver.get("https://www.wikipedia.org/");

        WebElement searchbox_click = driver.findElement(By.xpath("//input[@id=\"searchInput\" and @name=\"search\"]"));
        searchbox_click.click();

        searchbox_click.sendKeys(celebrityName);
        Thread.sleep(3000);

        WebElement searchbox_drop_down_options = driver.findElement(By.xpath("//a[@class=\"suggestion-link\"][1]"));
        searchbox_drop_down_options.click();

        Thread.sleep(1000);

        WebElement accolades = driver.findElement(By.xpath("//li[@id='toc-Accolades']//a"));
        accolades.click();

        WebElement accolades_link = driver.findElement(By.partialLinkText("List of awards and nominations received by Heath Ledger"));
        accolades_link.click();

        WebElement verify_AcademyAwards = driver.findElement(By.id("Academy_Awards"));
        String verifyAcademy_text = verify_AcademyAwards.getText();

        if(verifyAcademy_text.equals(AwardName)){
            System.out.println("Verified: Academy Awards");
        }
        else{
            System.out.println("Unverified: Academy Awards");
            driver.close();
        }
            List<WebElement> resultRow = driver.findElements(By.xpath("//table[2]//tbody/tr//td//a"));
            for(WebElement yearElement : resultRow){
                if(resultRow.size() > 0){
                    yearElement.findElement(By.xpath("//table[2]//tbody/tr//td//a[text()='"+year+"']"));

                String yearElementText =yearElement.findElement(By.xpath("//table[2]//tbody/tr//td//a[text()='"+year+"']")).getText();

                if(yearElementText.equals(year)){
                    System.out.println("The provided Year is Present");
                List<WebElement> getYearElement = driver.findElements(By.xpath("//table[2]//tbody/tr//td//a[text()='2009']/ancestor::tr//td")); 
                for(WebElement ResultList: getYearElement){
                    System.out.println(ResultList.getText());
                }               
                break;
                }
                else{
                    System.out.println("The provided Year is not Present");
                    driver.close();
                }
            }
            }
        }
    }

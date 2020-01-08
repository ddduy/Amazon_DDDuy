import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class Pratice {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Driver\\chromedriver.exe");
        WebDriver _driver = new ChromeDriver();

        _driver.get("https://www.amazon.com/");//Launch amazon page
        _driver.navigate().refresh();//Refresh to avoid error loading page

        //Select search category "Electronics"
        Select _search_in = new Select(_driver.findElement(By.id("searchDropdownBox")));
        _search_in.selectByVisibleText("Electronics");

        //Search with keyword "smart"
        String _text = "smart";
        WebElement _search = _driver.findElement(By.id("twotabsearchtextbox"));
        _search.sendKeys(_text);
        _search.sendKeys(Keys.ENTER);

        List<WebElement> _check = _driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));

        for(int i=0;i<_check.size();i++){
            if (_check.get(i).getText().contains("Smart")){
                System.out.println("test pass!");
                break;
            }
            else{
                if(i==_check.size()){
                    System.out.println("test failed!");
                }
            }
        }
    }
}

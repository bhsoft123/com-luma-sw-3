package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.Utility;

import java.util.List;

public class WomenTest extends Utility {

    String baseUrl = " https://magento.softwaretestingboard.com/";

@Before
public void setUp(){
    openBrowser(baseUrl);
}
@Test
public void verifyTheSortByProductNameFilter() throws InterruptedException {
    //Mouse Hover on Women Menu
    mouseHoverToElement(By.xpath("//a[@id='ui-id-4']//span[contains(text(),'Women')]"));
    //Mouse Hover on Top Menu
    mouseHoverToElement(By.xpath("//a[@id='ui-id-4']//span[contains(text(),'Women')]"));
    //Mouse Hover on jackets and click on it
    Thread.sleep(2000);
    mouseHoverToElementAndClick(By.xpath("//a[@id='ui-id-11']"));
    Thread.sleep(2000);
    //clickOnElement(By.xpath("manageHeaderLbl")); //click on the drop down
    Actions actions =new Actions(driver);
    List<WebElement> sortByitems = driver.findElements(By.xpath("//select[@id='sorter']/option"));
        for (WebElement element : sortByitems) {
        if (element.getText().equalsIgnoreCase("Product Name")) {
            System.out.println("product" + element.getText());
            element.click();
            WebElement ascOrder = driver.findElement(By.xpath("//a[@title='Set Ascending Direction']/span"));
            actions.moveToElement(ascOrder).click().build().perform();
            break;
    }
        //pending verifying that the display is in ascending order
    }
    // Verify the products name display in alphabetical order
    //List<WebElement> element1 = driver.findElements(By.xpath("//strong[@class = 'product name product-item-name']"));
    //String expectedText = "12 Items";
    //String actualText = driver.findElement(By.xpath("(//div[@class='toolbar toolbar-products']//p[@id='toolbar-amount'])[1]")).getText();
    //Assert.assertEquals(expectedText, actualText);

}


@Test
public void verifyTheSortByPriceFilter () throws InterruptedException {


    //Mouse Hover on Women Menu
    mouseHoverToElement(By.xpath("//a[@id='ui-id-4']//span[contains(text(),'Women')]"));
    //Mouse Hover on tops Menu
    mouseHoverToElement(By.xpath("//a[@id='ui-id-9']"));
    //Mouse Hover on jackets and click on it
    mouseHoverToElementAndClick(By.xpath("//a[@id='ui-id-11']"));
    Actions actions = new Actions(driver);
    //Select Sort By filter “Product Name

    List<WebElement> sortByPrice = driver.findElements(By.xpath("//select[@id='sorter']/option"));
    for( WebElement element : sortByPrice){
        if(element.getText().equalsIgnoreCase("Price")){
            System.out.println("Price" + element.getText());
            element.click();
            Thread.sleep(2000);
            WebElement ascOrder =driver.findElement(By.xpath("//a[@title='Set Ascending Direction']/span"));
            actions.moveToElement(ascOrder).click().build().perform();
            break;
    }
    }
    }


    @After
public void tearDown(){
    closeBrowser();
}
}

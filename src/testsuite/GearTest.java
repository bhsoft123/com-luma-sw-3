package testsuite;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class GearTest extends Utility {

    String baseUrl ="https://magento.softwaretestingboard.com/";
@Before
    public void setUp(){
        openBrowser(baseUrl);
    }

@Test
    public void userShouldAddProductSuccessfullyToShoppingCart() {
    //Mouse Hover on Gear Menu
    mouseHoverToElement(By.xpath("//a[@class='level-top ui-corner-all']//span[normalize-space()='Gear']"));
    //Mouse Hover on Bags and Click on bags
    mouseHoverToElementAndClick(By.xpath("//a[@id='ui-id-25']//span[normalize-space()='Bags']"));
    //Click on Product Name ‘Overnight Duffle’
    mouseHoverToElementAndClick(By.xpath("//a[@class='product-item-link'][normalize-space()='Overnight Duffle']"));
    //Verify the text ‘Overnight Duffle
    verifyText(By.xpath("//h1[contains(normalize-space(),'Overnight Duffle')]"), "Overnight Duffle");
    //Change Qty 3
    clearTextToElement(By.xpath("//input[@id='qty']"));
    sendTextToElement(By.xpath("//input[@id='qty']"), "3");
    //Click on ‘Add to Cart’ Button.
    mouseHoverToElementAndClick(By.xpath("//button[@id='product-addtocart-button']//span[normalize-space()='Add to Cart']"));
    //Verify the text
    verifyText(By.xpath("//div[@class='message-success success message']"), "You added Overnight Duffle to your shopping cart.");
    //Click on ‘shopping cart’ Link into message
    mouseHoverToElementAndClick(By.xpath("//a[normalize-space()='shopping cart']"));
    //Verify the product name
    verifyText(By.xpath("//td[@class='col item']//a[normalize-space()='Overnight Duffle']"), "Overnight Duffle");
    //Verify the Qty is ‘3’
    verifyText(By.xpath("//div[@class='control']//input[@id='qty']"),"3");
    //Verify the product price ‘$135.00’
    verifyText(By.xpath("//span[@class='cart-price']//span[@class='price'][normalize-space()='$135.00']"), "$135.00");
    //Change Qty to ‘5’
    clearTextToElement(By.xpath("//input[@id='qty']"));
    sendTextToElement(By.xpath("//input[@id='qty']"), "5");
    //Click on ‘Update Shopping Cart’ button
    mouseHoverToElementAndClick(By.xpath("//span[normalize-space()='Update Shopping Cart']"));
    //Verify the product price ‘$225.00’
    verifyText(By.xpath("//span[@class='cart-price']//span[@class='price'][normalize-space()='$225.00']"), "$225.00");
}
}

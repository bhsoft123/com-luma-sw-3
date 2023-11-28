package testsuite;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class MenTest extends Utility {

        String baseUrl ="https://magento.softwaretestingboard.com/";
@Before
public void setUp(){
    openBrowser(baseUrl);
}
@Test
public void userShouldAddProductSuccessFullyToShoppinCart(){
    //Mouse Hover on Men menu
    mouseHoverToElement(By.id("ui-id-5"));
    //Mouse Hover on Bottoms
    mouseHoverToElement(By.id("ui-id-18"));
    //Mouse Hover on Pants and click on it
    mouseHoverToElementAndClick(By.id("ui-id-23"));
    //Mouse Hover on product name 'Cronus yoga pant' and click on size 32
    mouseHoverToElementAndClick(By.xpath("//div[@class='swatch-opt-880']//div[@id='option-label-size-143-item-175']"));
    //Mouse Hover on product name ‘Cronus Yoga Pant’ and click on colour Black
    mouseHoverToElementAndClick(By.id("option-label-color-93-item-49"));
    //Mouse Hover on product name ‘Cronus Yoga Pant’ and click on ‘Add To Cart’ Button.
    mouseHoverToElement(By.xpath("//a[normalize-space()='Cronus Yoga Pant']"));
    //Mouse hover on Add to cart
    mouseHoverToElementAndClick(By.xpath("//button[@title='Add to Cart']"));
    //Verify the text
    verifyText(By.xpath("//a[normalize-space()='shopping cart']"), "You added Cronus Yoga Pant to your shopping cart");
    //Click on ‘shopping cart’ Link into message
    clickOnElement(By.xpath("//a[normalize-space()='shopping cart']"));
    //Verify the product name 'Cronus Yoga Pant'
    verifyText(By.xpath("//a[@class='product-item-link'][normalize-space()='Cronus Yoga Pant']"), "Cronus Yoga Pant");
    verifyText(By.xpath("//div[@class='swatch-opt-880']//div[@id='option-label-size-143-item-175']"), "32");
    verifyText(By.id("option-label-color-93-item-49"),"Black");
}
}

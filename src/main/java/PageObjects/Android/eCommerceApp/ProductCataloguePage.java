package PageObjects.Android.eCommerceApp;

import Utils.AndroidGestures;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductCataloguePage extends AndroidGestures {

    AndroidDriver driver;

    private String ProductPriceAirJordan9Retro;

    private String ProductPriceAirJordan1MidSe;

    public ProductCataloguePage(AndroidDriver driver){

        super(driver);

        this.driver = driver;

        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

    }

    /*

        Locators

    */

    @AndroidBy(id = "com.androidsample.generalstore:id/productName")
    private List<WebElement> numberOfProductsDisplayedSinglePageLocator;


    @AndroidFindBy(id = "com.androidsample.generalstore:id/productAddCart")
    private List<WebElement> genericAdd2CartButton;


    /*

    ------------------------------------------------------------------

     */


    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Air Jordan 9 Retro\"]//following-sibling::android.widget.LinearLayout[2]//child::*")
    private List<WebElement> priceAndAdd2CartFieldsAirJordan9Retro;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Air Jordan 9 Retro\"]//following-sibling::android.widget.LinearLayout[2]//child::android.widget.TextView[1]")
    private WebElement AirJordan9RetroPriceField;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Air Jordan 9 Retro\"]//following-sibling::android.widget.LinearLayout[2]//child::android.widget.TextView[2]")
    private WebElement AirJordan9RetroAdd2CartField;

    private By AirJordan9RetroAdd2CartFieldBy = By.xpath("//android.widget.TextView[@text=\"Air Jordan 9 Retro\"]//following-sibling::android.widget.LinearLayout[2]//child::android.widget.TextView[2]");


    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/productName\" and @text=\"Air Jordan 9 Retro\"]")
    private WebElement AirJordan9Retro;

    /*

    ------------------------------------------------------------------

     */

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Air Jordan 1 Mid SE\"]//following-sibling::android.widget.LinearLayout[2]//child::*")
    private List<WebElement> priceAndAdd2CartFieldsAirJordan1MidSe;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Air Jordan 1 Mid SE\"]//following-sibling::android.widget.LinearLayout[2]//child::android.widget.TextView[1]")
    private WebElement AirJordan1MidSePriceField;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Air Jordan 1 Mid SE\"]//following-sibling::android.widget.LinearLayout[2]//child::android.widget.TextView[2]")
    private WebElement AirJordan1MidSeAdd2CartField;

    @AndroidBy(xpath = "//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/productName\" and @text=\"Air Jordan 1 Mid SE\"]")
    private WebElement AirJordan1MidSE;


    /*

    ------------------------------------------------------------------

    */

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Air Jordan 4 Retro\"]//following-sibling::android.widget.LinearLayout[2]//child::*")
    private List<WebElement> priceAndAdd2CartFieldsAirJordan4Retro;

    @AndroidBy(xpath = "//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/productName\" and @text=\"Air Jordan 4 Retro\"]")
    private WebElement AirJordan4Retro;


    /*

    ------------------------------------------------------------------

    */


    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Jordan 6 Rings\"]//following-sibling::android.widget.LinearLayout[2]//child::*")
    private List<WebElement> priceAndAdd2CartFieldsJordan6Rings;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/productName\" and @text=\"Jordan 6 Rings\"]")
    private WebElement Jordan6Rings;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Jordan 6 Rings\"]//following-sibling::android.widget.LinearLayout[2]//child::android.widget.TextView[2]")
    private WebElement Jordan6RingsAdd2CartField;

    private By Jordan6RingsAdd2CartFieldBy = By.xpath("//android.widget.TextView[@text=\"Jordan 6 Rings\"]//following-sibling::android.widget.LinearLayout[2]//child::android.widget.TextView[2]");



    /*

    ------------------------------------------------------------------

    */

    @AndroidFindBy(id = "com.androidsample.generalstore:id/appbar_btn_cart")
    private WebElement ShoppingCartButton;


     /*
        Actions
     */

    public void addItem2CartViaIndex() throws InterruptedException {

        int totalNumberOfProductsDisplayed = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();

        //int totalNumberOfProductsDisplayed = numberOfProductsDisplayedSinglePageLocator.size();

        for(int i=0; i < totalNumberOfProductsDisplayed; i++){

            String prodText = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();

            if(prodText.equals("Air Jordan 4 Retro")){
                genericAdd2CartButton.get(i).click();
            } else if (prodText.equals("Air Jordan 1 Mid SE")) {
                genericAdd2CartButton.get(i).click();
            }
        }
    }


    public void addItem2CartViaXPathSibling(String ProductName) throws InterruptedException {

        if(ProductName.equalsIgnoreCase(AirJordan9Retro.getText())){

            //Scroll till element
            scrollTillElement(ProductName);

            //Checking if product 'Air Jordan 9 Retro's - Price, ADD TO CART field is displayed or not
            if(!priceAndAdd2CartFieldsAirJordan9Retro.isEmpty()){

                //Checking if product 'Air Jordan 9 Retro's - Price field is displayed or not
                if(AirJordan9RetroPriceField.isDisplayed()){

                    //Grab the Price of product
                    ProductPriceAirJordan9Retro = AirJordan9RetroPriceField.getText();

                    Thread.sleep(3000);

                    //Click on corresponding 'Add to cart' button
                    AirJordan9RetroAdd2CartField.click();

                } else {

                    //If product 'Air Jordan 9 Retro's - Price field is NOT Displayed -- scroll down
                    scrollDownVerySlightly();

                    //Grab the Price of product
                    ProductPriceAirJordan9Retro = AirJordan9RetroPriceField.getText();

                    Thread.sleep(3000);

                    //Click on corresponding 'Add to cart' button
                    AirJordan9RetroAdd2CartField.click();
                }
            }

        } else if(ProductName.equalsIgnoreCase("Air Jordan 4 Retro")){

        } else if (ProductName.equalsIgnoreCase("Jordan 6 Rings")) {

        }
        else {

            //Jordan 1 Mid SE

            //Scroll to beginning
            scrollToBeginning();

            //Scroll till element
            scrollTillElement(ProductName);


            //Checking if product 'Air Jordan 9 Retro's - Price, ADD TO CART field is displayed or not
            if(!priceAndAdd2CartFieldsAirJordan1MidSe.isEmpty()){

                //Checking if product 'Air Jordan 9 Retro's - Price field is displayed or not
                if(AirJordan1MidSePriceField.isDisplayed()){

                    //Grab the Price of product
                    ProductPriceAirJordan1MidSe = AirJordan1MidSePriceField.getText();

                    Thread.sleep(3000);

                    //Click on corresponding 'Add to cart' button
                    AirJordan1MidSeAdd2CartField.click();

                } else {

                    //If product 'Air Jordan 9 Retro's - Price field is NOT Displayed -- scroll down
                    scrollDownVerySlightly();

                    //Grab the Price of product
                    ProductPriceAirJordan1MidSe = AirJordan1MidSePriceField.getText();

                    Thread.sleep(3000);

                    //Click on corresponding 'Add to cart' button
                    AirJordan1MidSeAdd2CartField.click();
                }
            }
        }
    }


    public ProductCheckoutPage ClickShopCartButton(){

        ShoppingCartButton.click();

        //Create next page object

        ProductCheckoutPage productCheckoutPage = new ProductCheckoutPage(driver);

        return productCheckoutPage;

    }

    public String getProduct1Price(){

        ProductPriceAirJordan9Retro = AirJordan9RetroPriceField.getText();

        return ProductPriceAirJordan9Retro;

    }


    public String getProduct2Price(){

        ProductPriceAirJordan1MidSe = AirJordan1MidSePriceField.getText();

        return ProductPriceAirJordan1MidSe;

    }
}

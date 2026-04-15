package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {

    private WebDriver driver;

    private By productsTitle = By.className("title");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isProductsPageDisplayed() {
        return driver.getCurrentUrl().contains("inventory.html");
    }

    public String getProductsTitle() {
        return driver.findElement(productsTitle).getText();
    }
}
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.stream.Collectors;

public class ShoppingCartPage {

    private WebDriver driver;

    private By iconoCarrito = By.className("shopping_cart_link");
    private By productosEnCarrito = By.cssSelector(".inventory_item_name");

    public ShoppingCartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAgregarCarrito(String idProducto) {
        driver.findElement(By.id(idProducto)).click();
    }

    public void clickIconoCarrito() {
        driver.findElement(iconoCarrito).click();
    }

    public List<String> obtenerNombresProductosEnCarrito() {
        return driver.findElements(productosEnCarrito)
                .stream()
                .map(producto -> producto.getText())
                .collect(Collectors.toList());
    }

    public boolean productosEstanVisiblesEnCarrito(List<String> productosEsperados) {
        List<String> productosActuales = obtenerNombresProductosEnCarrito();

        return productosActuales.containsAll(productosEsperados);
    }
}
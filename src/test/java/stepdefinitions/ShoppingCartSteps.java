package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.ShoppingCartPage;
import utils.DriverManager;

import java.util.List;

public class ShoppingCartSteps {

    private WebDriver driver;
    private ShoppingCartPage shoppingCartPage;

    public ShoppingCartSteps() {
        this.driver = DriverManager.getDriver();
        this.shoppingCartPage = new ShoppingCartPage(driver);
    }

    @When("el usuario agrega los siguientes productos al carrito")
    public void elUsuarioAgregaLosSiguientesProductosAlCarrito(DataTable dataTable) {
        List<String> idsProductos = dataTable.asList();

        for (String idProducto : idsProductos) {
            shoppingCartPage.clickAgregarCarrito(idProducto);
        }
    }

    @When("el usuario hace clic en el icono del carrito")
    public void elUsuarioHaceClicEnElIconoDelCarrito() {
        shoppingCartPage.clickIconoCarrito();
    }

    @Then("puede ver los siguientes productos agregados en el carrito")
    public void puedeVerLosSiguientesProductosAgregadosEnElCarrito(DataTable dataTable) {
        List<String> productosEsperados = dataTable.asList();

        Assert.assertTrue(
                shoppingCartPage.productosEstanVisiblesEnCarrito(productosEsperados)
        );
    }
}
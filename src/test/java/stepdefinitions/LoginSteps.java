package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.ProductsPage;
import utils.DriverManager;

public class LoginSteps {

    private WebDriver driver;
    private LoginPage loginPage;
    private ProductsPage productsPage;

    @Given("el usuario está en la página de login")
    public void abrirPagina() {
        driver = DriverManager.getDriver();
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        loginPage.openLoginPage();
    }

    @When("ingresa usuario y contraseña válidos")
    public void ingresarCredencialesValidas() {
        loginPage.login("standard_user", "secret_sauce");
    }

    @Then("puede ver la pagina principal de productoss")
    public void validarLoginExitoso() {
        Assert.assertTrue(productsPage.isProductsPageDisplayed());
        Assert.assertEquals("Products", productsPage.getProductsTitle());
    }

    @When("ingresa usuario válido y contraseña incorrecta")
    public void ingresarContrasenaincorrecta() {
        loginPage.login("standard_user", "incoorrecta");
    }

    @Then("se muestra un mensaje de error de credenciales inválidas")
    public void validarMensajeDeErrorContasenaincorrecta() {
        Assert.assertTrue(loginPage.getErrorMessage().contains("Username and password do not match"));
    }

    @When("el usuario intenta iniciar sesión sin credenciales")
    public void loginSinCredenciales() {
        loginPage.login("", "");
    }


    @Then("se muestra un mensaje de error de credenciales requeridas")
    public void validarCamposObligatorios() {
        Assert.assertTrue(loginPage.getErrorMessage().contains("Username is required"));
    }


}
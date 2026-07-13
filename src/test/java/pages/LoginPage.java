package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;
    private By usuario = By.id("user-name");
    private By contrasena = By.id("password");
    private By botonAcceso = By.id("login-button");
    private By mensajeError = By.cssSelector("[data-test='error']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openLoginPage() {
        driver.get("https://www.saucedemo.com/");
    }

    public void login(String use, String contr) {
        driver.findElement(usuario).clear();
        driver.findElement(usuario).sendKeys(use);

        driver.findElement(contrasena).clear();
        driver.findElement(contrasena).sendKeys(contr);

        driver.findElement(botonAcceso).click();
    }

    public String obtenerMensajeError() {
        return driver.findElement(mensajeError).getText();
    }
}
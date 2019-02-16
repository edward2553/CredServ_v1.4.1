/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Vehiculo {

    WebDriver driver;
    By NombreVehiculo = By.name("txtVehiculo");
    By ClicInsertarVehiculo = By.xpath("//*[@id=\"content\"]/div[2]/div/div/form/button");
    Servicios servicios = new Servicios(driver);
    By ClicParametrizacionesVehiculo = By.xpath("/html/body/div/nav/ul/li[1]/ul/li[4]/a");
    By ClicEditarVehiculo = By.xpath("//*[@id=\"content\"]/table/tbody/tr[6]/td[3]/button");
    By NombreVehiculoEditar = By.xpath("//*[@id=\"5\"]/div/div/div[2]/div[1]/div/input[2]");
    By ClicEditar = By.xpath("//*[@id=\"5\"]/div/div/div[2]/input");
    By ClicEliminarVehiculo = By.xpath("//*[@id=\"content\"]/table/tbody/tr[6]/td[2]/input");

    public Vehiculo(WebDriver driver) {
        this.driver = driver;
    }

    //Set vehiculo name in input
    public String getNombreServico() {
        WebElement webElement = driver.findElement(NombreVehiculo);
        return webElement.getText();
    }

    //Set vehiculo name in input
    public String getNombreServicioEditar() {
        WebElement webElement = driver.findElement(NombreVehiculoEditar);
        return webElement.getText();
    }

    //Clic in the button insert vehiculo
    public void ClicInsertarVehiculo() {
        WebElement webElement = driver.findElement(ClicInsertarVehiculo);
        webElement.click();
    }

    public void ClicEditarVehiculo() {
        WebElement webElement = driver.findElement(ClicEditarVehiculo);
        webElement.click();
    }

    public void ClicEditar() {
        WebElement webElement = driver.findElement(ClicEditar);
        webElement.click();
    }

    public void ClicEliminarVehiculo() {
        WebElement webElement = driver.findElement(ClicEliminarVehiculo);
        webElement.click();
    }

    public void InsertarVehiculo(String nombreVehiculo) {

        driver.findElement(servicios.ClicParametrizaciones).click();
        driver.findElement(ClicParametrizacionesVehiculo).click();
        driver.findElement(NombreVehiculo).sendKeys(nombreVehiculo);
        driver.findElement(ClicInsertarVehiculo).click();

    }

    public void EditarVehiculo(String nombreVehiculo) {

        driver.findElement(servicios.ClicParametrizaciones).click();
        driver.findElement(ClicParametrizacionesVehiculo).click();
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(ClicEditarVehiculo)).click();
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(NombreVehiculoEditar)).clear();
        driver.findElement(NombreVehiculoEditar).sendKeys(nombreVehiculo);
        driver.findElement(ClicEditar).click();

    }

    public void EliminarVehiculo() {

        driver.findElement(servicios.ClicParametrizaciones).click();
        driver.findElement(ClicParametrizacionesVehiculo).click();
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(ClicEliminarVehiculo)).click();

    }

}

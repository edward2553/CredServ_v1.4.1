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

public class Precio {

    WebDriver driver;

    Servicios servicios = new Servicios(driver);

    By SelectServicio = By.name("selectServicio");
    By SelectVehiculo = By.name("selectVehiculo");
    By InputPrecio = By.name("txtPrecio");
    By ClicParametrizarPrecio = By.xpath("/html/body/div/nav/ul/li[1]/ul/li[2]/a");
    By ClicPolichado = By.xpath("/html/body/div/div/div[1]/div[2]/div/form/select[1]/option[3]");
    By ClicLavado = By.xpath("/html/body/div/div/div[1]/div[2]/div/form/select[1]/option[2]");
    By ClicCampero = By.xpath("/html/body/div/div/div[1]/div[2]/div/form/select[2]/option[3]");
    By ClicInsertarPrecio = By.xpath("/html/body/div/div/div[1]/div[2]/div/form/button");
    By ClicEditarServicio = By.xpath("/html/body/div/div/div[2]/table/tbody/tr[2]/td[5]/button");
    By ClicEditar = By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div[2]/input");
    By ClicEditar2 = By.xpath("/html/body/div[1]/div/div[2]/div[1]/div/div/div[2]/input");
    By InputEditar = By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div[2]/div[2]/div/input");
    By InputEditar2 = By.xpath("/html/body/div[1]/div/div[2]/div[1]/div/div/div[2]/div[2]/div/input");
    By InputEditar3 = By.xpath("//*[@id=\"1\"]/div/div/div[2]/div[2]/div/input");
    By ClicEditarServicio2 = By.xpath("/html/body/div/div/div[2]/table/tbody/tr[3]/td[5]/button");
    By ClicEditarServicio3 = By.xpath("//*[@id=\"1\"]/div/div/div[2]/input");
    By EliminarPrecio = By.xpath("/html/body/div/div/div[2]/table/tbody/tr[3]/td[4]/input");
    By imputEditarEddy = By.xpath("//*[@id=\"content\"]/div[2]/table/tbody/tr[2]/td[5]/button");

    public Precio(WebDriver driver) {

        this.driver = driver;
    }

    //Set user name in textbox
    public void getSelectVehiculo() {
        WebElement webElement = driver.findElement(SelectVehiculo);
        webElement.click();

    }

    public void getSelectServicio() {
        WebElement webElement = driver.findElement(SelectServicio);
        webElement.click();

    }

    public void ClicPolichado() {
        WebElement webElement = driver.findElement(ClicPolichado);
        webElement.click();
    }

    public void ClicEditarServicio() {
        WebElement webElement = driver.findElement(ClicEditarServicio);
        webElement.click();
    }

    public void ClicEditar() {
        WebElement webElement = driver.findElement(ClicEditar);
        webElement.click();
    }

    public String getPrecio() {
        WebElement webElement = driver.findElement(InputPrecio);
        return webElement.getText();

    }

    public void ClicParametrizarPrecio() {
        WebElement webElement = driver.findElement(ClicParametrizarPrecio);
        webElement.click();
    }

    public void IngresarPrecio(String Precio) {
        driver.findElement(servicios.ClicParametrizaciones).click();
        driver.findElement(ClicParametrizarPrecio).click();
        driver.findElement(SelectServicio).click();
        driver.findElement(ClicLavado).click();
        driver.findElement(SelectVehiculo).click();
        driver.findElement(ClicCampero).click();
        driver.findElement(InputPrecio).sendKeys(Precio);
        driver.findElement(ClicInsertarPrecio).click();
    }

    public void IngresarPrecioMenorACero(String Precio) {
        driver.findElement(servicios.ClicParametrizaciones).click();
        driver.findElement(ClicParametrizarPrecio).click();
        driver.findElement(SelectServicio).click();
        driver.findElement(ClicPolichado).click();
        driver.findElement(SelectVehiculo).click();
        driver.findElement(ClicCampero).click();
        driver.findElement(InputPrecio).sendKeys(Precio);
        driver.findElement(ClicInsertarPrecio).click();
    }

    public void IngresarPrecioSinSelect(String Precio) {
        driver.findElement(servicios.ClicParametrizaciones).click();
        driver.findElement(ClicParametrizarPrecio).click();
        driver.findElement(InputPrecio).sendKeys(Precio);
        driver.findElement(ClicInsertarPrecio).click();
    }

    public void IngresarPrecioSelecServicio(String Precio) {
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(servicios.ClicParametrizaciones)).click();
        driver.findElement(ClicParametrizarPrecio).click();
        driver.findElement(SelectServicio).click();
        driver.findElement(ClicPolichado).click();
        driver.findElement(InputPrecio).sendKeys(Precio);
        driver.findElement(ClicInsertarPrecio).click();
    }

    public void IngresarPrecioSelecVehiculo(String Precio) {
        driver.findElement(servicios.ClicParametrizaciones).click();
        driver.findElement(ClicParametrizarPrecio).click();
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(SelectVehiculo)).click();
        driver.findElement(ClicCampero).click();
        driver.findElement(InputPrecio).sendKeys(Precio);
        driver.findElement(ClicInsertarPrecio).click();
    }

    public void EditarPrecioLimiInfe(String Precio) {
        driver.findElement(servicios.ClicParametrizaciones).click();
        driver.findElement(ClicParametrizarPrecio).click();
        driver.findElement(ClicEditarServicio).click();
        //acciones de esperar
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(InputEditar2)).clear();
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(InputEditar2)).sendKeys(Precio);
        driver.findElement(ClicEditar2).click();

    }

    public void EditarPrecio(String Precio) {
        driver.findElement(servicios.ClicParametrizaciones).click();
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(ClicParametrizarPrecio)).click();
        driver.findElement(imputEditarEddy).click();
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(InputEditar3)).clear();
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(InputEditar3)).sendKeys(Precio);
        driver.findElement(ClicEditarServicio3).click();

    }

    public void EliminarPrecio() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(servicios.ClicParametrizaciones)).click();
        driver.findElement(ClicParametrizarPrecio).click();
        driver.findElement(EliminarPrecio).click();

    }

}

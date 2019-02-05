/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Servicios {

    WebDriver driver;
    By NombreServicio = By.name("txtServicio");
    By ClicInsertarServicio = By.xpath("/html/body/div/div/div[2]/div/div/form/button");
    By ClicParametrizaciones = By.xpath("/html/body/div/nav/ul/li[1]/a");
    By ClicParametrizarServicio = By.xpath("/html/body/div/nav/ul/li[1]/ul/li[3]/a");
    By ClicEliminarServicio = By.xpath("/html/body/div/div/table/tbody/tr[7]/td[2]/input");
    By ClicButtonEditarServico = By.xpath("/html/body/div/div/table/tbody/tr[7]/td[3]/button");
    By ClicEditar = By.xpath("/html/body/div[1]/div/div[8]/div/div/div[2]/input");
    By NombreServicioEditar = By.xpath("/html/body/div[1]/div/div[8]/div/div/div[2]/div[1]/div/input[2]");

    public Servicios(WebDriver driver) {
        this.driver = driver;
    }

    //Set service name in input
    public String setNombreServicio() {
        WebElement webElement = driver.findElement(NombreServicio);
        return webElement.getText();
    }

    //Set service name in input edit
    public String setNombreServicioEditar() {
        WebElement webElement = driver.findElement(NombreServicioEditar);
        return webElement.getText();
    }

    //Clic in the button Insert service
    public void ClicInsertarServicio() {
        WebElement webElement = driver.findElement(ClicInsertarServicio);
        webElement.click();
    }

    public void ClicParametrizaciones() {

        driver.findElement(ClicParametrizaciones).click();
    }

    public void ClicParametrizarServicio() {

        driver.findElement(ClicParametrizarServicio).click();
    }

    public void ClicEliminarServicio() {

        driver.findElement(ClicEliminarServicio).click();
    }

    public void InsertarServicio(String nombreServicio) {
        driver.findElement(ClicParametrizaciones).click();
        driver.findElement(ClicParametrizarServicio).click();
        driver.findElement(NombreServicio).sendKeys(nombreServicio);
        driver.findElement(ClicInsertarServicio).click();

    }

    public void EditarServicio(String nombreServicio) {
        driver.findElement(ClicParametrizaciones).click();
        driver.findElement(ClicParametrizarServicio).click();
        driver.findElement(ClicButtonEditarServico).click();
        driver.findElement(NombreServicioEditar).clear();
        driver.findElement(NombreServicioEditar).sendKeys(nombreServicio);
        driver.findElement(ClicEditar).click();
        

    }

    public void EliminarServicio() {

        driver.findElement(ClicParametrizaciones).click();
        driver.findElement(ClicParametrizarServicio).click();
        driver.findElement(ClicEliminarServicio).click();

    }

}

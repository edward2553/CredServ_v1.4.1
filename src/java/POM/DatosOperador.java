/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author sebastian.arismendy
 */
public class DatosOperador {
     WebDriver driver;
     WebDriverWait wait;
     
    By urlParametrizacion = By.xpath("//*[@id=\"sidebar\"]/ul/li[1]/a"); 
    By urlOperadores = By.linkText("Parametrizar Operadores");
    By txtPrimerNombre = By.name("txtPrimerNombre");
    By txtSegundoNombre = By.name("txtSegundoNombre");
    By txtPrimerApellido = By.name("txtPrimerApellido");
    By txtSegundoApellido = By.name("txtSegundoApellido");
    By txtCedula = By.name("txtCedula");
    By txtEdad = By.name("txtEdad");
    By txtEmail = By.name("txtEmail");
    By txtClave = By.name("txtClave");
    By txtTel = By.name("txtTel");
    By txtDireccion = By.name("txtDireccion");
    By btnAgregarOperador = By.xpath("//*[@id=\"content\"]/div/div[2]/div/button");
    By btnAgregar = By.xpath("//*[@id=\"agregarOperador\"]/div/div/form/div[2]/button[1]");
    By btnEliminar = By.xpath("//*[@id=\"tbl-maestros\"]/tbody/tr[2]/td[11]/button");
    public DatosOperador(WebDriver driver) {
        this.driver = driver;
    }
    
   public void setNombres(String nombre1, String nombre2){
         driver.findElement(txtPrimerNombre).sendKeys(nombre1);
         driver.findElement(txtSegundoNombre).sendKeys(nombre2);
   }
   
    public void setApellidos(String apellido1, String apellido2){
        driver.findElement(txtPrimerApellido).sendKeys(apellido1);
         driver.findElement(txtSegundoApellido).sendKeys(apellido2);
   }
    
   public void setCedula(String cedula){
        driver.findElement(txtCedula).sendKeys(cedula);
   }
   public void setEdad(String edad){
        driver.findElement(txtEdad).sendKeys(edad);
   }
   public void setEmail(String email){
        driver.findElement(txtEmail).sendKeys(email);
   }
   public void setContraseña(String contraseña){
        driver.findElement(txtClave).sendKeys(contraseña);
   }
   public void setTelefono(String telefono){
        driver.findElement(txtTel).sendKeys(telefono);
   }
   public void setDirreción(String dirrecion){
        driver.findElement(txtDireccion).sendKeys(dirrecion);
   }
   
    public void clickParametrizarOperadores() {
        WebElement webElement = driver.findElement(urlParametrizacion);
        webElement.click();
        WebElement webElement2 = driver.findElement(urlOperadores);
        webElement2.click();
    }
    public void clickAgregarOperador() {
        WebElement webElement = driver.findElement(btnAgregarOperador);
        webElement.click();
    } 
     public void clickAgregar() {
        WebElement webElement = driver.findElement(btnAgregar);
        webElement.click();
    } 
    public void clickEliminar() {
        WebElement webElement = driver.findElement(btnEliminar);
        webElement.click();
    } 
    
}

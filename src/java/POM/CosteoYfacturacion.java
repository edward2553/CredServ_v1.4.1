/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POM;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;


public class CosteoYfacturacion {

    private WebDriver driver = null;
    private By turno = By.xpath("//*[@id=\"tbl-maestros\"]/tbody/tr[2]/td[1]/center");

    public CosteoYfacturacion(WebDriver driver) {

        this.driver = driver;
    }

    public boolean verificarDatos(String turno) {

        String turnoCosteo = driver.findElement(this.turno).getText();
        return turno.equalsIgnoreCase(turnoCosteo);

    }

    public void esperarporAlerta(WebDriver driver) throws InterruptedException {
        int i = 0;
        while (i++ < 5) {
            try {
                Alert alert = driver.switchTo().alert();
                break;
            } catch (NoAlertPresentException e) {
                Thread.sleep(1000);
                continue;
            }
        }
    }
}

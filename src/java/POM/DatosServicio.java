package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author edwar
 */
public class DatosServicio {

    WebDriver driver;
    private By txt_cedula = By.name("txtCedula");
    private By txt_nombre = By.name("txtNombre");
    private By txt_apellido = By.name("txtApellido");
    private By txt_placa = By.name("txt_placaAutomotor");
    private By txt_horaSalida = By.name("horaSalida");
    private By btn_ingresarCliente = By.name("btn_continuar");
    private By lblConfirmacion = By.id("msjConfirmacion");
    private By opcionAutomotor = By.xpath("//*[@id=\"myModal\"]/div/div/div[2]/div[1]/label/input");
    private By abrirAutomtor = By.xpath("//*[@id=\"content\"]/div/form/div[5]/div[2]/button");
    private By serivicio1 = By.xpath("//*[@id=\"modaServicios\"]/div/div/div[2]/div/input");
    private By listoUtomotor = By.xpath("//*[@id=\"myModal\"]/div/div/div[3]/button");
    private By abrirServicios = By.xpath("//*[@id=\"content\"]/div/form/div[5]/div[3]/button");
    private By listoServicio = By.xpath("//*[@id=\"modaServicios\"]/div/div/div[7]/button");
    private By turnoAlv = By.name("txtTurno");

    public DatosServicio(WebDriver driver) {

        this.driver = driver;
    }

    public String getTurno() {
        return driver.findElement(turnoAlv).getAttribute("value");
 
    }

    public void clickBtn_continuar() {
        WebElement webElement = driver.findElement(this.btn_ingresarCliente);
        webElement.click();
    }

    public void click_automotorYservicio() {
        driver.findElement(abrirAutomtor).click();
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(opcionAutomotor)).click();
        driver.findElement(listoUtomotor).click();
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(abrirServicios)).click(); 
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(serivicio1)).click();
        driver.findElement(listoServicio).click();
    }

    public String getNombre_Cliente() {
        WebElement webElement = driver.findElement(txt_nombre);
        return webElement.getText();
    }

    public String getApellido_Cliente() {
        WebElement webElement = driver.findElement(txt_apellido);
        return webElement.getText();
    }

    public String getPlaca_Cliente() {
        WebElement webElement = driver.findElement(txt_placa);
        return webElement.getText();
    }

    public String getHoraSalida_Cliente() {
        WebElement webElement = driver.findElement(txt_horaSalida);
        return webElement.getText();
    }

    public String getMensajeConfirmacion() {
        WebElement webElement = driver.findElement(lblConfirmacion);
        return webElement.getText();
    }

    public void SetCedula(String cedula) {
        driver.findElement(txt_cedula).sendKeys(cedula);

    }

    public void setHoraSalida(String horaSalida) {
        driver.findElement(this.txt_horaSalida).sendKeys(horaSalida);

    }

    public void SetApellido(String apellido) {
        driver.findElement(txt_apellido).sendKeys(apellido);

    }

    public void setNombre(String nombre) {

        driver.findElement(txt_nombre).sendKeys(nombre);
    }

    public void setPlaca(String placa) {

        driver.findElement(txt_placa).sendKeys(placa);
    }

}

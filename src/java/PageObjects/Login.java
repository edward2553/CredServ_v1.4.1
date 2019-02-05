package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 *
 * @author edwar
 */
public class Login {

    WebDriver driver;
    By email = By.name("txtEmail");
    By password = By.name("txtClave");
    By btn_entrar = By.name("btn_login");
    By txt_errorDatos = By.id("mensajeError");
    
    public String txt_error;

    public Login(WebDriver driver) {

        this.driver = driver;
    }

    //Set user name in textbox
    public void setEmail(String email) {

        driver.findElement(this.email).sendKeys(email);

    }
    
    //Set password in password textbox

    public void setContrasena(String strPassword){

         driver.findElement(password).sendKeys(strPassword);

    }
    
    // hacer click en entrar
        public void clickLogin(){

            driver.findElement(btn_entrar).click();
            
 
    }  
        
        public boolean mensajeDeError(){
            WebElement webElement = driver.findElement(txt_errorDatos); 
            txt_error = webElement.getText();
            
            switch (txt_error) {
                    case "Datos Incorrectos" :
                        return true;                       
            }            
            return false;
        }
        
        public void loginApplication(String email, String contra){

        //Fill user name

        this.setEmail(email);

        //Fill password

        this.setContrasena(contra);

        //Click Login button

        this.clickLogin();
        

    }
        
        

}

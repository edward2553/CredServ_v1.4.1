/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prm_vehiculo;

import PageObjects.Vehiculo;
import com.credserv.entidades.EntidadVehiculo;
import com.credserv.persistencia.ServiciosParametrizacionesDAO;
import com.credserv.utilidades.camposDebug;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author crist
 */
public class vehiculos_JUnit {

    ServiciosParametrizacionesDAO dao = new ServiciosParametrizacionesDAO();
    EntidadVehiculo EntVehiculo;
    String InsertVehiculo = "BICICLETA";
    String EditarVehiculo = "MOTO";
    camposDebug obj_servicio = new camposDebug();
    int idVehiculo;

    public vehiculos_JUnit() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Prueba de que el vehiculo existe, poniendo el nombre de servicio en
     * Mayuscula
     */
    @Test
    public void testExisteVehiculoMAYUS() {
        System.out.println("existeVehiculoMayus");

        String vehiculo = "BUS";

        EntVehiculo = new EntidadVehiculo(vehiculo);
        boolean validar2 = dao.existeVehiculo(EntVehiculo);

        boolean validar = true;

        assertEquals(validar, validar2);
    }

    /**
     * Prueba de que el vehiculo existe, poniendo el nombre de servicio en
     * Minuscula
     */
    @Test
    public void testExisteVehiculoMINUS() {
        System.out.println("existeVehiculoMinus");

        String vehiculo = "bus";

        EntVehiculo = new EntidadVehiculo(vehiculo.toUpperCase());
        boolean validar2 = dao.existeVehiculo(EntVehiculo);

        boolean validar = true;

        assertEquals(validar, validar2);
    }

    /**
     * Prueba de insertar un servicio poniendo en campo nombre servicio
     * caracteres extraños
     */
    @Test
    public void testInsertarVehiculoCaractExtraños() {
        System.out.println("insertarVehiculoCaracExtraños");

        String caracRaros = "*";
        int h = 0;

        boolean validar = obj_servicio.caracteresRaros(caracRaros.toCharArray(), h);
        boolean validar2 = true;

        assertEquals(validar2, validar);

    }

    /**
     * Prueba de insertar un servicio, poniendo en campo servicio espacios en
     * blanco
     */
    @Test
    public void testInsertarVehiculoEspaciosBlanco() {
        System.out.println("insertarVehiculoEspacBlanco");

        String espcBlanco = "  ";

        boolean validar = obj_servicio.espacioBlanco(espcBlanco);
        boolean validar2 = true;

        assertEquals(validar2, validar);

    }

    /**
     * Prueba de insertar un servicio, poniendo en campo servicio numeros
     */
    @Test
    public void testInsertarVehiculoNumeros() {
        System.out.println("insertarVehiculoNumeros");

        int servicio = 1;

        boolean validar = obj_servicio.espacioBlanco(Integer.toString(servicio));
        boolean validar2 = false;

        assertEquals(validar2, validar);

    }

    /**
     * Prueba de insertar un vehiculo, el método es int para que nos retorne el
     * id del servicio y en la clase de ServicioJUnit lo guardamos en una
     * variable para así utilizarla para borrar y editar un servicio.
     */
    @Test
    public int testInsertarServicio() {
        System.out.println("insertarServicio");

        EntVehiculo = new EntidadVehiculo(InsertVehiculo);

        boolean validar = dao.insertarVehiculo(EntVehiculo);
        idVehiculo = dao.BuscarVehiculoTEST(InsertVehiculo);

        boolean validar2 = true;

        assertEquals(validar2, validar);

        return idVehiculo;

    }

    /**
     * Prueba para editar un vehiculo
     */
    @Test
    public void testEditarVehiculo(int vehiculo) {
        System.out.println("EditarServicio");

        EntVehiculo = new EntidadVehiculo(EditarVehiculo, vehiculo);
        boolean validar = dao.EditarVehiculo(EntVehiculo);
        boolean validar2 = true;

        assertEquals(validar2, validar);
    }

    /**
     * Prueba de Eliminar un vehiculo por ID
     */
    @Test
    public void testEliminarVehiculo(int vehiculo) {
        System.out.println("EliminarServicios");

        boolean validar = dao.EliminarVehiculos(vehiculo);
        boolean validar2 = true;

        assertEquals(validar, validar2);
    }

    public void TestAutomatizadaInsertarVehiculo(WebDriver driver) {
        Vehiculo vehiculo = new Vehiculo(driver);

        vehiculo.InsertarVehiculo(InsertVehiculo);

    }

    public void TestAutomatizadaEditarVehiculo(WebDriver driver) {

        Vehiculo vehiculo = new Vehiculo(driver);

        vehiculo.EditarVehiculo(EditarVehiculo);

    }
}

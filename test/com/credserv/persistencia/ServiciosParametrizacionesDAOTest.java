/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.credserv.persistencia;

import PageObjects.Login;
import PageObjects.Servicios;
import com.credserv.entidades.EntidadServicio;
import com.credserv.entidades.EntidadServiciosServiteca;
import com.credserv.entidades.EntidadVehiculo;
import com.credserv.utilidades.camposDebug;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 *
 * @author crist
 */
public class ServiciosParametrizacionesDAOTest {

    ServiciosParametrizacionesDAO dao = new ServiciosParametrizacionesDAO();
    EntidadServicio Entservicio;
    String InsertServicio = "CAMBIO DE MOTOR";
    String EditarServicio = "CAMBIO DE VOLANTE";
    camposDebug obj_servicio = new camposDebug();
    int idServicio;

    public ServiciosParametrizacionesDAOTest() {
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
     * Prueba de que el servicio existe, poniendo el nombre de servicio en
     * Mayuscula
     */
    @Test
    public void testExisteServicioMAYUS() {
        System.out.println("existeServicio");

        String servicio = "LAVADO";

        Entservicio = new EntidadServicio(servicio);
        boolean validar2 = dao.existeServicio(Entservicio);

        boolean validar = true;

        assertEquals(validar, validar2);
    }

    /**
     * Prueba de que el servicio existe, poniendo el nombre de servicio en
     * Minuscula
     */
    @Test
    public void testExisteServicioMinuscula() {
        System.out.println("existeServicio");

        String servicio = "lavado";

        Entservicio = new EntidadServicio(servicio.toUpperCase());
        boolean validar2 = dao.existeServicio(Entservicio);

        boolean validar = true;

        assertEquals(validar, validar2);
    }

    /**
     * Prueba de insertar un servicio poniendo en campo nombre servicio
     * caracteres extraños
     */
    @Test
    public void testInsertarServicioCaractExtraños() {
        System.out.println("insertarServicioCaracExtraños");

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
    public void testInsertarServicioEspaciosBlanco() {
        System.out.println("insertarServicioEspacBlanco");

        String espcBlanco = "  ";

        boolean validar = obj_servicio.espacioBlanco(espcBlanco);
        boolean validar2 = true;

        assertEquals(validar2, validar);

    }

    /**
     * Prueba de insertar un servicio, poniendo en campo servicio numeros
     */
    @Test
    public void testInsertarServicioNumeros() {
        System.out.println("insertarServicioNumeros");

        int servicio = 1;

        boolean validar = obj_servicio.espacioBlanco(Integer.toString(servicio));
        boolean validar2 = false;

        assertEquals(validar2, validar);

    }

    /**
     * Prueba de insertar un servicio, el método es int para que nos retorne el
     * id del servicio y en la clase de ServicioJUnit lo guardamos en una
     * variable para así utilizarla para borrar y editar un servicio.
     */
    @Test
    public int testInsertarServicio() {
        System.out.println("insertarServicio");

        Entservicio = new EntidadServicio(InsertServicio.toUpperCase());

        boolean validar = dao.insertarServicio(Entservicio);
        idServicio = dao.BuscarServicioTEST(InsertServicio);

        boolean validar2 = true;

        assertEquals(validar2, validar);

        return idServicio;

    }

    /**
     * Prueba para editar un servicio
     */
    @Test
    public void testEditarServicio(int servicio) {
        System.out.println("EditarServicio");

        Entservicio = new EntidadServicio(EditarServicio, servicio);
        boolean validar = dao.EditarServicio(Entservicio);
        boolean validar2 = true;

        assertEquals(validar2, validar);
    }

    /**
     * Prueba de Eliminar un servicio por ID
     */
    @Test
    public void testEliminarServicios(int servicio) {
        System.out.println("EliminarServicios");

        boolean validar = dao.EliminarServicios(servicio);
        boolean validar2 = true;

        assertEquals(validar, validar2);
    }

    public void TestAutomatizadaInsertarServicio(WebDriver driver) {
        Servicios servicios = new Servicios(driver);

        servicios.InsertarServicio(InsertServicio);

    }

    public void TestAutomatizadaEditarServicio(WebDriver driver) {

        Servicios servicios = new Servicios(driver);

        servicios.EditarServicio(EditarServicio);

    }

}

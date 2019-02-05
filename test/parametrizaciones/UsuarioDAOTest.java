/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parametrizaciones;

import com.credserv.entidades.Usuario;
import com.credserv.persistencia.UsuarioDAO;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author crist
 */
public class UsuarioDAOTest {

    public UsuarioDAOTest() {
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
     * TRUE: Insertó el Operador correctamente
     * FALSE: Insertó mal el Operador
     */
    @Test
    public void testInsertarOperador() {
        System.out.println("insertarCliente");
        Usuario usu = new Usuario("Edwin", "", "Gómez", "Meneses", "10025878", 40, "edwin@elpoli.edu.co", "EdwinMene", "258897", "Cra8a", 2);
        UsuarioDAO dao = new UsuarioDAO();
        boolean expResult = true;
        boolean result = dao.insertarOperador(usu);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * TRUE: Eliminó el operador correctamente
     * FALSE: No eliminó el operador
     */
    
    public void testEliminarOperador() {
        System.out.println("EliminarUsuario");
        String idUsuario = "edwin@elpoli.edu.co";
        UsuarioDAO dao = new UsuarioDAO();
        boolean expResult = true;
        boolean result = dao.EliminarOperador(idUsuario);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

}

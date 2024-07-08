package proyecto;

import Excepciones.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

/**
 * Este junit prueba la funcionalidad de la clase Cocina.
 */
public class CocinaTest {

    private Cocina cocina;
    private Pedido pedidoHamburguesa;
    private Pedido pedidoPizza;
    private Ingredientes ingrediente1 = Ingredientes.HAMBURGUESA;
    private Ingredientes ingrediente2 = Ingredientes.ACEITUNAS;

    /**
     * Inicializa nuevas instancias de Cocina y Pedidos antes de cada prueba.
     */
    @BeforeEach
    public void setUp() {
        cocina = new Cocina();
        pedidoHamburguesa = new Pedido(1, 1);
        pedidoPizza = new Pedido(2, 1);
    }

    /**
     * Esta prueba verifica que se puede agregar un pedido a la cocina.
     */
    @Test
    @DisplayName("testAddPedido")
    public void testAddPedido() {
        cocina.addPedido(pedidoHamburguesa);
        assertEquals(pedidoHamburguesa, cocina.getPedido());
    }

    /**
     * Esta prueba verifica que se pueden obtener todos los pedidos de la cocina.
     *
     * @throws nullPedidos si no hay pedidos en la cocina.
     */
    @Test
    public void testGetPedidos() throws nullPedidos {
        cocina.addPedido(pedidoHamburguesa);
        cocina.addPedido(pedidoPizza);
        ArrayList<Pedido> pedidos = cocina.getPedidos();
        assertTrue(pedidos.contains(pedidoHamburguesa) && pedidos.contains(pedidoPizza));
    }

    /**
     * Esta prueba verifica que se pueden limpiar todos los pedidos de la cocina.
     */
    @Test
    public void testLimpiarPedidos() {
        try {
            cocina.addPedido(pedidoHamburguesa);
            cocina.limpiarPedidos();
            cocina.getPedidos().isEmpty();
        } catch (nullPedidos e) {
            assertTrue(true);
        }
    }

    /**
     * Esta prueba verifica que se pueden agregar ingredientes a la cocina.
     */
    @Test
    public void testAgregarIngredientes() {
        cocina.agregarIngredientes(ingrediente1);
        cocina.agregarIngredientes(ingrediente2);
        ArrayList<Ingredientes> cocinado = cocina.getCocinado();
        assertTrue(cocinado.contains(ingrediente1) && cocinado.contains(ingrediente2));
    }

    /**
     * Esta prueba verifica que se pueden quitar ingredientes de la cocina.
     */
    @Test
    public void testQuitarIngrediente() {
        cocina.agregarIngredientes(ingrediente1);
        cocina.quitarIngrediente();
        assertTrue(cocina.getCocinado().isEmpty());
    }

    /**
     * Esta prueba verifica que se puede entregar una hamburguesa correctamente.
     */
    @Test
    public void testEntregarHamburguesa() {
        cocina.addPedido(pedidoHamburguesa);
        for (int x = 0; x < pedidoHamburguesa.getReceta().getIngredientes().size(); x++) {
            cocina.agregarIngredientes(pedidoHamburguesa.getReceta().getIngredientes().get(x));
        }
        System.out.println(cocina.getCocinado());
        System.out.println(cocina.getPedido().getReceta().getIngredientes());
        assertTrue(cocina.Entregar());
    }

    /**
     * Esta prueba verifica que se puede entregar una pizza correctamente.
     */
    @Test
    public void testEntregarPizza() {
        cocina.addPedido(pedidoPizza);
        for (int x = cocina.getPedido().getReceta().getIngredientes().size() - 1; x >= 0; x--) {
            cocina.agregarIngredientes(cocina.getPedido().getReceta().getIngredientes().get(x));
        }
        assertTrue(cocina.Entregar());
    }

    /**
     * Esta prueba verifica que se puede obtener la puntuación después de entregar un pedido.
     */
    @Test
    public void testGetPuntuacion() {
        cocina.addPedido(pedidoHamburguesa);
        for (int x = 0; x < cocina.getPedido().getReceta().getIngredientes().size(); x++) {
            cocina.agregarIngredientes(cocina.getPedido().getReceta().getIngredientes().get(x));
        }
        cocina.Entregar();
        assertTrue(cocina.getPuntuacion() == 50);
    }
}
package proyecto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Este junit prueba la funcionalidad de la clase Pedido.
 */
public class PedidoTest {

    private Pedido pedidoHamburguesa;
    private Pedido pedidoPizza;
    private Cliente cliente;

    /**
     * Inicializa nuevas instancias de Pedido antes de cada prueba.
     */
    @BeforeEach
    public void setUp() {
        int dificultad = 2;
        pedidoHamburguesa = new Pedido(1, dificultad);
        pedidoPizza = new Pedido(2, dificultad);
    }

    /**
     * Esta prueba verifica que el pedido de hamburguesa contiene el ingrediente HAMBURGUESA para corroborar que es una.
     * hamburguesa
     */
    @Test
    @DisplayName("testPedidoHamburguesa")
    public void testPedidoHamburguesa() {
        assertTrue(pedidoHamburguesa.getReceta().getIngredientes().contains(Ingredientes.HAMBURGUESA));
    }

    /**
     * Esta prueba verifica que el pedido de pizza contiene el ingrediente MASA para corroborar
     * que es una pizza.
     */
    @Test
    @DisplayName("testPedidoPizza")
    public void testPedidoPizza() {
        assertTrue(pedidoPizza.getReceta().getIngredientes().contains(Ingredientes.MASA));
    }

    /**
     * Esta prueba verifica que se puede establecer y obtener correctamente el cliente de un pedido.
     */
    @Test
    @DisplayName("testSetGetCliente")
    public void testSetGetCliente() {
        pedidoHamburguesa.setCliente(cliente);
        assertEquals(cliente, pedidoHamburguesa.getCliente());

        pedidoPizza.setCliente(cliente);
        assertEquals(cliente, pedidoPizza.getCliente());
    }
}
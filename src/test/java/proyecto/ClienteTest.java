package proyecto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Este junit prueba la funcionalidad de la clase Cliente.
 */
public class ClienteTest {
    private Cliente cliente;

    /**
     * Inicializa una nueva instancia de Cliente antes de cada prueba.
     */
    @BeforeEach
    public void setUp() {
        cliente = new Cliente(1);
    }

    /**
     * Esta prueba verifica que el cliente tiene un pedido no nulo.
     */
    @Test
    public void testGetPedido() {
        assertTrue(cliente.getPedido() != null);
    }

    /**
     * Esta prueba verifica que el pedido del cliente se establece en null
     * después de que el cliente ha comido.
     */
    @Test
    public void testClienteComiendo() {
        cliente.clienteComiendo();
        assertNull(cliente.getPedido());
    }
}
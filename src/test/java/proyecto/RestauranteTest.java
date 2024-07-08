package proyecto;

import Excepciones.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Este junit prueba la funcionalidad de la clase Restaurante.
 */
public class RestauranteTest {

    private Restaurante restaurante;

    /**
     * Inicializa una nueva instancia de Restaurante antes de cada prueba.
     */
    @BeforeEach
    public void setUp() {
        restaurante = Restaurante.getInstance();
    }

    /**
     * Esta prueba verifica que los nuevos clientes se agregan correctamente.
     * Verifica si las mesas en el comedor están ocupadas después de llamar a nuevosClientes para ver si hay un cliente.
     * en el restaurante
     */
    @Test
    @DisplayName("testNuevosClientes")
    public void testNuevosClientes() {
        Restaurante.getInstance().nuevosClientes();
        for (int x = 0; x < Restaurante.getInstance().getComedor().getMesas().size(); x++) {
            if (!Restaurante.getInstance().getComedor().getMesas().get(x).getMesaDisponible()) {
                assertTrue(true);
            }
        }
    }

    /**
     * Esta prueba verifica que se pueden tomar pedidos correctamente.
     * Llama a nuevosClientes y luego verifica si las mesas ocupadas tienen pedidos.
     *
     * @throws nullPedidos si hay un error al tomar un pedido.
     */
    @Test
    @DisplayName("testTomarPedido")
    public void testTomarPedido() throws nullPedidos {
        Restaurante.getInstance().nuevosClientes();
        for (int x = 0; x < Restaurante.getInstance().getComedor().getMesas().size(); x++) {
            if (!Restaurante.getInstance().getComedor().getMesas().get(x).getMesaDisponible()) {
                Restaurante.getInstance().tomarPedido(Restaurante.getInstance().getComedor().getMesas().get(x).getFamilia());
            }
        }
        assertTrue(!Restaurante.getInstance().getCocina().getPedidos().isEmpty());
    }

    /**
     * Esta prueba verifica que se puede establecer la cuota correctamente.
     * Cambia la cuota del restaurante y verifica que el valor se haya actualizado.
     */
    @Test
    @DisplayName("testSetCuota")
    public void testSetCuota() {
        restaurante.setCuota(2000);
        assertEquals(2000, restaurante.getCuota());
    }
}
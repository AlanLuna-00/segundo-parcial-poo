package mvc.controller;

import mvc.dto.AutoDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class AutoControllerTest {

    private AutoController autoController;

    @BeforeEach
    public void setUp() {
        autoController = AutoController.getInstance();
    }

    @Test
    public void testCrearAutoDeportivo() throws Exception {
        AutoDTO autoDeportivo = new AutoDTO("ABC123", "Deportivo Modelo X", 2, 10.0f, 5.0f);

        AutoDTO result = autoController.crearAuto(autoDeportivo);
        assertNotNull(result);
        assertEquals("ABC123", result.getPatente());
        assertEquals(5.0f, result.getPrecioAdicional());
        System.out.println("Auto deportivo creado: " + result);
    }

    @Test
    public void testCrearAutoSedan() throws Exception {
        AutoDTO autoSedan = new AutoDTO("XYZ789", "Sedan Modelo Y", 4, 8.0f);

        AutoDTO result = autoController.crearAuto(autoSedan);
        assertNotNull(result);
        assertEquals("XYZ789", result.getPatente());
        assertNull(result.getPrecioAdicional());
        System.out.println("Auto sedan creado: " + result);
    }

    @Test
    public void testCrearAutoConPatenteExistente() {
        AutoDTO autoDeportivo = new AutoDTO("DUP123", "Deportivo Z", 2, 15.0f, 7.0f);

        try {
            autoController.crearAuto(autoDeportivo);
            Exception exception = assertThrows(Exception.class, () -> autoController.crearAuto(autoDeportivo));
            assertEquals("Ya existe un auto con esa patente en el sistema.", exception.getMessage());
            System.out.println("Error al crear el auto: " + exception.getMessage());
        } catch (Exception e) {
            fail("Error al crear el auto: " + e.getMessage());
        }
    }

    @Test
    public void testBuscarAutoExistente() throws Exception {
        AutoDTO autoDeportivo = new AutoDTO("DEF456", "Deportivo A", 2, 12.0f, 6.0f);
        autoController.crearAuto(autoDeportivo);

        Optional<AutoDTO> result = autoController.buscarAuto("DEF456");
        assertTrue(result.isPresent());
        assertEquals("DEF456", result.get().getPatente());
        System.out.println("Auto deportivo encontrado: " + result.get());
    }

    @Test
    public void testBuscarAutoInexistente() {
        Optional<AutoDTO> result = autoController.buscarAuto("NO_EXISTE");
        assertFalse(result.isPresent());
        System.out.println("Auto no encontrado.");
    }
}

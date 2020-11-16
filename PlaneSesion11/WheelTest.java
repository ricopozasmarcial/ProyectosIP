
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class WheelTest.
 *
 * @author  MARCIAL RICO POZAS
 * @version 28/10/2017
 */
public class WheelTest
{
    /**
     * Default constructor for test class WheelTest
     */
    public WheelTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    /**
     * metodo de prueba de test()
     * 
     */
    @Test
    public void testTest()
    {
        //QUE EL VALOR DE LA PRESIÓN SEA INFERIOR A LA MÁXIMA Y VALIDE LA CONDICION IF
        Wheel wheel1 = new Wheel(Wheel.DEF_MAX_PRESSURE, Wheel.DEF_PRESSURE);
        assertEquals(Wheel.DEF_MAX_PRESSURE,wheel1.getMaxPressure(),0.1);
        assertEquals(Wheel.DEF_PRESSURE,wheel1.getPressure(),0.1);
        assertEquals(true,wheel1.test());

        //QUE EL VALOR DE LA PRESION SEA INFERIOR A LA MÁXIMA PERO NO VALIDE LA CONDICION IF
        wheel1 = new Wheel(Wheel.DEF_MAX_PRESSURE, 600.0);
        assertEquals(Wheel.DEF_MAX_PRESSURE,wheel1.getMaxPressure(),0.1);
        assertEquals(600.0,wheel1.getPressure(),0.1);
        assertEquals(false,wheel1.test());

        //QUE EL VALOR DE LA PRESIÓN SEA MAYOR A LA MAXIMA
        wheel1 = new Wheel(Wheel.DEF_MAX_PRESSURE, 1600.0);
        assertEquals(Wheel.DEF_MAX_PRESSURE,wheel1.getMaxPressure(),0.1);
        assertEquals(0.0,wheel1.getPressure(),0.1);
        assertEquals(false,wheel1.test());

        //QUE EL VALOR DE LA PRESIÓN SEA IGUAL AL MÍNIMO VALOR PARA EL QUE SE VALIDA LA CONDICIÓN
        wheel1 = new Wheel(Wheel.DEF_MAX_PRESSURE, 850.0);
        assertEquals(Wheel.DEF_MAX_PRESSURE,wheel1.getMaxPressure(),0.1);
        assertEquals(850.0,wheel1.getPressure(),0.1);
        assertEquals(true,wheel1.test());
    }

}

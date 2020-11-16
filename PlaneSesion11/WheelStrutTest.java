
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class WheelStrutTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class WheelStrutTest
{
    /**
     * Default constructor for test class WheelStrutTest
     */
    public WheelStrutTest()
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
     */
    @Test
    public void testTest()
    {
        //caso en el que ambas presiones sean correctas
        WheelStrut wheelStrut1 = new WheelStrut();
        wheelStrut1.test();
        assertTrue(wheelStrut1.test());
        assertTrue(wheelStrut1.getLeftWheel().test());
        assertTrue(wheelStrut1.getRightWheel().test());

        //caso en el que una rueda no sea válida
        Wheel wheel1 = new Wheel(Wheel.DEF_MAX_PRESSURE, Wheel.MIN_PRESSURE);
        Wheel wheel2 = new Wheel(WheelStrut.DEF_MAX_PRESSURE, WheelStrut.DEF_PRESSURE);
        wheelStrut1 = new WheelStrut(WheelStrut.DEF_DEPLOYED, wheel1, wheel2);
        wheelStrut1.test();
        assertFalse(wheelStrut1.test());
        assertFalse(wheel1.test());
        assertTrue(wheel2.test());

        //caso en el que ambas ruedas no sean validas
        wheel1 = new Wheel(Wheel.DEF_MAX_PRESSURE, Wheel.MIN_PRESSURE);
        wheel2 = new Wheel(Wheel.DEF_MAX_PRESSURE, Wheel.MIN_PRESSURE);
        wheelStrut1 = new WheelStrut(WheelStrut.DEF_DEPLOYED, wheel1, wheel2);
        wheelStrut1.test();
        assertFalse(wheelStrut1.test());
        assertFalse(wheel1.test());
        assertFalse(wheel2.test());

    }
}

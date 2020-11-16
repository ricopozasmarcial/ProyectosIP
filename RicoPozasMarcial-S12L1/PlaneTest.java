
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class PlaneTest.
 *
 * @author  MARCIAL RICO
 * @version 17/10/2017
 */
public class PlaneTest
{
    /**
     * Default constructor for test class PlaneTest
     */
    public PlaneTest()
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
     * metodo de prueba para toString
     */
    @Test
    public void testToString()
    {
        //CASO EN EL NO QUE HAYA PILOTO
        Plane plane1 = new Plane(null,Plane.DEFAULT_IDENTIFIER, Plane.DEFAULT_FUEL);
        assertEquals(null,plane1.getPilot());
        assertEquals(plane1.DEFAULT_FUEL,plane1.getFuel());
        assertEquals(plane1.DEFAULT_IDENTIFIER,plane1.getIdentifier());
        assertEquals(plane1.getIdentifier() + " - " + plane1.getFuel() + " - " + "(" + plane1.getXPos() + "," + plane1.getYPos() + ")" + "(" + plane1.getXSpeed() + "," + plane1.getYSpeed() + ")" + "NO PILOT",plane1.toString());

        //CASO EN EL QUE HAYA PILOTO
        plane1 = new Plane(Plane.DEFAULT_PILOT,Plane.DEFAULT_IDENTIFIER, Plane.DEFAULT_FUEL);
        assertEquals(Plane.DEFAULT_PILOT,plane1.getPilot());
        assertEquals(plane1.DEFAULT_FUEL,plane1.getFuel());
        assertEquals(plane1.DEFAULT_IDENTIFIER,plane1.getIdentifier());
        assertEquals(plane1.getIdentifier() + " - " + plane1.getFuel() + " - " + "(" + plane1.getXPos() + "," + plane1.getYPos() + ")" + "(" + plane1.getXSpeed() + "," + plane1.getYSpeed() + ")" + plane1.getPilot().getHashCode(),plane1.toString());

    }

    /**
     * metodo de prueba para getMaxLoad
     */
    //@Test
    //public void testGetMaxLoad()
    //{
    //caso en el que todo este correcto y haya un número correcto de motores, combustible y pasajeros
    //Plane plane1 = new Plane(Plane.DEFAULT_IDENTIFIER, Plane.MAX_FUEL, Plane.MAX_NUMBER_ENGINES);
    //assertEquals('A', plane1.getIdentifier());
    //assertEquals(5000, plane1.getFuel());
    //assertEquals(8, plane1.getNumberOfEngines());
    //assertEquals(27000,plane1.getMaxLoad(100));

    //caso en el que haya un dato incorrecto 
    //plane1 = new Plane(Plane.DEFAULT_IDENTIFIER, 15000, Plane.MAX_NUMBER_ENGINES);
    //assertEquals('A', plane1.getIdentifier());
    //assertEquals(0, plane1.getFuel());
    //assertEquals(8, plane1.getNumberOfEngines());
    //assertEquals(000,plane1.getMaxLoad(100));

    //caso en el que se exceda el número de pasajeros
    //plane1 = new Plane(Plane.DEFAULT_IDENTIFIER, Plane.MAX_FUEL, Plane.MAX_NUMBER_ENGINES);
    //assertEquals('A', plane1.getIdentifier());
    //assertEquals(5000, plane1.getFuel());
    //assertEquals(8, plane1.getNumberOfEngines());
    //assertEquals(-1,plane1.getMaxLoad(1452));

    //caso en el que el número de pasajeros sea negativo
    //plane1 = new Plane(Plane.DEFAULT_IDENTIFIER, Plane.MAX_FUEL, Plane.MAX_NUMBER_ENGINES);
    //assertEquals('A', plane1.getIdentifier());
    //assertEquals(5000, plane1.getFuel());
    //assertEquals(8, plane1.getNumberOfEngines());
    //assertEquals(-1,plane1.getMaxLoad(-89544));
    //}

    /**
     * metodo de prueba para getNumberOfEngines
     */
    //@Test
    // void testGetNumberOfEngines()
    //{
    //numero valido de motores
    //Plane plane1 = new Plane(Plane.DEFAULT_IDENTIFIER, Plane.MAX_FUEL, Plane.MAX_NUMBER_ENGINES);
    //assertEquals(8, plane1.getNumberOfEngines());

    //número invalido de motores
    //plane1 = new Plane(Plane.DEFAULT_IDENTIFIER, Plane.MAX_FUEL, 0 );
    //assertEquals(0, plane1.getNumberOfEngines());

    //}

    /**
     * metodo de prueba para getXSpeed
     *
     */
    @Test
    public void testGetXSpeed()
    {
        //caso 1: ambas velocidades están en rangos válidos. en este caso ambos en su valor mínimo
        Plane plane1 = new Plane(Plane.DEFAULT_PILOT, Plane.DEFAULT_IDENTIFIER, Plane.DEFAULT_FUEL, Plane.MIN_X, Plane.MIN_Y, Plane.MIN_SPEED_Y, Plane.MIN_SPEED_X);
        assertEquals(-1, plane1.getXSpeed());

        //caso 2: ambas velocidades están en rangos válidos, en este caso en su valor máximo
        plane1 = new Plane(Plane.DEFAULT_PILOT, Plane.DEFAULT_IDENTIFIER, Plane.DEFAULT_FUEL,Plane.MIN_X, Plane.MIN_Y, Plane.MAX_SPEED_Y, Plane.MAX_SPEED_X);
        assertEquals(1, plane1.getXSpeed());

        //caso 3: alguna de las velocidades está en un rango invalido, en este caso xSpeed
        plane1  = new Plane(Plane.DEFAULT_PILOT, Plane.DEFAULT_IDENTIFIER, Plane.DEFAULT_FUEL,Plane.MIN_X, Plane.MIN_Y, Plane.MAX_SPEED_Y,78);
        assertEquals(-1, plane1.getXSpeed());

    }

    /**
     * metodo de prueba para getYSpeed
     *
     */
    @Test
    public void testGetYSpeed()
    {
        //caso 1: ambas velocidades están en rangos válidos. en este caso ambos en su valor mínimo
        Plane plane1 =new Plane(Plane.DEFAULT_PILOT, Plane.DEFAULT_IDENTIFIER, Plane.DEFAULT_FUEL,Plane.MIN_X, Plane.MIN_Y, Plane.MIN_SPEED_Y, Plane.MIN_SPEED_X);
        assertEquals(-1, plane1.getYSpeed());

        //caso 2: ambas velocidades están en rangos válidos, en este caso en su valor máximo
        plane1 = new Plane(Plane.DEFAULT_PILOT, Plane.DEFAULT_IDENTIFIER, Plane.DEFAULT_FUEL,Plane.MIN_X, Plane.MIN_Y, Plane.MAX_SPEED_Y, Plane.MAX_SPEED_X);
        assertEquals(1, plane1.getYSpeed());

        //caso 3: alguna de las velocidades está en un rango invalido, en este caso ySpeed
        plane1 = new Plane(Plane.DEFAULT_PILOT, Plane.DEFAULT_IDENTIFIER, Plane.DEFAULT_FUEL,Plane.MIN_X, Plane.MIN_Y, 87,Plane.MIN_SPEED_X);
        assertEquals(-1, plane1.getYSpeed());

    }

    /**
     * metodo de prueba de fly
     * 
     */
    @Test
    public void testFly()
    {
        //caso en el que el avión vuele y los valores de xPos e yPos no esten en los límites
        Plane plane1 = new Plane(Plane.DEFAULT_PILOT, Plane.DEFAULT_IDENTIFIER, Plane.MAX_FUEL, 5, 5, Plane.MAX_SPEED_Y, Plane.MAX_SPEED_X);
        assertTrue(plane1.fly());
        assertEquals(4999, plane1.getFuel());
        assertEquals(6, plane1.getYPos());
        assertEquals(6, plane1.getXPos());

        //caso en que el avion vuele pero el valor de xPos este en el límite inferior
        plane1 = new Plane(Plane.DEFAULT_PILOT, Plane.DEFAULT_IDENTIFIER, Plane.MAX_FUEL, 0, 5, Plane.MAX_SPEED_Y, Plane.MAX_SPEED_X);
        assertTrue(plane1.fly());
        assertEquals(4999, plane1.getFuel());
        assertEquals(6, plane1.getYPos());
        assertEquals(0, plane1.getXPos());

        //caso en que el avion vuele pero el valor de xPos sea máximo
        plane1 = new Plane(Plane.DEFAULT_PILOT, Plane.DEFAULT_IDENTIFIER, Plane.MAX_FUEL, 10, 5, Plane.MAX_SPEED_Y, Plane.MAX_SPEED_X);
        assertTrue(plane1.fly());
        assertEquals(4999, plane1.getFuel());
        assertEquals(6, plane1.getYPos());
        assertEquals(10, plane1.getXPos());

        //caso en que el avion vuele pero el valor de yPos sea mínimo
        plane1 = new Plane(Plane.DEFAULT_PILOT, Plane.DEFAULT_IDENTIFIER, Plane.MAX_FUEL, 5, 0, Plane.MAX_SPEED_Y, Plane.MAX_SPEED_X);
        assertTrue(plane1.fly());
        assertEquals(4999, plane1.getFuel());
        assertEquals(0, plane1.getYPos());
        assertEquals(6, plane1.getXPos());

        //caso en que el avion vuele pero el valor de yPos sea maximo
        plane1 = new Plane(Plane.DEFAULT_PILOT, Plane.DEFAULT_IDENTIFIER, Plane.MAX_FUEL, 5, 10, Plane.MAX_SPEED_Y, Plane.MAX_SPEED_X);
        assertTrue(plane1.fly());
        assertEquals(4999, plane1.getFuel());
        assertEquals(10, plane1.getYPos());
        assertEquals(6, plane1.getXPos());

        //caso en que el avion vuele peor ambas posiciones sea minimas
        plane1 = new Plane(Plane.DEFAULT_PILOT, Plane.DEFAULT_IDENTIFIER, Plane.MAX_FUEL, 0, 0, Plane.MAX_SPEED_Y, Plane.MAX_SPEED_X);
        assertTrue(plane1.fly());
        assertEquals(4999, plane1.getFuel());
        assertEquals(0, plane1.getYPos());
        assertEquals(0, plane1.getXPos());

        //caso en que el avion vuele pero ambas posiciones sean maximas
        plane1 = new Plane(Plane.DEFAULT_PILOT, Plane.DEFAULT_IDENTIFIER, Plane.MAX_FUEL, 10, 10, Plane.MAX_SPEED_Y, Plane.MAX_SPEED_X);
        assertTrue(plane1.fly());
        assertEquals(4999, plane1.getFuel());
        assertEquals(10, plane1.getYPos());
        assertEquals(10, plane1.getXPos());

        //caso en que el avion no vuele
        plane1 = new Plane(Plane.DEFAULT_PILOT, Plane.DEFAULT_IDENTIFIER, Plane.MIN_FUEL, 5, 5, Plane.MAX_SPEED_Y, Plane.MAX_SPEED_X);
        assertFalse(plane1.fly());
        assertEquals(0, plane1.getFuel());
        assertEquals(5, plane1.getYPos());
        assertEquals(5, plane1.getXPos());
    }
}


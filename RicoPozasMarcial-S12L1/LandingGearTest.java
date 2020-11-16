

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class LandingGearTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class LandingGearTest
{
    /**
     * Default constructor for test class LandingGearTest
     */
    public LandingGearTest()
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
     * metodo de prueba del constructor sin parameteros
     */
    @Test
    public void testLandingGear()
    {
     LandingGear landg1 = new LandingGear();
     assertFalse(landg1.getLever());
     assertNotNull(landg1.getNose());
     assertNotNull(landg1.getLeft());
     assertNotNull(landg1.getRight());
    }
    /**
     * metodo de prueba de moveLever
     */
    @Test
    public void testMoveLever()
    {
     //caso en que lever sea true
     LandingGear landg1 = new LandingGear();
     landg1.moveLever(LandingGear.LEVER_UP);
     assertTrue(landg1.getLever());
     assertFalse(landg1.getNose().getDeployed());
     assertFalse(landg1.getLeft().getDeployed());
     assertFalse(landg1.getRight().getDeployed());
     
     //caso en que lever sea false
     landg1 = new LandingGear();
     landg1.moveLever(LandingGear.LEVER_DOWN);
     assertFalse(landg1.getLever());
     assertTrue(landg1.getNose().getDeployed());
     assertTrue(landg1.getLeft().getDeployed());
     assertTrue(landg1.getRight().getDeployed());
     
    }
}

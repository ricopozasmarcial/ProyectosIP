
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class PersonTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class PersonTest
{
    /**
     * Default constructor for test class PersonTest
     */
    public PersonTest()
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

    @Test
    public void testSetAge()
    {
        Person person1 = new Person();
        person1.setAge(50);
        assertEquals(50, person1.getAge());
        person1.setAge(120);
        assertEquals(50, person1.getAge());
        person1.setAge(0);
        assertEquals(0, person1.getAge());
        person1.setAge(-10);
        assertEquals(0, person1.getAge());
        person1.setAge(300);
        assertEquals(0, person1.getAge());
    }


    @Test
    public void testGetCriticalAge()
    {
        Person person1 = new Person();
        person1.setAge(0);
        assertEquals(18, person1.getCriticalAge());
        person1.setAge(18);
        assertEquals(0, person1.getCriticalAge());
        person1.setAge(65);
        assertEquals(0, person1.getCriticalAge());
    }


    @Test
    public void testGetHashCode()
    {
        Person person1 = new Person("Marcial", "Rico Pozas",18 , Person.GENDER_MALE);
        assertEquals("18 - MA - RICO - ADULT", person1.getHashCode());
    }
}




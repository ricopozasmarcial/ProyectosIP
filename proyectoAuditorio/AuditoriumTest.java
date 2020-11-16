

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
/**
 * The test class AuditoriumTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class AuditoriumTest
{
    /**
     * Default constructor for test class AuditoriumTest
     */
    public AuditoriumTest()
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
     * metodo de prueba de addConcert
     */
    @Test
    public void testAddConcert()
    {
        //se llama por primera vez al metodo(crea el primer concierto)
        Auditorium aud1 = new Auditorium();
        assertEquals(0, aud1.getConcerts().size());
        aud1.addConcert("Marcial", 3.0, new Date(6,3,1999));
        assertEquals(1, aud1.getConcerts().size());
        
        //se llama por segunda vez
        aud1.addConcert("Marcial", 3.0, new Date(7,4,1989));
        assertEquals(2, aud1.getConcerts().size());
    
        //se llama introduciendo un concierto con la misma fecha
        aud1.addConcert("Gema", 5.0, new Date(7,4,1989));
        assertEquals(2, aud1.getConcerts().size());
    }
    
    /**
     * metodo de prueba de seekConcert
     */
    @Test
    public void testSeekConcerts()
    {
        //se añaden tres conciertos y se busca el nombre marcial
        Auditorium aud1 = new Auditorium();
        assertEquals(0, aud1.getConcerts().size());
        aud1.addConcert("Marcial", 3.0, new Date(6,3,1999)); //posicion 0
        aud1.addConcert("Nuria", 3.0, new Date(5,9,2019)); //posicion 1
        aud1.addConcert("Gema", 5.0, new Date(7,4,1989)); //posicion 2
        aud1.seekConcert("Marcial");
        assertEquals(aud1.getConcerts().get(0), aud1.seekConcert("Marcial"));
        
        //se busca ahora el nombre Nuria
        aud1.seekConcert("Nuria");
        assertEquals(aud1.getConcerts().get(1), aud1.seekConcert("Nuria"));
        
        //se busca el nombre Gema
        aud1.seekConcert("Gema");
        assertEquals(aud1.getConcerts().get(2), aud1.seekConcert("Gema"));
    }
    
    /**
     * metodo de prueba de removeConcerts
     */
    @Test
    public void testRemoveConcerts()
    {
        //se añaden tres conciertos y se elimina el concierto en el año 1999
        Auditorium aud1 = new Auditorium();
        aud1.addConcert("Marcial", 3.0, new Date(6,3,1999)); //posicion 0
        aud1.addConcert("Nuria", 3.0, new Date(5,9,2019)); //posicion 1
        aud1.addConcert("Gema", 5.0, new Date(7,4,1989)); //posicion 2
        assertEquals(3, aud1.getConcerts().size());
        aud1.removeConcerts(1999);
        assertEquals(2, aud1.getConcerts().size());
        //se elimina el año 2019
        aud1.removeConcerts(2019);
        assertEquals(1, aud1.getConcerts().size());
    }
}

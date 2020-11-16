
import java.util.*;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class SeatManagerTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class SeatManagerTest
{
    /**
     * Pruebas para bookSeat que reserva un asiento si esta libre
     * y da falso si no lo esta
     */
    @Test
    public void testBookSeat()
    {
        //CASO 1 TODO CORRECTO, SE RESERVA ASIENTO LIBRE
        SeatManager sm = new SeatManager(4,5); //4 en primera y 5 en turista
        Person personToBook;
        for(int i=0; i<9; i++)
            for(int j=0; j < SeatManager.COLUMNS; j++)
            {
                personToBook = new Person();
                assertTrue(sm.bookSeat(personToBook, i, j));
                assertEquals(personToBook, sm.getSeat(i,j));
            }

        //CASO 2 EL ASIENTO NO ESTA LIBRE
        sm = new SeatManager(5,6); //5 en primera y 6 en turista
        personToBook = new Person();
        sm.bookSeat(personToBook, 1, 1);
        Person person2 = new Person();
        assertFalse(sm.bookSeat(person2, 1, 1));
        assertEquals(personToBook, sm.getSeat(1,1));

        //CASO 3 PERSONA A RESERVAR NULL
        try{
            sm.bookSeat(null, 1, 1);
            fail();
        }   catch(RuntimeException rte)
        {
            assertEquals("Parámetro invalido", rte.getMessage());
        }
        //CASO 4 FILA INCORRECTA
        try{
            sm.bookSeat(personToBook, -1, 1);
            fail();
        }   catch(RuntimeException rte)
        {
            assertEquals("Parámetro invalido", rte.getMessage());
        }
        //CASO 5 COLUMNA INCORRECTA

        try{
            sm.bookSeat(personToBook, 1, -1);
            fail();
        }   catch(RuntimeException rte)
        {
            assertEquals("Parámetro invalido", rte.getMessage());
        }
    }

    /**
     * metodo de prueba del constructor por defecto
     */
    @Test
    public void testSeatManager()
    {
        //se crea un SeatManager por defecto
        SeatManager sm = new SeatManager();
        assertEquals(SeatManager.MIN_FIRST+SeatManager.MIN_STANDARD, sm.getSeats().length);
    }

    /**
     * metodo de prueba del constructos con parametros 
     */
    @Test
    public void testSeatManagerParam()
    {
        //se crea un SeatManager con parametros validos
        SeatManager sm = new SeatManager(SeatManager.MIN_FIRST,SeatManager.MIN_STANDARD);
        assertEquals(SeatManager.MIN_FIRST+SeatManager.MIN_STANDARD, sm.getSeats().length);

        //se crea con el numero de filas en primera clase menor al minimo
        try
        {
            sm = new SeatManager(SeatManager.MIN_FIRST-1, SeatManager.MIN_STANDARD);
            fail();
        }
        catch (RuntimeException rte)
        {
            assertEquals("numero invalido", rte.getMessage());

        }

        //se crea con el numero de filas en primera clase invalido
        try
        {
            sm = new SeatManager(-1, SeatManager.MIN_STANDARD);
            fail();
        }
        catch (RuntimeException rte)
        {
            assertEquals("numero invalido", rte.getMessage());
        }

        //se crea con el numero de filas en clase turista menor al minimo
        try
        {
            sm = new SeatManager(SeatManager.MIN_FIRST, SeatManager.MIN_STANDARD-1);
            fail();
        }
        catch (RuntimeException rte)
        {
            assertEquals("numero invalido", rte.getMessage());
        }

        //se crea con el numero de filas en clase turista invalido
        try
        {
            sm = new SeatManager(SeatManager.MIN_FIRST, -1);
            fail();
        }
        catch (RuntimeException rte)
        {
            assertEquals("numero invalido", rte.getMessage());
        }

        //se crea con el numero de filas y columnas invalido
        try
        {
            sm = new SeatManager(-1, -1);
            fail();
        }
        catch (RuntimeException rte)
        {
            assertEquals("numero invalido", rte.getMessage());
        }
    }

    /**
     * metodo de prueba de firstPassenger()
     */
    @Test
    public void testFirstPassenger()
    {
        //la matriz posee un pasajero en la primera posicion
        SeatManager sm = new SeatManager();
        sm.bookSeat(new Person(),0,0);
        sm.firstPassenger();
        assertNotNull(sm.getSeat(0,0));

        //la matriz posee tres pasajeros
        sm = new SeatManager();
        sm.bookSeat(new Person(),0,0);
        sm.bookSeat(new Person(),2,3);
        sm.bookSeat(new Person(),1,3);
        sm.firstPassenger();
        assertNotNull(sm.getSeat(0,0));   

        //el avion no posee pasajeros
        sm = new SeatManager();
        try
        {
            sm.firstPassenger();
            fail();
        }
        catch(RuntimeException rte)
        {
            assertEquals("No hay pasajeros", rte.getMessage());
        }
    }

    /**
     * metodo de prueba de oldestPassenger
     */
    @Test
    public void testOldestPassenger()
    {
        //solo hay un pasajero en el avion
        SeatManager sm1= new SeatManager();
        sm1.bookSeat(new Person(),0,0);
        assertEquals(sm1.firstPassenger(), sm1.getOldestPassenger());

        //hay varios pasajeros en el avion
        sm1= new SeatManager();
        sm1.bookSeat(new Person(10),0,0);
        sm1.bookSeat(new Person(20),1,0);
        sm1.bookSeat(new Person(30),2,0);
        sm1.bookSeat(new Person(40),3,0);
        assertEquals(sm1.getSeat(3,0), sm1.getOldestPassenger());
    }

    @Test
    public void testNumberOfFreeSeats()
    {
        //hay todos los sitios libres en la primera fila
        SeatManager sm = new SeatManager();
        assertEquals(SeatManager.COLUMNS, sm.numberOfFreeSeats(0) );

        //hay un sitio ocupado en la primera fila
        sm = new SeatManager();
        sm.bookSeat(new Person(),0,0);
        assertEquals(SeatManager.COLUMNS-1, sm.numberOfFreeSeats(0));

        //todos los sitios de una fila están ocupados
        sm = new SeatManager();
        sm.bookSeat(new Person(),0,0);
        sm.bookSeat(new Person(),0,1);
        sm.bookSeat(new Person(),0,2);
        sm.bookSeat(new Person(),0,3);
        sm.bookSeat(new Person(),0,4);
        sm.bookSeat(new Person(),0,5);
        assertEquals(0, sm.numberOfFreeSeats(0));

        //se introduce un valor <0
        try
        {
            sm.numberOfFreeSeats(-1);
            fail();
        }
        catch(RuntimeException rte)
        {
            assertEquals("FILA INCORRECTA", rte.getMessage());
        }

        //se introduce un valor superior al limite de filas
        try
        {
            sm.numberOfFreeSeats(10);
            fail();
        }
        catch(RuntimeException rte)
        {
            assertEquals("FILA INCORRECTA", rte.getMessage());
        }
    }

    /**
     * metodo de prueba de releaseSeat 
     */
    @Test
    public void testReleaseSeat()
    {
        // se elimina un asiento
        SeatManager sm = new SeatManager();
        sm.bookSeat(new Person(),0,0);
        sm.releaseSeat(0,0);
        assertNull(sm.getSeat(0,0));

        //se intenta liberar un asiento no ocupado
        try
        {
            sm.releaseSeat(1,1);
            fail();
        }
        catch(RuntimeException rte)
        {
            assertEquals("El asiento ya esta libre", rte.getMessage());
        }
    }

    /**
     * metodo de prueba de getOldestPeople
     */
    @Test
    public void testGetOldestPeople()
    {        
        Person p1 = new Person(10);
        Person p2 = new Person(20);
        Person p3 = new Person(30);
        Person p4 = new Person(40);
        Person p5 = new Person(50);
        Person p6 = new Person(60);
        Person p7 = new Person(70);
        Person p8 = new Person(80);

        // caso en que haya personas que superen el margen de edad de 65 años
        SeatManager sm = new SeatManager();
        sm.bookSeat(p1,0,1);
        sm.bookSeat(p2,0,2);
        sm.bookSeat(p3,0,3);
        sm.bookSeat(p4,0,4);
        sm.bookSeat(p5,0,5);
        sm.bookSeat(p6,1,2);
        sm.bookSeat(p7,1,3); //lo supera
        sm.bookSeat(p8,1,1); // lo supera
        assertEquals(2, sm.getOldestPeople().size());
    }

    /**
     * metodo de prueba de childrenPassenger
     */
    @Test
    public void testChildrenPassenger()
    {
        Person p1 = new Person(10);
        Person p2 = new Person(15);
        Person p3 = new Person(17);
        Person p4 = new Person(18);
        Person p5 = new Person(50);
        Person p6 = new Person(60);
        Person p7 = new Person(70);
        Person p8 = new Person(80);

        // caso en que haya personas que no superen el margen de edad de 18 años
        SeatManager sm = new SeatManager();
        sm.bookSeat(p1,0,1);
        sm.bookSeat(p2,0,2);
        sm.bookSeat(p3,0,3);
        sm.bookSeat(p4,0,4);
        sm.bookSeat(p5,0,5);
        sm.bookSeat(p6,1,2);
        sm.bookSeat(p7,1,3); 
        sm.bookSeat(p8,1,1); 
        assertEquals(3, sm.childrenPassengers().size());
    }

    /**
     * metodo de prueba de getNumPax
     */
    @Test
    public void testGetNumPax()
    {
        SeatManager sm = new SeatManager();
        byte fallo = 8;

        //añado 2 pasajeros en primera y 3 en turista
        sm.bookSeat(new Person(),0,0);
        sm.bookSeat(new Person(),0,1);
        sm.bookSeat(new Person(),5,1);
        sm.bookSeat(new Person(),5,2);
        assertEquals(2, sm.getNumPax(SeatManager.FIRST_CLASS));
        assertEquals(2, sm.getNumPax(SeatManager.STANDARD_CLASS));
        assertEquals(4, sm.getNumPax(SeatManager.ALL_CLASS));

        //se intenta acceder a un area no disponible
        try
        {
            sm.getNumPax(fallo);
            fail();
        }
        catch(RuntimeException rte)
        {
            assertEquals("Parametro incorrecto", rte.getMessage());
        }
    }

    /**
     * metodo de prueba de loadPax
     */
    @Test
    public void testLoadPax()
    {
        Person p1 = new Person();
        Person p2 = new Person();
        Person p3 = new Person();
        
        //se introducen 3 personas en un avion vacio
        SeatManager sm = new SeatManager();
        sm.loadPax(3);
        assertNotNull(sm.getSeat(0,0));
        assertNotNull(sm.getSeat(0,1));
        assertNotNull(sm.getSeat(0,2));
        
        //en un avion con las posiciones [0][1], [0][3] y [0][5] ocupadas se añaden 3 personas
        sm = new SeatManager();
        sm.bookSeat(p1,0,1);
        sm.bookSeat(p2,0,3);
        sm.bookSeat(p3,0,5);
        sm.loadPax(3);
        assertNotNull(sm.getSeat(0,0));
        assertNotNull(sm.getSeat(0,2));
        assertNotNull(sm.getSeat(0,4));
        
        //se introduce un dato invalido negativo
        try
        {
            sm.loadPax(-1);
            fail();
        }
        catch(RuntimeException rte)
        {
            assertEquals("Numero de personas incorrecto", rte.getMessage());
        }
        
        //se introduce un dato invalido mayor al numero de asientos
        try
        {
            sm.loadPax(((sm.getFirst()+sm.getStandard())*SeatManager.COLUMNS)+1);
            fail();          
        }
        catch(RuntimeException rte)
        {
            assertEquals("Numero de personas incorrecto", rte.getMessage());
        
        }       
    }
    
    /**
     * metodo getNumPaxBySection de la clase SeatManager
     */
    @Test
    public void testgetNumPaxBySection()
    {
        //caso en que se intente obtener una seccion con dos pasajeros
        SeatManager sm = new SeatManager();
        sm.bookSeat(new Person(),1,2);
        sm.bookSeat(new Person(),1,1);
        assertEquals(2,sm.getNumPaxBySection(0,0,2,2));
        
        //caso en que no haya pasajeros en la seccion
        sm = new SeatManager();
        assertEquals(0,sm.getNumPaxBySection(0,0,2,2));
        
        //caso en que row1  sea negativo
        try
        {
          sm.getNumPaxBySection(-1,0,2,2);
          fail();
        }
        catch(RuntimeException rte)
        {
            assertEquals("ALGUN DATO ERRONEO", rte.getMessage());
        }
        
        //caso en que row1 sea superior al permitido
        try
        {
          sm.getNumPaxBySection((sm.getFirst()+sm.getStandard())+1,0,2,2);
          fail();
        }
        catch(RuntimeException rte)
        {
            assertEquals("ALGUN DATO ERRONEO", rte.getMessage());
        }
        
        //caso en que colum1 sea negativo
        try
        {
          sm.getNumPaxBySection(0,-1,2,2);
          fail();
        }
        catch(RuntimeException rte)
        {
            assertEquals("ALGUN DATO ERRONEO", rte.getMessage());
        }
        
        //caso en que colum1 sea superior al permitido
        try
        {
          sm.getNumPaxBySection(-1,SeatManager.COLUMNS+1,2,2);
          fail();
        }
        catch(RuntimeException rte)
        {
            assertEquals("ALGUN DATO ERRONEO", rte.getMessage());
        }
        
        //caso en que row2 sea negativo
        try
        {
          sm.getNumPaxBySection(0,0,-2,2);
          fail();
        }
        catch(RuntimeException rte)
        {
            assertEquals("ALGUN DATO ERRONEO", rte.getMessage());
        }
        
        //caso en que row2 sea mayor de lo permitido
        try
        {
          sm.getNumPaxBySection(0,0,(sm.getFirst()+sm.getStandard())+1,2);
          fail();
        }
        catch(RuntimeException rte)
        {
            assertEquals("ALGUN DATO ERRONEO", rte.getMessage());
        }
        
        //caso en que colum2 sea negativo
        try
        {
          sm.getNumPaxBySection(0,0,2,-2);
          fail();
        }
        catch(RuntimeException rte)
        {
            assertEquals("ALGUN DATO ERRONEO", rte.getMessage());
        }
        
        //caso en que colum2 sea superior al permitido
        try
        {
          sm.getNumPaxBySection(-1,0,2,SeatManager.COLUMNS+1);
          fail();
        }
        catch(RuntimeException rte)
        {
            assertEquals("ALGUN DATO ERRONEO", rte.getMessage());
        }
    }
    
    /**
     * metodo de prueba de loadPassengers
     */
    @Test
    public void testLoadPassengers()
    {       
        int p=0;
        SeatManager sm = new SeatManager();
        
        //se añaden 10 pasajeros a un avios vacio
        sm.loadPassengers(10);
        for(int i=0;i<sm.getSeats().length;i++)
            for(int j=0;j<sm.getSeats()[i].length;j++)
                if(sm.getSeats()[i][j] != null)
                    p++;
        assertEquals(10,p);
        
        //se añaden 10 pasajeros a un avion con 1 pasajero
        int q=0;
        sm = new SeatManager();
        sm.bookSeat(new Person(),0,0);
        sm.loadPassengers(10);
        for(int i=0;i<sm.getSeats().length;i++)
            for(int j=0;j<sm.getSeats()[i].length;j++)
                if(sm.getSeats()[i][j] != null)
                    q++;
        assertEquals(11,q);
        
        //el numero de pasajeros introducido es negativo
        try
        {
            sm.loadPassengers(-1);
            fail();
        }
        catch(RuntimeException rte)
        {
            assertEquals("El numero maximo de pasajeros es invalido", rte.getMessage());
        }
        
        //el numero de pasajeros introducido es mayor que el maximo 
        try
        {
            sm.loadPassengers(((sm.getFirst()+sm.getStandard())*SeatManager.COLUMNS)+1);
            fail();
        }
        catch(RuntimeException rte)
        {
            assertEquals("El numero maximo de pasajeros es invalido", rte.getMessage());
        }
    }
    
}
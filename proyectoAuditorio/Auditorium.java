import java.util.ArrayList;
/**
 * CLASE AUDITORIUM DE LA SESION NO PRESENCIAL 10
 * 
 * @author MARCIAL RICO POZAS
 * @version 24/11/2017
 */
public class Auditorium
{
    //atributos de la clase Auditorium
    private ArrayList<Concert> concerts;

    /**
     * constructor por defecto de objetos de la clase Auditorium
     */
    public Auditorium()
    {
        concerts = new ArrayList<Concert>();
    }

    /**
     * metodo seekConcert de la clase Auditorium
     * @param concertName, que indica el nombre del concierto a buscar
     */
    public Concert seekConcert (String concertName)
    {
        for ( Concert conciertos : concerts)
        {
            if ( conciertos.getName() == concertName)
                return conciertos;
        }
        return null;
    }

    /**
     * metodo addConcert de la clase Auditorium
     * @param concertName, un tipo String que indica el nombre del concierto
     * @param date, un tipo Date que indica la fecha del concierto
     * @param price, un double que indica el precio del billete
     */
    public void addConcert(String concertName, double price, Date date)
    {
        if(concerts.isEmpty())
            concerts.add(new Concert(concertName, price, date));
        else
        {
            boolean igual = false;
            for(int i = 0; i<concerts.size() ; i++)
            {
                if(concerts.get(i).getDate().getDay()== date.getDay() && concerts.get(i).getDate().getMonth()== date.getMonth()
                && concerts.get(i).getDate().getYear()== date.getYear())                
                {   
                    igual=true;                     
                }
            }
            if(igual!=true)
                concerts.add(new Concert(concertName, price, date));
        }
    }

    /**
     * metodo remove concerts de la clase Auditorium
     * @param year, un entero que indica el año de los conciertos a borrar
     */
    public void removeConcerts(int year)
    {
            for(int i = 0; i<concerts.size() ; i++)
            {
                if( concerts.get(i).getDate().getYear()== year)                
                {   
                    concerts.remove(i);                     
                }
            }
    }

    /**
     * metodo get del atributo concerts
     * @return el valor de concerts
     */
    public ArrayList getConcerts()
    {
        return concerts;
    }
}

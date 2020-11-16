
import java.util.*;
/**
 * Clase FSim de la Sesion no Presencial 12
 * 
 * @author MARCIAL RICO POZAS 
 * @version 05/12/2017
 */
public class FSim
{
    //constantes de la clase Fsim
    public final static String IDs = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public final static char DOT = '.';

    //atributos de la clase FSim
    private ArrayList<Plane> planes;
    private char[][] map;

    /**
     * constructor con un parametro de objetos de la clase FSim
     * 
     * @param planeNumber, un entero que establece el numero de aviones en la simulacion
     */
    public FSim(int planeNumber)
    {
        planes = new ArrayList<Plane>();
        if (planeNumber <= IDs.length())
            for(int i=0; i<planeNumber;i++)
                planes.add(new Plane(IDs.charAt(i)));
        else
            throw new IllegalArgumentException("DEMASIADOS AVIONES");

        map = new char[Plane.MAX_X+1][Plane.MAX_Y+1];
    }

    /**
     * metodo fillWithDots de la clase FSim
     */
    public void fillWithDots()
    {
        for (int i= 0; i< Plane.MAX_X+1; i++)
            for (int j= 0; j< Plane.MAX_Y+1; j++)
                map[i][j]=DOT;
    }

    /**
     * metodo printMap de la clas FSim
     */
    public void printMap()
    {
        for (char[] fila: map)
        {
            for(char pos: fila)
                System.out.print(pos+" ");
            System.out.println();
        }
    }

    /**
     * metodo simulate de la clase FSim
     */
    public void simulate()
    {
        fillWithDots();
        Plane p;
        int x1,y1;
        Iterator<Plane> it = planes.iterator();
        while(it.hasNext())
        {
            p = it.next();
            p.fly();
            x1= p.getXPos();
            y1 = p.getYPos();
            if(map[y1][x1]!= DOT)
            {
                System.out.println("COLISION ENTRE" + p.getIdentifier()+ " y " + map[y1][x1]);
                eliminar(map[y1][x1]);
                eliminar(p.getIdentifier());
                map[y1][x1] = '%';
            }
            map[y1][x1] = p.getIdentifier();
        }
        printMap();
    }

    /**
     * metodo eliminar de la clase FSim
     * 
     * @param identifier, un char que indica el caracter a eliminar
     */
    private void eliminar(char identifier)
    {
        identifier = ' ';
    }
}

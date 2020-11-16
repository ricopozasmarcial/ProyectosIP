import java.util.*;
/**
 * Clase SeatManager de la sesion 11
 * 
 * @author MARCIAL RICO POZAS
 * @version 03/12/2017
 */
public class SeatManager
{
    //constantes de la clase SeatManager
    public final static int MIN_FIRST = 3;
    public final static int MIN_STANDARD = 4;
    public final static int COLUMNS = 6;
    public static final byte FIRST_CLASS = 1;     
    public static final byte STANDARD_CLASS = 2;     
    public static final byte ALL_CLASS = 3; 

    //atributos de la clase SeatManager
    private int first;
    private int standard;
    private Person[][] seats;

    /**
     * constructor por defecto de objetos de la clase SeatManager
     */
    public SeatManager()
    {
        setFirst(MIN_FIRST);
        setStandard(MIN_STANDARD);
        setSeats(MIN_FIRST, MIN_STANDARD);

    }

    /**
     * Constructor con parametros de objetos de la clase SeatManager
     * @param first, un entero que asigna las filas en primera
     * @param standard, un entero que asigna las filas en turista
     */
    public SeatManager(int first, int standard)
    {
        this();
        setFirst(first);
        setStandard(standard);
        setSeats(first, standard);
    }

    /**
     * metodo set del atributo first
     * 
     * @param first, indica el numero de filas de primera clase
     */
    private void setFirst( int first)
    {
        if(first < MIN_FIRST)
            throw new RuntimeException("numero invalido");
        else
            this.first = first;
    }

    /**
     * metodo get del atributo first
     * 
     * @return el valor de first
     */
    public int getFirst()
    {
        return this.first;
    }

    /**
     * metodo set del atributo standard
     * 
     * @param standard, indica el numero de filas de clase turista
     */
    private void setStandard( int standard)
    {
        if(standard < MIN_STANDARD)
            throw new RuntimeException("numero invalido");
        else
            this.standard = standard;
    }

    /**
     * metodo get del atributo standard
     * 
     * @return el valor de standard
     */
    public int getStandard()
    {
        return this.standard;
    }

    /**
     * metodo set del atributo seats
     * 
     * @param standard, un entero que indica los asientos de clase turista
     * @param first, un entero que indica los asientos de primera clase
     */
    private void setSeats(int standard, int first)
    {
        if(this.standard < 4 || this.first < 3 )
            throw new RuntimeException("numero invalido");
        seats = new Person[standard + first][COLUMNS];
    }

    /**
     * metodo get del atributo seats
     * 
     * @return el valor de seats
     */
    public Person[][] getSeats()
    {
        return this.seats;
    }

    /**
     * metodo firstPassenger de la clase SeatManager
     * 
     * @return primer pasajero que encuentra al recorrer la matriz
     * Si no hay pasajero que lance excepción
     */
    public Person firstPassenger()
    {
        for(int i=0; i< seats.length; i++)
            for(int j=0; j< seats[i].length; j++)
                if(seats[i][j] != null)
                    return seats[i][j]; 
        throw new RuntimeException("No hay pasajeros");
    }

    /**
     * metodo oldestPassenger de la clase SeatManager
     * 
     * @return la persona con mayor edad del avion
     */
    public Person getOldestPassenger()
    {
        Person oldestPassenger = firstPassenger();
        for(int i= 0; i<seats.length; i++)
            for(int j= 0; j<seats[i].length; j++)
            {
                if(seats[i][j] != null && seats[i][j].getAge() > oldestPassenger.getAge())
                    oldestPassenger = seats[i][j];
            }
        return oldestPassenger;
    }

    /**
     * metodo numberOfFreeSeats de la clase SeatManager
     * 
     * @param row, un entero que que se corresponde con la fila a analizar
     * @return numero de asientos libres en la final del avion que se le pasa como parametro
     */
    public int numberOfFreeSeats(int row)
    {
        if(row < 0 || row> seats.length)
            throw new RuntimeException("FILA INCORRECTA");
        int numberOfFreeSeats = 0; 
        for (int j=0; j<seats[row].length; j++)
            if(seats[row][j] == null)
                numberOfFreeSeats = numberOfFreeSeats + 1;
        return numberOfFreeSeats;
    }

    /**
     * @return lista de las posiciones libres de la fila recibida como parametro
     */
    public ArrayList<Person> getFreePosition(int fila)
    {
        checkRow(fila);
        ArrayList<Person> asientosLibres = new ArrayList<Person>();
        for(int j= 0; j<seats[fila].length; j++)
            if(seats[fila][j] == null)
                asientosLibres.add(j,seats[fila][j]);
        return asientosLibres;
    }

    /**
     * metodo rowPassangers de la clase SeatManager
     * 
     * @return lista con las personas de la fila recibida como parámetro
     */

    public ArrayList<Person> rowPassengers(int row)
    {
        ArrayList<Person> passengers = new ArrayList<Person>();
        for(int j= 0; j<seats[0].length; j++)
            if(seats[row][j] != null)
                passengers.add(seats[row][j]);
        return passengers;
    }

    /**
     * metodo freePassengers de la clase SeatManager
     * 
     * @param row, un entero que indica la fila
     * @return lista de las posiciones libres de la fila recibida como parametro
     */
    public ArrayList<String> freePassengers(int row)
    {
        ArrayList<String> passengers = new ArrayList<String>();
        for(int j= 0; j<seats.length; j++)
            if(seats[row][j] == null)
                passengers.add(j , "Asiento Vacio");
        return passengers;
    }

    /**
     * metodo bookSeat de la clase SeatManager 
     * 
     * @param persona, de tipo Person
     * @param final, en la que se hace la reserva
     * @param columna en la que se hace la reserva
     * 
     * @return true si se ha podido hacer y false si estaba el asiento ocupado
     */
    public boolean bookSeat(Person passenger, int fila, int columna)
    {
        boolean reservado = false;
        if(passenger == null || fila < 0 || fila > (this.standard + this.first) || columna
        < 0 || columna > COLUMNS )
            throw new RuntimeException("Parámetro invalido");
        if(seats[fila][columna] == null)
        {
            seats[fila][columna] = passenger;
            reservado = true;
        }
        return reservado;
    }

    /**
     * metodo releaseSeat de la clase SeatManager
     * 
     * @param fila, un entero que indica la fila
     * @param columna, un entero que indica la columna
     * 
     * @return true si el asiento esta libre o false si sigue ocupado
     */
    public boolean releaseSeat(int fila, int columna)
    {
        boolean libre = false;
        if(seats[fila][columna] == null)
            throw new RuntimeException("El asiento ya esta libre");            
        if(seats[fila][columna] != null)
        {
            seats[fila][columna] = null;
            libre = true;
        }
        return libre;
    }

    /**
     * Metodo getSeat de la clase SeatManager
     * 
     * @param fila
     * @param columna
     * 
     * @return persona que esta en esa posicion o null
     */
    public Person getSeat( int fila, int columna)
    {
        checkRow(fila);
        checkColumn(columna);
        if(seats[fila][columna] != null)
            return seats[fila][columna];
        else
            return null;
    }

    /**
     * metodo checkRow de la clase SeatManager
     * @param fila, un entero que da el valor de la fila a comprobar
     */
    public void checkRow(int fila)
    {
        if(fila<0 || fila>= seats.length)
            throw new RuntimeException("Numero de fila invalido");
    }

    /**
     * metodo checkColumn 
     * @param columna, un entero que da el valor de la columna a comprobar
     */
    public void checkColumn(int columna)
    {
        if(columna<0 || columna>=  seats[0].length)
            throw new RuntimeException("Numero de columna invalido");
    }

    /**
     * @return ArrayList que contenga a las personas de menor edad sentadas en el avion
     */
    public ArrayList<Person> getOldestPeople()
    {
        ArrayList<Person> oldest = new ArrayList<Person>();
        for(int i=0; i < seats.length; i++)
            for(int j=0; j < seats[i].length; j++)
            {
                Person person = seats[i][j];
                if(person!= null && person.getAge() >= Person.RETIREMENT_AGE)
                    oldest.add(person);
            }
        return oldest;
    }

    /**
     * metodo print de la clase SeatManager
     */
    public void print()
    {
        int f,c;
        char car;
        Person p;
        char[] column = {'A','B','C','D','E','F'};

        System.out.println("  ");
        for(c=0;c<seats[0].length;c++)
        {
            if(c==3)
                System.out.printf("    ");
            System.out.print("  ");
            System.out.print(column[c]);
        }

        System.out.printf("\n");
        for(f=0;f<seats.length;f++)
        {
            if(f==getFirst())
            {
                System.out.print("--");
                for(c=-1;c<seats[f].length;c++)
                    System.out.print("---");
                System.out.println();
            }

            System.out.printf("%2d ",f);

            for(c=0;c<seats[f].length;c++)
            {
                if(c==3)
                    System.out.printf("   ");

                p=seats[f][c];
                if(p==null)
                    car='?';
                else
                if(p.getAge()<Person.ADULTHOOD_AGE)
                    car='C';
                else
                    car='X';
                System.out.printf("%2c ", car);
            }
            System.out.printf("\n");
        }
    }

    /**
     * metodo loadPassengers de la clase SeatManager
     * @param maxPassengers, un entero que asigna un maximo de pasajeros a introducir aleatoriamente
     */
    public void loadPassengers(int maxPassengers)
    {
        Random r = new Random();
        int q = 0;
        if ( maxPassengers > (getFirst()+getStandard())*COLUMNS || maxPassengers < 0)
            throw new RuntimeException("El numero maximo de pasajeros es invalido");
        while(q< maxPassengers)
        {
            int i = r.nextInt(seats.length);
            int j = r.nextInt(seats[0].length);
            if(seats[i][j] == null)
            {    
                seats[i][j] = new Person();
                q++;
            }
        }
    }

    /**
     * metodo childrenPassengers de la clase SeatManager
     * 
     * @return un arrayList con los niños sentados en el avion
     */
    public ArrayList<Person> childrenPassengers()
    {
        ArrayList<Person> children = new ArrayList<Person>();
        for(int i= 0; i<seats.length;i++)
            for(int j=0; j<seats[i].length;j++)
            {
                Person person = seats[i][j];
                if(person!= null && person.getAge() < Person.ADULTHOOD_AGE)
                    children.add(person);
            }
        return children;            
    }

    /**
     * metodo getNumPax de la clase SeatManager
     * 
     * @param area, un byte que especifica el area del avion 
     */
    public int getNumPax(byte area)
    {
        int passengers = 0;
        if(area != FIRST_CLASS && area !=STANDARD_CLASS && area != ALL_CLASS)
            throw new RuntimeException("Parametro incorrecto");

        if(area == FIRST_CLASS)
            for(int i=0;i<this.first;i++)
                for(int j=0;j<seats[i].length ;j++)
                    if(seats[i][j]!= null)
                        passengers++;

        if(area == STANDARD_CLASS)
            for(int i=0;i<this.standard;i++)
                for(int j=0;j<seats[i].length ;j++)
                    if(seats[i][j]!= null)
                        passengers++;

        if(area == ALL_CLASS)
            for(int i=0;i<seats.length;i++)
                for(int j=0;j<seats[i].length ;j++)
                    if(seats[i][j]!= null)
                        passengers++;

        return passengers;
    }

    /**
     * metodo loadPax de la clase SeatManager
     * 
     * @param paxNumber, un entero que indica el numero de pasajeros a introducir
     */
    public void loadPax(int paxNumber)
    {       
        if(paxNumber <0 || paxNumber > ((getStandard()+getFirst())*COLUMNS))
            throw new RuntimeException("Numero de personas incorrecto");
        for(int i=0;i<seats.length && paxNumber > 0; i++)
            for (int j= 0;j<seats[i].length && paxNumber > 0; j++)
                if(seats[i][j] == null)
                {
                    bookSeat(new Person(),i,j);
                    paxNumber--;
                }        
    }

    /**
     * metodo que devuelve una fila determinada del array
     * 
     * @param row, fila a devolver
     * @return los elementos de la fila indicada
     */
    public Person[] devolverFila (int row)
    {
        if((row>=0)&&(row<seats.length))
            return seats[row];
        else
            throw new RuntimeException("NO EXISTE LA FILA");
    }
    
    /**
     * metodo getColumn de la clase SeatManager
     * 
     * @param column, un entero que indica el numero de la columna a devolver
     * @return columna, un array con los valores de la columna indicada
     */
    public Person[] getColumn(int column)
    {
        int f;
        Person p;
        Person[] columna = new Person[seats.length];
        if(column>=0 && column<seats.length)
        {
            for(f=0; f<seats.length;f++)
                columna[f]=seats[f][column];
            return columna;
        }
        else
            throw new IllegalArgumentException("NO EXISTE LA COLUMNA");
    }
    
    /**
     * metodo getSection de la clase SeatManager
     * 
     * @param f1, un entero que indica la fila que forma un angulo con c1
     * @param f2, un entero que indica la fila que forma el otro angulo con c2
     * @param c1, un entero que indica la columna que forma un angulo con f1
     * @param c2, un entero que indica la columna que forma el otro angulo con f2
     * 
     * @param section, un array con las personas contenidas en la seccion
     */
    public Person[][] getSection(int f1, int f2, int c1, int c2)
    {
        int f,c;
        Person[][] section=new Person[f2-f1+1][c2-c1+1];
        for (f=f1;f<=f2;f++)
            for(c=c1;c<=c2; c++)
                section[f-f1][c-c1]=seats[f][c];
        return section;
    }

    /**
     * metodo getNumPaxBySection
     * 
     * @param row1, un entero que indica la fila que forma un angulo con colum1
     * @param row2, un entero que indica la fila que forma el otro angulo con colum2
     * @param colum1, un entero que indica la columna que forma un angulo con row1
     * @param colum2, un entero que indica la columna que forma el otro angulo con row2
     * 
     * @return el numero de personas contenidas en la seccion
     */
    public int getNumPaxBySection (int row1, int colum1, int row2, int colum2)
    {
        if(row1 < 0 || row1> (getFirst()+getStandard())|| row2 < 0 || row2> (getFirst()+getStandard())||
        colum1 < 0 || colum1 > COLUMNS || colum2 < 0 || colum2 > COLUMNS )
            throw new RuntimeException ("ALGUN DATO ERRONEO");
        int row, colum;
        int contador = 0;
        for (row=row1;row<=row2;row++)
            for(colum=colum1;colum<=colum2; colum++)
                if(seats[row][colum]!= null)
                    contador++;
        return contador;
    }
    
    
}
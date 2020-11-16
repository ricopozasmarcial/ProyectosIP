
/**
 * Clase Plane para el primer control. Grupo L1
 * 
 * @author MARCIAL RICO POZAS 
 * @version 17/10/2017
 */
public class  Plane
{
    //constantes de la clase Plane
    public final static int MIN_FUEL = 0;
    public final static int MAX_FUEL = 5000;
    public final static int DEFAULT_FUEL = 1000;
    public final static char DEFAULT_IDENTIFIER = 'A';
    public final static Person DEFAULT_PILOT = new Person();
    //public final static int MIN_NUMBER_ENGINES = 1;
    //public final static int MAX_NUMBER_ENGINES = 8;
    //public final static int KG_ENGINE = 5000;
    //public final static int AVERAGE_WEIGHT = 80;
    //public final static int MAX_PASSENGERS = 200;
    public final static int MAX_X = 10;
    public final static int MIN_X = 0;
    public final static int MAX_Y = 10;
    public final static int MIN_Y = 0;
    public final static int MAX_SPEED_X = 1;
    public final static int MIN_SPEED_X = -1;
    public final static int MAX_SPEED_Y = 1;
    public final static int MIN_SPEED_Y = -1;

    //atributos de la clase Plane
    private Person pilot;
    private char identifier;
    private int fuel;
    private int numberOfEngines;
    private int xPos;
    private int yPos;
    private int xSpeed;
    private int ySpeed;

    /**
     * constructor por defecto de la clase Plane
     */
    public Plane()
    {
        setIdentifier(DEFAULT_IDENTIFIER);
        setFuel(MIN_FUEL);
        //setNumberOfEngines(MIN_NUMBER_ENGINES);
        setXPos(MAX_X);
        setYPos(MAX_Y);
        setXSpeed(MAX_SPEED_X);
        setYSpeed(MAX_SPEED_Y);
    }

    /**
     * constructor con parámetros de la clase Plane
     * @param  person  (establece la presencia de un piloto)
     * @param identifier (asigna una letra comprendida entre 'A' y 'Z')
     * @param fuel (establece un entero como indicador de cantidad de combustible)
     */  
    public Plane(Person pilot, char identifier, int fuel)
    {
        this();
        setPilot(pilot);
        setIdentifier(identifier);
        setFuel(fuel);
    }

    /**
     * constructor con parámetros para la clase Plane
     * @param xPos que establece la posición en el eje x del avión
     * @param yPos que establece la posición en el eje y del avión
     * @param xSpeed que establece la velocidad en el eje x del avión
     * @param ySpeed que establece la velocidad en el eje y del avión
     */
    public Plane(Person pilot, char identifier, int fuel, int xPos,int yPos, int ySpeed, int xSpeed)
    {
        this();
        setPilot(pilot);
        setIdentifier(identifier);
        setFuel(fuel);
        setXPos(xPos);
        setYPos(yPos);
        setXSpeed(xSpeed);
        setYSpeed(ySpeed);
    }
    /**
     * segundo constructor con parámetros de la clase Plane
     * @param identifier (asigna una letra comprendida entre 'A' y 'Z')
     * @param fuel (establece un entero como indicador de cantidad de combustible)
     * @param numberOfEngines (establece un entero comprendido entre 1 y 8 que representa el número de motores del avión)
     */
    //public Plane(char identifier, int fuel, int numberOfEngines)
    //{
    //this();
    //setIdentifier(identifier);
    //setFuel(fuel);
    //setNumberOfEngines(numberOfEngines);  
    //}
    /**
     * método set para el atributo numberOfEngines
     * @param numberOfEngines (establece un entero comprendido entre 1 y 8 que representa el número de motores del avión)
     */
    //private void setNumberOfEngines(int numberOfEngines)
    //{
    //if (numberOfEngines >= MIN_NUMBER_ENGINES && numberOfEngines <= MAX_NUMBER_ENGINES) //condición if para la asignación de un valor numberOfEngines
    //this.numberOfEngines = numberOfEngines;

    //else if (numberOfEngines < MIN_NUMBER_ENGINES || numberOfEngines > MAX_NUMBER_ENGINES)//condición adicional en caso de no cumplirse la primera
    //this.numberOfEngines = 0;       
    //}
    /**
     * metodo set para el atributo pilot
     * @param  person  (establece la presencia de un piloto)
     */
    private void setPilot(Person pilot)
    {
        if (pilot != null) //condición if para la asignación de un pilot
            this.pilot = pilot;   
        else
            this.pilot = null;
    }

    /**
     * metodo set para el atributo identifier
     * @param identifier (asigna una letra comprendida entre 'A' y 'Z')
     */
    private void setIdentifier(char identifier)
    {
        if (identifier >= 'A' && identifier <= 'Z') //condición if para la asignación caracter char
            this.identifier = identifier;
    }

    /**
     * metodo set para el atributo fuel
     *  @param fuel (establece un entero como indicador de cantidad de combustible)
     */
    private void setFuel(int fuel)
    {
        if (fuel > MIN_FUEL && fuel <= MAX_FUEL) //condición if para la asignación de entero fuel
            this.fuel = fuel;
    }   

    /**
     * metodo get para el atributo fuel
     * @return un entero que representa la cantidad de combustible
     */
    public int getFuel()
    {
        return fuel;
    }
    /**
     * metodo get para el atributo numberOfEngines
     * @return un entero que representa el número de motores
     */
    //public int getNumberOfEngines()
    //{
    //return numberOfEngines; 
    //}
    /**
     * metodo get para el atributo indentifier
     * @return un caracter que identifica el avión en cuestión
     */
    public char getIdentifier()
    {
        return identifier;
    }

    /**
     * metodo get para el atributo pilot
     * @return un pilot en caso de haberlo
     */
    public Person getPilot()
    {
        return pilot;
    }

    /**
     * método set del atributo xPos
     * @param xPos que establece un valor entero a la posición del avión en el eje x
     */
    private void setXPos(int xPos)
    {
        if(xPos <= MAX_X && xPos >= MIN_X) //condición if que reduce a un valor 0 el valor de xPos si el dato introducido es erróneo
            this.xPos = xPos;
        else 
            this.xPos = MIN_X;
    }

    /**
     * método get del atributo xPos
     * @return el valor de xPos
     */
    public int getXPos()
    {
        return xPos;
    }

    /**
     * método set del atributo yPos
     * @param yPos que establece un valor entero a la posición del avión en el eje y
     */
    private void setYPos(int yPos)
    {
        if(yPos <= MAX_Y && yPos >= MIN_Y) //condición if que reduce a un valor 0 el valor de yPos si el dato introducido es erróneo
            this.yPos = yPos;
        else 
            this.yPos = MIN_Y;
    }

    /** 
     *método get del atributo yPos
     *@return el valor de yPos
     */
    public int getYPos()
    {
        return yPos;
    }

    /**
     * método set del atributo xSpeed
     * @param xSpeed que establece un valor entero a la velocidad en el eje x del avión
     */
    private void setXSpeed(int xSpeed)
    {
        if(xSpeed <= MAX_SPEED_X && xSpeed >= MIN_SPEED_X) //condición que reduce a un valor -1 el valor de xSpeed si el dato introducido es erróneo 
            this.xSpeed = xSpeed;
        else
            this.xSpeed = MIN_SPEED_X;
    }

    /**
     * método get del atributo xSpeed
     * @return el valor de xSpeed
     */
    public int getXSpeed()
    {
        return xSpeed;
    }

    /**
     * método set del atributo ySpeed
     * @param ySpeed que establece un valor entero a la velocidad en el eje y del avión
     */
    private void setYSpeed(int ySpeed)
    {
        if(ySpeed <= MAX_SPEED_Y && ySpeed >= MIN_SPEED_Y) //condición que reduce el valor de ySpeed a -1 si algún dato introducido es incorrecto
            this.ySpeed = ySpeed;
        else
            this.ySpeed = MIN_SPEED_Y;
    }

    /**
     * método get del atributo ySpeed
     * @return el valor de ySpeed
     */
    public int getYSpeed()
    {
        return ySpeed;
    }

    /**
     * método accelerate que modifica el estado de los atributos xSpeed e ySpeed siempre y cuando los valores introducidos sean válidos
     */
    public void accelerate(int xSpeed, int ySpeed)
    {
        if(xSpeed >= MIN_SPEED_X && xSpeed <= MAX_SPEED_X  && ySpeed >= MIN_SPEED_Y && ySpeed <= MAX_SPEED_Y) //condición if que verifica que los datos introducidos estén dnetro del rango de valores esperado. Si se cumple, se reasignan los valores
        {
            this.xSpeed = xSpeed;
            this.ySpeed = ySpeed;
        }
        else if (xSpeed < MIN_SPEED_X || xSpeed > MAX_SPEED_X  || ySpeed < MIN_SPEED_Y || ySpeed > MAX_SPEED_Y) //setencia adicional que niega el cambio de reasignación de valores si la condición anterior no se cumple
        {
            this.xSpeed = this.xSpeed;
            this.ySpeed = this.ySpeed;
        }   
        else //condición adicional que niega la reasignación en cualquier otro caso no comprendido
        {
            this.xSpeed = this.xSpeed;
            this.ySpeed = this.ySpeed;
        }   
    }

    /**
     * metodo getMaxLoad
     * @param numberOfPassengers (asigna un entero para saber el número de pasajeros que incluir en la fórmula)
     * @return el resultado de la formula si las condiciones son correctas, un valor 0 si alguno de los datos es erróneo o un valor -1 si el número de pasajeros es inválido
     */
    //public int getMaxLoad(int numberOfPassengers)
    //{ 
    //int maxLoad; //variable que usaré para obtener el resultado de la fórmula
    //if (getFuel() > MIN_FUEL && getFuel() <= MAX_FUEL && numberOfPassengers >= 0 && numberOfPassengers <= MAX_PASSENGERS && numberOfEngines >= MIN_NUMBER_ENGINES && numberOfEngines <= MAX_NUMBER_ENGINES) //condición if que aplica la fórmula si las condiciones son cumplidas
    //{
    //maxLoad = (KG_ENGINE*numberOfEngines)-(fuel+numberOfPassengers*AVERAGE_WEIGHT);  
    //} 
    //else if (numberOfPassengers < 0 || numberOfPassengers > MAX_PASSENGERS) //condición adicional que me asegura un valor -1 si solo es inválido el número deep pasajeros
    //{
    //maxLoad = -1;
    //} 
    //else if (getFuel() <= MIN_FUEL || getFuel() > MAX_FUEL || numberOfEngines < MIN_NUMBER_ENGINES || numberOfEngines > MAX_NUMBER_ENGINES) //condición adicional que me devuelve un valor 0 si el resto de datos son inválidos
    //{
    //maxLoad = 000;
    //}
    //else // condición para otro supuesto caso no contemplado
    //maxLoad = 000;

    //return maxLoad;
    //} 

    /**
     * metodo toString() que devuelve una cadena
     * @return el resultante de la condición establecida
     */
    public String toString()
    {
        String stringToReturn = getIdentifier() + " - " + getFuel() + " - " + "(" + getXPos() + "," + getYPos() + ")" + "(" + getXSpeed() + "," + getYSpeed() + ")" ;
        if (getPilot() != null) //condición que establece una cadena hashCode si se encuentra un piloto
            stringToReturn = stringToReturn + getPilot().getHashCode();
        else //condición adicional que establece un mensaje "NO PILOT" si no se encuentra un piloto
            stringToReturn = stringToReturn + "NO PILOT";
        return stringToReturn;
    }

    /*
     * metodo fly de la clase Plane
     */
    public boolean fly()
    {
        if (getFuel() > MIN_FUEL)
        { 
            this.fuel = (getFuel()-1);
            if (getXPos() > MIN_X && getXPos() < MAX_X)
                this.xPos = (getXPos() + getXSpeed());
            if (getYPos() > MIN_Y && getYPos() < MAX_Y)
                this.yPos = (getYPos() + getYSpeed());
            return true;
        }
        else
            return false;  
    }

}
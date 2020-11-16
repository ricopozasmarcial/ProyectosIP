
/**
 * Write a description of class WheelStrut here.
 * 
 * @author MARCIAL RICO POZAS
 * @version 31/10/2017
 */
public class WheelStrut
{
    //constantes de la clase WheelStrut
    public final static boolean DEF_DEPLOYED = true;
    public final static boolean DEF_NOT_DEPLOYED = false;
    public final static Wheel DEF_WHEEL = new Wheel();
    public final static double DEF_PRESSURE = 1739.0;
    public final static double BOING_737 = DEF_PRESSURE;
    public final static double DEF_MAX_PRESSURE = DEF_PRESSURE;

    //atributos de la clase WheelStrut
    private boolean deployed;
    private Wheel leftWheel;
    private Wheel rightWheel;

    /**
     * constuctor por defecto de la clase WheelStrut
     */
    public WheelStrut()
    {
        setDeployed(DEF_DEPLOYED);
        setLeftWheel(new Wheel(DEF_PRESSURE, DEF_PRESSURE));
        setRightWheel(new Wheel(DEF_PRESSURE, DEF_PRESSURE));
    }

    /**
     * constructor con parámetros de la clase WheelStrut
     * @param strutState, un booleano que indica el estado del puntal
     * @param ruedaIzquierda, un Wheel que asocia un objeto Wheel
     * @param ruedaDerecha, un Wheel que asocia un objeto Wheel
     */
    public WheelStrut(boolean strutState, Wheel ruedaIzquierda, Wheel ruedaDerecha)
    {
        this();
        setDeployed(strutState);
        setLeftWheel(ruedaIzquierda);
        setRightWheel(ruedaDerecha);
    }

    /**
     * metodo set del atributo deployed
     * @param deployed, un booleano que establece la posición del puntal
     */
    private void setDeployed(boolean deployed)
    {
        this.deployed = deployed;
    }

    /**
     * metodo set del atributo leftWheel
     * @param leftWheel, un Wheel que establece la presencia de una rueda izquierda
     */
    private void setLeftWheel(Wheel leftWheel)
    {
        if (leftWheel != null)
            this.leftWheel = leftWheel;
    }

    /**
     * metodo set del atributo rightWheel
     * @param rightWheel, un Wheel que establece la presencia de una rueda derecha
     */
    private void setRightWheel(Wheel rightWheel)
    {
        if (rightWheel != null)
            this.rightWheel = rightWheel;
    }

    /**
     * metodo get para el atributo deployed
     * @return el valor de deployed
     */
    public boolean getDeployed()
    {
        return this.deployed;
    }

    /**
     *metodo get para el atributo leftWheel
     *@return el valor de leftWheel
     */
    public Wheel getLeftWheel()
    {
        return this.leftWheel; 
    }

    /**
     * metodo get para rightWheel
     * @return el valor de rightWheel
     */
    public Wheel getRightWheel()
    {
        return this.rightWheel; 
    }

    /**
     * metodo test de la clase WheelStrut
     */
    public boolean test()
    {
        rightWheel.test();
        leftWheel.test();
        if(rightWheel.test() == true && leftWheel.test() == true)
            return true;
        else
            return false;
    }

    /**
     * metodo toString de la clase WheelStrut
     */
    public String toString()
    { 
        String cadena = ("Deployed: " + test() + " - Test: [L: " + leftWheel.test() + "] [R: " + rightWheel.test() + "]");
        return cadena;
    }

    /**
     * metodo deploy de la clase WheelStrut
     */
    public void deploy()
    {
        this.deployed = true;
    }

    /**
     * método retract de la clase WheelStrut
     */
    public void retract()
    {
        this.deployed = false; 
    }

    public void print()
    {    
        String cadena21;
        if(getDeployed() == true)
            cadena21 = "TRUE";
        else
            cadena21 = "FALSE";
        System.out.println("RETRACTED");
        System.out.println("Test..............." + cadena21);
        System.out.println("");
        System.out.println("LEFT Wheel");
        leftWheel.print();
        System.out.println("RIGHT Wheel");
        rightWheel.print();
    }
}

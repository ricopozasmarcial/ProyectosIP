
/**
 * Clase Wheel de la sesión 6 de PL de I.P
 * 
 * @author MARCIAL RICO POZAS
 * @version 24/10/2017
 */
public class Wheel
{
    //constantes de la clase wheel
    public final static int THRESHOLD = 85;
    public final static double MIN_PRESSURE = 0.0;
    public final static double DEF_PRESSURE = 900.0;
    public final static double DEF_MAX_PRESSURE = 1000.0;

    //atributos de la clase wheel
    private double maxPressure;
    private double pressure;

    /**
     * constructor por defecto de la clase Wheel
     */
    public Wheel()
    {
        setPressure(DEF_PRESSURE);
        setMaxPressure(DEF_MAX_PRESSURE);
    }

    /**
     * constructor con parámetros de la clase Wheel
     * @param maxPressure, un double que establece la presión máxima
     * @param pressure,un double que establece la presión
     */
    public Wheel(double maxPressure, double pressure)
    {
        this();
        setMaxPressure(maxPressure);
        setPressure(pressure); 
    }

    /**
     * método set para el atributo maxPressure
     * @param maxPressure, un double que establece la presión máxima
     */
    private void setMaxPressure(double maxPressure)
    {
        if (maxPressure >= MIN_PRESSURE)
            this.maxPressure = maxPressure;
    }

    /**
     * método set para el atributo pressure
     * @param pressure,un double que establece la presión
     */
    private void setPressure(double pressure)
    {
        if (pressure >= MIN_PRESSURE && pressure <= getMaxPressure())
            this.pressure = pressure;
    }

    /**
     * método get para el atributo maxPressure
     * @return el valor de maxPressure
     */
    public double getMaxPressure()
    {
        return this.maxPressure;  
    }

    /**
     * método get para el atributo pressure
     * @return el valor de pressure
     */
    public double getPressure()
    {
        return this.pressure;  
    }

    /**
     * metodo test para la clase Wheel
     * @return true si el valor de la ecuación es verdadero
     * @return falso si el valor de la ecuación es falso
     */
    public boolean test()
    {
        if(getPressure() >= (getMaxPressure()*THRESHOLD/100.0))
            return true;      
        else
            return false;   
    }

    /**
     * metodo toString de la clase Wheel
     * @return el valor del String cadena
     */
    public String toString()
    {
        String cadena = new String();
        cadena = String.format("MaxP: %.1f Mb - Pressure: %.1f Mb - Percentage: %.2f - Test:",getMaxPressure(),getPressure(),getPressure()/getMaxPressure()*100);
        if (test())
            cadena = cadena + "true";
        else
            cadena = cadena + "false";
        return cadena; 
    }

    /**
     * metodo print de la  clase Wheel
     */
    public void print()
    {
        String data1 = "Current Pressure....... " + getPressure() + "Mb";
        String data2 = "Max Pressure... " + getMaxPressure() + " (" + ((getPressure()*100)/getMaxPressure()) + ") %";
        String data3 = "Test............... ";
        if (test())
            data3 = data3 +"OK";
        else
            data3 = data3 + "FAIL";   
        System.out.println(data1);
        System.out.println(data2);
        System.out.println(data3);
    }
}

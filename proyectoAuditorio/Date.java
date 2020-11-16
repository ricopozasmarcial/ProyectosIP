
/**
 * CLASE DATE DE LA SESION NO PRESENCIAL 10
 * 
 * @author MARCIAL RICO POZAS
 * @version 24/11/2017
 */
public class Date
{
    //atributos de la clase Date
    private int day;
    private int month;
    private int year;
    
    /**
     * constructor con parametros de objetos de la clase Date
     * @param day, un entero que asigna un valor al dia
     * @param month, un entero que asigna un valor al mes
     * @param year, un entero que asigna un valor al año
     * 
     */
    public Date(int day, int month, int year)
    {
     setDay(day);
     setMonth(month);
     setYear(year);
    }
    
    /**
     * metodo set del atributo day
     * @param day, un entero que asigna un valor al dia
     */
    private void setDay(int day)
    {
     this.day = day;
    }
    
     /**
     * metodo set del atributo month
     * @param month, un entero que asigna un valor al mes
     */
    private void setMonth(int month)
    {
     this.month = month;
    }
    
     /**
     * metodo set del atributo year
     * @param year, un entero que asigna un valor al año
     */
    private void setYear(int year)
    {
     this.year = year;
    }
    
    /**
     * metodo get del atributo day
     * @return el valor de day
     */
    public int getDay()
    {
        return this.day;
    }
    
    /**
     * metodo get del atributo month
     * @return el valor de month
     */
    public int getMonth()
    {
        return this.month;
    }
    
    /**
     * metodo get del atributo year
     * @return el valor de year
     */
    public int getYear()
    {
        return this.year;
    }
}

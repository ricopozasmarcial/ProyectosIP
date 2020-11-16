
/**
 * CLASE CONCERT DE LA SESION NO PRESENCIAL 9
 * 
 * @author MARCIAL RICO POZAS 
 * @version 24/11/2017
 */
public class Concert
{
    //atributos de la clase concert
    private String name;
    private double price;
    private Date date;

    /**
     * constructor con parametros de objetos de la clase Concert
     * @param name, un String que asigna el nombre del concierto
     * @param price, un double que asigna el precio
     * @param date, un Date que asigna una fecha al concierto
     */
    public Concert (String name, double price, Date date)
    {
        setName(name);
        setPrice(price);
        setDate(date);
    }

    /**
     * metodo set del atributo name
     * @param name, un string que asigna un nombre
     */
    private void setName(String name)
    {
        this.name = name;
    }

    /**
     * metodo set del atributo price
     */
    private void setPrice(double price)
    {
        this.price = price;
    }

    /**
     * metodo set del atributo date
     * @param date, un tipo Date que asigna una fecha al concierto
     */
    private void setDate(Date date)
    {
        if(date != null)
            this.date = date;
    }
    
    /**
     * metodo get del atributo name
     * @return el valor de name
     */
    public String getName()
    {
        return this.name;
    }
    
    /**
     * metodo get del atributo price
     * @return el valor de price
     */
    public double getPrice()
    {
        return this.price;
    }
    
    /**
     * metodo get del atributo Date
     * @return el valor de Date
     */
    public Date getDate()
    {
        return this.date;
    }
}

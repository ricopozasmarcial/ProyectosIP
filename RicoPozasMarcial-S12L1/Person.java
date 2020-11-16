import java.util.*;

/**
 * clase Person para tarea no presencial 2.
 * 
 * @author (Marcial Rico Pozas) 
 * @version (01/10/2017)
 */
public class Person
{
    //constantes de la clase Person
    public final static int MIN_AGE = 0;
    public final static int MAX_AGE = 120;
    public final static boolean GENDER_MALE = true;
    public final static boolean GENDER_FEMALE = false;    
    public final static int ADULTHOOD_AGE = 18;
    public final static int RETIREMENT_AGE = 65;
    public final static String[] DEF_FEMALE_NAMES ={"Gema", "nuria", "Natalia" , "Bea"};
    public final static String[] DEF_MALE_NAMES ={"Marcial", "Armando", "Miguel" , "Carlos"};
    public final static String[] DEF_SURNAMES ={"Rico", "Pozas", "Romero" , "Lobeiras"};

    //atributos de la clase Person
    private int age;
    private String name;
    private String surname;
    private boolean gender;
    private int criticalAge;
    /**
     * constructor de objetos de la clase Person
     */
    public Person()
    {
        Random r;
        r = new Random();
        setGender(r.nextBoolean());
        if(getGender() == GENDER_MALE)
        {
            setName(DEF_MALE_NAMES[r.nextInt(DEF_MALE_NAMES.length)]); 
            setSurname(DEF_SURNAMES[r.nextInt(DEF_SURNAMES.length)]);
            setAge(r.nextInt(MAX_AGE));
        }
        else
        {               
            setName(DEF_FEMALE_NAMES[r.nextInt(DEF_FEMALE_NAMES.length)]); 
            setSurname(DEF_SURNAMES[r.nextInt(DEF_SURNAMES.length)]);
            setAge(r.nextInt(MAX_AGE));
        }

        //setName("Marcial"); 
        //setSurname("Rico Pozas");
        //setAge(r.nextInt(MAX_AGE));
    }

    /**
     * constructor con parámetros de la clase Person
     * @param age de tipo entero que asigna la edad
     */
    public Person(int age)
    {
        this();
        setAge(age); 
    }

    /**
     * constructor con parámetros de la clase Person
     * @param name de tipo String que asigna un nombre
     */
    public Person (String name)
    {
        this();
        setName(name);
    }

    /**
     * constructor con parámetros de la clase Person
     * @param name de tipo String que asigna un nombre
     * @param surname de tipo String que asigna un apellido
     * @param age de tipo entero que asigna la edad
     * @param boolean de tipo booleano que asigna un sexo
     */
    public Person (String name, String surname, int age, boolean gender)
    {
        this();
        setName(name);
        setSurname(surname);
        setAge(age);
        setGender(gender); 
    }

    /**
     * metodo set para el atributo age
     * @param age de tipo entero que asigna la edad
     */
    public void setAge(int age)
    {
        if (age>=MIN_AGE && age<MAX_AGE)
            this.age = age;
        if (age<MIN_AGE && age>=MAX_AGE)
            this.age = 000;
    }

    /**
     * metodo get para el altributo age
     * @return el valor de age
     */
    public int getAge ()
    {
        return age;
    }

    /**
     * metodo set para el atributo name
     * @param name de tipo String que asigna un nombre
     */
    public void setName (String name)
    {
        this.name = name;
    }

    /**
     * metodo get para el atributo name
     * @return el valor de name
     */
    public String getName ()
    {
        return name;
    }

    /**
     * metodo set para el atributo surname
     * @param surname de tipo String que asigna un apellido
     */     
    public void setSurname (String surname)
    {
        this.surname = surname;
    }

    /**
     * metodo get para el atributo surname
     * @return el valor de surname
     */
    public String getSurname()
    {
        return surname;
    }

    /**
     * metodo set para el atributo gender
     * @param gender de tipo booleano que asigna un sexo
     */
    public void setGender (boolean gender)
    {
        this.gender = gender;
    }

    /**
     * metodo get para el atributo get
     * @return el estado de gender
     */
    public boolean getGender ()
    {
        return gender;
    }

    /**
     * metodo get para el atributo age
     * @return el valor de criticalAge()
     */
    public int getCriticalAge()
    { 
        if (age <= ADULTHOOD_AGE )
        {
            criticalAge = ADULTHOOD_AGE - age;
        }
        else if (age > ADULTHOOD_AGE && age < RETIREMENT_AGE)
        {
            criticalAge = RETIREMENT_AGE - age;   
        }
        else if  (age >= RETIREMENT_AGE)
        {
            criticalAge = age - RETIREMENT_AGE;  
        }    
        return criticalAge;
    }

    /**
     * metodo que imprime un mensaje en la pantalla de comandos
     */
    public void print()
    {
        System.out.println("Mi edad es "+ getAge() + " pero el año que viene tendre " + ( getAge() +1) + " años");
        System.out.println("Datos completos de persona");
        System.out.println(toString());

    }

    /**
     * matodo toString() que deuvelve una cadena
     * @return la cadena data establecida
     */
    public String toString()
    {
        String data = "Nombre = " + this.getName() + " Apellido = " + this.getSurname() + " Edad = " + this.getAge() + " Sexo = "; 
        if (gender == true)
            data = data + "Masculino";
        else
            data = data + "Femenino";
        return data;
    }

    /**
     * metodo metodoDePrueba para asignar distintos nombres
     */
    public void metodoDePrueba()
    {
        Person a,b;

        a=new Person();
        b=new Person();

        b.setName ("María");
        a.setName ("Pedro");

        System.out.println(a.getName());
        System.out.println(b.getName());
    }

    /**
     * METODO getHashCode que devuelve una cadena
     * @return la cadena establecida en mayúsculas
     */
    public String getHashCode()
    {                
        String hashCode = (getAge() + " - " + getName().substring(0,2) + " - " + getSurname().substring(0,4) + " - " + getAgeRank());         
        return hashCode.toUpperCase();
    }

    /**
     * metodo getAgeRank() que deuvelve un string en función de la edad
     * @return "CHILD" si la edad está por debajo de 18
     * @return "ADULT" si la edad está por encima de 18 y encima de 65
     * @return "RETIRED" si la edad está por encima de 65
     */
    public String getAgeRank()
    {
        if (getAge() < ADULTHOOD_AGE )

            return "CHILD";

        else if (getAge() >= ADULTHOOD_AGE && getAge()< RETIREMENT_AGE)

            return "ADULT";   

        else 
            return "RETIRED"; 
    }

}


/**
 * Write a description of class LandingGear here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LandingGear
{
    //constantes de la clase LandingGear
    public final static boolean LEVER_UP = true;
    public final static boolean LEVER_DOWN = false;
    public final static WheelStrut DEF_WHEEL_STRUT = new WheelStrut();
    //atributos de la clase LandingGear
    private boolean lever;
    private WheelStrut nose;
    private WheelStrut left;
    private WheelStrut right;

    /**
     * constructor sin parametros de obejtos de la clase LandingGear
     */
    public LandingGear()
    {
        setNose(DEF_WHEEL_STRUT);
        setLeft(DEF_WHEEL_STRUT);
        setRight(DEF_WHEEL_STRUT);
        setLever(LEVER_DOWN);
        nose.deploy();
        left.deploy();
        right.deploy();
    }

    /**
     * metodo set del atributo lever
     * @param lever, un booleano que establece la posicion de lever
     */
    private void setLever(boolean lever)
    {
        this.lever = lever;
    }

    /**
     * metodo set del atributo nose
     * @param nose, un WheelStrut que establece el estado de nose
     */
    private void setNose(WheelStrut nose)
    {
        if(nose != null)
            this.nose = nose;
    }

    /**
     * metodo set del atributo left
     * @param left, un WheelStrut que establece el estado de left
     */
    private void setLeft(WheelStrut left)
    {
        if(left != null)
            this.left = left;
    }

    /**
     * metodo set del atributo right
     *  @param right, un WheelStrut que establece el estado de right
     */
    private void setRight(WheelStrut right)
    {
        if(right != null)
            this.right = right;
    }

    /**
     * metodo get del atributo lever
     * @return el valor de lever
     */
    public boolean getLever()
    {
        return this.lever;
    }

    /**
     * metodo get del atributo nose
     * @return el estado de nose
     */
    public WheelStrut getNose()
    {
        return this.nose;
    }

    /**
     * metodo get del atributo left
     * @return el estado de left
     */
    public WheelStrut getLeft()
    {
        return this.left;
    }

    /**
     * metodo get del atributo right
     * @return el estado de right
     */
    public WheelStrut getRight()
    {
        return this.right;
    }

    /**
     * metodo moveLever de la clase LandingGear
     * @param action, un booleano que cambia el estado de la palanca
     */
    public void moveLever(boolean action)
    {
        if(action == LEVER_UP)
        {
            this.lever = LEVER_UP;
            nose.retract();
            right.retract();
            left.retract();
        }
        else if (action == LEVER_DOWN)
        {
            this.lever = LEVER_DOWN;
            nose.deploy();
            left.deploy();
            right.deploy();
        }
    }

    /**
     * metodo test de la clase LandingGear
     */
    public boolean test()
    {
        if(getNose().test() == true && getLeft().test() == true && getRight().test() == true)
            return true;
        else
            return false;
    }

    /**
     * metodo print de la clase LandingGear
     */
    public void print()
    {
        String data = "";
        if(getLever() == LEVER_UP)
            data = "UP";
        else if (getLever() == LEVER_DOWN)
            data = "DOWN";
        System.out.println("Lever................." + data);
        String data2 = "";
        if(test() == true)
            data2 = "TRUE";
        else if (test() == false)
            data2 = "FALSE"; 
        System.out.println("Test.................." + data2 + ".");

        String data3 = "";
        String data4 = "";
        String data5 = "";
        if(nose.test() != true )
            data3 = "FAIL";
        else if (nose.test() == true && nose.getDeployed() == true)
            data3 = "ON";
        else if (nose.test() == true && nose.getDeployed() != true)
            data3 = "OFF";
        if(left.test() != true )
            data4 = "FAIL";
        else if (left.test() == true && left.getDeployed() == true)
            data4 = "ON";
        else if (left.test() == true && left.getDeployed() != true)
            data4 = "OFF";
        if(right.test() != true )
            data5 = "FAIL";
        else if (right.test() == true && right.getDeployed() == true)
            data5 = "ON";
        else if (right.test() == true && right.getDeployed() != true)
            data5 = "OFF";
        System.out.println("   " + data3);
        System.out.println(data4 + "     " + data5);
    }

    /**
     * metodo toString de la clase LandingGear
     */
    public String toString()
    {
        String data1 = "";
        if(getLever() == LEVER_UP)
            data1 = "UP";
        else if (getLever() == LEVER_DOWN)
            data1 = "DOWN";
        String data2 = "";
        if(test() == true)
            data2 = "OK";
        else if (test() == false)
            data2 = "FAILURE"; 
        String data3 = "";
        if(nose.getDeployed() == true)
            data3 = "ON";
        else if (nose.getDeployed() != true)
            data3 = "OFF";
        else if (nose.getRightWheel().test() == false || nose.getLeftWheel().test() == false)
            data3 = "PRESS";
        String data4 = "";
        if(left.getDeployed() == true)
            data4 = "ON";
        else if (left.getDeployed() != true)
            data4 = "OFF";
        else if ( left.getDeployed() != true && left.getRightWheel().test() == false || left.getLeftWheel().test() == false)
            data4 = "PRESS";
        String data5 = "";
        if(right.getDeployed() == true)
            data5 = "ON";
        else if (right.getDeployed() != true)
            data5 = "OFF";
        else if (right.getDeployed() != true  && right.getRightWheel().test() == false || right.getLeftWheel().test() == false)
            data5 = "PRESS"; 
        String cadena = "Lever: " + data1 + " " + "Status: " + data2 + " " + "Nose: " + data3 + " " + "Left: " + data4 + " " + "Right: " + data5;
        return cadena;
    }
}

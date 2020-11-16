
import java.util.*;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class MatrixTest.
 *
 * @author  MARCIAL RICO POZAS
 * @version 18/12/2017
 */
public class MatrixTest
{
    /**
     * Default constructor for test class MatrixTest
     */
    public MatrixTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    /**
     * metodo de prueba del primer constructor de objetos de la clase Matrix
     */
    @Test
    public void testMatrix1()
    {
        //se crea una matriz con un valor valido
        Matrix m1 = new Matrix(5);
        assertEquals(5, m1.getMatrix().length);

        //se crea una matriz con un valor negativo
        try
        {
            m1 = new Matrix(-5);
            fail();
        }
        catch(RuntimeException rte)
        {
            assertEquals("Error: La dimensión debe estar entre 1 y" + Matrix.MAX_DIMENSION, rte.getMessage());
        }
        
        //se crea una matriz con un valor > 10
        //se crea una matriz con un valor negativo
        try
        {
            m1 = new Matrix(15);
            fail();
        }
        catch(RuntimeException rte)
        {
            assertEquals("Error: La dimensión debe estar entre 1 y" + Matrix.MAX_DIMENSION, rte.getMessage());
        }
    }
    
     /**
     * metodo de prueba del primer constructor de objetos de la clase Matrix
     */
    @Test
    public void testMatrix2()
    {
        //se crea una matriz con una dimension valida
        Matrix m1 = new Matrix(new int[5][5]);
        assertEquals(5, m1.getMatrix().length);
        
        //la matriz no es cuadrada
        try
        {
           Matrix m2 = new Matrix(new int[8][4]);
            fail();
        }
        catch(RuntimeException rte)
        {
            assertEquals("La matriz tiene que ser cuadrada", rte.getMessage());
        }
                
        //se crea una matriz con un valor > 10
        try
        {
            Matrix m4 = new Matrix(new int[15][15]);
            fail();
        }
        catch(RuntimeException rte)
        {
            assertEquals("Error: La dimensión debe estar entre 1 y" + Matrix.MAX_DIMENSION, rte.getMessage());
        }
    }

    /**
     * metodo de prueba de swapDiagonals
     * 
     */
    @Test
    public void testSwapDiagonals()
    {
        //Caso1, en que creemos una matriz de dimension impar: creamos m  de dimension 3 y le damos valores
        int [][] mx = {{1,2,3},{4,5,6},{7,8,9}};
        Matrix m = new Matrix(mx);

        //comprobamos la ejecucion del metodo comprobando los valores de la diagonal principal y secundaria
        m.swapDiagonals();
        assertEquals(3, m.getValue(0,0)); //posicion (0,0)
        assertEquals(5, m.getValue(1,1)); //posicion (1,1)
        assertEquals(7, m.getValue(2,2)); //posicion (2,2)
        assertEquals(1, m.getValue(0,2)); //posicion (0,2)
        assertEquals(9, m.getValue(2,0)); //posicion (2,0)

        //Caso2, volvemos a ejecutar el metodo con lo cual las posiciones volveran a ser las originales
        m.swapDiagonals();
        assertEquals(1, m.getValue(0,0)); //posicion (0,0)
        assertEquals(5, m.getValue(1,1)); //posicion (1,1)
        assertEquals(9, m.getValue(2,2)); //posicion (2,2)
        assertEquals(3, m.getValue(0,2)); //posicion (0,2)
        assertEquals(7, m.getValue(2,0)); //posicion (2,0)

        //Caso3, en que la matriz creada sea de dimension par: creamos una m de dimension 4 y le damos valores
        int[][] mz = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        Matrix m1 = new Matrix(mz);

        //comprobamos la ejecucion del metodo comprobando los valores de la diagonal principal y secundaria
        m1.swapDiagonals();
        assertEquals(4, m1.getValue(0,0)); //posicion (0,0)
        assertEquals(7, m1.getValue(1,1)); //posicion (1,1)
        assertEquals(10, m1.getValue(2,2)); //posicion (2,2)
        assertEquals(13, m1.getValue(3,3)); //posicion (3,3)
        assertEquals(1, m1.getValue(0,3)); //posicion (0,3)
        assertEquals(6, m1.getValue(1,2)); //posicion (1,2)
        assertEquals(11, m1.getValue(2,1)); //posicion (2,1)
        assertEquals(16, m1.getValue(3,0)); //posicion (3,0)

        //Caso4, volvemos a ejecutar el metodo con lo cual las posiciones volveran a ser las originales
        m1.swapDiagonals();
        assertEquals(1, m1.getValue(0,0)); //posicion (0,0)
        assertEquals(6, m1.getValue(1,1)); //posicion (1,1)
        assertEquals(11, m1.getValue(2,2)); //posicion (2,2)
        assertEquals(16, m1.getValue(3,3)); //posicion (3,3)
        assertEquals(4, m1.getValue(0,3)); //posicion (0,3)
        assertEquals(7, m1.getValue(1,2)); //posicion (1,2)
        assertEquals(10, m1.getValue(2,1)); //posicion (2,1)
        assertEquals(13, m1.getValue(3,0)); //posicion (3,0)

    }

    /**
     * metodo de prueba de addByColumns
     */
    @Test
    public void testAddByColumns()
    {
        //Caso1, se crea una matriz de valores impares y se llama al metodo

        int [][] mx = {{1,2,3},{4,5,6},{7,8,9}}; 
        //el array suma seria {12,15,18}
        int[] prueba = {12,15,18};
        Matrix m = new Matrix(mx);        
        //llamamos al metodo
        assertArrayEquals( prueba, m.addByColumns());

        //Caso2, se crea una matriz de valores pares y se llama al metodo
        int[][] mz = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        //el array suma seria {28,32,36,40} 
        int[] prueba1 = {28,32,36,40};
        m = new Matrix(mz);
        //llamamos al metodo
        assertArrayEquals( prueba1, m.addByColumns());

        //Caso3, se crea una matriz de valores impares vacia y se llama al metodo
        int[][] my = {{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0}, {0,0,0,0,0}};
        //el array suma seria 0
        int[] prueba2 = {0,0,0,0,0};
        m = new Matrix(my);
        //llamamos al metodo
        assertArrayEquals(prueba2, m.addByColumns());
    }

    /**
     * metodo de prueba de swapRows
     */
    @Test
    public void testSwapRows()
    {
        //Caso1, Creamos una matriz con una dimension valida de tamaño impar
        int [][] mx = {{1,2,3},{4,5,6},{7,8,9}};//las filas a cambiar seran la primera y la ultima
        int[] fila0 = {1,2,3};
        int[] fila2 = {7,8,9};
        Matrix m = new Matrix(mx); 
        //Llamamos al metodo
        m.swapRows();
        assertArrayEquals( fila0, m.getMatrix()[2]);
        assertArrayEquals(fila2, m.getMatrix()[0]);

        //Caso2, Creamos una matriz con una dimension valida de tamaño par
        int[][] my = {{1,2,3,4,5,7,8,5,4,6},{5,6,7,8,6,8,7,4,1,2},{9,10,11,12,8,6,9,4,2,5},{13,14,15,16,9,9,4,2,6,4},{4,8,7,5,6,4,8,5,2,9},{8,8,47,5,86,49,8,52,2,9},{34,8,7,65,6,4,38,5,42,9},{4,48,72,5,6,54,8,5,92,92},{46,8,7,55,6,4,8,54,28,9},{40,8,87,50,60,40,8,5,2,49}}; 
        m = new Matrix(my);
        //se cambiaran las filas 0 con la 2 y la 4 con la 6
        int[] fila00 =  {1,2,3,4,5,7,8,5,4,6};
        int[] fila02 = {9,10,11,12,8,6,9,4,2,5};
        int[] fila4 =  {4,8,7,5,6,4,8,5,2,9} ;
        int[] fila6 = {34,8,7,65,6,4,38,5,42,9};
        //llamamos al metodo
        m.swapRows();
        assertArrayEquals( fila00, m.getMatrix()[2]);
        assertArrayEquals(fila02, m.getMatrix()[0]);
        assertArrayEquals( fila4, m.getMatrix()[6]);
        assertArrayEquals(fila6, m.getMatrix()[4]);

        //Caso3, Creamos una matriz de dimension invalida menor al umbral
        int [][] mz = {{1,2},{3,4}};
        m = new Matrix(mz);
        //llamamos al metodo
        try
        {
            m.swapRows();
            fail();
        }
        catch(RuntimeException rte)
        {            
            assertEquals("la matriz es muy pequeña" , rte.getMessage());
        }
    }

    /**
     * metodo de prueba de moveColumn
     */
    @Test
    public void testMoveColumn()
    {
        //Caso1, creamos una matriz de dimension par y movemos la columna valida 0
        int[][] mz = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        Matrix m = new Matrix(mz);
        int[][] prueba = {{2,3,4,1},{6,7,8,5},{10,11,12,9},{14,15,16,13}}; //la matriz tras llamar al metodo
        m.moveColumn(0);
        assertEquals(prueba, m.getMatrix());

        //Caso2, creamos una matriz de dimension impar y movemos la columna valida 1
        int [][] mx = {{1,2,3},{4,5,6},{7,8,9}};
        Matrix m1 = new Matrix(mx);
        int[][] prueba1 = {{1,3,2},{4,6,5},{7,9,8}};
        m1.moveColumn(1);
        assertEquals(prueba, m.getMatrix());

        //Caso3, creamos una matriz pero intentamos mover una columna negativa
        int[][] my = {{1,2,40,40,50},{80,70,10,30,60},{4,5,7,5,2},{4,9,4,4,4}, {1,2,5,40,14}};
        Matrix m2 = new Matrix(my);
        try
        {
            m2.moveColumn(-1);
            fail();
        }
        catch(RuntimeException rte)
        {
            assertEquals("El parametro es invalido" ,rte.getMessage());
        }

        //Caso4, creamos una matris pero intentamos mover una columna mayor que su dimension
        int[][] mg = {{1,2,40,40,50,0},{80,70,10,30,60,0},{4,5,7,5,2,0},{4,9,4,4,4,0}, {1,2,5,40,14,0},{0,0,0,0,0,0}};
        Matrix m3 = new Matrix(mg);
        try
        {
            m3.moveColumn(10);
            fail();
        }
        catch(RuntimeException rte)
        {
            assertEquals("El parametro es invalido" ,rte.getMessage());
        }

    }

    /**
     * metodo de prueba de rotateMatrix
     */
    @Test
    public void testRotateMatrix()
    {
        //Caso1, creamos una matriz de dimension par y la rotamos 
        int[][] mz = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int[][] prueba ={{4,8,12,16},{3,7,11,15},{2,6,10,14},{1,5,9,13}};
        Matrix m = new Matrix(mz);
        m.rotateMatrix();
        assertEquals(prueba,m.getMatrix());

        //caso2, se crea una matriz de dimension impar y se rota 2 veces
        int[][] mx = {{1,2,3},{1,2,3},{1,2,3}};
        int[][] rot1 ={{3,3,3},{2,2,2},{1,1,1}};
        int[][] rot2 ={{3,2,1},{3,2,1},{3,2,1}};
        Matrix m1 = new Matrix(mx);
        //la rotamos por primera vez
        m1.rotateMatrix();
        assertEquals(rot1, m1.getMatrix());
        //la rotamos por segunda vez
        m1.rotateMatrix();
        assertEquals(rot2, m1.getMatrix());

        //caso3, se crea una matriz de dimension par y se rota hasta llegar a la misma posicion
        int [][] my = {{1,2},{3,4}};
        Matrix m3 = new Matrix(my);
        int[][] rot01 ={{2,4},{1,3}};
        int[][] rot02 ={{4,3},{2,1}};
        int[][] rot03 ={{3,1},{4,2}};
        int[][] rot04 ={{1,2},{3,4}};
        //la rotamos por 1 vez
        m3.rotateMatrix();
        assertEquals(rot01, m3.getMatrix());
        //la rotamos por 2 vez
        m3.rotateMatrix();
        assertEquals(rot02, m3.getMatrix());
        //la rotamos por 3 vez
        m3.rotateMatrix();
        assertEquals(rot03, m3.getMatrix());
        //la rotamos por ultima vez
        m3.rotateMatrix();
        assertEquals(rot04, m3.getMatrix());
    }

    /**
     * metodo de prueba de verticalReverse
     */
    @Test
    public void testVerticalReverse()
    {
        //Caso1, creamos una matriz de dimension par y llamamos al metodo
        int[][] mz = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int[][] prueba = {{1,14,3,16},{5,10,7,12},{9,6,11,8},{13,2,15,4}}; //matriz tras llamar al metodo
        Matrix m = new Matrix(mz);
        m.verticalReverse();
        assertEquals(prueba, m.getMatrix());

        //Caso2, llamamos al metodo otra vez
        m.verticalReverse();
        assertEquals(mz, m.getMatrix());

        //Caso3, la matriz no posee columnas impares
        int[][] mx = {{1}};
        Matrix m2 = new Matrix(mx);
        try
        {
            m2.verticalReverse();
            fail();
        }
        catch(RuntimeException rte)
        {
            assertEquals("la matriz no posee columnas impares", rte.getMessage());
        }
    }

    /**
     * metodo de prueba horizontalReverse
     */
    @Test
    public void testHorizontalReverse()
    {
        //Caso1, creamos una matriz de dimension par y llamamos al metodo
        int[][] mz = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int[][] prueba ={{1,2,3,4},{8,7,6,5},{9,10,11,12},{16,15,14,13}};
        Matrix m = new Matrix(mz);
        m.horizontalReverse();
        assertEquals(prueba, m.getMatrix());

        //Caso2, creamos una matriz de dimension impar y llamamos al metodo
        int[][] mx = {{1,2,3},{1,2,3},{1,2,3}};
        int[][] prueba1 ={{1,2,3},{3,2,1},{1,2,3}};
        int[][] prueba2 ={{1,2,3},{1,2,3},{1,2,3}};
        Matrix m2 = new Matrix(mx);
        //lo llamamos por primera vez
        m2.horizontalReverse();
        assertEquals(prueba1, m2.getMatrix());
        //lo llamamos por segunda vez
        m2.horizontalReverse();
        assertEquals(prueba2, m2.getMatrix());

        //Caso3, se intenta llamar al metodo con una matriz sin filas impares
        int[][] my = {{1}};
        Matrix m3 = new Matrix(my);
        try
        {
            m3.horizontalReverse();
            fail();
        }
        catch(RuntimeException rte)
        {
            assertEquals("la matriz no posee filas impares", rte.getMessage());
        }
    }
}

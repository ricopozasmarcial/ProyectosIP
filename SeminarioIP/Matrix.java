import java.util.*;
/**
 * Clase Matrix del proyecto seminario de ip
 * 
 * @author MARCIAL RICO POZAS
 * @version 18/12/2017
 */
public class Matrix
{
    //constantes de la clase Matrix
    public final static int MAX_DIMENSION = 10;

    //atributos de la clase Matrix
    private int[][] matriz;

    /**
     * constructor con  un parametros de objetos de la clase Matrix
     * 
     * @param size, un entero que establece la dimension de la matriz cuadrada.
     */
    public Matrix(int size)
    {
        if(size<0 || size> MAX_DIMENSION)
            throw new RuntimeException("Error: La dimensión debe estar entre 1 y" + MAX_DIMENSION);

        Random r = new Random();
        setMatriz(size);

        for(int i =0; i<matriz.length;i++)
            for(int j =0;j<matriz[i].length;j++)
            {
                int n = r.nextInt(100);
                while(n<5)
                    n = r.nextInt(100);
                matriz[i][j] = n;
            }

    } 

    /**
     * constructor con un parametro de la clase Matrix
     * 
     * @param matrix, una matriz bidimensional
     */
    public Matrix(int[][] matriz)
    {        
        for(int i=0;i<matriz.length;i++)
            for(int j=0;j<matriz[i].length;j++)
                if(matriz.length==matriz[i].length)
                    this.matriz = matriz;
                else
                    throw new RuntimeException("La matriz tiene que ser cuadrada");
                   
        if(matriz.length<0 || matriz.length>MAX_DIMENSION)
            throw new RuntimeException("Error: La dimensión debe estar entre 1 y" + MAX_DIMENSION);
    }

    /**
     * metodo set del atributo matrix
     * 
     * @param size, un entero que asigna la dimension
     */
    private void setMatriz(int size)
    {
        if(size<=0 || size > MAX_DIMENSION)
            throw new RuntimeException("Error: La dimensión debe estar entre 1 y" + MAX_DIMENSION); 
        matriz = new int[size][size];
    }

    /**
     * metodo swapDiagonals de la clase Matrix
     */
    public void swapDiagonals()
    {
        int fila0 = 0;
        int fila = 0;
        int columna = matriz.length-1;
        int a = 0;

        for(int i=0;i<matriz.length;i++)
            for(int j=0;j<matriz[i].length;j++)
            {
                if(i==j)
                {
                    a = matriz[fila0][fila0];
                    matriz[fila0][fila0] = matriz[fila][columna];
                    matriz[fila][columna] = a;
                    a = 0;
                    fila0++;
                    fila++;
                    columna--;
                }                   
            }
    }

    /**
     * metodo addByColumns de la clase Matrix
     * 
     * @return un vector con la suma de los elementos de sus columnas
     */
    public int[] addByColumns()
    {
        int[] suma = new int[matriz.length];
        int contador = 0;
        int sumatorio = 0;
        for(int j=0;j<matriz[0].length;j++)
        {
            while(contador< matriz.length)
            {
                sumatorio = matriz[contador][j] + sumatorio;
                suma[j]=sumatorio;
                contador++;
            }
            contador =0;
            sumatorio =0;
        } 
        return suma;
    }

    /**
     * metodo swapRows de la clase Matrix
     */
    public void swapRows()
    {
        int cambio0 = 0;
        int cambio1 = 2;
        int[] a = new int[matriz.length];
        if(matriz.length<= 2)
            throw new RuntimeException("la matriz es muy pequeña");

        while(cambio1<matriz.length)
        {
            a = matriz[cambio0];
            matriz[cambio0] = matriz[cambio1];
            matriz[cambio1]= a;
            cambio0 = cambio1+2;
            cambio1 = cambio1+4;
        }

    }

    /**
     * metodo print de la clase Matrix
     */
    public void print()
    {
        int contador = 0;
        for(int i=0;i<matriz.length;i++)
        {
            for(int j=0;j<matriz[i].length;j++)
            {    
                if(i==contador)    
                    System.out.print(matriz[i][j] + " ");
            }
            System.out.print("\n");
            contador++;
        }
        System.out.print("\n");
    }

    /**
     * metodo moveColumn de la clase Matrix
     * 
     * @param column, un entero que indica la columna a mover
     */
    public void moveColumn(int column)
    {
        if(column <0||column > matriz.length)
            throw new RuntimeException("El parametro es invalido");    
        int[] aux = new int[matriz.length];        
        for(int j=column;j<matriz[0].length-1;j++)
        {
            for(int i=0;i<matriz.length;i++)
            {
                aux[i] = matriz[i][j];
                matriz[i][j] = matriz[i][j+1];
                matriz[i][j+1] = aux[i];
            }
        }

    }

    /**
     * metodo rotateMatrix de la clase Matrix
     */
    public void rotateMatrix()
    {
        int[][] aux = new int[matriz.length][matriz.length];
        for(int i = 0;i<matriz.length;i++)
            for(int j = 0;j<matriz[i].length;j++)
                aux[matriz.length-1-j][i] = matriz[i][j];
        matriz = aux;
    }

    /**
     * metodo verticalReverse de la clase Matrix
     */
    public void verticalReverse()
    {
        if(matriz.length==1)
            throw new RuntimeException("la matriz no posee columnas impares");
        int impar = 0;
        for(int i = 0; i<matriz.length;i++)
        { 
            for(int j=1;j<matriz[i].length; j+=2)
                if((i+impar)<matriz.length && (matriz.length-1-impar)>=0)
                {
                    int fila = matriz[i][j];
                    int fila1 = matriz[matriz.length-1-impar][j];
                    matriz[i][j] = fila1;
                    matriz[matriz.length-1-impar][j] = fila;
                }
            impar++;
        }
    }

    /**
     * metodo horizontalReverse de la clase Matrix
     */
    public void horizontalReverse()
    {
        if(matriz.length==1)
            throw new RuntimeException("la matriz no posee filas impares");
        int[] aux = new int[matriz.length];
        int a = matriz.length-1;
        for(int i=1;i<matriz.length;i+=2)
        {
            for(int j=0;j<matriz[i].length;j++)
            {
                if(j<matriz.length/2)
                {
                    aux[j] = matriz[i][j];
                    matriz[i][j] = matriz[i][a];
                    matriz[i][a] = aux[j];
                    a--;
                }
            }
            a = matriz.length-1;
        }
    }

    /**
     * metodo getValue de la clase Matrix
     * 
     * @param row, un entero que indica el valor de la fila indicada
     * @param column, un entero que indica el valor de la columna indicada
     * 
     * @return el valor de la celda seleccionada
     */
    public int getValue(int row, int column)
    {
        if(row<0 || row>= matriz.length || column<0 || column>= matriz.length)
            throw new RuntimeException("parametros incorrectos");        
        return matriz[row][column];
    }

    /**
     * metodo getMatrix de la clase Matrix
     * 
     * @return el valor de la matriz
     */
    public int[][] getMatrix()
    {
        return this.matriz;
    }

}


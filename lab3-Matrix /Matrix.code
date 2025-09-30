import java.util.*;
public class Matrix {
    private int[][] data;
    
    //Constructor that initializes the matrix with the given dimensions.
    public Matrix(int rows, int cols)
    {
        if(rows <= 0 || cols <=0) throw new IllegalArgumentException("Dimensions must be positive > 0.");
        data = new int[rows][cols];
    }
    
    //Constructor that initializes the matrix with a pre-existing 2D array.
    public Matrix(int[][] data)
    {
        //validating  the 2D array
        if(data == null || data.length ==0) throw new IllegalArgumentException("2D array null or empty.");
        
        //initialzing this.data with data
        this.data = new int[data.length][data[0].length];
        
        for(int i = 0; i < data.length; i++)
        {
            this.data[i] = data[i];
        }
    }
    
    
    //Fills the matrix with random integer values between 1 and 10.
    public void populateRandom()
    {
        Random rand = new Random();
        for(int i = 0; i< data.length; i++)
        {
            for(int j = 0; j < data[i].length; j++)
            {
                data[i][j] = rand.nextInt(9) + 1;
            }
        }
    }
    
    //Adds this matrix to another matrix. 
    /* Challenge: If the matrices do not have the same dimensions, 
      this method must throw an IllegalArgumentException. Returns 
      a new Matrix object that is the sum of the two.
    */
    public Matrix add(Matrix other)
    {
        if((other.data.length != this.data.length) && (other.data[0].length != this.data.length)) throw new IllegalArgumentException("2D array dimensions are not same.");
        
        Matrix newMatrix = new Matrix(other.data.length, other.data[0].length);
        for(int i = 0; i < newMatrix.data.length; i++)
        {
            for(int j = 0; j < newMatrix.data[0].length; j++)
            {
                newMatrix.data[i][j] = this.data[i][j] + other.data[i][j];
            }
        }
        
        return newMatrix;
    }
    
    //Multiplies this matrix by another matrix.
    /* Challenge: If the number of columns in this matrix does not 
       equal the number of rows in the other matrix, throw an 
       IllegalArgumentException. Returns a new Matrix object that 
       is the product.
    */
    public Matrix multiply(Matrix other)
    {
        if((other.data.length != this.data.length) && (other.data[0].length != this.data.length)) throw new IllegalArgumentException("2D array dimensions are not same.");
        
        Matrix newMatrix = new Matrix(other.data.length, other.data[0].length);
        for(int i = 0; i < newMatrix.data.length; i++)
        {
            for(int j = 0; j < newMatrix.data[0].length; j++)
            {
                newMatrix.data[i][j] = this.data[i][j] * other.data[i][j];
            }
        }
        
        return newMatrix;
    }
    
    @Override 
    public String toString()
    {
        String matrixRep = "{";
        for(int i = 0; i < this.data.length-1; i++)
        {
            for(int j = 0; j < this.data[i].length; j++)
            {
                matrixRep += this.data[i][j];
                matrixRep += " ";
            }
            matrixRep += "\n ";
        }
        
        //last row
        for(int i = 0; i < this.data[this.data.length-1].length-1; i++)
        {
            matrixRep += this.data[this.data.length-1][i];
            matrixRep += " ";
        }
        
        //last element
        matrixRep += (this.data[this.data.length-1][this.data[0].length-1]+ "}");
        return matrixRep;
    }
}//end matrix clas

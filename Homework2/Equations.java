import java.util.*;
public class Equations {
  /****** DO NOT CHANGE THIS CLASS ***********************************/
  /*
  An object from this Equations class represents a table of n equations
  in n unknowns. For example, if we have these three equations with 
  unknowns x, y, z 

    15x + 21y - 37z = 14
    -2x - 50y + 12z = 0
    83x - 22y + 25z = 45

  then the object would have this array of information:

    15 21 -37 14
    -2 -50 12 0
    83 -22 25 45

  Thus, there is a 3x3 array of coefficients of the variables,
  plus an extra column for the right side of the equality
  */

  // instance variable M contains the equations
  HashMap<Integer,ArrayList<Double>> M; // map from row number to row

  public Equations(Double[][] matrix) {
    // save input matrix into M -- it represents the equations
    M = new HashMap<Integer,ArrayList<Double>>();
    for (int i=0;i<matrix.length;i++) { // step through rows of matrix
      ArrayList<Double> L = new ArrayList<Double>(Arrays.asList(matrix[i]));
      M.put(i,L);
      }
    }

  // probably not needed, but size() method defined
  public int size() { return M.size(); }

  // handy method to return a specific coefficient in row/column
  public Double Element(int row, int column) {
    return M.get(row).get(column);
    }

  // only used by GaussianTest, this compares two Equations instances
  public boolean fuzzyEquals(Equations other) {
    for (int row=0; row<M.size(); row++) { 
      for (int column=0; column<M.size()+1; column++) {
        double difference = Element(row,column) - other.Element(row,column);
        if ((difference < -0.01) || (difference > 0.01)) return false; 
        }
      } 
    return true;  // if not failed so far, must be OK!
    }

  // objects with a toString() method can make for nice System.out.println(..) 
  public String toString() { 
    // print contents of M for debugging purposes
    String R = ""; 
    for (int i=0; i<M.size(); i++) {
      R += String.format("\nRow %d:",i);
      for (int j=0; j<M.get(i).size(); j++) { 
        R += String.format(" %6.2f",M.get(i).get(j));
        }
      }
    return R;
    }

  }

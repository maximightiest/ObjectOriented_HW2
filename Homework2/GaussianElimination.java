import java.lang.Math.*;
import java.util.*;

class GaussianElimination extends Equations {
  public GaussianElimination(Double[][] matrix) {
    super(matrix); // superclass saves input matrix as equations
    }
  // create more methods here, used by the reduce method
  // below; also use methods in the parent class (look at
  // Equations.java to understand them)
  
  //Checks and sees what the max number in the column given, only checking from the rows that are equal
  //or higher than the column number given. EX) it will not check row 0 if you are looking for the max
  //number in column 2, it will start checking at row 2 and ignore row 0 and 1
  public int maxRow(int column_num){
      int holder = 0;
      double maxNum = 0;
      for(int i=column_num; i<this.size();i++){
          double newHolder = Math.abs(this.Element(i,column_num));
          if(newHolder > maxNum){
              maxNum = Math.abs(this.Element(i,column_num));
              holder = i;
            }
        }
      return holder;
    }
  
  //swaps two rows
  public void swapRows(int rownum, int rownum2){
      ArrayList<Double> L = new ArrayList<Double>();
      ArrayList<Double> J = new ArrayList<Double>();
      ArrayList<Double> H = new ArrayList<Double>();
      L = M.get(rownum);
      J = M.get(rownum2);
      H = M.get(rownum);
      
      M.put(rownum,J);
      M.put(rownum2,H);
      
    }
    
  //subtracts one row from another
  public void minusRows(ArrayList<Double> L, int rowToMinus){
      ArrayList<Double> J = new ArrayList<Double>();
      for(int i=0; i<this.size()+1;i++){
          double holder = L.get(i);
          double minusHolder = this.Element(rowToMinus, i);
          minusHolder = minusHolder - holder;
          J.add(minusHolder);
          
        }
      M.put(rowToMinus,J);
    }
   
    
  //uses minusRows to scale a row
  //Boy this thing is complicated but hey it works right?!?!
  //It takes the maxRow, and scales it to a factor given in reduce. It then uses minusRows to do
  //(rowtominus - L), which gives us the reduced row of the row which needs reducing, rowtominus
  //did you understand that?? Cus I didn't I just got lucky on the assignment!!!
  public void scaleRow(int rownum, double factor,int rowtominus){
      ArrayList<Double> L = new ArrayList<Double>();
      double holder = 0;
      for(int i=0; i<this.size()+1;i++){
          holder = this.Element(rownum, i);
          holder = holder * factor;
          L.add(holder);
        }
      //M.put(rownum,L);
      minusRows(L, rowtominus);
    }
      
    
  //Uses the functions above by going through each row/column and reduces and does the whole Gaussian thing
  public void reduce() {
    // this should have code to do the Gaussian elimination
    for(int i=0; i<this.size()-1;i++){
        int maxRow1 = maxRow(i);
        double maxNumber = Element(maxRow1,i);
        this.swapRows(i,maxRow1);
        for(int j=i+1; j<this.size();j++){
            double factor = (Element(j,i)/maxNumber);
            this.scaleRow(i,factor,j);
        }
    }
    }

}

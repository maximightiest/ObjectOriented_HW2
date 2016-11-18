public class GaussianTest {
  public static void main(String[] args) {
    /*
       test case for Gaussian Elimination, consisting of a 3x3 matrix
       of coefficients for the three variables x, y, and z; and a vector
       of constants to complete the equations.  Thus the equations of 
       this test case are 

          9x +   y + 63z   =  -1 
          2x + 18y -  4z   =  -2   
         12x + 13y + 14z   =  -3
    */ 
    Double[][] matrix = new Double[][] {{9.0,1.0,63.0,-1.0},
                                        {2.0,18.0,-4.0,-2.0},
                                        {12.0,13.0,14.0,-3.0}};
    /* 
        expected result after Gaussian Elimination should look something
        like this (assuming that the reduce method uses swap in each 
        iteration, to get the maximum pivot, as explained in class) 
    */
    Double[][] result_matrix = new Double[][] {{12.0,13.0,14.0,-3.0},
                                        {0.0,15.83,-6.33,-1.5},
                                        {0.0,0.0,49.0,0.42}};

    // run the test case and compare
    GaussianElimination TestCase = new GaussianElimination(matrix);
    GaussianElimination Solution = new GaussianElimination(result_matrix); 
    TestCase.reduce();
    if (Solution.fuzzyEquals(TestCase)) 
      System.out.println("Successful test\n");
    else 
      System.out.println("Failed test\n");
    System.out.println("\n" + TestCase);
    }
  }

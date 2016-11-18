public class GaussianTest2 {
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
    /* requested by student - a second, larger test case */
    Double[][] second_matrix = new Double[][] {
     {-0.03, -0.45, -0.32,  0.16,  0.20, -0.07, -0.10,  0.32, -0.35,  0.09,  0.05},
     {-0.46,  0.47, -0.07,  0.47,  0.38, -0.44, -0.39, -0.30,  0.35, -0.37, -0.47},
     {-0.30, -0.13,  0.16, -0.14, -0.15, -0.21, -0.20,  0.46, -0.07, -0.15, -0.30},
     {0.16 , 0.42 , 0.01 ,-0.33 ,-0.29 , 0.29 , 0.15 ,-0.12 , 0.36 , 0.07 ,-0.40},
     {-0.08, -0.47,  0.06, -0.27,  0.04, -0.11,  0.40,  0.41, -0.35,  0.22,  0.25},
     {-0.29, -0.22,  0.39,  0.42, -0.26,  0.43,  0.46,  0.43, -0.18,  0.03,  0.46},
     {-0.09,  0.40,  0.47, -0.37, -0.35, -0.50, -0.11,  0.33,  0.08,  0.32,  0.04},
     {-0.49, -0.17, -0.24, -0.11, -0.26,  0.49, -0.44,  0.28,  0.06,  0.09,  0.39},
     {0.45 , 0.19 ,-0.50 , 0.02 ,-0.17 , 0.36 ,-0.20 , 0.46 ,-0.35 , 0.37 , 0.45},
     {0.13 , 0.04 ,-0.08 , 0.39 ,-0.03 ,-0.42 , 0.44 , 0.34 , 0.32 ,-0.33 ,-0.20}};
    Double[][] second_result = new Double[][] {
     {-0.49 , -0.17 , -0.24,  -0.11,  -0.26,   0.49,  -0.44,   0.28,   0.06,   0.09,   0.39},
     {0.00  , 0.63  , 0.16 ,  0.57 ,  0.62 , -0.90 ,  0.02 , -0.56 ,  0.29 , -0.45 , -0.84},
     {0.00  , 0.00  ,-0.73 , -0.11 , -0.44 ,  0.86 , -0.61 ,  0.75 , -0.31 ,  0.48 ,  0.85},
     {0.00  , 0.00  , 0.00 , -0.81 , -0.98 ,  0.51 , -0.38 ,  1.08 , -0.31 ,  0.88 ,  1.02},
     {0.00  , 0.00  , 0.00 ,  0.00 , -0.94 ,  0.95 ,  0.02 ,  1.42 , -0.59 ,  0.81 ,  1.37},
     {0.00  , 0.00  , 0.00 ,  0.00 ,  0.00 , -0.70 ,  0.25 ,  0.07 ,  0.55 , -0.39 , -0.47},
     {0.00  , 0.00  , 0.00 ,  0.00 ,  0.00 ,  0.00 ,  0.64 , -0.45 ,  0.85 , -0.63 , -0.93},
     {0.00  , 0.00  , 0.00 ,  0.00 ,  0.00 ,  0.00 ,  0.00 ,  0.82 , -0.87 ,  0.68 ,  0.78},
     {0.00  , 0.00  , 0.00 ,  0.00 ,  0.00 ,  0.00 ,  0.00 ,  0.00 ,  0.15 , -0.41 , -0.74},
     {0.00  , 0.00  , 0.00 ,  0.00 ,  0.00 ,  0.00 ,  0.00 ,  0.00 ,  0.00 ,  0.13 , -0.25}};
    // run the test cases and compare
    GaussianElimination TestCase = new GaussianElimination(matrix);
    GaussianElimination Solution = new GaussianElimination(result_matrix); 
    TestCase.reduce();
    if (Solution.fuzzyEquals(TestCase)) 
      System.out.println("Successful on first test case\n");
    else 
      System.out.println("Failed on first test case\n");
    System.out.println("\n" + TestCase);
    System.out.println("\n-------------------------------\n");
    TestCase = new GaussianElimination(second_matrix);
    Solution = new GaussianElimination(second_result);
    TestCase.reduce();
    if (Solution.fuzzyEquals(TestCase)) 
      System.out.println("Successful on second test case\n");
    else 
      System.out.println("Failed on second test case\n");
    System.out.println("\n" + TestCase);
    }
  }

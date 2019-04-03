/**
 * Glass Falling
 */
public class GlassFalling {

  // Do not change the parameters!
  public int glassFallingRecur(int floors, int sheets) {
    // Fill in here and change the return
      if (floors == 1 || floors == 0) {
		    return floors;
	    }
	    if (sheets == 1) {
		    return floors;
	    }
	  
	  int minimumTrials = Integer.MAX_VALUE;
	  int result;
	  
	  for (int i = 0; i <= floors; i++) {
		  result = 1 + Math.max(glassFallingRecur(0, floors - 1), glassFallingRecur(sheets - 1, floors));
		  minimumTrials = Math.min(result, minimumTrials);
		  
		  if (result < minimumTrials) {
			  minimumTrials = result;
		  }
	  }
	  
	  
    return minimumTrials + 1;
  }

  // Optional:
  // Pick whatever parameters you want to, just make sure to return an int.
  public int glassFallingMemoized() {
    // Fill in here and change the return
    return 0;
  }

  // Do not change the parameters!
  public int glassFallingBottomUp(int floors, int sheets) {
    // Fill in here and change the return
    int glassFloor[][] = new int [sheets + 1][floors + 1];
	  int result;
	  int i, j;
	  
	  for (i = 0; i <= sheets; i++) {
		  glassFloor[i][1] = 1;
		  glassFloor[i][0] = 0;
	  }
	  for (j = 1; j <= floors; j++) {
		  glassFloor[1][j] = j;
	  }
	  for (i = 2; j <= sheets; i++) {
		  for (j = 2; j <= floors; j++) {
			  glassFloor[i][j] = Integer.MAX_VALUE;
			  for (int n = 1; n <= j; n++) {
				  result = 1 + Math.max(glassFloor[i - 1][n - 1], glassFloor[i][j - n]);
				  if (result < glassFloor[i][j])
					  glassFloor[i][j] = result;
			  }
		  }
	  }
    return glassFloor[sheets][floors];
    return 0;
  }


  public static void main(String args[]){
      GlassFalling gf = new GlassFalling();

      // Do not touch the below lines of code, and make sure
      // in your final turned-in copy, these are the only things printed
      int minTrials1Recur = gf.glassFallingRecur(27, 2);
      int minTrials1Bottom = gf.glassFallingBottomUp(27, 2);
      int minTrials2Recur = gf.glassFallingRecur(100, 3);
      int minTrials2Bottom = gf.glassFallingBottomUp(100, 3);
      System.out.println(minTrials1Recur + " " + minTrials1Bottom);
      System.out.println(minTrials2Recur + " " + minTrials2Bottom);
  }
}

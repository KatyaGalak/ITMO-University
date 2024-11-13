import java.util.Random;

public class Lab1 {
	private static final int ELEMENT_FROM_FIRST_ARRAY = 5;
	private static final int ELEMENT_TO_FIRST_ARRAY = 19;
	private static final double ELEMENT_FROM_SECOND_ARRAY = -5.0;
	private static final double ELEMENT_TO_SECOND_ARRAY = 2.0;
	private static final int SIZE_ARRAY_Z1_OF_Y = 8;
	private static final int SIZE_ARRAY_Z1_OF_X = 16;
	private static final int SIZE_ARRAY_X = 16;
	
    private static int[] generateArray1(int start, int end) {
        int sizeArray = (end - start) / 2 + 1;
        int ans[] = new int[sizeArray];
        
        for (int i = 0; i < sizeArray; ++i) {
            ans[i] = end;
            end -= 2;
        }

        return ans;
    }

    private static float[] generateArray2(int numNumbers, double start, double end) {
        float ans[] = new float[numNumbers];
        Random rn = new Random();
        
        for (int i = 0; i < numNumbers; ++i) {
            ans[i] = (float)rn.nextDouble(end - start) + (float)start;
        }

        return ans;
    }
	
	private static double calcMatrixElem(int z, float x) {
		double ans;
		
		if (z == 5) {
			ans = Math.cos(
					Math.pow(
						Math.pow(x, x + 1.0), Math.atan((x - 1.5) / 7.0) / 2.0
					)
			);
		} else if(z == 7 || z == 11 || z == 17 || z == 19) {
			ans = Math.atan(
					Math.sin(
						Math.tan(
							Math.pow(3.0 * x, 2)
						)
					)
			);
		} else {
			ans = Math.pow(
					Math.pow(
						Math.asin(
							Math.pow((x - 1.5) / 7.0, 2)
						), 1.0 / 3.0
					), 1.0 / 3.0
			);
		}
		
		return ans;
	}

    private static double[][] generateArray3(int sizeY, int sizeX, int[] z, float[] x) {
        double[][] ans = new double[sizeY][sizeX];

        for (int i = 0; i < sizeY; ++i) {
            for (int j = 0; j < sizeX; ++j) {
                ans[i][j] = calcMatrixElem(z[i], x[j]);
            }
        }

        return ans;
    }

    private static void printTwoDArrayDouble(double[][] array) {
        System.out.println("z1 array:");
        for (double[] line : array) {
            for (double element : line) {
                System.out.format("%7.3f ", element);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {	
        int[] z = generateArray1(ELEMENT_FROM_FIRST_ARRAY, ELEMENT_TO_FIRST_ARRAY);
        float[] x = generateArray2(SIZE_ARRAY_X, ELEMENT_FROM_SECOND_ARRAY, ELEMENT_TO_SECOND_ARRAY);
        double[][] z1 = generateArray3(SIZE_ARRAY_Z1_OF_Y, SIZE_ARRAY_Z1_OF_X, z, x);

        printTwoDArrayDouble(z1);
    }
}

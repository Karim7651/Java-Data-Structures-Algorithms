public class Array {
    //Missing Number
    //Find the missing number in an integer array of 1 to 100
    public static int missingNumber(int[] array) {
        int length = 10;
        int properSum = 100 * (100 + 1) / 2; //n(n+1)/2
        int arraySum = 0;
        for (int i = 0; i < length; i++) {
            arraySum += array[i];
        }
        return properSum - arraySum;

    }

    public static int[] twoSum(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] + array[j] == target) {
                    return new int[]{array[i], array[j]};
                }
            }
        }
        throw new IllegalArgumentException("No matches found");
    }

    public static Boolean isPermutation(int[] array1, int[] array2) {
        if (array2.length != array1.length)
            return false;
        int sum1 = 0;
        int sum2 = 0;
        int mul1 = 1;
        int mul2 = 1;
        for (int i = 0; i < array1.length; i++) {
            sum1 += array1[i];
            sum2 += array2[i];
            mul1 *= array1[i];
            mul2 *= array1[i];
        }
        return ((sum1==sum2) &&(mul1 == mul2));
    }

    public static boolean rotateImageByNinetyDegreesRight(int[][] matrix){
        if(matrix.length == 0 || matrix.length != matrix[0].length){
            return false;
        }
        int rows = matrix.length;
        int columns = matrix[0].length; // same as rows but for calrity
        //transpose in place
        for(int i = 0 ; i < rows ; i++){
            for(int j = i ; j < columns ; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        //two pointer vertical mirror
        //columns-1-j is the vertical mirror to current i j
        for(int i = 0 ; i < rows ; i++){
            for(int j = 0 ; j < columns/2 ; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][columns-1-j];
                matrix[i][columns-1-j] = temp;
            }
        }
        return true;
    }


    public static int[][] transposeMatrix(int[][] matrix){
        int rows = matrix.length;
        int columns = matrix[0].length;
        int[][] transposedMatrix = new int[columns][rows];
        for(int i = 0 ; i < rows ; i++){
            for(int j = 0 ; j <columns ; j++){
                transposedMatrix[j][i] = matrix[i][j];
            }
        }
        return transposedMatrix;
    }
}

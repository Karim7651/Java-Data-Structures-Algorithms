public class MatrixMultiplication {
    public static int[][] multiply(int[][] arr1 , int[][] arr2){
        int rows1 = arr1.length;
        int col1 =  arr1[0].length;
        int rows2 = arr2.length;
        int cols2 =  arr2[0].length;
        if(col1 != rows2){
            System.out.print("Matrices can't be multiplied");
            return null;
        }
        int[][] resultMatrix = new int[rows1][cols2];
        for(int i = 0 ; i < rows1;i++){
            for(int j = 0 ; j <  cols2; j++){
                resultMatrix[i][j] = 0;
                for(int k = 0 ; k < rows2; k++){
                    resultMatrix[i][j] += arr1[i][k]*arr2[k][j];
                }
            }
        }
        return resultMatrix;
    }
}

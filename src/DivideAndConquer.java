public class DivideAndConquer {
    public static int fib(int n){
        // 0 1 1 2 3 5 8 13
        if(n<2){
            return n;
        }
        return fib(n-1) + fib(n-2);
    }
    //find number of factors
    //sum of 1,3,4
    public static int numberFactor(int n){
        //{},{1},{1,1}
        //why ? n==0 returns 1 ?
        if((n==0) || (n==1) || (n==2)){
            return 1;
        }
        if(n==3){ //{1,1,1} , {3}
            return 2;
        }
        int subProblem1 = numberFactor(n-1);
        int subProblem2 = numberFactor(n-3);
        int subProblem3 = numberFactor(n-4);
        return subProblem1 + subProblem2 + subProblem3;
    }
    //call this with currentHouse = 0;
    public static int maxValueHouse(int[] houses, int currentHouse){
        if(currentHouse >= houses.length)
            return 0;
        int stealFirstHouse = houses[currentHouse] + maxValueHouse(houses,currentHouse+2);
        int skipFirstHouse = maxValueHouse(houses,currentHouse+1);
        return Math.max(skipFirstHouse,stealFirstHouse);
    }
    /*
    * s1 , s2 are given strings
    * convert s2 to s1 using delete, replace, insert operations
    * find minimum numberOfChanges to convert s2 to s1*/
    public static int convertString(String s1 , String s2 , int indexOne, int indexTwo){
        if(indexOne == s1.length() ){
            // the rest of s2 needs to be deleted to be like s1
            return s2.length() - indexOne;
        }
        if(indexTwo == s2.length()){
            //the rest of s1 needs to be inserted to s2 to be like s1
            return s1.length() - indexTwo;
        }
        if(s1.charAt(indexOne) == s2.charAt(indexTwo)){
            return convertString(s1,s2,indexOne+1,indexTwo+1);
        }else{
            int toReplace = convertString(s1,s2,indexOne+1,indexTwo+1);
            int toDelete = convertString(s1,s2,indexOne+1,indexTwo);
            int toInsert = convertString(s1,s2,indexOne,indexTwo+1);
            return Math.min(toReplace,Math.min(toDelete,toInsert));
        }

    }
    public static int zeroOrOneKnapsack(int[] profits,int[] weights,int currentIndex,int capacity){
        if(currentIndex>=weights.length || weights[currentIndex] > capacity || capacity==0){
            return 0;
        } else if (weights[currentIndex]<=capacity) {
            //take it or don't take it
            int take = profits[currentIndex] + zeroOrOneKnapsack(profits,weights,currentIndex+1,capacity-weights[currentIndex]);
            int dontTake = zeroOrOneKnapsack(profits,weights,currentIndex+1,capacity);
            return Math.max(take,dontTake);
        }
        return 0;
    }

    public static int longestCommonSubsequence(String s1 , String s2 , int index1, int index2){
        if( index1 == s1.length() || index2 == s2.length() ){
            return 0;
        }if(s1.charAt(index1) == s2.charAt(index2)){
            return 1 + longestCommonSubsequence(s1,s2,index1+1,index2+1);
        }else{
            int increments1 = longestCommonSubsequence(s1,s2,index1+1,index2);
            int increments2 = longestCommonSubsequence(s1,s2,index1,index2+1);
            return Math.max(increments1,increments2);
        }
    }

    public static int longestCommonPalindromicSubsequence(String s , int leftIndex , int rightIndex){
        if(leftIndex>=rightIndex){
            return 0;
        }if(s.charAt(leftIndex) == s.charAt(rightIndex)){
            return 2 + longestCommonPalindromicSubsequence(s,leftIndex++,rightIndex--);
        }else{
            int incrementLeftIndex = longestCommonPalindromicSubsequence(s,leftIndex++,rightIndex);
            int incrementRightIndex = longestCommonPalindromicSubsequence(s,leftIndex,rightIndex--);
            return Math.max(incrementLeftIndex,incrementRightIndex);
        }
    }

    public static int minimumCostToReachLastCell(int[][] array, int i,int j){
        if(i==array.length - 1 && j== array[0].length - 1){
            return array[i][j];
        }
        if(i==array.length  || j== array[0].length ){
            //we went over array bounds so we reject this pathing
            return Integer.MAX_VALUE;
        }
        int moveRight = minimumCostToReachLastCell(array,i,j+1);
        int moveDown = minimumCostToReachLastCell(array,i+1,j);
        return Math.min(moveRight,moveDown) + array[i][j];
    }

    public static int numberOfPathsToReachLastCellWithGivenCost(int[][] array,int i ,int j,int cost){
        if(cost < 0){
            return 0;
        }
        if(i == array.length - 1 && j== array[0].length - 1){
            if(array[i][j] - cost == 0)
                return 1;
            else
                return 0;
        }
        if(i == array.length -1){
            return numberOfPathsToReachLastCellWithGivenCost(array,i,j++,cost-array[i][j]);
        } else if (j == array[0].length-1) {
            return numberOfPathsToReachLastCellWithGivenCost(array,i++,j,cost-array[i][j]);
        }else{
            int moveRight = numberOfPathsToReachLastCellWithGivenCost(array,i, j++,cost-array[i][j]);
            int moveLeft = numberOfPathsToReachLastCellWithGivenCost(array,i++,j,cost-array[i][j]);
            return moveLeft + moveRight;
        }

    }
}

public class DynamicProgramming {
    //O(N)
    //O(N)
    private static int fib(int n , int[] cachedResults){
        if(n<2)
            return n;
        if(cachedResults[n] == 0){
            int result = fib(n-1,cachedResults) + fib(n-2,cachedResults);
            cachedResults[n] = result;
            return result;
        }else{
            return cachedResults[n];
        }
    }
    public static int fib(int n){
        int[] cachedResults = new int[n+1];
        cachedResults[0] = 0;
        cachedResults[1] = 1;
        return fib(n,cachedResults);
    }

    public static int fibTabulation(int n){
        int[] cachedResults = new int[n+1];
        cachedResults[0] = 0;
        cachedResults[1] = 1;
        for(int i = 2 ; i < cachedResults.length ; i++){
            cachedResults[i] = cachedResults[i-1] + cachedResults[i-2];
        }
        return cachedResults[cachedResults.length-1];
    }

    //1, 3, 4
    private static int numberFactorMemo(int n , int[] dp){
        if(n==0 || n==1 || n==2){
            return 1;
        }if(n == 3){
            return 2;
        }else if (dp[n] != 0){
            return dp[n];
        }else{
            int factor1 = numberFactorMemo(n-1,dp);
            int factor2 = numberFactorMemo(n-3,dp);
            int factor3 = numberFactorMemo(n-4,dp);
            dp[n] = factor1 + factor2 + factor3;
            return dp[n];
        }

    }
    public static int numberFactorMemo(int n){
        return numberFactorMemo(n,new int[n+1]);
    }
    public static int numberFactorTabulation(int n){
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;
        for(int i = 4 ; i<dp.length ; i++){
            dp[i] = dp[i-1] + dp[i-3] + dp[i-4];
        }
        return dp[n];
    }

}

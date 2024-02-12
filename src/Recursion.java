public class Recursion {
    public static StringBuilder binary = new StringBuilder();
    public static int sumOfDigitsOfPositiveInteger(int n) {
        if (n < 0)
            return -1; //invalid
        if (n == 0)
            return 0;
        return n % 10 + sumOfDigitsOfPositiveInteger(n / 10);
    }

    public static int powerUsingRecursion(int base, int exponent) {
        if (exponent < 0)
            return -1;
        if (exponent == 0)
            return 1;
        return base * powerUsingRecursion(base, exponent - 1);
    }

    public static int GCD(int firstNumber,int secondNumber){
        if(secondNumber>firstNumber)
            GCD(secondNumber,firstNumber);
        if(firstNumber < 0 || secondNumber < 0)
            return -1;

        if (firstNumber == 0)
            return secondNumber;
        else if(secondNumber == 0)
            return firstNumber;
        else{
            int remainder = firstNumber%secondNumber;
            return GCD(secondNumber,remainder);
        }

    }

    public static void decimalToBinaryWithStringBuilder(int decimal){
        if(decimal == 0)
            return;
        int remainder = decimal%2;
        int quotient = decimal/2;
        binary.insert(0,String.valueOf(remainder));
        decimalToBinaryWithStringBuilder(quotient);


    }

    public static int decimalToBinary(int decimal){
        if(decimal == 0)
            return 0;
        return decimal%2 + 10*decimalToBinary(decimal/2);
    }


}

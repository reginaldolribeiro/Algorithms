package exercises.hackerrank;

public class PowerSum {
    public static void main(String[] args) {
        int totalSum = 4;
        int exponent = 2;
//        System.out.println("Power " + Math.pow(2,3));
        int result = powerSum(totalSum,exponent);
        System.out.println(result);
    }

    private static int powerSum(int totalSum, int exponent) {
        return powerSumHelper(totalSum, exponent, 1);
    }

    private static int powerSumHelper(int totalSum, int exponent, int num) {
        int result = totalSum - power(num, exponent);
        System.out.println("totalSum = " + totalSum + " - power(" + num + ", " + exponent + ")" + " -  result is " + result);
        if(result == 0)
            return 1; // 1 combination
        if(result < 0)
            return 0;

        return powerSumHelper(result, exponent, num+1) + powerSumHelper(totalSum, exponent, num+1);
    }

    private static int power(int base, int exponent){
        if(exponent == 1) return base;
        return base * power(base, exponent-1);
    }
}

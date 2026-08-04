public class rec3_Sum_1_To_N_And_Factorial {
    // Parameterized Recursion
    public static void parameterizedRecursionSum1toN(int i, int sum){
        if(i == 0) {
            System.out.println(sum);
            return;
        }
        parameterizedRecursionSum1toN(i-1, sum + i);
    }
    public static int functionalRecursionFactorial(int n){
        if(n == 1) return 1;
        return n * functionalRecursionFactorial(n-1);
    }
    public static void main(String[] args) {
        parameterizedRecursionSum1toN(4, 0);
        System.out.println(functionalRecursionFactorial(4));
    }
}

public class rec5 {
    public static int functionalRecursionFibonacci(int n){
        if(n <= 1) return n;
        return functionalRecursionFibonacci(n-1) + functionalRecursionFibonacci(n-2);
    }
    public static void main(String[] args) {
        System.out.println(functionalRecursionFibonacci(6));    
    }
}

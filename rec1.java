public class rec1 {
    public static void print1toNUsingRecursion(int i, int n){
        if(i>n) return;
        System.out.println("i = " + i);
        print1toNUsingRecursion(i+1, n);
    }

    public static void printNto1UsingRecursion(int i, int n){
        if(i<1) return;
        System.out.println("i = " + i);
        printNto1UsingRecursion(i - 1, n);
    }

    public static void print1toNUsingBacktracking(int i, int n){
        if(i<1) return;
        print1toNUsingBacktracking(i-1, n);
        System.out.println("i = " + i);
    }

    public static void printNto1UsingBacktracking(int i, int n){
        if(i > n) return;
        printNto1UsingBacktracking(i + 1, n);
        System.out.println("i = " + i);
    }

    public static void main(String[] args) {
        int n = 5;
        // print1toNUsingRecursion(1, n);
        // System.out.println("----------------");
        // printNto1UsingRecursion(5, n);
        System.out.println("Backtracking ----");
        // print1toNUsingBacktracking(n, n);
        System.out.println("------------");
        printNto1UsingBacktracking(1, n);
    }
}

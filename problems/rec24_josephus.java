public class rec24_josephus {
    public static void main(String[] args) {
        int n = 7; // Number of people in the circle
        int k = 3; // Every k-th person will be eliminated

        int survivor = josephus(n, k);
        System.out.println("The position of the last survivor is: " + survivor);
    }

    public static int josephus(int n, int k) {
        if (n == 1) {
            return 1; // Base case: only one person left
        } else {
            // Recursive case: find the position of the survivor in the reduced problem
            return (josephus(n - 1, k) + k - 1) % n + 1;
        }
    }
}
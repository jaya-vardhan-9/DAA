public class obst {

    public static int optimalSearchTree(int[] keys, int[] freq) {
        int n = keys.length;
        int[][] cost = new int[n + 1][n + 1];

        // Initialize the diagonal cells with the frequency of single keys
        for (int i = 0; i < n; i++)
            cost[i][i] = freq[i];

        // Consider chains of increasing length
        for (int length = 2; length <= n; length++) {
            for (int i = 0; i <= n - length + 1; i++) {
                int j = i + length - 1;
                cost[i][j] = Integer.MAX_VALUE;

                // Try making all keys in the current range as root
                for (int r = i; r <= j; r++) {
                    int c = ((r > i) ? cost[i][r - 1] : 0) +
                            ((r < j) ? cost[r + 1][j] : 0) +
                            sum(freq, i, j);
                    if (c < cost[i][j])
                        cost[i][j] = c;
                }
            }
        }
        return cost[0][n - 1];
    }

    // A utility function to get sum of array elements freq[i] to freq[j]
    public static int sum(int[] freq, int i, int j) {
        int s = 0;
        for (int k = i; k <= j; k++) {
            s += freq[k];
        }
        return s;
    }

    public static void main(String[] args) {
        int[] keys = {10, 12, 20};
        int[] freq = {34, 8, 50};
        System.out.println("Cost of optimal BST is " + optimalSearchTree(keys, freq));
    }
}

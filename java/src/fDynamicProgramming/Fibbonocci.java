package fDynamicProgramming;

public class Fibbonocci {
	
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
       
        if (N < 1 || N > 92) {
            throw new RuntimeException("N must be between 1 and 92");
        }

        long[] fib = new long[N+1];

        // base cases
        fib	[0] = 0;
        fib[1] = 1;

        // bottom-up dynamic programming
        for (int n = 2; n <= N; n++)
            fib[n] = fib[n-1] + fib[n-2];

        // print results
        System.out.println(fib[N]);

    }
	
}

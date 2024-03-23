public class fibonacci {
    public static void main(String[] args) {
        int[] nValues = {10, 30, 50, 70};

        for (int n : nValues) {
            long startTime = System.currentTimeMillis();
            int result = fib(n);
            long endTime = System.currentTimeMillis();
            long elapsedTime = endTime - startTime;
            System.out.println("n = " + n + ", Fibonacci = " + result + ", 실행 시간(ms) = " + elapsedTime);
        }
    }

    public static int fib(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }
}


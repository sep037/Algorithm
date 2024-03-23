public class fibonacci2 {
    public static void main(String[] args) {
        int[] nValues = {10, 30, 50, 70};

        // 알고리즘 1.7을 이용한 피보나치 수 계산 및 실행 시간 분석
        System.out.println("알고리즘 1.7을 이용한 피보나치 수 계산");
        for (int n : nValues) {
            long startTime = System.currentTimeMillis();
            int result = fib2(n);
            long endTime = System.currentTimeMillis();
            long elapsedTime = endTime - startTime;
            System.out.println("n = " + n + ", Fibonacci = " + result + ", 실행 시간(ms) = " + elapsedTime);
        }
    }

    public static int fib2(int n) {
        int[] f = new int[n + 1];
        f[0] = 0;
        if (n > 0) {
            f[1] = 1;
            for (int i = 2; i <= n; i++) {
                f[i] = f[i - 1] + f[i - 2];
            }
        }
        return f[n];
    }
}


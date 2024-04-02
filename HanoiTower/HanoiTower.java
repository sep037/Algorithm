package HanoiTower;
public class HanoiTower {
  public static void main(String[] args) {
      int[] nValues = {2, 5};

      for (int n : nValues) {
          long startTime = System.nanoTime();
          solveHanoi(n, 'A', 'C', 'B');
          long endTime = System.nanoTime();
          long duration = (endTime - startTime) / 1_000_000; // 나노초를 밀리초로 변환

          System.out.println("For n = " + n + ", Time taken: " + duration + " milliseconds");
      }
  } //

  public static void solveHanoi(int n, char from, char to, char aux) {
      if (n == 1) {
          System.out.println("Move disk 1 from " + from + " to " + to);
          return;
      }
      solveHanoi(n - 1, from, aux, to);
      System.out.println("Move disk " + n + " from " + from + " to " + to);
      solveHanoi(n - 1, aux, to, from);
  }
}






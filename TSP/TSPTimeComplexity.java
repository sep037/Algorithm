package TSP;
import java.util.*;


public class TSPTimeComplexity {
    private int numberOfNodes;
    private Stack<Integer> stack;

    public TSPTimeComplexity() {
        stack = new Stack<Integer>();
    }

    public void tsp(int adjacencyMatrix[][]) {
        numberOfNodes = adjacencyMatrix[1].length - 1;
        int[] visited = new int[numberOfNodes + 1];
        visited[1] = 1;
        stack.push(1);
        int element, dst = 0, i;
        int min = Integer.MAX_VALUE;
        boolean minFlag = false;

        while (!stack.isEmpty()) {
            element = stack.peek();
            i = 1;
            min = Integer.MAX_VALUE;
            while (i <= numberOfNodes) {
                if (adjacencyMatrix[element][i] > 0 && visited[i] == 0) {
                    if (min > adjacencyMatrix[element][i]) {
                        min = adjacencyMatrix[element][i];
                        dst = i;
                        minFlag = true;
                    }
                }
                i++;
            }
            if (minFlag) {
                visited[dst] = 1;
                stack.push(dst);
                minFlag = false;
                continue;
            }
            stack.pop();
        }
    }

    public static void main(String... arg) {
        int[] nodes = {5, 10, 20};  // 다양한 크기의 그래프를 테스트
        Random rand = new Random();
        for (int number_of_nodes : nodes) {
            int[][] graph = new int[number_of_nodes + 1][number_of_nodes + 1];

            // 그래프의 가중치를 무작위로 생성
            for (int i = 1; i <= number_of_nodes; i++) {
                for (int j = 1; j <= number_of_nodes; j++) {
                    if (i != j) {
                        graph[i][j] = rand.nextInt(100) + 1;
                    }
                }
            }

            TSPTimeComplexity tsp = new TSPTimeComplexity();
            long startTime = System.currentTimeMillis();
            tsp.tsp(graph);
            long endTime = System.currentTimeMillis();

            System.out.println("Number of nodes: " + number_of_nodes + ", Time taken: " + (endTime - startTime) + " milliseconds");
        }
    }
}

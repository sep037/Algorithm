package TSP;
import java.util.*;

public class TSPTimeComplexity {
    private int numberOfNodes; // 그래프의 노드 수를 저장할 변수
    private Stack<Integer> stack; // 방문한 노드를 추적하는 스택

    public TSPTimeComplexity() {
        stack = new Stack<Integer>(); // 스택 초기화
    }

    public void tsp(int adjacencyMatrix[][]) {
        numberOfNodes = adjacencyMatrix[1].length - 1; // 노드 수 설정
        int[] visited = new int[numberOfNodes + 1]; // 방문한 노드를 체크하는 배열
        visited[1] = 1; // 시작 노드 방문 표시
        stack.push(1); // 시작 노드를 스택에 푸시
        int element, dst = 0, i;
        int min = Integer.MAX_VALUE;
        boolean minFlag = false;

        while (!stack.isEmpty()) { // 스택이 비어있지 않는 동안 반복
            element = stack.peek(); // 현재 노드
            i = 1;
            min = Integer.MAX_VALUE; // 최소값 초기화
            while (i <= numberOfNodes) { // 모든 인접 노드를 확인
                if (adjacencyMatrix[element][i] > 0 && visited[i] == 0) { // 방문하지 않았고 경로가 존재하는 경우
                    if (min > adjacencyMatrix[element][i]) { // 더 작은 가중치를 찾은 경우
                        min = adjacencyMatrix[element][i];
                        dst = i;
                        minFlag = true;
                    }
                }
                i++;
            }
            if (minFlag) { // 최소 가중치를 갖는 노드를 찾은 경우
                visited[dst] = 1; // 방문 표시
                stack.push(dst); // 스택에 푸시
                minFlag = false; // 플래그 초기화
                continue;
            }
            stack.pop(); // 최소 가중치 노드를 찾지 못한 경우 스택에서 팝
        }
    }

    public static void main(String... arg) {
        int[] nodes = {5, 10, 20};  // 다양한 크기의 그래프를 테스트할 노드 수
        Random rand = new Random(); // 랜덤 객체 생성

        for (int number_of_nodes : nodes) { // 각 노드 수에 대하여
            int[][] graph = new int[number_of_nodes + 1][number_of_nodes + 1]; // 그래프의 가중치 행렬 생성

            // 그래프의 가중치를 무작위로 생성
            for (int i = 1; i <= number_of_nodes; i++) {
                for (int j = 1; j <= number_of_nodes; j++) {
                    if (i != j) {
                        graph[i][j] = rand.nextInt(100) + 1; // i와 j가 다르면 랜덤 가중치 부여
                    }
                }
            }

            TSPTimeComplexity tsp = new TSPTimeComplexity(); // TSP 객체 생성
            long startTime = System.currentTimeMillis(); // 시작 시간 측정
            tsp.tsp(graph); // TSP 문제 해결
            long endTime = System.currentTimeMillis(); // 종료 시간 측정

            // 결과 출력
            System.out.println("Number of nodes: " + number_of_nodes + ", Time taken: " + (endTime - startTime) + " milliseconds");
        }
    }
}

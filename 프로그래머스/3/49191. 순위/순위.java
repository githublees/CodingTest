class Solution {
    public int solution(int n, int[][] results) {
        
        int[][] graph = new int[n+1][n+1];
        
        for (int[] edge : results) {
            
            // A > B
            graph[edge[0]][edge[1]] = 1;
            graph[edge[1]][edge[0]] = -1;
            
        }
        
        for (int m = 1; m <= n; m++) {
            for (int s = 1; s <= n; s++) {
                for (int e = 1; e <= n; e++) {
                    
                    // A > B, B > C => A > C
                    if (graph[m][e] == 1 && graph[e][s] == 1) {
                        graph[m][s] = 1;
                        graph[s][m] = -1;
                    }
                    
                    if (graph[m][e] == -1 && graph[e][s] == -1) {
                        graph[m][s] = -1;
                        graph[s][m] = 1;
                    }
                
                }
            }
        }
        
        int answer = 0;
        
        for (int i = 1; i <= n; i++) {
            
            int cnt = 0;
            
            for (int j = 1; j <= n; j++) {
                
                if (graph[i][j] != 0) cnt++;
                
            }
            
            if (cnt == n-1) answer++;
        }
    
        return answer;
    }
}
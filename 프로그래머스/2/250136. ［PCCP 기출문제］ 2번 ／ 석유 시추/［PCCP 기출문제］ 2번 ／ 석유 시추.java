import java.util.*;

class Solution {
    
    static int n, m, answer = 0;
    
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    static int[] total_oil;
    static boolean[][] visited;
    
    static class Pos {
        int x;
        int y;
        
        public Pos (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public int solution(int[][] land) {
        
        n = land.length;
        m = land[0].length;
        
        total_oil = new int[land[0].length];
        visited = new boolean[land.length][land[0].length];
        
        for (int i = 0; i < n; i++) {
            
            for (int j = 0; j < m; j++) {
                
                if (visited[i][j]) continue;
                
                if (land[i][j] == 1) {
                    bfs(i, j, land);
                }
            }
        }
        
        return answer;
    }
    
    private static void bfs (int x, int y, int[][] land) {
        
        Queue<Pos> q = new LinkedList<>();
        
        q.offer(new Pos(x, y));
        visited[x][y] = true;
        
        int count = 0, min_y = 501, max_y = 0;
        
        while (!q.isEmpty()) {
            
            Pos p = q.poll();
            
            count++;
            min_y = Math.min(min_y, p.y);
            max_y = Math.max(max_y, p.y);
            
            for (int d = 0; d < 4; d++) {
                int nx = p.x + dx[d];
                int ny = p.y + dy[d];
                
                if (nx < 0 || ny < 0 || nx >= n || ny >= m || visited[nx][ny] || land[nx][ny] == 0) continue;
                
                q.offer(new Pos(nx, ny));
                visited[nx][ny] = true;
            }
        }
        
        for (int i = min_y; i <= max_y; i++) {
            total_oil[i] += count;
            answer = Math.max(answer, total_oil[i]);
        }
    }
}
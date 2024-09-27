import java.util.*;

class Solution {
    
    static int answer = Integer.MAX_VALUE;
    static int[][] map;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    
    static class Pos {
        int x;
        int y;
        int dis;
        
        public Pos (int x, int y, int dis) {
            this.x = x;
            this.y = y;
            this.dis = dis;
        }
    }
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        
        map = new int[101][101];
        
        for (int i = 0; i < rectangle.length; i++) {
            isFillMap(rectangle[i][0]*2, rectangle[i][1]*2, rectangle[i][2]*2, rectangle[i][3]*2);
        }
        
        bfs(characterX*2, characterY*2, itemX*2, itemY*2);
        
        return answer / 2;
        
    }
    
    public static void bfs(int startX, int startY, int endX, int endY) {
        
        Queue<Pos> q = new LinkedList<>();
        
        boolean[][] visited = new boolean[101][101];
        
        q.offer(new Pos(startX, startY, 0));
        
        visited[startX][startY] = true;
        
        while (!q.isEmpty()) {

            Pos p = q.poll();
            
            if (p.x == endX && p.y == endY) {
                answer = p.dis;
                return;
            }
            
            for (int d = 0; d < 4; d++) {
                
                int nx = p.x + dx[d];
                int ny = p.y + dy[d];
                
                if (nx < 0 || ny < 0 || nx > 100 || ny > 100 || 
                        visited[nx][ny] || map[nx][ny] == 0 || map[nx][ny] == 2) continue;
                    
                q.offer(new Pos(nx, ny, p.dis+1));
                visited[nx][ny] = true;
                
            }
        }
    }
    
    public static void isFillMap(int x1, int y1, int x2, int y2) {
        for (int i = x1; i <= x2; i++) {
            
            for (int j = y2; j >= y1; j--) {
                
                if (map[i][j] == 2) continue;
                
                if (i == x1 || i == x2 || j == y1 || j == y2) {
                    map[i][j] = 1;
                } else {
                    map[i][j] = 2;
                }
            }
        }
    }
}
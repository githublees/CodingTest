class Solution {
    
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public int solution(String[][] board, int h, int w) {
        
        String color = board[h][w];
        
        int answer = 0;
        
        for (int d = 0; d < 4; d++) {
            
            int nx = h + dx[d];
            int ny = w + dy[d];
            
            if (nx < 0 || ny < 0 || nx >= board.length || ny >= board[0].length) continue;
            
            if (color.equals(board[nx][ny])) {
                answer++;
            }
            
        }
        
        
        return answer;
    }
}
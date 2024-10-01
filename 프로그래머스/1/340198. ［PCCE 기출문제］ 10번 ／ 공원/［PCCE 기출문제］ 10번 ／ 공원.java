class Solution {
    public int solution(int[] mats, String[][] park) {
        int answer = -1;
        
        int[][] dp = new int[park.length+1][park[0].length+1];
        
        for (int i = 0; i < park.length; i++) {
            
            for (int j = 0; j < park[0].length; j++) {
                
                if (park[i][j].equals("-1")) {
                    park[i][j] = "1";
                } else {
                    park[i][j] = "0";
                }
                
            }
        }
        
        int max = 0;
        
        for (int i = 1; i <= park.length; i++) {
            
            for (int j = 1; j <= park[0].length; j++) {
            
                if (!park[i-1][j-1].equals("0")) {
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j])) + 1;
                    max = Math.max(max, dp[i][j]);
                }
                
            }
            
        }
        
        for (int i = 0; i < mats.length; i++) {
            
            if (max >= mats[i]) {
                answer = Math.max(answer, mats[i]);
            }
            
        }
        
        return answer;
    }
}
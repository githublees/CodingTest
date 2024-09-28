class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        
        int start = diffs[0];
        int end = 0;
        
        for (int i = 0; i < diffs.length; i++) {
            end = Math.max(end, diffs[i]);
        }
        
        int answer = end;
        
        while (start <= end) {
            
            int level = (start + end) / 2;
            
            long sum = 0;
            
            for (int d = 0; d < diffs.length; d++) {
                
                if (diffs[d] <= level) {
                    
                    sum += times[d];
                    
                }
                else {
                    
                    int cnt = diffs[d] - level;
                    
                    sum += (times[d] + times[d-1]) * cnt + times[d];
                    
                }
                
            }
            
            if (sum <= limit) {
                
                end = level - 1;
                answer = Math.min(answer, level);

            }
            else {
                
                start = level + 1;
                
            }
            
        }
        
        return answer;
    }
}
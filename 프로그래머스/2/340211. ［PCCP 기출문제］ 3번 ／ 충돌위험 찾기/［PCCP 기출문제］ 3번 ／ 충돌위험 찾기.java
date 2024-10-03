import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

class Solution {
    
    public int solution(int[][] points, int[][] routes) {
        
        int answer = 0;
        
        Map<String, Integer> timeMap = new HashMap<>();
        
        for (int i = 0; i < routes.length; i++) {
            
            int[] route = routes[i];
            int[] now = points[route[0]-1];
            int currentTime = 0;
            
            for (int j = 1; j < route.length; j++) {
                int[] next = points[route[j]-1];
                List<int[]> path = getPath(now, next);
                
                if (j == route.length-1) {
                    path.add(new int[]{next[0], next[1]});
                }

                for (int[] pos : path) {
                    
                    String key = pos[0] + "," + pos[1] + "," + currentTime;
                    
                    timeMap.put(key, timeMap.getOrDefault(key, 0) + 1);
                    
                    if (timeMap.get(key) == 2) {
                        answer++;
                    }
                    
                    currentTime++;
                }
                
                now = next;
            }
        }
        
        
        return answer;
    }
    
    private static List<int[]> getPath (int[] start, int[] end) {
        
        List<int[]> path = new ArrayList<>();
        
        int rStart = start[0], cStart = start[1];
        int rEnd = end[0], cEnd = end[1];
        
        while (rStart != rEnd) {
            
            path.add(new int[]{rStart, cStart});
            
            if (rStart < rEnd) 
                rStart++;
            else 
                rStart--;  
            
        }
        
        while (cStart != cEnd) {
            
            path.add(new int[]{rStart, cStart});
            
            if (cStart < cEnd)
                cStart++;
            else
                cStart--;
            
        }
        
        return path;
        
    }
}
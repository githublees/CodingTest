import java.util.*;

class Solution {
    
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int[][] answer = {};
        
        List<int[]> result = new ArrayList<>();
        
        for (int i = 0; i < data.length; i++) {
            
            int code = data[i][0];
            int date = data[i][1];
            int maximum = data[i][2];
            int remain = data[i][3];
            
            if (ext.equals("code")) {
                
                if (code < val_ext) {
                    result.add(data[i]);
                }
                
            }
            else if (ext.equals("date")) {
                
                if (date < val_ext) {
                    result.add(data[i]);
                }
                
            }
            else if (ext.equals("maximum")) {
                
                if (maximum < val_ext) {
                    result.add(data[i]);
                }
            }
            else {
                
                if (remain < val_ext) {
                    result.add(data[i]);
                }
                
            }
        }
        
        Collections.sort(result, (o1, o2) -> {
            
            if (sort_by.equals("code")) {
                return o1[0] - o2[0];
            }
            else if (sort_by.equals("date")) {
                return o1[1] - o2[1];
            }
            else if (sort_by.equals("maximum")) {
                return o1[2] - o2[2];
            }
            else {
                return o1[3] - o2[3];
            }
            
        });
        
        return result.toArray(new int[0][]);
    }
}
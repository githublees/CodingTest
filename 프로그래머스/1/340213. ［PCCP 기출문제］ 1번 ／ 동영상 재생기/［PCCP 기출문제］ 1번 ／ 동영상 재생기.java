class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        
        String[] temp = video_len.split(":");
        int trans_len = Integer.parseInt(temp[0]) * 60 + Integer.parseInt(temp[1]);
        
        temp = pos.split(":");
        int trans_pos = Integer.parseInt(temp[0]) * 60 + Integer.parseInt(temp[1]);
        
        temp = op_start.split(":");
        int trans_start = Integer.parseInt(temp[0]) * 60 + Integer.parseInt(temp[1]);
        
        temp = op_end.split(":");
        int trans_end = Integer.parseInt(temp[0]) * 60 + Integer.parseInt(temp[1]);
        
        for (int i = 0; i < commands.length; i++) {
            
            String order = commands[i];
            
            if (trans_pos >= trans_start && trans_pos <= trans_end) {
                trans_pos = trans_end;
            }
            
            if (order.equals("prev")) {
                
                if (trans_pos < 10) {
                    trans_pos = 0;
                } 
                else {
                    trans_pos -= 10;
                }
                
            }
            else if (order.equals("next")) {
                
                if (trans_pos + 10 > trans_len) {
                    trans_pos = trans_len;
                } 
                else {
                    trans_pos += 10;
                }
                
            }
            
            if (trans_pos >= trans_start && trans_pos <= trans_end) {
                trans_pos = trans_end;
            }
            
        }
        
        String min = String.valueOf(trans_pos / 60);
        min = min.length() == 1 ? "0" + min : min;
        
        String sec = String.valueOf(trans_pos % 60);
        sec = sec.length() == 1 ? "0" + sec : sec;
        
        return min + ":" + sec;
    }
}
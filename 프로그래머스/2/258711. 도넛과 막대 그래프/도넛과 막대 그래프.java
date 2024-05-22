import java.util.*;

class Solution {
    public int[] solution(int[][] edges) {
        Map<Integer, int[]> node = new HashMap<>();
        int[] answer = {0, 0, 0, 0};
        
        Arrays.stream(edges).forEach(edge -> {
            int a = edge[0];
            int b = edge[1];
            
            node.put(a, node.getOrDefault(a, new int[]{0, 0}));
            node.put(b, node.getOrDefault(b, new int[]{0, 0}));
            
            node.get(a)[0]++;
            node.get(b)[1]++;
        });
        
        int[] cnt;
        
        for (int key : node.keySet()) {
            cnt = node.get(key);
            
            // 들어오는 노드가 없고 나가는 노드가 2개 이상이면 정점
            if (cnt[0] >= 2 && cnt[1] == 0) {
                answer[0] = key;
            // 나가는 노드가 0
            } else if (cnt[0] == 0) {
                answer[2]++;
            } else if (cnt[0] >= 2 && cnt[1] >= 2) {
                answer[3]++;
            }
        }
        
        answer[1] = node.get(answer[0])[0] - answer[2] - answer[3];
        
        
        return answer;
    }
}
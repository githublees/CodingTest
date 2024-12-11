import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n, w, L;
    static int[] truck;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        
        Queue<Integer> truck = new LinkedList<>();
        Queue<Integer> bridge = new LinkedList<>();
        
        st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < n; i++) {
            truck.add(Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < w; i++) {
            bridge.add(0);
        }

        int time = 0;
        int bridge_weight = 0;
        
        // 현재 다리에 올라와 있는 트럭이 존재하지 않을 때 까지
        while (!bridge.isEmpty()) {
            time++;
            // 다리에 올라와 있는 트럭이 다리에서 내려올 때
            bridge_weight -= bridge.poll();
            
            // 도착하지 않은 트럭이 존재하지 않을 때 까지
            if (!truck.isEmpty()) {
                if (truck.peek() + bridge_weight <= L) {
                    bridge_weight += truck.peek();
                    bridge.add(truck.poll());
                } else {
                    bridge.add(0);
                }
            }
        }
        
        System.out.println(time);
    }
}
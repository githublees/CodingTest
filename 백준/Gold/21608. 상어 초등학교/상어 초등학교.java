import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
    static int[][] map;
    static Map<Integer, Set<Integer>> student;

    static class Seat implements Comparable<Seat> {

        int x, y, like, empty;

        public Seat(int x, int y, int like, int empty) {
            this.x = x;
            this.y = y;
            this.like = like;
            this.empty = empty;
        }

        @Override
        public int compareTo(Seat o) {

            if (like != o.like) {
                return o.like - like;
            }

            if (empty != o.empty) {
                return o.empty - empty;
            }

            if (x != o.x) {
                return x - o.x;
            }

            return y - o.y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        student = new LinkedHashMap<>();

        for (int i = 0; i < N*N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken());
            student.put(number, new HashSet<>());
            for (int j = 0; j < 4; j++) {
                int like = Integer.parseInt(st.nextToken());
                student.get(number).add(like);
            }
        }

        for (int number : student.keySet()) {
            findSeat(number);
        }

        System.out.println(getScore());
    }

    private static int getScore() {

        int answer = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                int count = 0;

                for (int d = 0; d < 4; d++) {
                    int nx = i + dx[d];
                    int ny = j + dy[d];

                    if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                        continue;
                    }

                    if (student.get(map[i][j]).contains(map[nx][ny])) {
                        count++;
                    }
                }

                if (count > 0) {
                    answer += (int) Math.pow(10, count-1);
                }
            }
        }

        return answer;
    }

    private static void findSeat(int number) {

        List<Seat> seats = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                int likeCnt = 0;
                int emptyCnt = 0;

                for (int d = 0; d < 4; d++) {
                    int nx = i + dx[d];
                    int ny = j + dy[d];

                    if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                        continue;
                    }

                    if (student.get(number).contains(map[nx][ny])) {
                        likeCnt++;
                    }

                    if (map[nx][ny] == 0) {
                        emptyCnt++;
                    }
                }
                seats.add(new Seat(i, j, likeCnt, emptyCnt));
            }
        }

        Collections.sort(seats);

        for (Seat seat : seats) {
            if (map[seat.x][seat.y] != 0) {
                continue;
            }
            map[seat.x][seat.y] = number;
            return;
        }
    }
}
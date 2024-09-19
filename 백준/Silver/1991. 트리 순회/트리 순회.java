import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static Map<String, Node> tree;
    static class Node {
        String left;
        String right;

        public Node (String left, String right) {
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        tree = new HashMap<>();

        String first = "";

        for (int i = 0; i < N; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            String root = st.nextToken();
            String left = st.nextToken();
            String right = st.nextToken();

            if (i == 0) first = root;

            if (left.equals(".")) left = null;
            if (right.equals(".")) right = null;

            tree.put(root, new Node(left, right));
        }

        System.out.println(preorder(first));
        System.out.println(inorder(first));
        System.out.println(postorder(first));
    }

    private static String preorder(String node) {

        if (node == null) return "";

        return node + preorder(tree.get(node).left) + preorder(tree.get(node).right);
    }

    private static String inorder(String node) {

        if (node == null) return "";

        return inorder(tree.get(node).left) + node + inorder(tree.get(node).right);
    }

    private static String postorder(String node) {

        if (node == null) return "";

        return postorder(tree.get(node).left) + postorder(tree.get(node).right) + node;
    }

}
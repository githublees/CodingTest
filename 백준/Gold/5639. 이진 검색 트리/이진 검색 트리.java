import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        BinarySearchTree<Integer> tree = new BinarySearchTree<>();

        while (true) {

            String str = br.readLine();

            if (str == null || str.isEmpty()) break;

            int node = Integer.parseInt(str);

            tree.add(node);

        }

        tree.postorder();

    }

    static class Node<E> {

        E value;

        Node<E> left;
        Node<E> right;
        Node<E> parent;

        Node(E value) {
            this(value, null);
        }

        Node(E value, Node<E> parent) {
            this.value = value;
            this.parent = parent;
            this.right = null;
            this.left = null;
        }
    }

    public static class BinarySearchTree<E> {

        private Node<E> root; // 루트(최상단) 노드
        private int size; // 요소(노드)의 개수

        public BinarySearchTree() {
            this.root = null;
            this.size = 0;
        }

        public boolean add(E value) {


            return addValue(value) == null;
        }

        private E addValue(E value) {

            Node<E> current = root; // 탐색할 노드를 가리키는 current node

            // 만약 current가 null, 즉 root가 null이면 root에 새 노드를 만들고 null 반환
            if (current == null) {
                root = new Node<E>(value);
                size++;
                return null;
            }

            Node<E> currentParent; // current의 직전 탐색 노드를 가리키는 노드

            // 삽입할 노드가 비교 될 수 있도록 한 변수를 만든다.
            @SuppressWarnings("unchecked")
            Comparable<? super E> compValue = (Comparable<? super E>) value;

            int compResult; // 비교 결과 (양수, 0, 음수)를 담고 있을 변수

            do {

                // 다음 순회에서 current의 부모노드를 가리킬 수 있도록 현재 current를 저장
                currentParent = current;

                compResult = compValue.compareTo(current.value);

                /*
                 * 비교 결과 value 보다 current.value 가 작으면
                 * current를 current의 왼쪽 자식으로 갱신하고,
                 * value 보다 current.value가 크다면 current를 오른쪽
                 * 자식으로 갱신하며, 같을 경우 순회를 중단하고 value를 반환한다.
                 */
                if (compResult < 0) {

                    current = current.left;

                } else if (compResult > 0) {

                    current = current.right;

                } else {

                    return value;

                }

            } while (current != null);

            // 순회가 완료되어 삽입해야 할 위치를 찾았다면 삽입 할 value를 노드로 만든다.
            Node<E> newNode = new Node<E>(value, currentParent);

            // 직전 비교 결과에 따라 currentParent의 오른쪽 혹은 왼쪽 노드에 새 노드를 연결해준다.
            if (compResult < 0) {
                currentParent.left = newNode;
            } else {
                currentParent.right = newNode;
            }

            size++;
            return null;
        }

        /**
         * 전위 순회
         * (부모 노드 > 왼쪽 자식 노드 > 오른쪽 자식 노드)
         */
        public void preorder() {
            preorder(this.root);
        }

        public void preorder(Node<E> o) {
            // null이 아닐 떄 까지 재귀적으로 순회
            if(o != null) {
                System.out.println(o.value);	// 부모 노드
                preorder(o.left);	// 왼쪽 자식 노드
                preorder(o.right);	// 오른쪽 자식 노드
            }
        }

        /**
         * 중위 순회
         * (왼쪽 자식 노드 > 부모 노드 > 오른쪽 자식 노드)
         */
        public void inorder() {
            inorder(this.root);
        }

        public void inorder(Node<E> o) {
            if(o != null) {
                inorder(o.left);	// 왼쪽 자식 노드
                System.out.println(o.value);	// 부모 노드
                inorder(o.right);	// 오른쪽 자식 노드
            }
        }

        /**
         * 후위 순회
         * (왼쪽 자식 노드 > 오른쪽 자식 노드 > 부모 노드)
         */
        public void postorder() {
            postorder(this.root);
        }

        public void postorder(Node<E> o) {
            if(o != null) {
                postorder(o.left);	// 왼쪽 자식 노드
                postorder(o.right);	// 오른쪽 자식 노드
                System.out.println(o.value);	// 부모 노드
            }
        }
    }
}
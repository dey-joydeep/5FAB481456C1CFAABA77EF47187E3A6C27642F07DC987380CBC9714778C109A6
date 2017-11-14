import java.util.Queue;

public class BTMain {
	public static void main(String[] args) {
		int data = 11;
		int[] treeElems = { 10, 6, 14, 5, 8, 11, 8 };
		BinaryTree bTree = new BinaryTree();
		for (int n : treeElems)
			bTree.insert(n);
		Queue<Node> resultQueue = bTree.getNodeListAtDepthOf(data);
		while (!resultQueue.isEmpty()) {
			System.out.print(resultQueue.poll().data + " ");
		}
	}
}

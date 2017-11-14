import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
	private Node root;

	public void insert(int value) {
		Queue<Node> queue = new LinkedList<Node>();
		if (root == null) {
			root = new Node(value);
			return;
		}
		queue.offer(root);

		// Insert the nodes on Level Order (BSF)
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			if (node.left == null) {
				node.left = new Node(value);
				return;
			}
			queue.offer(node.left);

			if (node.right == null) {
				node.right = new Node(value);
				return;
			}
			queue.offer(node.right);
		}
	}

	public Queue<Node> getNodeListAtDepthOf(int data) {
		if (root == null) {
			System.out.println("Tree is empty");
			return null;
		}
		Queue<Node> queue = new LinkedList<Node>();
		Queue<Node> resultQueue = new LinkedList<Node>();
		queue.offer(root);
		// depth end marker
		queue.offer(null);
		boolean found = false;
		boolean isNextDepth = false;
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			// next depth
			if (null == node) {
				if (!queue.isEmpty()) {
					// depth end marker
					queue.offer(null);
				}
				isNextDepth = true;

				// If given node has no match in this depth,
				// discard all stored result
				if (!found)
					resultQueue.clear();
			} else {
				// if the node is found and next depth is detected
				// break the loop and return resultQueue
				if (found && isNextDepth)
					break;
				isNextDepth = false;

				// If the node is found, update the flag
				if (!found)
					found = (data == node.data);

				// add all nodes of current depth
				resultQueue.offer(node);

				if (node.left != null) {
					queue.offer(node.left);
				}
				if (node.right != null) {
					queue.offer(node.right);
				}
			}
		}
		return resultQueue;
	}
}

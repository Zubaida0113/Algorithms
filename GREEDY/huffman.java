package GREEDY;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.PriorityQueue;
// Node class with character support
class Node {
	int data;
	char ch;
	Node left, right;

	Node(int data, char ch) {
		this.data = data;
		this.ch = ch;
		this.left = null;
		this.right = null;
	}
}

public class huffman{

	// Function to traverse Huffman Tree and get codes
	static void preOrder(Node root, Map<Character, String> codeMap, String curr) {
		if (root == null) return;

		// If it's a leaf node, store the code for the character
		if (root.left == null && root.right == null) {
			codeMap.put(root.ch, curr);
			return;
		}

		preOrder(root.left, codeMap, curr + '0');
		preOrder(root.right, codeMap, curr + '1');
	}

	static Map<Character, String> huffmanCodes(String s, int[] freq) {
		int n = s.length();

		// Min heap (priority queue) based on frequency
		PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.data - b.data);

		for (int i = 0; i < n; i++) {
			pq.add(new Node(freq[i], s.charAt(i)));
		}

		// Construct Huffman Tree
		while (pq.size() > 1) {
			Node l = pq.poll();
			Node r = pq.poll();

			Node newNode = new Node(l.data + r.data, '\0'); // '\0' means internal node
			newNode.left = l;
			newNode.right = r;
			pq.add(newNode);
		}

		Node root = pq.poll();
		Map<Character, String> codeMap = new LinkedHashMap<>(); // Preserves order
		preOrder(root, codeMap, "");
		return codeMap;
	}

	public static void main(String[] args) {
		String s = "abcdef";
		int[] freq = {5, 9, 12, 13, 16, 45};

		Map<Character, String> huffmanMap = huffmanCodes(s, freq);

		for (Map.Entry<Character, String> entry : huffmanMap.entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}
	}
}

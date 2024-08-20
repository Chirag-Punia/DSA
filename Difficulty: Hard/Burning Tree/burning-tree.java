//{ Driver Code Starts
//Initial Template for Java


import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

class Node {
	int data;
	Node left;
	Node right;

	Node(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}

class GfG {

	static Node buildTree(String str) {

		if (str.length() == 0 || str.charAt(0) == 'N') {
			return null;
		}

		String ip[] = str.split(" ");
		// Create the root of the tree
		Node root = new Node(Integer.parseInt(ip[0]));
		// Push the root to the queue

		Queue<Node> queue = new LinkedList<>();

		queue.add(root);
		// Starting from the second element

		int i = 1;
		while (queue.size() > 0 && i < ip.length) {

			// Get and remove the front of the queue
			Node currNode = queue.peek();
			queue.remove();

			// Get the current node's value from the string
			String currVal = ip[i];

			// If the left child is not null
			if (!currVal.equals("N")) {

				// Create the left child for the current node
				currNode.left = new Node(Integer.parseInt(currVal));
				// Push it to the queue
				queue.add(currNode.left);
			}

			// For the right child
			i++;
			if (i >= ip.length)
				break;

			currVal = ip[i];

			// If the right child is not null
			if (!currVal.equals("N")) {

				// Create the right child for the current node
				currNode.right = new Node(Integer.parseInt(currVal));

				// Push it to the queue
				queue.add(currNode.right);
			}
			i++;
		}

		return root;
	}

	static void printInorder(Node root) {
		if (root == null)
			return;

		printInorder(root.left);
		System.out.print(root.data + " ");

		printInorder(root.right);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		while (t > 0) {
			String s = br.readLine();
			int target = Integer.parseInt(br.readLine());
			Node root = buildTree(s);

			Solution g = new Solution();
			System.out.println(g.minTime(root, target));
			t--;

		}
	}
}



// } Driver Code Ends


class Pair {
    Node left;
    Node right;
    Node parent;
    
    Pair(Node left, Node right, Node parent) {
        this.left = left;
        this.right = right;
        this.parent = parent;
    }
}

class Solution {
    static int ans;

    public static void mppBuilder(Node root, Map<Node, Pair> mpp, Node parent) {
        if (root == null) return;
        mpp.put(root, new Pair(root.left, root.right, parent));
        mppBuilder(root.left, mpp, root);
        mppBuilder(root.right, mpp, root);
    }

    public static void bfs(Node root, Map<Node, Pair> mpp, Map<Node, Boolean> visited) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        visited.put(root, true);
        
        while (!q.isEmpty()) {
            int size = q.size();
            boolean burnt = false;
            
            for (int i = 0; i < size; i++) {
                Node curr = q.poll();
                Pair neigh = mpp.get(curr);
                
                if (neigh.left != null && !visited.getOrDefault(neigh.left, false)) {
                    q.add(neigh.left);
                    visited.put(neigh.left, true);
                    burnt = true;
                }
                if (neigh.right != null && !visited.getOrDefault(neigh.right, false)) {
                    q.add(neigh.right);
                    visited.put(neigh.right, true);
                    burnt = true;
                }
                if (neigh.parent != null && !visited.getOrDefault(neigh.parent, false)) {
                    q.add(neigh.parent);
                    visited.put(neigh.parent, true);
                    burnt = true;
                }
            }
            
            if (burnt) ans++;
        }
    }

    public static void dfs(Node root, Map<Node, Pair> mpp, Map<Node, Boolean> visited, int target) {
        if (root == null) return;
        if (root.data == target) {
            bfs(root, mpp, visited);
            return;
        }
        dfs(root.left, mpp, visited, target);
        dfs(root.right, mpp, visited, target);
    }

    public static int minTime(Node root, int target) {
        ans = 0;
        Map<Node, Pair> mpp = new HashMap<>();
        Map<Node, Boolean> visited = new HashMap<>();
        mppBuilder(root, mpp, null);
        dfs(root, mpp, visited, target);
        return ans;
    }
}

import java.util.ArrayList;

/**
 * MorseCodeTree
 * 
 * @author Zhiming Lin
 *
 */
public class MorseCodeTree implements LinkedConverterTreeInterface<String> {
	private TreeNode<String> root;

	/**
	 * Constructor - calls the buildTree method
	 */
	public MorseCodeTree() {
		root = null;
		buildTree();
	}

	/**
	 * Returns a reference to the root
	 * 
	 * @return reference to root
	 */
	@Override
	public TreeNode<String> getRoot() {
		return root;
	}

	/**
	 * sets the root of the MorseCodeTree
	 * 
	 * @param newNode - a copy of newNode will be the new root
	 */
	@Override
	public void setRoot(TreeNode<String> newNode) {
		root = new TreeNode<String>(newNode);

	}

	/**
	 * Adds element to the correct position in the tree based on the code This
	 * method will call the recursive method addNode
	 * 
	 * @param code   - the code for the new node to be added, example ".-."
	 * @param result - the letter for the corresponding code, example "r"
	 * @return the MorseCodeTree with the new node added
	 */
	@Override
	public LinkedConverterTreeInterface<String> insert(String code, String result) {
		addNode(root, code, result);
		return this;
	}

	/**
	 * This is a recursive method that adds element to the correct position in the
	 * tree based on the code.
	 * 
	 * @param root   - the root of the tree for this particular recursive instance
	 *               of addNode
	 * @param code   - the code for this particular recursive instance of addNode
	 * @param letter - the data of the new TreeNode to be added
	 */
	@Override
	public void addNode(TreeNode<String> root, String code, String letter) {
		if (code.length() == 1) {
			if (code.equals(".")) {
				// root.left.data = letter;
				root.left = new TreeNode<String>(letter);
			} else {
				root.right = new TreeNode<String>(letter);
			}
		} else {
			if (code.charAt(0) == '.') {
				addNode(root.left, code.substring(1), letter);
			} else {
				addNode(root.right, code.substring(1), letter);
			}
		}

	}

	/**
	 * Fetch the data in the tree based on the code This method will call the
	 * recursive method fetchNode
	 * 
	 * @param code - the code that describes the traversals to retrieve the string
	 *             (letter)
	 * @return the string (letter) that corresponds to the code
	 */
	@Override
	public String fetch(String code) {
		return fetchNode(root, code);
	}

	/**
	 * This is the recursive method that fetches the data of the TreeNode that
	 * corresponds with the code A '.' (dot) means traverse to the left.
	 * 
	 * @param root - the root of the tree for this particular recursive instance of
	 *             addNode
	 * @param code - the code for this particular recursive instance of addNode
	 * @return the string (letter) corresponding to the code
	 */
	@Override
	public String fetchNode(TreeNode<String> root, String code) {
		if (code.length() == 1) {
			if (code.equals(".")) {
				return root.left.data;
			} else {
				return root.right.data;
			}
		} else {
			if (code.charAt(0) == '.') {
				return fetchNode(root.left, code.substring(1));
			} else {
				return fetchNode(root.right, code.substring(1));
			}
		}
	}

	/**
	 * This operation is not supported in the MorseCodeTree
	 */
	@Override
	public LinkedConverterTreeInterface<String> delete(String data) throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

	/**
	 * This operation is not supported in the MorseCodeTree
	 */
	@Override
	public LinkedConverterTreeInterface<String> update() throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

	/**
	 * This method builds the MorseCodeTree by inserting the nodes of the tree level
	 * by level based on the code.
	 */
	@Override
	public void buildTree() {
		setRoot(new TreeNode<String>(""));
		// level 1
		insert(".", "e");
		insert("-", "t");
		// level 2
		insert("..", "i");
		insert(".-", "a");
		insert("-.", "n");
		insert("--", "m");
		// level 3
		insert("...", "s");
		insert("..-", "u");
		insert(".-.", "r");
		insert(".--", "w");
		insert("-..", "d");
		insert("-.-", "k");
		insert("--.", "g");
		insert("---", "o");
		// level 4
		insert("....", "h");
		insert("...-", "v");
		insert("..-.", "f");
		insert(".-..", "l");
		insert(".--.", "p");
		insert(".---", "j");
		insert("-...", "b");
		insert("-..-", "x");
		insert("-.-.", "c");
		insert("-.--", "y");
		insert("--..", "z");
		insert("--.-", "q");

	}

	/**
	 * Returns an ArrayList of the items in the linked Tree in LNR (Inorder)
	 * Traversal order Used for testing to make sure tree is built correctly
	 * 
	 * @return an ArrayList of the items in the linked Tree
	 * 
	 */
	@Override
	public ArrayList<String> toArrayList() {
		ArrayList<String> list = new ArrayList<String>();
		LNRoutputTraversal(root, list);
		return list;
	}

	/**
	 * The recursive method to put the contents of the tree in an ArrayList in LNR
	 * (Inorder)
	 * 
	 * @param root - the root of the tree for this particular recursive instance
	 * @param list - the ArrayList that will hold the contents of the tree in LNR
	 *             order
	 */
	@Override
	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {
		if (root != null) {
			LNRoutputTraversal(root.left, list);
			list.add(root.data);
			LNRoutputTraversal(root.right, list);
		}

	}

}

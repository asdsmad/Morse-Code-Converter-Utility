/**
 * TreeNode<T>
 * @author Zhiming Lin
 *
 * @param <T> - data type of TreeNode
 */
public class TreeNode<T> {
	T data;
	TreeNode<T> right, left;
	
	/**
	 * Create a new TreeNode with left and right child set to null and data set to the dataNode
	 * @param dataNode - the data to be stored in the TreeNode
	 */
	public TreeNode(T dataNode) {
		data = dataNode;
		right = null;
		left = null;
	}
	
	/**
	 * used for making deep copies
	 * @param node - node to make copy of
	 */
	public TreeNode(TreeNode<T> node) {
		data = node.data;
		right = node.right;
		left = node.left;
	}
	
	/**
	 * Return the data within this TreeNode
	 * @return the data within the TreeNode
	 */
	public T getData() {
		return data;
	}
}

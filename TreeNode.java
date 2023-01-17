public class TreeNode<Thing extends Comparable<Thing>> {

	TreeNode left = null; //left child node
	Thing value;
	TreeNode right = null; //right child node
	TreeNode parent; //parent node


	public TreeNode(Thing a) {
		value = a;
	}
//Node input function compares whether inputted key is lesser than or greater than node and inserts appropriately.
	public void inputKey(Thing a) {

		if (a.compareTo(value) < 0) {
			if (left == null) {
				left = new TreeNode(a);
			} else {
				left.inputKey(a);
			}

		} else if (a.compareTo(value) > 0) {
			if (right == null) {
				right = new TreeNode(a);
			} else {
				right.inputKey(a);
			}

		}
	}
}

public class BST<Thing extends Comparable<Thing>> {

    TreeNode root = null;

    public BST() {

    }

    public void input(Thing a) {

        if (root == null) {

            root = new TreeNode(a);
        } else {
            if (duplicationCheck(root, a) == true) {
                System.out.println("No duplicate values allowed!");
                return;
            }
            root.inputKey(a);
        }
    }

    private boolean duplicationCheck(TreeNode node, Thing a) {

        if (node == null) {
            return false;
        } else if (node.value.equals(a)) {
            return true;
        }

        duplicationCheck(node.left, a);
        duplicationCheck(node.right, a);

        return false;

    }


    public void preOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }

        System.out.print(node.value + " ");

        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }

    public void postOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }

        postOrderTraversal(node.left);
        postOrderTraversal(node.right);

        System.out.print(node.value + " ");
    }

    public void inOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }

        inOrderTraversal(node.left);
        System.out.print(node.value + " ");
        inOrderTraversal(node.right);


    }

    public Comparable getRoot() {
        return root.value;
    }

    public TreeNode searchNode(TreeNode node, Thing a) {
        if (a.compareTo((Thing) node.value) == 0) {
            return node;
        }
        //If a is less than the current node value, head left.
        else if (a.compareTo((Thing) node.value) < 0) {
            if (node.left == null) {
                return null;
            }
            return searchNode(node.left, a);
        }
        //If a is more than the current node value, head right.
        else {
            if (node.right == null) {
                return null;
            }
            return searchNode(node.right, a);
        }
    }

    public TreeNode deleteNode(TreeNode node, Thing a) {
        return null;
    }

    public void displayTree(){
        System.out.println(getRoot() + "- root");
        for(int i = 0; i < TreeNode.nodes.size(); i++){
            System.out.println(TreeNode.nodes.get(i));
        }
    }




}
/*
    public void deleteNode(Thing a) {
        TreeNode node = searchNode(root, a);
        if(node == null){
            System.out.println("Node not found.");
            return;
        }
        if(node.left == null && node.right == null){
            node.value = null;
        }


    }



    public int getHeight(TreeNode node, int value){
        if(node==null){
            return -1;
        }

        return 0;
    }
*/
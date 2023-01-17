public class BST<Thing extends Comparable<Thing>> {

    TreeNode root = null; //root node of the tree

    public BST() {
    }
//Tree input function
    public void input(Thing a) {
        if (root == null) {
            root = new TreeNode(a);
            root.parent = null;
            System.out.println("Node " + a + " inserted");
        }
        else {
            if (duplicationCheck(root, a)) {
                System.out.println("No duplicate values allowed!");
                return;
            }
            root.inputKey(a);
            System.out.println("Node " + a + " inserted");
            setParent(root, searchNode(root, a));
        }
    }
//Compares two nodes whether they have the same data value and returns true or false.
    private boolean duplicationCheck(TreeNode node, Thing a) {

        if (node == null) {
            return false;
        }
        else if (a.compareTo((Thing) node.value) == 0) {
            return true;
        }
        else if (a.compareTo((Thing) node.value) > 0){
            return duplicationCheck(node.right, a);
        }
        else{
            return duplicationCheck(node.left, a);
        }
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
    public TreeNode searchNode(TreeNode node, Thing a) {
        if(node == null){
            return null;
        }
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

    public void deleteNode(Thing a) {
        TreeNode node = searchNode(root, a); //Searches if the node to be deleted exists or not.
        if (node == null) {
            System.out.println("Node not found");
            return;
        }
        //If node has no children
        else if (node.left == null && node.right == null) {
            if(node == root){
                root = null;
                System.out.println("Node " + node.value + " deleted");
                return;
            }
            else if (node.parent.left == node) {
                node.parent.left = null;
            }
            else {
                node.parent.right = null;
            }
            System.out.println("Node " + node.value + " deleted");
        }
        //If node has one child
        else if (node.left == null || node.right == null) {
            if (node.left == null) {
                if(node == root){
                    root = node.right;
                }
                else if (a.compareTo((Thing) node.parent.value) < 0) {
                    node.parent.left = node.right;
                    node.right.parent = node.parent;
                }
                else if (a.compareTo((Thing) node.parent.value) > 0) {
                    node.parent.right = node.right;
                    node.right.parent = node.parent;
                }
            }
            if (node.right == null) {
                if(node == root){
                    root = node.left;
                }
                else if (a.compareTo((Thing) node.parent.value) < 0) {
                    node.parent.left = node.left;
                    node.left.parent = node.parent;
                }
                else if (a.compareTo((Thing) node.parent.value) > 0) {
                    node.parent.right = node.left;
                    node.left.parent = node.parent;
                }
            }
            System.out.println("Node " + node.value + " deleted");
        }
        //If node has two child
        else if (node.left != null && node.right != null) {
            TreeNode lowestNode = lowestInOrder(node.left); //This implementation allows us to enter left child of the selected node and finds the node with the largest value from that left child.
            if (node == root) {
                if (node.left == lowestNode) {
                    lowestNode.right = node.right;
                    node.right.parent = lowestNode;
                    root = lowestNode;
                    root.parent = null;
                } else {
                    lowestNode.parent.right = null;
                    lowestNode.left = node.left;
                    lowestNode.right = node.right;
                    node.left.parent = lowestNode;
                    node.right.parent = lowestNode;
                    root = lowestNode;
                    root.parent = null;
                }
            } else {
                if (a.compareTo((Thing) node.parent.value) < 0) {
                    if (lowestNode.parent == node) {
                        lowestNode.right = node.right;
                        lowestNode.parent = node.parent;
                        node.parent.left = lowestNode;
                        node.right.parent = lowestNode;
                    } else {
                        lowestNode.parent.right = null;
                        lowestNode.left = node.left;
                        lowestNode.right = node.right;
                        lowestNode.parent = node.parent;
                        node.parent.left = lowestNode;
                        node.left.parent = lowestNode;
                        node.right.parent = lowestNode;
                    }
                }
                if (a.compareTo((Thing) node.parent.value) > 0) {
                    if (lowestNode.parent == node) {
                        lowestNode.parent = node.parent;
                        lowestNode.right = node.right;
                        lowestNode.right.parent = lowestNode;
                        node.parent.right = lowestNode;
                    } else {
                        lowestNode.parent.right = null;
                        lowestNode.left = node.left;
                        lowestNode.left.parent = lowestNode;
                        lowestNode.right = node.right;
                        lowestNode.right.parent = lowestNode;
                        lowestNode.parent = node.parent;
                        node.parent.right = lowestNode;
                    }
                }
            }
            System.out.println("Node " + node.value + " deleted");
        }
    }

//This function recursively searches and finds the largest node from a given node.
    private TreeNode lowestInOrder(TreeNode node) {
        if (node.right == null) {
            return node;
        } else {
            return lowestInOrder(node.right);
        }
    }
//This function is used during insertion and it assigns the parent value to a child.
    private void setParent(TreeNode a, TreeNode node) {
        if (searchNode(root, (Thing) node.value) == null) {
            return;
        }
        if (a.left == node) {
            node.parent = a;
        } else if (a.right == node) {
            node.parent = a;
        } else if (node.value.compareTo(a.value) < 0) {
            if (a.left == null) {
                return;
            } else {
                setParent(a.left, node);
            }
        } else {
            if (a.right == null) {
                return;
            } else {
                setParent(a.right, node);
            }
        }
    }
//Tree display function that initializes the print function starting from the root
    public void displayTree() {
        print("", root, false);
    }
//A recursive print function that prints |-- if left subtree and \-- if right subtree except for root as it is the first to be initialized
    private void print(String prefix, TreeNode node, boolean isLeft) {
        if (node != null) {
            System.out.println(prefix + (isLeft ? "|-- " : "\\-- ") + node.value);
            print(prefix + (isLeft ? "|   " : "    "), node.left, true);
            print(prefix + (isLeft ? "|   " : "    "), node.right, false);
        }
    }
}
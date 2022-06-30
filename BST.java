public class BST<Thing extends Comparable<Thing>> {

    TreeNode root = null;

    public BST() {
    }

    public void input(Thing a) {

        if (root == null) {

            root = new TreeNode(a);
            root.parent = null;
        } else {
            if (duplicationCheck(root, a) == true) {
                System.out.println("No duplicate values allowed!");
                return;
            }
            root.inputKey(a);
            setParent(root, searchNode(root, a));
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

    public void deleteNode(Thing a) {
        TreeNode node = searchNode(root, a);
        if (node == null) {
            System.out.println("Node not found");
            return;
        }
        //If node has no children
        if (node.left == null && node.right == null) {
            if (node.parent.left == node) {
                node.parent.left = null;
            } else {
                node.parent.right = null;
            }
        }
        //If node has one child
        else if (node.left == null || node.right == null) {
            if (node.left == null) {
                if (a.compareTo((Thing) node.parent.value) < 0) {
                    node.parent.left = node.right;
                    node.right.parent = node.parent;
                }
                if (a.compareTo((Thing) node.parent.value) > 0) {
                    node.parent.right = node.right;
                    node.right.parent = node.parent;
                }
            }
            if (node.right == null) {
                if (a.compareTo((Thing) node.parent.value) < 0) {
                    node.parent.left = node.left;
                    node.left.parent = node.parent;
                }
                if (a.compareTo((Thing) node.parent.value) > 0) {
                    node.parent.right = node.left;
                    node.left.parent = node.parent;
                }
            }
        }
        //If node has two child
        else if (node.left != null && node.right != null) {
            TreeNode lowestNode = lowestInOrder(node.left);
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
        }
    }


    private TreeNode lowestInOrder(TreeNode node) {
        if (node.right == null) {
            return node;
        } else {
            return lowestInOrder(node.right);
        }
    }

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

    public void displayTree() {
        print("", root, false);
    }

    private void print(String prefix, TreeNode node, boolean isLeft) {
        if (node != null) {
            System.out.println(prefix + (isLeft ? "|-- " : "\\-- ") + node.value);
            print(prefix + (isLeft ? "|   " : "    "), node.left, true);
            print(prefix + (isLeft ? "|   " : "    "), node.right, false);
        }
    }
}
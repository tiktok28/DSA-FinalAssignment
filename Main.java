import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        BST tree = new BST();
// Main Menu
        boolean running = true;

        do {
            System.out.println("""
                .----------------------.
                | 1.Insert Node\s       |
                | 2.Delete Node\s       |
                | 3.Search Node\s       |
                | 4.Tree Traversals\s   |
                | 5.Display Tree\s      |
                | 6.Exit\s              |
                '----------------------'""");
            System.out.print("\nPick an option: ");

            int option = keyboard.nextInt();

            if (option == 1) {
                System.out.println("Please enter an Element");
                Comparable inputValue = keyboard.next();
                try{
                    inputValue = Integer.parseInt((String) inputValue);
                    tree.input(inputValue);
                    }
                catch(Exception e){
                    tree.input(inputValue);
                }
            }
            else if(option == 2){
                System.out.println("Select a node to be deleted");
                Comparable inputValue = keyboard.next();
                try {
                    inputValue = Integer.parseInt((String) inputValue);
                    tree.deleteNode(inputValue);
                }
                catch(Exception e){
                    tree.deleteNode(inputValue);
                }
            }
            else if(option == 3){
                System.out.println("Input a node to be searched.");
                Comparable searchItem = keyboard.next();
                try {
                    searchItem = Integer.parseInt((String) searchItem);
                    tree.searchNode(tree.root, searchItem);
                }
                catch(Exception e){
                    tree.searchNode(tree.root, searchItem);
                }
                if(tree.searchNode(tree.root, searchItem) != null){
                    System.out.println("Node " + searchItem + " found");
                }
                else{
                    System.out.println("Node not found");
                }
            }
            else if(option == 4) {

                System.out.println("PreOrder Traversal:");
                tree.preOrderTraversal(tree.root);
                System.out.println("\n");

                System.out.println("PostOrder Traversal:");
                tree.postOrderTraversal(tree.root);
                System.out.println("\n");

                System.out.println("InOrder Traversal:");
                tree.inOrderTraversal(tree.root);
                System.out.println("\n");

            }else if(option == 5){
                tree.displayTree();
            }
            else if(option == 6){
                System.out.println("Exiting...");
                running = false;
            }else{
                System.out.println("Please input a valid option!");
            }
        }
        while(running);
        keyboard.close();
    }
}
import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        BST tree = new BST();
        ArrayList<Comparable> Array = new ArrayList<Comparable>();

        System.out.println("""
                ██████╗ ██╗███╗   ██╗ █████╗ ██████╗ ██╗   ██╗    ███████╗███████╗ █████╗ ██████╗  ██████╗██╗  ██╗    ████████╗██████╗ ███████╗███████╗
                ██╔══██╗██║████╗  ██║██╔══██╗██╔══██╗╚██╗ ██╔╝    ██╔════╝██╔════╝██╔══██╗██╔══██╗██╔════╝██║  ██║    ╚══██╔══╝██╔══██╗██╔════╝██╔════╝
                ██████╔╝██║██╔██╗ ██║███████║██████╔╝ ╚████╔╝     ███████╗█████╗  ███████║██████╔╝██║     ███████║       ██║   ██████╔╝█████╗  █████╗ \s
                ██╔══██╗██║██║╚██╗██║██╔══██║██╔══██╗  ╚██╔╝      ╚════██║██╔══╝  ██╔══██║██╔══██╗██║     ██╔══██║       ██║   ██╔══██╗██╔══╝  ██╔══╝ \s
                ██████╔╝██║██║ ╚████║██║  ██║██║  ██║   ██║       ███████║███████╗██║  ██║██║  ██║╚██████╗██║  ██║       ██║   ██║  ██║███████╗███████╗
                ╚═════╝ ╚═╝╚═╝  ╚═══╝╚═╝  ╚═╝╚═╝  ╚═╝   ╚═╝       ╚══════╝╚══════╝╚═╝  ╚═╝╚═╝  ╚═╝ ╚═════╝╚═╝  ╚═╝       ╚═╝   ╚═╝  ╚═╝╚══════╝╚══════╝

                """);

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
                Comparable inputValue;
                System.out.println("Please input the number of elements to be entered:");
                int size = keyboard.nextInt();

                for (int i = 0; i < size; i++) {
                    while (!(Array.size() == size)) {
                        System.out.println("Please enter an Element");
                        try{
                            inputValue = Integer.parseInt(keyboard.next());
                            if (!(Array.contains(inputValue))) {
                                Array.add(inputValue);
                            } else {
                                System.out.println("No duplicates allowed!");
                            }
                        }
                        catch(Exception e){
                            inputValue = keyboard.next();
                            if (!(Array.contains(inputValue))) {
                                Array.add(inputValue);
                            } else {
                                System.out.println("No duplicates allowed!");
                            }
                        }
                    }
                }
                for (int i = 0; i < Array.size(); i++) {
                    tree.input(Array.get(i));
                }
            }
            else if(option == 2){
                System.out.println("Select a node to be deleted");
                Comparable inputValue;
                try {
                    inputValue = Integer.parseInt(keyboard.next());
                    tree.deleteNode(inputValue);
                }
                catch(Exception e){
                    inputValue = keyboard.next();
                    tree.deleteNode(inputValue);
                }

            }
            else if(option == 3){
                System.out.println("Input a node to be searched.");
                Comparable searchItem;
                try {
                    searchItem = Integer.parseInt(keyboard.next());
                }
                catch(Exception e){
                    searchItem = keyboard.next();
                }
                if(tree.searchNode(tree.root, searchItem) == null){
                    System.out.println("The node does not exist");
                }else{
                    System.out.println(searchItem + " exists in the tree");
                }
            }else if(option == 4) {

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
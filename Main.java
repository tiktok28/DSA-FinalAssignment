import java.util.Scanner;
import java.util.ArrayList;
//Naveen
public class Main {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        BST tree = new BST();
        ArrayList<Comparable> Array = new ArrayList<Comparable>();

//        System.out.println("""
//                ██████╗ ██╗███╗   ██╗ █████╗ ██████╗ ██╗   ██╗    ███████╗███████╗ █████╗ ██████╗  ██████╗██╗  ██╗    ████████╗██████╗ ███████╗███████╗
//                ██╔══██╗██║████╗  ██║██╔══██╗██╔══██╗╚██╗ ██╔╝    ██╔════╝██╔════╝██╔══██╗██╔══██╗██╔════╝██║  ██║    ╚══██╔══╝██╔══██╗██╔════╝██╔════╝
//                ██████╔╝██║██╔██╗ ██║███████║██████╔╝ ╚████╔╝     ███████╗█████╗  ███████║██████╔╝██║     ███████║       ██║   ██████╔╝█████╗  █████╗ \s
//                ██╔══██╗██║██║╚██╗██║██╔══██║██╔══██╗  ╚██╔╝      ╚════██║██╔══╝  ██╔══██║██╔══██╗██║     ██╔══██║       ██║   ██╔══██╗██╔══╝  ██╔══╝ \s
//                ██████╔╝██║██║ ╚████║██║  ██║██║  ██║   ██║       ███████║███████╗██║  ██║██║  ██║╚██████╗██║  ██║       ██║   ██║  ██║███████╗███████╗
//                ╚═════╝ ╚═╝╚═╝  ╚═══╝╚═╝  ╚═╝╚═╝  ╚═╝   ╚═╝       ╚══════╝╚══════╝╚═╝  ╚═╝╚═╝  ╚═╝ ╚═════╝╚═╝  ╚═╝       ╚═╝   ╚═╝  ╚═╝╚══════╝╚══════╝
//
//                """);

        boolean running = true;

        do {
//            System.out.println("""
//                .----------------------.
//                | 1.Insert Node\s       |
//                | 2.Delete Node\s       |
//                | 3.Search Node\s       |
//                | 4.Tree Traversals\s   |
//                | 5.Display Tree\s      |
//                | 6.Exit\s              |
//                '----------------------'""");
            System.out.print("\nPick an option: ");

            int option = keyboard.nextInt();

            if (option == 1) {
                Comparable inputValue;

                for (int i = 0; i < 7; i++) {
                    while (!(Array.size() == 7)) {
                        System.out.println("Please enter an Element");
                        inputValue = keyboard.next();
                        if (!(Array.contains(inputValue))) {
                            Array.add(inputValue);
                        } else {
                            System.out.println("No duplicates allowed!");
                        }
                    }
                }
                for (int i = 0; i < Array.size(); i++) {
                    tree.input(Array.get(i));
                }
            }
            else if(option == 2){
                System.out.println("Node Deletion not done yet");
            }
            else if(option == 3){
                Comparable searchItem = keyboard.next();
                if(tree.searchNode(tree.root, searchItem) == null){
                    System.out.println("The node does not exist");
                }else{
                    System.out.println(searchItem + " Exists in the tree");
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
                running = false;
            }else{
                System.out.println("Not done yet");
            }
        }while(running);





        //tree.deleteNode(20);

        keyboard.close();
    }
}
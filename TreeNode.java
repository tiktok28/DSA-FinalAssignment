import java.util.ArrayList;

public class TreeNode<Thing extends Comparable<Thing>>{

	
	TreeNode left = null;
	Thing value;
	TreeNode right = null;

	public static ArrayList<Comparable> nodes = new ArrayList<>();
	
	public TreeNode (Thing a) {

		value = a;
	}

	public void inputKey(Thing a) {
		
		if(a.compareTo(value) < 0) {
			if(left == null) {
				left = new TreeNode(a);
				nodes.add(left.value + "- L");
			}
			
			else {
				left.inputKey(a);
			}

		}
		
		else if(a.compareTo(value) > 0){
			if(right == null) {
				right = new TreeNode(a);
				nodes.add(right.value + "- R");
			}
			
			else {
				right.inputKey(a);
			}

		}



		/*
		else {
			System.out.println("error");

		}*/
	}
	

	
}	

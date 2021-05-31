//***DO NOT MODIFY THIS FILE***//
public class TreeTester {

	public static Node[] ts = new Node[2];
	
	public static void initTrees()
	{
		int count = 0;

		ts[count++] = new Node(1, "Anuwat", 
				new Node(2, "Bodin", new Node(3,"Chailert", null, null), new Node(4,"Duanhatai", null, null))
				, new Node(5,"Ekawat", new Node(6,"Chaiwat", null, null), null));
		
		ts[count++] = new Node(100, "Amily", 
				new Node(50,"Mason", new Node(23,"Jackson", new Node(50,"Wyatt", null, null), null), new Node(50,"Carter", null, null)), 
				new Node(111,"Harper", new Node(100,"Grayson", null, null), new Node(112,"Avery", new Node(105,"Adison", null, null), new Node(140,"Jaaxon", null, null))));
	}
	
	public static void main(String[] args) {
		initTrees();
		
		System.out.println("@TASK1");
		System.out.println("List of All Person in Tree=>" +TreeManagement.printInorderName(ts[0],""));
		System.out.println("List of All Person in Tree=>" +TreeManagement.printInorderName(ts[1],""));
		System.out.println("");
		
		System.out.println("@TASK2");
		System.out.println("Number of Person whose name begins with 'C' = "+TreeManagement.countName(ts[0], 'C'));
		System.out.println("Number of Person whose name begins with 'A' = "+TreeManagement.countName(ts[1], 'A'));
		System.out.println("");
//
//		System.out.println("@TASK3");
//		System.out.println("The Person named Duanhatai has id = "+TreeManagement.searchIDByName(ts[0], "Duanhatai"));
//		System.out.println("The Person named Avery has id = "+TreeManagement.searchIDByName(ts[1], "Avery"));
//		System.out.println("");
//
//		System.out.println("@TASK4");
//		System.out.println(TreeManagement.findLongestName(ts[0]).name+" has the longest name in the Tree");
//		System.out.println(TreeManagement.findLongestName(ts[1]).name+" has the longest name in the Tree");
//		System.out.println("");
		
	}

}

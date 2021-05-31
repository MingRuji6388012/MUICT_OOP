// DO NOT MODIFY THIS FILE 
public class TreeCalculatorTester {
	public static Node[] ts = new Node[7];
	
	public static void initTrees()
	{
		int count = 0;
		ts[count++] = null;
		ts[count++] = new Node(16, null, null);
		
		ts[count++] = new Node(16, new Node(14, null, null), null);
		
		ts[count++] = new Node(1, new Node(3, new Node(6, null, null), new Node(7, null, null)), 
				new Node(4, new Node(8, null, null), new Node(10, null, null)));
		
		ts[count++] = new Node(1, new Node(3, null, null), 
				new Node(4, new Node(8, null, null), new Node(10, null, null)));
		
		ts[count++] = new Node(1, new Node(Integer.MAX_VALUE-1, new Node(6, null, null), null), 
				new Node(4, new Node(8, null, null), new Node(10, null, null)));
		
		ts[count++] = new Node(1, new Node(3, new Node(6, null, null), new Node(7, null, null)), 
				null);
	}
	
	public static void testRegular()
	{	System.out.println("-------------- Regular ----------------");
		for(int i = 0; i < ts.length; i++)
		{
			Node root = ts[i];
			int max = TreeCalculator.findMax(root);
			int min = TreeCalculator.findMin(root);
			System.out.println("Tree["+i+"] Max: "+max+"\tMin: "+min);
			
		}
	}
	
	public static void testBonus()
	{
		System.out.println("-------------- BONUS ----------------");
		for(int i = 0; i < ts.length; i++)
		{
			Node root = ts[i];
			double sum = TreeCalculator.sumTree(root);
			double avg = TreeCalculator.avgTree(root);
			System.out.println("Tree["+i+"] Sum: "+sum+"\tAverage: "+avg);
			
		}
	}
	
	public static void main(String[] args)
	{
		initTrees();
		testRegular();
		testBonus();
		
	}

}

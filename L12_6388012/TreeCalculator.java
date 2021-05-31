
public class TreeCalculator {

	public static int findMax(Node root)
	{	//****YOUR CODE HERE**
		if(root == null) return -1;

		int max = root.id;
		int leftValue = findMax(root.left);
		int rightValue = findMax(root.right);
		if (leftValue > max && root.left != null) max = leftValue;
		if (rightValue > max && root.right != null) max = rightValue;

		return max;
		//*********************
	}
	public static int findMin(Node root)
	{	//****YOUR CODE HERE**
		if(root == null) return -1;

		int min = root.id;
		int leftValue = findMin(root.left);
		int rightValue = findMin(root.right);

		if (leftValue < min && root.left != null) min = leftValue;
		if (rightValue < min && root.right != null) min = rightValue;

		return min;
		//*********************
	}


	//************* BONUS ****************//
	static int count = 0;
	public static double sumTree(Node root)
	{
		//****YOUR CODE HERE**
		if(root == null) return 0;
		else {
			sumTree(root.left);
			sumTree(root.right);
		}
		return 0;
		//*********************
	}

	public static int getCount(Node root){
		if(root == null) return 0;
		return 1+ getCount(root.left)+ getCount(root.right);
	}

	public static double avgTree(Node root)
	{
		//****YOUR CODE HERE*
		double sum = sumTree(root);
		int count = getCount(root);
		if(sum == 0 && count == 0) return 0;
		return sum / (double) count;
		//*********************
	}
	
}

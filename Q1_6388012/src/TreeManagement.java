//ID:
//Name:
//Sec:

public class TreeManagement {

	//TASK1: Display all name in Tree using InOrderTraversal
    public static String printInorderName(Node root, String _result)
    {
        if(root == null){
            return _result;
        }
        printInorderName(root.left,_result);
        System.out.print(root.name+"|");
        printInorderName(root.right,_result);
        return _result;
    }
    
	//TASK2: Count number of all name begin with a character 'P'
    public static int countName(Node root, char _char)
    {
        int count = 0;
        if(root == null) return -1;
        String charName = String.valueOf(_char);
        if (charName.equals(root.name.substring(0,1))){
            count++;
        }
        return count;
    }
    
	//TASK3: Find the index of a  given name in Tree
    public static int searchIDByName(Node root, String _name)
    {
    	//CODE HERE
    	return 0;
    }
    
    
	//TASK4: Find the longest name in Tree (using recursive function)
	public static Node findLongestName(Node root)
	{	
    	//CODE HERE
    	return new Node(0,"",null,null); //You can remove this empty node when start implementation
	}
	
}


public class NameSearcherTester {

	public static void main(String[] args)
	{
		System.out.println("***************** NORMAL****************");
		NameSearcher linearA = new LinearNameSearcher("test.txt");		
		System.out.print("[Linear-Case1] "+linearA.find("Zebra"));
		System.out.println(" >>> Number of Comparisons (Linear):"+linearA.getNumComparisons()+"\n");
		
		linearA.resetCompareCounter();
		System.out.print("[Linear-Case2] "+linearA.find("ant"));
		System.out.println(" >>> Number of Comparisons (Linear):"+linearA.getNumComparisons()+"\n");
		
		linearA.resetCompareCounter();
		System.out.print("[Linear-Case3] "+linearA.find("tiger"));
		System.out.println(" >>> Number of Comparisons (Linear):"+linearA.getNumComparisons()+"\n");
		

		NameSearcher linearB = new LinearNameSearcher("unsortedName.txt");		
		System.out.print("[Linear-Case4] "+linearB.find("Monkey D. Luffy"));
		System.out.println(" >>> Number of Comparisons (Linear):"+linearB.getNumComparisons()+"\n");
		
		linearB.resetCompareCounter();
		System.out.print("[Linear-Case5] "+linearB.find("Monkey"));
		System.out.println(" >>> Number of Comparisons (Linear):"+linearB.getNumComparisons()+"\n");
		
		linearB.resetCompareCounter();
		System.out.print("[Linear-Case6] "+linearB.find("trafalgar d. water law"));
		System.out.println(" >>> Number of Comparisons (Linear):"+linearB.getNumComparisons()+"\n");
		
		linearB.resetCompareCounter();
		System.out.print("[Linear-Case7] "+linearB.find("Yonta Maria Grand Fleet"));
		System.out.println(" >>> Number of Comparisons (Linear):"+linearB.getNumComparisons()+"\n");
				
		// Extra Task just for FUN


		System.out.println("********* EXTRA TASK for CRAZY PEOPLE************");

		NameSearcher binaryC = new BinaryNameSearcher("test.txt");

		binaryC.sortName();
		System.out.print("[Binary-Case1] "+binaryC.find("Zebra"));
		System.out.println(" >>> Number of Comparisons (Binary):"+binaryC.getNumComparisons()+"\n");

		binaryC.resetCompareCounter();
		System.out.print("[Binary-Case2] "+binaryC.find("ant"));
		System.out.println(" >>> Number of Comparisons (Binary):"+binaryC.getNumComparisons()+"\n");

		binaryC.resetCompareCounter();
		System.out.print("[Binary-Case3] "+binaryC.find("tiger"));
		System.out.println(" >>> Number of Comparisons (Binary):"+binaryC.getNumComparisons()+"\n");

		NameSearcher binaryD = new BinaryNameSearcher("unsortedName.txt");
		binaryD.sortName();
		System.out.print("[Binary-Case4] "+binaryD.find("Monkey D. Luffy"));
		System.out.println(" >>> Number of Comparisons (Binary):"+binaryD.getNumComparisons()+"\n");

		binaryD.resetCompareCounter();
		System.out.print("[Binary-Case5] "+binaryD.find("Monkey"));
		System.out.println(" >>> Number of Comparisons (Binary):"+binaryD.getNumComparisons()+"\n");

		binaryD.resetCompareCounter();
		System.out.print("[Binary-Case6] "+binaryD.find("trafalgar d. water law"));
		System.out.println(" >>> Number of Comparisons (Binary):"+binaryD.getNumComparisons()+"\n");

		binaryD.resetCompareCounter();
		System.out.print("[Binary-Case7] "+binaryD.find("Yonta Maria Grand Fleet"));
		System.out.println(" >>> Number of Comparisons (Binary):"+binaryD.getNumComparisons()+"\n");

		
	}
	
	
}

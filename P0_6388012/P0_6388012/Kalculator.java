//Name: Rujiphart Charatvaraphan
//ID: 6388012
//Section: 1

import java.util.ArrayList;




public class Kalculator {
	//******INSERT YOUR CODE HERE***********
	private ArrayList<Double> Data; //Allocate memory; -> perform as ArrayList
	//**************************************

	/**
	 * Constructor is the fist method to be call at instantiation of a Kalculator object.
	 * If you need to initialize your object, do so here. 
	 */
	Kalculator()
	{
		//******INSERT YOUR CODE HERE***********
		this.Data = new ArrayList<>();
		//**************************************
	}
	
	/**
	 * Add number to the list of numbers. 
	 * @param number
	 */
	public void addNumber(double number)
	{	//******INSERT YOUR CODE HERE***********
		Data.add(number);
		//**************************************
	}
	
	/**
	 * Remove the least recently added number from the list. If the list is empty, do nothing.
	 */
	public void deleteFirstNumber()
	{
		//******INSERT YOUR CODE HERE***********
		if(Data.size() >= 1)
		Data.remove(0);
		//**************************************
	}
	
	/**
	 * Remove the most recently added number from the list. If the list is empty, do nothing.
	 */
	public void deleteLastNumber()
	{
		//******INSERT YOUR CODE HERE***********
		if(Data.size() > 0)
		Data.remove(Data.size()-1);
		//**************************************
	}
	
	/**
	 * Calculate the summation of all the numbers in the list, then returns the sum. 
	 * If the list is empty, return 0.
	 * @return
	 */
	public double getSum()
	{
		//******INSERT YOUR CODE HERE***********
		if(Data.size() > 0){
		double sum = 0;
			for(int i = 0 ; i< Data.size() ; i++){
				sum += Data.get(i);
			}
		return sum;
		}else return 0;
		//**************************************
	}
	
	/**
	 * Calculate and return the average of all the numbers in the list.
	 * If the list is empty, return 0.
	 * @return
	 */
	public double getAvg()
	{
		//******INSERT YOUR CODE HERE***********
		if(Data.size()>0)
		return getSum() / Data.size();
		else return 0;
		//**************************************
	}
	
	/**
	 * Calculate and return the sample standard deviation of all the numbers in the list.
	 * If the list has fewer than 2 numbers, return 0.
	 * @return
	 */
	public double getStd()
	{
		//******INSERT YOUR CODE HERE***********
		// double sumPower = 0;
		// 	for(int i = 0 ; i< Data.size() ; i++){
		// 		sumPower += Math.pow(Data.get(i),2);
		// 	}
		if(Data.size()>2){
		double avg = getAvg();
		double sum = 0; 
			for(int i = 0 ; i<Data.size() ; i++){
				sum += Math.pow(Data.get(i) - avg, 2);
			}
		return Math.sqrt(sum / (Data.size()-1));
		}else return 0;
		//**************************************
	}
	
	/**
	 * Find and return the maximum of all the numbers in the list.
	 * If the list is empty, return 0.
	 * @return
	 */
	public double getMax()
	{
		//******INSERT YOUR CODE HERE***********
		if(Data.size()>1){
			double max = Data.get(0);
			for(int i = 0 ; i< Data.size() ; i++){
				double num = Data.get(i);
				if(num > max){
					max = num;
				}
			}
		//Data.stream().mapToDouble(e->e).max().orElse(other);
		return max;
		}else return 0;
		//**************************************
	}
	
	/**
	 * Find and return the minimum of all the numbers in the list.
	 * If the list is empty, return 0.
	 */
	public double getMin()
	{
		
		//******INSERT YOUR CODE HERE***********
			if(Data.size()>1){
			double min = Data.get(0);
			for(int i = 0 ; i< Data.size() ; i++){
				double num = Data.get(i);
				if(num < min){
					min = num;
				}
			}
			return min;
		}else return 0;
		//**************************************
	}
	
	/**
	 * Find and return the maximum k numbers of all the numbers in the list as an array of k double number.
	 * The order of the returned k numbers does not matter. (We only care if you can get the max k elements)
	 * If the list has fewer than k numbers, return null.
	 */
	public double[] getMaxK(int k)
	{
		//******INSERT YOUR CODE HERE***********
			if(Data.size() < k)
			return null;	
			else{
				double[] max = new double[Data.size()];
				for(int i = 0 ; i < Data.size() ; i++){
					max[i] = Data.get(i);
				}

				for(int i = 0 ; i < Data.size()-1 ; i++){
					for(int j = 0 ; j < Data.size()-i-1; j++){
						if(max[j] < max[j+1]){
						 		double temp = max[j+1] ;
								 max[j+1] = max[j];
								 max[j] = temp;
 						}
					}
				}
				double[] MaxReturn = new double[k];
				for(int i = 0 ; i < k ; i++){
					MaxReturn[i] = max[i];
				}
				return MaxReturn;
			}
		//**************************************
	}
	
	/**
	 * Find and return the minimum k numbers of all the numbers in the list as an array of k double number.
	 * The order of the returned k numbers does not matter. (We only care if you can get the min k elements)
	 * If the list has fewer than k numbers, return null.
	 */
	public double[] getMinK(int k)
	{
		//******INSERT YOUR CODE HERE***********
			if(Data.size() < k)
			return null;	
			else{
				double[] min = new double[Data.size()];
				for(int i = 0 ; i < Data.size() ; i++){
					min[i] = Data.get(i);
				}

				for(int i = 0 ; i < Data.size()-1 ; i++){
					for(int j = 0 ; j < Data.size()-i-1; j++){
						if(min[j] > min[j+1]){
							 	double temp = min[j+1] ;
								 min[j+1] = min[j];
							 	min[j] = temp;
 						}
					}
				}
				double[] MinReturn = new double[k];
				for(int i = 0 ; i < k ; i++){
					MinReturn[i] = min[i];
				}
				return MinReturn;
			}
		
		//**************************************
	}
	
	/**
	 * Print (via System.out.println()) the numbers in the list in format of:
	 * DATA[<N>]:[<n1>, <n2>, <n3>, ...]
	 * Where N is the size of the list. <ni> is the ith number in the list.
	 * E.g., "DATA[4]:[1.0, 2.0, 3.0, 4.0]"
	 */
	public void printData()
	{
		//******INSERT YOUR CODE HERE***********
			System.out.println("DATA[" + Data.size()+ "]: "+ Data);
		//**************************************
	}
}

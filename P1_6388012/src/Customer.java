//Name: Rujiphart Charatvaraphan
//ID: 6388012
//Section: 1

import java.util.ArrayList;
import java.util.List;

public class Customer {
	
	//*********************** DO NOT MODIFY ****************************//
	public static enum CustomerType{DEFAULT, STUDENT, PROFESSOR, ATHLETE, ICTSTUDENT};	//Different types of customers 
	private static int customerRunningNumber = 1;	//static variable for assigning a unique ID to a customer
	private CanteenICT canteen = null;	//reference to the CanteenICT object
	private int customerID = -1;		//this customer's ID
	protected CustomerType customerType = CustomerType.DEFAULT;	//the type of this customer, initialized with a DEFAULT customer.
	protected List<FoodStall.Menu> requiredDishes = new ArrayList<FoodStall.Menu> ();	//List of required dishes
	//*****************************************************************//
	private int Process = 1;
	private FoodStall isThatStall = null;
	private int EatTime = 0;
	private int ComparingEatingTime = 0;
	public int frontQueueFlag = 0;
	public int WaitOneStep = 0;
	/**
	 * You must initialize each customer's ID to customerRunningNumber
	 * @param _canteen
	 */
	Customer(CanteenICT _canteen) 
    {
        //******************* YOUR CODE HERE **********************
		   Process = 1;
		   this.canteen = _canteen;
           this.customerID = customerRunningNumber++;
		   for(FoodStall.Menu food: FoodStall.Menu.values()){
			   requiredDishes.add(food);
			   EatTime += FoodStall.EAT_TIME[food.ordinal()];
		   }
		   ComparingEatingTime = EatTime;
          // customerID = customerRunningNumber
          // customerRunningNumber++;
        //*****************************************************
    }

    int WaitOneStepTwo = 0;
	public void increaseProcess(){
		Process++;
	}
    public int getMinCustomer (List<FoodStall> fs){
    	int min = 0;
		for(int i = 0 ; i < fs.size() ; i++){
			if(fs.get(min).getCustomerQueue().size() > fs.get(i).getCustomerQueue().size()){
				min = i;
			}
		}
		return min;
	}

    public void takeAction()
    {
        //************************** YOUR CODE HERE **********************//
        /**
         * First Action -> The first person in Waiting queue goes to the foodstall
         */
		
		if(Process == 1){
			List<FoodStall> foodStore = canteen.getFoodStall();
			if(this.getCustomerID() == canteen.getFirstWaitToEnterQueue().getCustomerID() && frontQueueFlag == 1){
				int min = getMinCustomer(foodStore);
					if (foodStore.get(min).getCustomerQueue().size() < FoodStall.MAX_QUEUE && !foodStore.get(min).FlagFoodStall && foodStore.get(min).getMenu().containsAll(this.requiredDishes)) {
							foodStore.get(min).addCustomerQueue(this);
							isThatStall = foodStore.get(min); //The foodstall that has the lowest customer(s)
							canteen.removeFirstWaitToEnterQueue();
							Process++;
						}//shift + tab
			}
		}

		/**
		 * Second Action
		 */
			
		else if(Process == 2){
			if(this.getCustomerID()==isThatStall.getFirstPersonOfFoodstall().customerID && isThatStall.isWaitingForOrder() && !isThatStall.FlagFoodStall ){ //isWaitingForOrder is used for cheking that this customer is waiting for ordering the food, e.g., don't change the value of orderTime (the method that used to change ordertime is takeorder!)
				isThatStall.takeOrder(this.requiredDishes);
				Process++;
			}
		}
		/**
		 * Third Action
		 */
		else if(Process == 3){
			if(this.getCustomerID()==isThatStall.getFirstPersonOfFoodstall().customerID && this.isThatStall.isReadyToServe()) {
				this.isThatStall.serve();
				this.isThatStall.removeFirstPersonOfFoodstall();
				canteen.addWaitToSeatQueue(this);
				isThatStall.FlagFoodStall = true;
				Process++;
			}
		}
		/**
		 * Forth Action
		 */

		else if(Process == 4){
			if(this.getCustomerID() ==  canteen.getFirstWaitToSeatQueue().getCustomerID()){
				if(this.canteen.addCustomerToTable(this)){
					canteen.removeFirstWaitToSeatQueue();
					Process++;
				}
			}
//			if(this instanceof ICTStudent){
//				if(canteen.ICTEatHere(this)){
//					Process++;
//				}
//			}
		}

		/**
		 * Fifth Action
		 */
		else if(Process == 5){
			if(canteen.IsThisCustomerSeated(this)){
				EatingProcess(this);
			}
	}
}

        //**************************************************************//
		public boolean isEating() {
			if(this.EatTime != this.ComparingEatingTime)
			return true;
			else return false;
		}

		//* For checking that this customer done his/her eating
		public boolean EatingDone() {
			if(ComparingEatingTime < 0){
				return true;
			}else return false;
		}

		public void reduceEatingTime(){
			ComparingEatingTime--;
		}

		public int getComparingEatingTime(){
			return ComparingEatingTime;
		}

		public void setComparingEatingTime(int TimeSet){
    	this.ComparingEatingTime = TimeSet;
		}

		public void EatingProcess(Customer thisCustomer) {
			ComparingEatingTime--;
			if(thisCustomer.EatingDone()){
				canteen.doneQueueProgress(thisCustomer);
			}
		}
		//*************************************************

		//***************For hashing, equality checking, and general purposes. DO NOT MODIFY **************************//	
	
	public CustomerType getCustomerType()
	{
		return this.customerType;
	}
	
	public int getCustomerID()
	{
		return this.customerID;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + customerID;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (customerID != other.customerID)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Customer [customerID=" + customerID + ", customerType=" + customerType +"]";
	}

	public String getCode()
	{
		return this.customerType.toString().charAt(0)+""+this.customerID;
	}
	
	/**
	 * print something out if VERBOSE is true 
	 * @param str
	 */
	public void jot(String str)
	{
		if(CanteenICT.VERBOSE) System.out.println(str);
		
		if(CanteenICT.WRITELOG) CanteenICT.append(str, canteen.name+"_state.log");
	}
	
	//*************************************************************************************************//
	
}

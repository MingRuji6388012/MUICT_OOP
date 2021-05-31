//Name: Rujiphart Charatvaraphan
//ID: 6388012
//Section: 1

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class CanteenICT {

	//*********************** DO NOT MODIFY ****************************//
	public static final int MAX_NUM_FOODSTALLS = 10;	//Max number of food stalls
	public static final int MAX_NUM_TABLES = 10;		//Max number of tables 
	public static final int MAX_BUDGET = 70000;			//Max budget for food stall installation
	
	//logging variables
	public static final boolean VERBOSE = true;		//If set true, things will be printed out on the console
	public static final boolean WRITELOG = true;	//If set true, log files will be generated
	
	
	//state variables
	public String name = null;		//The name of this CanteenICT
	private int timer = 0;			//The timer variable, incremented at the beginning of each iteration
	private	boolean running = false;	//True if the simulation is still running 
	
	//resource variables
	private List<Customer> allCustomers = new ArrayList<Customer>();	//List of all the customers, initialized by setCustomers()
	private List<Customer> waitToEnterQueue = new ArrayList<Customer>();	//List of the customers waiting to enter the canteen
	private List<Customer> waitToSeatQueue = new ArrayList<Customer>();	//List of the customers waiting to take seats at the tables
	private List<Customer> doneQueue =  new ArrayList<Customer>();		//List of the customers who already finish eating
	
	private List<FoodStall> foodStalls = new ArrayList<FoodStall>();	//List of the food stalls
	private List<Table> tables = new ArrayList<Table>();				//List of the tables
	//******************************************************************//
	private Table currentTable = null;


	/**
	 * Compute the cost of building of all the food stalls. 
	 * The building cost of a food stall is the sum of the installation cost of each food type that it sells.
	 * For example, if foodStalls[0] sells NOODLES and foodStalls[1] sells MEAT and SALAD, then the total
	 * installation cost would be 4000 + 5000 + 3500 = 12500 baht 
	 */
	public double getInstallCost()
    {
        //************************************** YOUR CODE HERE *********************************//
        double sumCost = 0;
        for(int i = 0 ; i< foodStalls.size() ; i++){
            FoodStall fs = foodStalls.get(i);
            for(int j = 0 ; j< fs.getMenu().size() ; j++){
                switch (fs.getMenu().get(j)){
                    case NOODLES: sumCost+= FoodStall.INSTALLATION_COST[FoodStall.Menu.NOODLES.ordinal()]; break;
                    case DESSERT: sumCost+= FoodStall.INSTALLATION_COST[FoodStall.Menu.DESSERT.ordinal()]; break;
                    case MEAT: sumCost+= FoodStall.INSTALLATION_COST[FoodStall.Menu.MEAT.ordinal()]; break;
                    case SALAD: sumCost+= FoodStall.INSTALLATION_COST[FoodStall.Menu.SALAD.ordinal()]; break;
                    case BEVERAGE: sumCost+= FoodStall.INSTALLATION_COST[FoodStall.Menu.BEVERAGE.ordinal()]; break;
                }
            }
        }
		return sumCost;
    }

	public boolean isAllShop() {
		for(FoodStall EachFoodstore : this.foodStalls){
			int flag = 0;
			for(int i = 0 ; i < EachFoodstore.getMenu().size() ; i++){
				switch (EachFoodstore.getMenu().get(i)){
                    case NOODLES: //flag++; break;
                    case DESSERT: //flag++; break;
                    case MEAT: //flag++; break;
                    case SALAD: //flag++; break;
                    case BEVERAGE: flag++; break; //-> If the statement
                }
			}
			if(flag == 5) return true;
		}
		return false;
    }

    /**
     * Validating the canteen in the following aspects, before the simulation:
     * - Cost of setting up the food stalls must not exceed the max budget.
     * - A customer's required food types must be satisfied by at least one food stall.
     * - There is at least one table.
     * @return
     */
    //STUDENT
    public boolean validateCanteen() {
        //************************************** YOUR CODE HERE *********************************//
        if(getInstallCost() > MAX_BUDGET || !isAllShop() || tables.size() < 1)
        return false;
        else return  true;
        //**************************************************************************************//
    }

	//*This method is for process 1 of Customer.takeaction()

	public void removeFirstWaitToEnterQueue(){
        waitToEnterQueue.remove(0);
    }

    public Customer getFirstWaitToEnterQueue(){
        if(waitToEnterQueue != null && !waitToEnterQueue.isEmpty()){
            return waitToEnterQueue.get(0);
        }else return null;
    }

    public List<FoodStall> getFoodStall(){
        return foodStalls;
	
    }

	//*********************************************************


	//*These Methods are given for process 4 of Customer.takeaction()*/
	public Boolean addCustomerToTable(Customer LuckyPerson){
		for(int i = 0 ; i < tables.size() ; i++){
			if(!tables.get(i).isFull()){
				tables.get(i).getSeatedCustomers().add(LuckyPerson);
				return true;
			}
		}
		return false;
	}


	public void removeFirstWaitToSeatQueue(){
        waitToSeatQueue.remove(0);
    }

	public Customer getFirstWaitToSeatQueue(){
        if(!waitToSeatQueue.isEmpty()){
            return waitToSeatQueue.get(0);
        }else return null;
    }

	//*This method is for process 3,4 of Customer.takeaction()
	public void addWaitToSeatQueue(Customer LuckyPerson) {
        waitToSeatQueue.add(LuckyPerson);
    }
	
	
	//*******************************************************/

	//**These Methods are given for process 5 of Customer.takeaction() */
	public boolean IsThisCustomerSeated(Customer ComparedPerson){
		for(int i = 0 ; i < tables.size() ; i++){
			if(tables.get(i).getSeatedCustomers().contains(ComparedPerson)){
				currentTable = tables.get(i);
				return true;
			}
		}
		return false;
	}
	
	public void doneQueueProgress(Customer thisCustomer) {
		currentTable.getSeatedCustomers().remove(thisCustomer);
		this.doneQueue.add(thisCustomer);
	}

	public List<Customer> getDoneQueue() {
		return doneQueue;
	}

	public Boolean ICTEatHere(Customer ICT_student){
			if(ICT_student.getCustomerID() == getFirstWaitToSeatQueue().getCustomerID()){
				//if tables are full, first customer who is ICT student waiting for seat can eat by standing until finish in seat queue
				ICT_student.reduceEatingTime();
				if(ICT_student.EatingDone()) {
					this.doneQueue.add(ICT_student);
					this.waitToSeatQueue.remove(ICT_student);
					return true;
				}//remove from queue
			}
		return false;
//    	if(){
//			ICT_student.reduceEatingTime();
//			if (ICT_student.EatingDone()) {
//				doneQueue.add(ICT_student);
//				waitToSeatQueue.remove(ICT_student);
//			}
//		}
	}

	/**
     * This method is optional, but it gives you some flexibility to do pre-processing, if any, before processing the customers.
	 **/

    private void preprocess()
    {
        //******************************************** YOUR CODE HERE (IF ANY) *******************************//
		if(timer == 1){
			waitToEnterQueue.get(0).frontQueueFlag = 1;
		}
		for(FoodStall fs: foodStalls){
			if(!fs.getCustomerQueue().isEmpty()){
				fs.FlagFoodStall = false;
			}
		}
        //****************************************************************************************************//
    }
	
	/**
	 * This method is optional, but it gives you some flexibility to do post-processing stuff if any, before printing the snapshot.
	 */
	private void postprocess()
	{
		//******************************************** YOUR CODE HERE (IF ANY) *******************************//
			for(Customer cs : allCustomers){
				cs.frontQueueFlag = 0;
			}
			if(!waitToEnterQueue.isEmpty()){
				waitToEnterQueue.get(0).frontQueueFlag = 1;
			}
			if(!waitToSeatQueue.isEmpty()){
				waitToSeatQueue.get(0).frontQueueFlag = 1;
			}
			for(FoodStall fs: foodStalls){
				if(!fs.getCustomerQueue().isEmpty()){
					fs.getCustomerQueue().get(0).frontQueueFlag = 1;
				}
			}
		// Customer.flag = 0;
		//****************************************************************************************************//
	}
	
	
	
	/**
	 * If customerConfig is null, print a warning message and do nothing.
	 * 
	 * Remove existing customers in the waiting to enter queue if any.
	 * 
	 * Parse the input customerConfig where each character represent the type of a customer, 
	 * and add the customers to the waitToEnterQueue observing the ordering. 
	 * 
	 * 'D' = DEFAULT, 'S' = STUDENT, 'P' = PROFESSOR, 'A' = ATHLETE, 'I' = ICTSTUDENT (Only implement DEFAULT customer for the main project.
	 * Other types of customers are for the bonus credits.)
	 * 
	 * For example, 'DD' means add two default customers. 'SPS' means add a student, a professor, and another student to waitToEnterQueue.
	 * 
	 * @param customerConfig
	 * @return
	 */
	public int setCustomers(String customerConfig)
	{
		if(customerConfig == null)
		{
			System.out.println("Input string cannot be null.");
			return 0;
		}
		
		this.allCustomers.clear();
		
		
		for(int i = 0; i < customerConfig.length(); i++)
		{
			char ch = customerConfig.charAt(i);
			Customer c = null;
			switch(ch)
			{	case 'D': c = new Customer(this);
						  break;
				//******************************** YOUR CODE HERE (BONUS) ***********************************//
				case 'S': c = new Customer(this);
						  break;
				case 'P': c = new Customer(this);
						  break;
				case 'A': c = new Customer(this);
						  break;
				case 'I': c = new Customer(this);
						  break;
				//******************************************************************************************//
			}
			if(c!=null)
			{
				this.allCustomers.add(c);
			}
		}
		
		this.waitToEnterQueue.clear();
		this.waitToEnterQueue.addAll(this.allCustomers);
		//waitToEnterQueue = allCustomer (in case of object)
		return this.allCustomers.size();
	}
	
	

	
	//******************************************** DO NOT MODIFY ****************************************//
	

	/**
	 * Initialize your canteen by setting timer to 0, and canteen name
	 * @param name
	 */
	public CanteenICT(String name)
	{
		timer = 0;
		this.name = name;
	}

	public int getCurrentTime()
	{
		return timer;
	}

	public String getName() {
		return this.name;
	}


	public int setFoodStalls(String[][] foodStallConfig)
	{
		if(foodStallConfig == null) return 0;
		for(String[] ss: foodStallConfig)
		{
			String name = ss[0];
			List<FoodStall.Menu> menu = new ArrayList<FoodStall.Menu>();
			for(int i = 0; i < ss[1].length(); i++)
			{
				char ch = ss[1].charAt(i);
				switch(ch)
				{	
				case 'N': if(!menu.contains(FoodStall.Menu.NOODLES)) menu.add(FoodStall.Menu.NOODLES); break;
				case 'D': if(!menu.contains(FoodStall.Menu.DESSERT)) menu.add(FoodStall.Menu.DESSERT); break;
				case 'M': if(!menu.contains(FoodStall.Menu.MEAT)) menu.add(FoodStall.Menu.MEAT); break;
				case 'S': if(!menu.contains(FoodStall.Menu.SALAD)) menu.add(FoodStall.Menu.SALAD); break;
				case 'B': if(!menu.contains(FoodStall.Menu.BEVERAGE)) menu.add(FoodStall.Menu.BEVERAGE); break;
				}
			}

			FoodStall fs = new FoodStall(name, this, menu);
			this.foodStalls.add(fs);

		}
		return this.foodStalls.size();
	}

	/**
	 * Return true of all the customers are in the done queue (no more simulation needed)
	 * @return
	 */
	public boolean isFinished()
	{
		return this.doneQueue.size() == this.allCustomers.size(); //All customers get out of the canteen
	}
	
	
	/**
	 * 
	 * Remove existing tables in this.tables if any.
	 * Initialize tables by adding numTables tables to this.tables. If numTables > MAX_NUM_TABLES, only add MAX_NUM_TABLES tables.
	 * @param numTables
	 * @return the number of tables added.
	 */
	public int setTables(int numTables)
	{
		if(numTables > MAX_NUM_TABLES)  numTables = MAX_NUM_TABLES; //Parameter gives more than 5 tables, it will be forced to initialize the table for only 5 tables
		for(int i = 0; i < numTables; i++)
		{
			this.tables.add(new Table());
		}
		
		return this.tables.size();
	}
	
	
	/**
	 * Call simulate(-1).
	 */
	public void simulate()
	{
		simulate(-1);
	}


	/**
	 * The main mechanism that simulate the canteen. Starting by validating the canteen and removing all the existing log files.
	 * In each iteration, it increments the timer then loops through each customer to invoke takeAction().
	 * The simulation terminates when the termination criteria is met or maxIteration is reached. 
	 * If maxIteration is < 0, it runs until the simulation ends.
	 * @param maxIteration
	 */
	public void simulate(int maxIteration)
	{


		if(!this.validateCanteen())
		{
			System.out.println("The canteen does not pass the validation. Cannot simulate.");
			return;
		}

		//clear all the existing log files
		removeLogFiles();
		running = true;
		log();	//log initial state
		while(timer < maxIteration || maxIteration < 0) //Infinity loop (until find break;)
		{

			//increment timer, required.
			timer++;
			this.preprocess();
			
			for(Customer c: this.allCustomers)
			{
				c.takeAction();
			}

			//synchronize qeueues
			this.postprocess();


			log();

			//if done terminate
			if(this.isFinished())
			{
				System.out.println("@@@ Done simulation. Good bye. :)");
				break;
			}

		}
		running = false;
		log();
	}
		
	/**
	 * This method returns a string representing the snapshot of the canteen.
	 * @return
	 */
	public String printState()
	{
		StringBuilder str = new StringBuilder();
		str.append("======================= T:"+this.timer+"=======================\n");
		
		StringBuilder temp = new StringBuilder();
		for(Customer c: this.waitToEnterQueue)
		{
			temp.append(c.getCustomerType().name().charAt(0)+""+c.getCustomerID()+" ");
		}
		str.append("[Waiting-to-Enter Queue]: "+temp.toString().trim().replace(' ', '-')+"\n");
		
		
		for(FoodStall fs: this.foodStalls)
		{
			str.append("[Food Stall: "+fs.getName()+"]: ");
			temp = new StringBuilder();
			for(Customer c: fs.getCustomerQueue())
			{
				temp.append(c.getCustomerType().name().charAt(0)+""+c.getCustomerID()+" ");
			}
			str.append(temp.toString().trim().replace(' ', '-')+"\n");
		}
		
		temp = new StringBuilder();
		for(Customer c: this.waitToSeatQueue)
		{
			temp.append(c.getCustomerType().name().charAt(0)+""+c.getCustomerID()+" ");
		}
		str.append("[Waiting-to-Seat Queue]: "+temp.toString().trim().replace(' ', '-')+"\n");
		
		for(int i = 0; i < this.tables.size(); i++)
		{	Table t =  this.tables.get(i);
			str.append("[Table "+t.getID()+"]: ");
			temp = new StringBuilder();
			for(Customer c: t.getSeatedCustomers())
			{
				temp.append(c.getCustomerType().name().charAt(0)+""+c.getCustomerID()+" ");
			}
			str.append(temp.toString().trim().replace(' ', '-')+"\n");
		}
		
		//done queue
		temp = new StringBuilder();
		for(Customer c: this.doneQueue)
		{
			temp.append(c.getCustomerType().name().charAt(0)+""+c.getCustomerID()+" ");
		}
		str.append("[Done Queue]: "+temp.toString().trim().replace(' ', '-')+"\n");
		
		return str.toString();
	}
	
	/**
	 * This method appends logs to the log files.
	 */
	private void log()
	{
		String state = this.printState();
		if(VERBOSE) System.out.println(state);
		
		if(WRITELOG)
		{
			if(running)
			{
				int numInFoodQueues = 0;
				int numOnTables = 0;
				for(FoodStall fs: this.foodStalls)
				{
					numInFoodQueues += fs.getCustomerQueue().size();
				}
				for(Table t: this.tables)
				{
					numOnTables += t.getSeatedCustomers().size();
				}
				
				
				String summary = "T="+this.timer+
						"\t"+this.waitToEnterQueue.size()+
						"\t"+numInFoodQueues+
						"\t"+this.waitToSeatQueue.size()+
						"\t"+numOnTables+
						"\t"+this.doneQueue.size();
				
				append(state, this.name+"_state.log");
				append(summary, this.name+"_summary.log");
			}
			else if(timer > 0)
			{
				append("@@ Simulation Done. Great Job!!", this.name+"_state.log");
				append("@@ Simulation Done. Great Job!!", this.name+"_summary.log");
			}
		
		}
	}
	
	/**
	 * Delete existing log files if any
	 */
	private void removeLogFiles()
	{
		
		try {
			File summaryLog = new File(this.name+"_summary.log");
			Files.deleteIfExists(summaryLog.toPath());
			
			File stateLog = new File(this.name+"_state.log");
			Files.deleteIfExists(stateLog.toPath());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * A convenient method to append str to the File identified by filename. Only works with newer version of Java.
	 * @param str
	 * @param filename
	 */
	public static void append(String str, String filename)
	{
		try {
			FileWriter fileWriter = new FileWriter(filename, true);
			PrintWriter printWriter = new PrintWriter(fileWriter);
		    printWriter.println(str); 
		    printWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	    
	}
	
	//**************************************************************************************************//
}


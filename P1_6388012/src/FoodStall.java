//Name: Rujiphart Charatvaraphan
//ID: 6388012
//Section: 1

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class FoodStall {
	
	//**************************** DO NOT MODIFY **********************************//
	public static final int MAX_QUEUE = 5;			//Max number of customers waiting to order food 
	public static enum Menu{NOODLES, DESSERT, MEAT, SALAD, BEVERAGE};	//Different type of food tyoe
	public static final int[] INSTALLATION_COST = {4000, 2500, 5000, 3500, 2000};	//Installation cost of each food type
	public static final int[] COOKING_TIME = {2, 1, 3, 2, 1};	//Time to cook each food type
	public static final int[] EAT_TIME = {6, 5, 10, 5, 2};	//Time for a customer to eat each food type
	
	
	private String foodStallName = null;	//The name of this food stall
	private List<Menu> availableMenu = new ArrayList<Menu>();	//List of all the available food types 
	private CanteenICT canteen = null;	//Reference to the CanteenICT object
	private List<Customer> customerQueue = new ArrayList<Customer>();	//List of the customers at this food stall
    
    protected int orderTime = -1;	//internal reference when someone orders food
	private int cookingTime = -1;	//internal reference to keep track of cooking time for the current order
	//********************************************************************************//
	public boolean FlagFoodStall = false;

    /**
     * Constructor. Initializing name, canteen reference, and menu
     * @param name
     * @param _canteen
     * @param menu
     */

    FoodStall(String name, CanteenICT _canteen, List<Menu> menu)
    {
        this.canteen = _canteen;
        this.foodStallName = name;

        for(Menu dish: menu)
        {
            this.availableMenu.add(dish); //Add all menu into the dish
        }

        this.orderTime = -1;
    }


	//* This method is for process 1 of Customer.takeaction()

    public void addCustomerQueue(Customer LuckyPerson) {
        customerQueue.add(LuckyPerson);
    }

	//*This method is for process 2,3 of Customer.takeaction()
    public Customer getFirstPersonOfFoodstall(){
        if(!customerQueue.isEmpty()){
            return customerQueue.get(0);
        }else return null;
    }

	//*This method is for process 3 of Customer.takeaction()
    public void removeFirstPersonOfFoodstall(){
        customerQueue.remove(0);
    }



	//************************************** DO NOT MODIFY ************************************************//
	public String getName()
	{
		return this.foodStallName;
	}
	
	public List<FoodStall.Menu> getMenu()
	{
		return this.availableMenu;
	}
	
	public List<Customer> getCustomerQueue()
	{
		return this.customerQueue;
	}
	

	/**
	 * Takes order and returns the amount of time required to cook the dishes. 
	 * 
	 * If cannot take order, return -1. E.g. Still cooking, waiting for pick-up, or does not have one of the required dishes
	 * @param dishes
	 * @return
	 */
	public int takeOrder(List<Menu> dishes)	//cook in batch
	{
		if(this.isCooking()) return -1;	//if cooking then return no
		if(this.isReadyToServe()) return -1; //food not picked up yet, return false.
		if(!this.availableMenu.containsAll(new HashSet<Menu>(dishes))) return -1;	//if cannot cook one of the dishes, return false
		this.orderTime = canteen.getCurrentTime();
		this.cookingTime = 0;	//calculate cooking time
		for(Menu dish: dishes) //(Default customer) dishes -> NDMSB -> Spend time for 9 time steps for cooking 
		{
			this.cookingTime += FoodStall.COOKING_TIME[dish.ordinal()]; //Default customer -> 9 Time steps
		}
		return this.cookingTime; //(Default customer return 9;)
	}
	
	/**
	 * Return true if the food stall is available to take order
	 * @return
	 */
	public boolean isWaitingForOrder()
	{
		return this.orderTime < 0;
	}
	
	/**
	 * Return true if currently cooking something.
	 * @return
	 */
	public boolean isCooking()
	{
		return (canteen.getCurrentTime() - this.orderTime) <= this.cookingTime; //*cooking time = 9
                                                                                //*timer = 1, o */
                                                                                
	}
	
	/**
	 * Return true of the food is ready to be served 
	 * @return
	 */
	public boolean isReadyToServe()
	{
		return !this.isCooking() && this.orderTime > 0; // T ^ T = T 
	}
	
	/**
	 * If called, reset the internal clocks so that the food stall is available to take order again.
	 * @return
	 */
	public boolean serve()
	{
		if(!this.isReadyToServe()) return false;
		this.orderTime = -1;
		this.cookingTime = -1;
		return true;
	}
	
	//**********************************************************************************************************//
	
}


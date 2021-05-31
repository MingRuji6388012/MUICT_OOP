//Name: Rujiphart Charatvaraphan
//ID: 6388012
//Section: 1
import java.util.Arrays;
import java.util.List;

public class Athlete extends Customer{
    private final List<FoodStall.Menu> athlete = Arrays.asList(new FoodStall.Menu[] {FoodStall.Menu.MEAT, FoodStall.Menu.MEAT, FoodStall.Menu.MEAT, FoodStall.Menu.SALAD, FoodStall.Menu.BEVERAGE});
    private int EatTime = 0;

    public Athlete(CanteenICT _canteen){
        super(_canteen);
        this.requiredDishes = athlete;
        this.customerType = CustomerType.ATHLETE;
        for(FoodStall.Menu menu : requiredDishes){
            this.EatTime += FoodStall.EAT_TIME[menu.ordinal()];
        }
    }
}

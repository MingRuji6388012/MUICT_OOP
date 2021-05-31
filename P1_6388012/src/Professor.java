//Name: Rujiphart Charatvaraphan
//ID: 6388012
//Section: 1
import java.util.Arrays;
import java.util.List;

public class Professor extends Customer{
    private final List<FoodStall.Menu> professor = Arrays.asList(new FoodStall.Menu[] {FoodStall.Menu.NOODLES, FoodStall.Menu.BEVERAGE});
    private int EatTime = 0;

    public Professor(CanteenICT _canteen){
        super(_canteen);
        this.requiredDishes =  professor;
        this.customerType = CustomerType.PROFESSOR;
        for(FoodStall.Menu menu : requiredDishes){
            this.EatTime += FoodStall.EAT_TIME[menu.ordinal()];
        }
    }
}

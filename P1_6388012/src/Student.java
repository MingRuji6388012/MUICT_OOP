//Name: Rujiphart Charatvaraphan
//ID: 6388012
//Section: 1
import java.util.Arrays;
import java.util.List;

public class Student extends Customer {
    private final List<FoodStall.Menu> student = Arrays.asList(new FoodStall.Menu[] {FoodStall.Menu.DESSERT, FoodStall.Menu.DESSERT, FoodStall.Menu.DESSERT, FoodStall.Menu.DESSERT, FoodStall.Menu.DESSERT});
    private int EatTime = 0;

    public Student(CanteenICT _canteen){
        super(_canteen);
        this.requiredDishes =  student;
        this.customerType = CustomerType.STUDENT;
        for(FoodStall.Menu menu : requiredDishes){
            this.EatTime += FoodStall.EAT_TIME[menu.ordinal()];
        }
    }
}

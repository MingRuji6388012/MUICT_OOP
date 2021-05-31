import java.util.ArrayList;

public class PremiumMember extends Member{
    private double fee;
    static final double Family_FEE = 80.00;
    private ArrayList<String> family;

    public PremiumMember(String email, String password, double fee){
        super(email,password);
        this.fee = fee;
        this.family = new ArrayList<String>();
    }

    public void printMemberInfo(){
        System.out.println("---- Premium MEMBER ----");
        System.out.println("Member fee: "+fee);
        super.printMemberInfo();
        if(family.size()>=1){
            System.out.println("List of Family");
            for (String s : family) {
                System.out.println(s + ",");
            }
        }
    }

    // Challenge code //
    /**
     * add username in ArrayList "family"
     * @param username
     * @return
     */

    public boolean addFamily(String username){
        if(family.size()<=1) {
            if (username != null) {
                family.add(username);
                System.out.println(username + " is added successfully");
                return true;
            }else return addFamily(null);
        }
        System.out.println("user: "+username+" cannot be added, the Family user is reached the limit");
        return false;
    }

    /**
     * Remove username in ArrayList "family"
     * @param username
     * @return
     */
    public boolean removeFamily(String username){
        for(int i = 0 ; i< family.size(); i++){
            if(username.equals(family.get(i))){
                family.remove(i);
                System.out.println(username+" is removed successfully");
                return true;
            }
        }
        System.out.println("user: " + username + " does not exist and cannot be removed");
        return false;
    }

    public double getMonthlyBill(){
        return fee+Family_FEE;
    }

}

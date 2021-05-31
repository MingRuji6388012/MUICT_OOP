import java.util.Scanner;

public class ThrowMethod {
    public static void main(String[] args) {
        try {
            Scanner kb = new Scanner(System.in);
            System.out.println("Input your number(must be than 0) : ");
            int num = kb.nextInt();
            if(num < 0){
                throw new Exception("Your input must be more than 0");//การสร้าง Exception เอง
               // return; -> Unreachable
               // throw new Exception("Eiei"); -> Unreachable
            }
            System.out.println(num);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
           return;
        }
        //System.out.println("Finally!"); -> Unreachable
    }
}

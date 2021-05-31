import java.util.Scanner;
public class Palindrome {
    public static void IsItPalindrome (){
        Scanner input = new Scanner(System.in);
        System.out.print("\nEnter string to check whether it is palindrome : ");

        String Compared = input.nextLine();         // iO Oi --> fgets in  //input.next(); --> scanf in c

        String IsPalindrome = "";

        for(int i = Compared.length()-1; i >=0 ; i--){ //Reverse string
            IsPalindrome += Compared.charAt(i);
        }

        if(Compared.equals(IsPalindrome)){
            System.out.println(Compared+" is Palindrome");
        }else System.out.println(Compared+" is not Palindrome");
        input.close();
    }
}

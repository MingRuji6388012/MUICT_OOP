import java.util.Scanner;

public class ParkingTicket {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String Enter = input.nextLine();
        String Leaving = input.nextLine();
        CalculateTime(Enter,Leaving);
        input.close();
    }

    public static void CalculateTime(String Entering, String Leaving){
        int enter = Integer.parseInt(Entering);
        int leave = Integer.parseInt(Leaving);
        int minuteEnter,minuteLeave,hourEnter,hourLeave,diffHour,diffMin;
        minuteEnter = enter % 100;
        minuteLeave = leave % 100;
        hourEnter = enter / 100;
        hourLeave = leave / 100;
        if(enter >= leave){
            hourLeave += 24;
        }
        if (minuteEnter > minuteLeave) {
            minuteLeave += 60;
            hourLeave--;
        }
        diffHour = hourLeave - hourEnter;
        diffMin = minuteLeave - minuteEnter;
        System.out.println("Entering time -> " + Entering); // "Output string" + Variable
        System.out.print("Leaving time -> " + Leaving);

        if(enter >= leave) {
            System.out.print(" (overnight)");
        }
        System.out.println("\nParking Duration: " + diffHour + " hours and " + diffMin + " minutes");

        PrintParkingDuration(diffHour,diffMin);
        PrintParkingFee(diffHour,diffMin);
    }
    
    public static void PrintParkingDuration(int Hour , int Min){
        for(int i = 1 ; i<= Hour ; i++){
            for(int j = 1 ; j<= 4 ; j++){
                System.out.print("|***************");
            }
            System.out.println(" " + i + " hr");
        }
        for(int i = 1 ; i<= 60 ; i++){
            if(i % 15 == 1)
                System.out.print("|");
            if(i <= Min)
                System.out.print("*");
            else
                System.out.print(" ");
        }
        System.out.println(" " + Min + " min\n");
    }

    public static void PrintParkingFee(int Hour , int Min){
        double Fee = 0;
        for(int i = 3 ; i <= Hour ; i++){
            Fee += 99;
        }
        // Approach 1
//        for(int i = 0 ; i <= Min ; i+=30){
//            Fee += (double) 99/2;
//        }
        
        // Approach 2
        int i = 1;
        while(i <= Min){ //31-59
            Fee = Fee + (double)99/2;
            i = i + 30;
        }
        System.out.println("Parking fee: "+ Fee);
    }
}



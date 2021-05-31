import java.util.UUID;

public class MemberTester {
    public static void main(String[] args) {
        Video[] _vdos = new Video[5];
        // create 5 videos
        for(int i = 0; i < _vdos.length; i++){ // index 0-4 (length 5)
            String generatedString = UUID.randomUUID().toString();
            _vdos[i] = new Video("[ICT Training]: How to start JAVA Lessons:" + (i+1) + "\n", "http://www.mutube.com?url="+generatedString);
        }

        FreeMember free = new FreeMember("dooMaidoo@mu.edu", "1234");
        System.out.println("Task 1: Adding new video into free member account");
        for(Video each_vdo: _vdos){
            free.addVideo(each_vdo);
        }
        System.out.println("*******************************");
        System.out.println("Task 2: Remove/add a video from free account");
        free.removeVideo(_vdos[1]);
        free.addVideo(_vdos[3]);
        System.out.println("*******************************");

        System.out.println("Task 3: Display free member information");
        free.printMemberInfo();
        System.out.println("*******************************");

        PremiumMember premium = new PremiumMember("likeGods@mu.edu", "9876", 399);
        System.out.println("Task 4: Add/remove new videos into premium member account");
        for(Video each_vdo: _vdos){
            premium.addVideo(each_vdo);
        }
        premium.removeVideo(_vdos[2]);
        System.out.println("*******************************");
        System.out.println("Task 5: Display premium member information");
        premium.printMemberInfo();

        System.out.println("Challenge 1: Add/Remove Family members");
        premium.addFamily("alan@turing");
        premium.addFamily("bill@gates");
        premium.addFamily("steve@job");
        premium.removeFamily("bill@gates");
        premium.removeFamily("bill@gates");
        System.out.println("*******************************");

        System.out.println("Challenge 2: Get monthly bill of premium member account");
        System.out.println("The monthly bill: " + premium.getMonthlyBill());
        System.out.println("*******************************");

        System.out.println("Challenge 3: Display premium member info");
        premium.printMemberInfo();
        System.out.println("*******************************");

    }
}

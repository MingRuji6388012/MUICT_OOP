import java.util.ArrayList;

/*
 * DO NOT MODIFY THIS CLASS
 */

public class RobotTester {
	
	public static void main(String args[]){

		System.out.println("--------- Testing SkatingRobot ---------");
		Robot robot = new SkatingRobot("Newbie", 2, 5, 'N');
		SkatingRobot newbie = (SkatingRobot) robot;
		System.out.println(newbie);	// execute SkatingRobot's toString()
		
		System.out.println("* Turns clockwise -> " + newbie.turnClockWise());
		System.out.println("* Skates with speed 5 -> " + newbie.skate(5));
		
		for(int i = 0; i < 5; i++) {
			if(i%2 == 0)
				newbie.turnClockWise();
			else
				newbie.turnCounterClockWise();
		}
		
		System.out.println("* Turns to direction E and skats with speed 5 -> " + newbie.skate('E', 2));
		System.out.println(newbie);
		
		System.out.println("\nTesting invalid arguments!");
		try {
			System.out.println("** Skates with speed 0");
			newbie.skate(0);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			System.out.println("** Turns to direction D and skaptes with speed 8");
			newbie.skate('D', 8);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println(newbie);	
		
		// Uncomment to test task 2

		System.out.println("\n--------- Testing SpeakingRobot ---------");
		ArrayList<Robot> robots = new ArrayList<Robot>();
		robots.add(new Robot("Python"));
	    robots.add(new Robot("C#", 1, 1));
	    robots.add(new Robot("Go"));
	    robots.add(new Robot("Dart", 10, 1));
	    robots.add(new Robot("Ruby", 10, 1));
	    robots.add(new Robot("React"));

	    Robot robot2 = new SpeakingRobot("Java");
	    SpeakingRobot java = (SpeakingRobot) robot2;

	    System.out.println("*** Greetings other robots at the same location.");
	    java.greeting(robots);

	    System.out.println("*** Moves to a new location (10, 1) and greetings again.");
	    java.setLocation(10, 1);
		java.greeting(robots);

		
	}
	
}

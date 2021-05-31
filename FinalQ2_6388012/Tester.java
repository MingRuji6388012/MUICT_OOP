//import static org.junit.jupiter.api.Assertions.*;
//
//import java.io.ByteArrayOutputStream;
//import java.io.PrintStream;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
///*
// * DO NOT MODIFY THIS CLASS
// */
//
//class Tester {
//
//	private final PrintStream standardOut = System.out;
//	private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//	private final List<Robot> robots = new ArrayList<Robot>();
//
//	@Test
//	void testTask1SkatingRobot() {
//		Robot robot = new SkatingRobot("Surf", 0, 0, 'N');	// SkatingRobot is a subclass of Robot
//		assertTrue(robot instanceof SkatingRobot);
//
//		SkatingRobot r = (SkatingRobot) robot;
//		assertEquals("Surf", r.getName());
//		assertEquals(0, r.getLocX());
//		assertEquals(0, r.getLocY());
//		assertEquals("(0, 0)", r.getLocation());
//		assertEquals('N', r.getDirection());
//
//		assertEquals('E', r.turnClockWise());
//		assertEquals('S', r.turnClockWise());
//		assertEquals('W', r.turnClockWise());
//		assertEquals('N', r.turnClockWise());
//
//		assertEquals('W', r.turnCounterClockWise());
//		assertEquals('S', r.turnCounterClockWise());
//		assertEquals('E', r.turnCounterClockWise());
//		assertEquals('N', r.turnCounterClockWise());
//
//		assertEquals("(0, 10)", r.skate(10));
//		r.turnClockWise();	// current direction is E
//		assertEquals("(8, 10)", r.skate(8));
//		r.turnClockWise();	// current direction is S
//		assertEquals("(8, 2)", r.skate(8));
//		r.turnClockWise();	// current direction is W
//		assertEquals("(-2, 2)", r.skate(10));
//
//		try {
//			r.skate(0);		// invalid speed
//		} catch (IllegalArgumentException e) {
//			System.out.println(e.getMessage());
//		}
//
//		assertEquals("N (-2, 12)", r.skate('N', 10));
//		assertEquals("E (6, 12)", r.skate('E', 8));
//		assertEquals("S (6, 4)", r.skate('S', 8));
//		assertEquals("W (-4, 4)", r.skate('W', 10));
//		try {
//			r.skate('X', 4);	// invalid direction
//		} catch (IllegalArgumentException e) {
//			System.out.println(e.getMessage());
//		}
//
//		assertEquals("Surf is at location (-4, 4) and facing at direction W", r.toString());
//	}
//
//
//	@BeforeEach
//	public void setUp() {
//	    System.setOut(new PrintStream(outputStream));
//	    robots.add(new Robot("Python"));
//	    robots.add(new Robot("C#", 1, 1));
//	    robots.add(new Robot("Go"));
//	    robots.add(new Robot("Dart", 10, 1));
//	    robots.add(new Robot("Ruby", 10, 1));
//	    robots.add(new Robot("React"));
//	}
//
//	/**
//	 * uncomment testSpeakingRobot and testSpeakingRobot2 below
//	 * to test SpeakingRobot Class (Task 2)
//	 */
//
//	/*
//	@Test
//	void testSpeakingRobot() {
//	    Robot robot = new SpeakingRobot("Java");
//	    assertTrue(robot instanceof SpeakingRobot);
//
//	    SpeakingRobot r = (SpeakingRobot) robot;
//	    r.greeting(robots);
//	    assertEquals("Hi [Python, Go, React], I'm Java. Nice to meet you.", outputStream.toString().trim());
//
//	}
//
//	@Test
//	void testSpeakingRobot2() {
//	    SpeakingRobot r = new SpeakingRobot("OOP", 0, 0);
//	    r.setLocation(10, 1);
//		r.greeting(robots);
//
//		assertEquals("Hi [Dart, Ruby], I'm OOP. Nice to meet you.", outputStream.toString().trim());
//	}
//	*/
//
//	@AfterEach
//	public void tearDown() {
//	    System.setOut(standardOut);
//	}
//}

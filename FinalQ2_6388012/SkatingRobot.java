// ID:
// Name:
// Section

/**
 * This SaktingRobot class must extend the Robot Class
 *
 */

public class SkatingRobot extends Robot{

	// ----------------------------------
	// Additional instance fields go here
	private char direction;
	// ----------------------------------
	// Facing direction either N, E, S, or W
	
	public SkatingRobot(String _name, int _x, int _y, char _direction) {
		super(_name,_x,_y);
		direction = _direction;
	}
	
	public SkatingRobot(String _name, char _direction) {
		super(_name);
		direction = _direction;
	}
	
	/**
	 * @return current direction
	 */
	public char getDirection() {
		return direction;
	}
	
	/**
	 * Turns the robot 90 degrees clockwise 
	 * e.g., the direction 'N' changes to 'E', 'E' changes to 'S' and so on... 
	 * @return the new direction
	 */
	public char turnClockWise() {
		switch (direction){
			case 'N': direction = 'E';
			case 'E': direction = 'S';
			case 'S': direction = 'W';
			case 'W': direction = 'E';
		}
		return direction;
	}
	
	/**
	 * Turns the robot 90 degrees counterclockwise 
	 * e.g., the direction 'N' changes to 'W', 'W' changes to 'S' and so on... 
	 * @return the new direction
	 */
	public char turnCounterClockWise() {
		switch (direction){
			case 'N': direction = 'W';
			case 'W': direction = 'S';
			case 'S': direction = 'E';
			case 'E': direction = 'N';
		}
		return direction;
	}
	
	/**
	 * The robot skates in the direction that it is facing at the given speed.
	 * As a result, the location x or y is changing.
	 * 
	 * For example, if the robot is currently at location (0, 0) facing 'N' direction 
	 * and the speed is 5, then the location y is increased by 5.
	 * 
	 * @throws IllegalArgumentException if the speed is less than or equals to 0. 
	 * 			The message is "Invalid speed (must be positive number)".
	 * 
	 * @return the new location as string -> (location x, location y) e.g., "(0, 5)"
	 */
	public String skate(int speed) {
		if(speed <= 0){
			throw new IllegalArgumentException("Invalid speed (must be positive number)");
		}else{
			switch (direction){
				case 'N': setLocation(getLocX(),getLocY()+speed); break;
				case 'E': setLocation(getLocX()+speed,getLocY()); break;
				case 'S': setLocation(getLocX(),getLocY()-speed); break;
				case 'W': setLocation(getLocX()-speed,getLocY()); break;
			}
		}
		return getLocation();
	}
	
	/**
	 * The robot turns into a given direction and skates in that direction at the given speed.
	 * 
	 * For example, if the robot is currently at location (0, 0) facing 'N' direction, and
	 * the given direction is 'S' and the speed is 5, then the location y will be decreased by 5.
	 * The new location will be (0, -5)
	 * 
	 * @throws IllegalArgumentException if the given direction is invalid.
	 * 			The message is "Invalid direction (N, S, E, and W only)".
	 * 
	 * @return the direction and location as string -> direction (location x, location y) e.g., "N (0, 5)"
	 */
	public String skate(char newDirection, int speed) {
		if(newDirection != 'N' && newDirection != 'E' && newDirection != 'S' && newDirection != 'W'){
			throw new IllegalArgumentException("Invalid direction (N, S, E, and W only)");
		}else{
			if(newDirection == 'N'){
				setLocation(getLocX(),getLocY()+speed);
			}else if(newDirection == 'E'){
				setLocation(getLocX()+speed,getLocY());
			}else if(newDirection == 'S'){
				setLocation(getLocX(),getLocY()-speed);
			}else if(newDirection == 'W'){
				setLocation(getLocX()-speed,getLocY());
			}
		}
		return getLocation();
	}
	
	/**
	 * @return information of this SkatingRobot (see the expected output)
	 */
	public String toString() {
		StringBuilder outputStr = new StringBuilder();
		outputStr.append(super.toString());
		outputStr.append(" and facing at direction "+direction);
		return outputStr.toString();
	}
}

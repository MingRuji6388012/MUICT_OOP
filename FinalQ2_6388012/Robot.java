/*
 * DO NOT MODIFY THIS CLASS
 */

public class Robot {
	public String name;
	private int x, y;		// Coordinate (x, y) location of the robot
	
	// Initialize name and coordinate (x, y) location
	public Robot(String _name, int _x, int _y) {
		this.name = _name;
		this.x = _x;
		this.y = _y;
	}
	
	// Initialize name of the robot with the default value of location (0, 0)
	public Robot(String _name) {
		this(_name, 0, 0);
	}
	
	// Return the robot's name
	public String getName() {
		return name;
	}
	
	// Return the current location x
	public int getLocX() {
		return x;
	}
	
	// Return the current location y
	public int getLocY() {
		return y;
	}
	
	// Return the current location x and location y
	public String getLocation() {
		return "("+ x + ", " + y + ")";
	}
	
	// Set a new location for this robot
	public void setLocation(int _x, int _y) {
		this.x = _x;
		this.y = _y;
	}
	
	// Return true if the given robot is at the same location, 
	// Otherwise return false.
	public boolean equals(Robot r) {
		return (this.x == r.x) && (this.y == r.y);
	}
	
	// Return information of this Robot 
	public String toString() {
		return name + " is at location (" + x + ", " + y + ")";
	}
}

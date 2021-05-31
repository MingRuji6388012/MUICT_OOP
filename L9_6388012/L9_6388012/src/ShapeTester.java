import java.net.Socket;
import java.util.HashMap;
import java.util.regex.Matcher;


public class ShapeTester {
	public static void main(String[] args){
		MingFrame mingFrame = new MingFrame(); //Bonus
		
		HashMap<String, Shape> shapeMap = new HashMap<String, Shape>();
		shapeMap.put("circle_2", new Circle(10));
		shapeMap.put("my.circle", new Circle(2));
		shapeMap.put("2square", new Square(5));
		shapeMap.put("Square*", new Square(10));
		shapeMap.put("triangle2", new Triangle(20, 40));
		shapeMap.put("123_.DidProgramGotThis", new Triangle(3,4));
		shapeMap.put("RootOf_Square123", new Square(22.5));

		Triangle x = new Triangle(20, 10);
		if(shapeMap.get("my.circle").compareTo(x) == - 1)
			System.out.println("my.circle is smaller than triangle x");
		if(shapeMap.get("Square*").compareTo(x) == 0)
			System.out.println("Square* is the same size as triangle x");
		if(shapeMap.get("triangle2").compareTo(x) == 1)
			System.out.println("triangle2 is larger than triangle x");
		System.out.println("--------------------");
		
		printAllShapes(shapeMap);
		
		System.out.println("--------------------");
		System.out.println("Number of invalid shape's name is " + countInvalidName(shapeMap));
		
		// Put two more object into the shapeMap
		// One object must have a valid name, another one must have invalid name
		
	}
	
	
	/*
	 * Print all shapes in the HashMap
	 * The format is: name -> shape description from toString() method.
	 * For example: triangle2->Triangle with base 2.0, height  4.0 (color=red, area=4.0)
	 * Note that the order of shape in your output might different from the expected output
	 * This is OKAY!
	 */
	public static void printAllShapes(HashMap<String, Shape> shapes) {
		for(String i: shapes.keySet()){
			System.out.println(i + "->" + shapes.get(i).toString());
		}
	}
	
	/*
	 * Count number of shapes whose name is invalid
	 * The valid name starts with a letter, followed by letters, digits, or underscores.
	 * E.g., circle, Circle, my_Circle, circle_2
	 * Here is an example of invalid name: 3circle, circle.my, circle*
	 */
	public static int countInvalidName(HashMap<String, Shape> shapes) {
		int count = 0;
		for(String name: shapes.keySet()){
			
			if(isLetter(name.charAt(0)) || isDigit(name.charAt(0))){
				if(name.matches("[A-Za-z0-9_]+")){
					count++;
				}
			}
		}
		return shapes.size()-count;
		// int count = 0;
		// //int iterationCount = 0;
		// for(String name: shapes.keySet()){
		// 	// System.out.println("Countloop "+ iterationCount++ +", Name: "+ name);
		// 	int nameLength = name.length();
		// 	int CharPass = 0;
		// 	if(isLetter(name.charAt(0))){
		// 		for(int i = 0; i < nameLength; i++){
		// 			boolean isOkay = isLetter(name.charAt(i))|| isDigit(name.charAt(i)) || name.charAt(i) == 95;
		// 			if(isOkay){
		// 				CharPass++;
		// 			}	
		// 		}
		// 	}
		// 	if(CharPass != nameLength){
		// 		System.out.println("Invalid name is " + name);
		// 		count++;
		// 	}
		// }
		// return count;
	}
	
	public static boolean isLetter(char someChar){
		return (someChar >= 65 && someChar <= 90) || (someChar >= 97 && someChar <= 122);
	}

	public static boolean isDigit(char someChar){
		return (someChar >= 48 && someChar <= 57);
	}
	
}

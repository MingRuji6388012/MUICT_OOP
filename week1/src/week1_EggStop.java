public class week1_EggStop {
	public static void main(String[] args) {
		for(int i = 1 ; i<= 3 ; i++) {
			PrintEgg(i); //Static method 
		}
	}
		public static void PrintEgg(int num) {
				System.out.println("  ______");
				System.out.println(" /      \\");
				System.out.println("/        \\");
				if(num == 3) {
					System.out.println("|  STOP  |");
				}
				System.out.println("\\        /");
				System.out.println(" \\______/");
				if(num > 1) {
					System.out.print("+--------+");
					
				}
				if(num < 3) 
					System.out.println("\n");
					if(num == 2) {
						System.out.println();
					}
						
			}
	
}

public class week1_LetterPrinter {
	public static void main(String[] args) {
		System.out.println();
		for(int i = 1 ; i<=5 ; i++) {
			if(i % 4 ==1) {
				System.out.println("XXXXXXXX");
			}else {
				System.out.println("X      XX");
			}	
		}
		for(int i = 1 ; i <= 5 ; i++) {
			System.out.print("XX");
			for(int j = 1 ; j<=2+i ; j++) {
				System.out.print(" ");
			}
			System.out.print("XX");
			System.out.println();
		}
	}
}

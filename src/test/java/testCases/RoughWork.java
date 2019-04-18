package testCases;

public class RoughWork {

	/*
	 * public static void main(String[] args) {
	 * 
	 * int count = 5; for (int i = 1; i <= count; i++) { for (int j = 0; j < i; j++)
	 * { System.out.print("*"); } System.out.println(""); }
	 * 
	 * } 
	 */

	public static void main(String[] args) {

		int count = 5;
		for (int i = count; i>0; i--) {
			for (int j = 0; i<j; j++) {
				System.out.print("*");
			}
			System.out.println("");
		}
	}

}

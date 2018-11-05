
public class Helpers {
	
	/**
	 * rounds down in ones digit
	 * @return
	 */
	public static int round (int num) {
		
		return num - num%10;
				
	}
	
	public static void main (String [] args) {
		
		System.out.println(round(3));
		
	}
	
}

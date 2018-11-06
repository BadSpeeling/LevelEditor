
public class Helpers {
	
	/**
	 * rounds down in ones digit
	 * @return
	 */
	public static int round (int num) {
		return num - num%10;
	}
	
	public class EntityID {
		public static final int redX = 0;
	}
	
	public static String getLevelEditorObject (int id) {
		
		switch (id) {
			case 0: return "redX.png";
			default: return "";
		}
		
	}
	
	public static void main (String [] args) {
		
		System.out.println(round(17));
		
	}
	
}

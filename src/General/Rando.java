package General;

public class Rando {

	public static void main(String[] args) {
		
		String input = "You can not now realize that you will ever feel better. Is not this so? And yet it is a mistake. You are sure to be happy again. To know this, which is certainly true, will make you some less miserable now.";		
		
		for (int limit = 10; limit <= 31; limit++) {
		
			String curLine = "";
			System.out.println("Approx chars per line: " + limit);
			
			for (int i = 0; i < input.length(); i++) {
				
				char next = input.charAt(i);
				
				if (next == ' ' && curLine.length() >= limit) {
					System.out.println(curLine);
					curLine = "";
				}
				
				else {
					curLine += next;
				}
				
			}
			
			System.out.println(curLine + "\n");
			
		}
		
		
		
	}

}

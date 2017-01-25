package library;

public class Snippet {
	public  void menu(){
	
		String choice;
		int amount;
	
		do {
			choice = Console.readLine(""  
					+ "(0)             --- attack\n"
					+ "(1)             --- defense\n"
					+ "(2)             --- flee\n"
					+ "(anything else) --- quit\n ?");
			if (choice.equals("0")){
				System.out.println(this);
			}
			else if (choice.equals("1")){
				amount = Console.readInt("how much to deposit (in cents)?");
				deposit(amount);
				System.out.println(this);
			}
			else if (choice.equals("2")){
				amount = Console.readInt("how much to withdraw (in cents)?");
				withdraw(amount);
				System.out.println(this);
			}
			else System.out.println("** Bye **");
	
		}
		while (choice.equals("0")
			|| choice.equals("1") 
				|| choice.equals("2"));
		
	}
}


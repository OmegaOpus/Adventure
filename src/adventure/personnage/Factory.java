package adventure.personnage;

import java.util.Random;

public class Factory {

	
	public static String listName[]={"Carac", "Ulric", "Tybalt", "Borin", "Sadon", "Terrowin", "Rowan", "Forthwind", 
			"Althalos", "Fendrel", "Brom", "Hadrian", "Lord Crewe", "Walter De Bolbec", "Earl of Derwintwater", 
			"Lord Montagu", "Sir John Fenwick of Wallington", "Oliver Cromwell", "Justice McKinnon", 
			"Sir Clifton Writingham", "Walter deGrey", "Roger de Mowbray", "Joseph Rowntree", "Geoffrey Chaucer",
			"William of Wykeham", "Francis Drake"};
	public static int length = listName.length;
	
	public static Warrior newWarrior(){
		Random rnd = new Random();
		String name = listName[rnd.nextInt(length)];
		return new Warrior(name);
	}
	public static Mage newMage(){
		Random rnd = new Random();
		String name = listName[rnd.nextInt(length)];
		return new Mage(name);
	}
	
	public static Pretre newPretre(){
		Random rnd = new Random();
		String name = listName[rnd.nextInt(length)];
		return new Pretre(name);
	}
	
	
	
	public static Rogue newRogue(){
		Random rnd = new Random();
		String name = listName[rnd.nextInt(length)];
		return new Rogue(name);
	}
	
	
	
	public static Hero newHero(){
		Random rnd = new Random();
		String name = listName[rnd.nextInt(length)];
		if(System.currentTimeMillis()%4==0){
			return (Hero) new Warrior(name);
		}
		else if(System.currentTimeMillis()%4==1){
			return (Hero) new Mage(name);
		}
		else if(System.currentTimeMillis()%4==2) {
			return (Hero) new Rogue(name);
		}
		else
		{
			return (Hero) new Pretre(name);
		}
		
	}
	public static void main(String[] args) {
		if(args.length >=1){
			for(int j = Integer.parseInt(args[0], 10); j>= 0; j--){
						System.out.println((newHero().toString()));
				}
			}
		}
	
	
}

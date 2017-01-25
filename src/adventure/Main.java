package adventure;

import java.util.Random;
import library.Console;
import adventure.personnage.*;
import adventure.combat.*;

public class Main {
	
	static public void main(String [] args){
		String choiceHeal;
		//String choice;
		String tacos;
		String choice2;
		Hero hero1;
		int PvIni = 0, PmIni=0;
		Hero hero2;
		int gain = 0;
		boolean cond = true;
		int Stage = 0;
		tacos = Console.readLine("Sélectionnez votre classe :"  +
				"\n"
				+ "(0)             --- Rogue\n"
				+ "(1)             --- Warrior\n"
				+ "(2)             --- Mage\n"
				+ "(3)             --- Pretre\n"	
				+ "(q) --- quit\n ?");
		if (tacos.equals("q")){
			System.exit(0);
			hero1=Factory.newHero();
		}
		else if (Integer.parseInt(tacos) == 0){
			hero1 = Factory.newRogue();
			}
		else if(Integer.parseInt(tacos) == 1){
		  hero1 = Factory.newWarrior();
			}
		else if(Integer.parseInt(tacos) == 3){
			  hero1 = Factory.newPretre();
				}
		else{
		    hero1 = Factory.newMage();			}
		hero1.setName(Console.readLine(" Veuillez choisir votre nom. Celui-ci vous suivra durant toute la partie. \n "));

		Random rnd = new Random();
		System.out.println("Vous vous appelez donc : " + hero1.toString());
		try {
		    Thread.sleep(rnd.nextInt(100));                 //100 milliseconds is one second.
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		
		PvIni = hero1.getHealth();
		PmIni = hero1.getMana();
		boolean combat,partie;
		
		do {
			cond=true;
			combat=true;
			partie=true;
			Stage++;
		hero2 = Factory.newHero();
		System.out.println(hero2.toString() + " entre en jeu ! Affrontez le.");

combat:		do {
			
			if(hero1.isDead()){
				System.out.println("Yolo t'as perdu looser");
				break;
			}
			else if (hero2.isDead()) {
				System.out.println("Bien joué ! Vous avez gagné !");
				System.out.println(hero2.toString() + " est mort !");
				gain = 10*Stage;
				hero1.setOr(gain+hero1.getOr());
				System.out.println("Vous avez gagné de l'xp et " + gain +" d'or ! \n");
				break;
			}
			if(Attacks.menu(hero1, hero2))
				break combat;

			if (!hero2.isDead())
				hero2.IA(hero1);

		}
		while (combat);
		
		
		System.out.println("Vous possédez actuellement " + hero1.getOr() +" d'or ! \n");
		
		
		do{
			choice2 = Console.readLine(""  
					+ "(yes)             --- Continue ?\n");
			if(choice2.equals("no")){
				partie=false;
				cond=false;
			}
			if (choice2.equals("yes")){
				cond=false;
			}
		}while(cond);
		
		if (choice2.equals("yes")&& hero1.getOr() >= 10){
			choiceHeal = Console.readLine("Vous pouvez vous soigner chez la fée Lili \n"  
					+ "(yes)             --- Heal (10 or) ?\n");
			if (choiceHeal.equals("yes")){
				LiliHeal.Heal(hero1, PvIni, PmIni);
			}
		}
		}while (partie);
	     System.out.println("** Bye **");
	}

}

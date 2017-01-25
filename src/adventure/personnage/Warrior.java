package adventure.personnage;

//import java.util.Random;

import library.Console;
import adventure.equipement.*;
import adventure.combat.*;

public class Warrior extends Hero implements Armored{
	
	public Warrior(String name) {
		super(name, 23, 19);
		posture="defense";
	}
	
	public double armor(){
		return 4;
	}
	
	//final int dmgHigh = 42;
    //final int dmgLow = 32;	
	final String job = "(Warrior)";

		
	/*public int getDmgLow(){
		return dmgLow;
	}
	
	public int getDmgHigh(){
		return dmgHigh;
	}*/
	
	public int Attack(){
			return inflict();
	}
	

	public String toString(){
		return super.toString()+ " " + job;
	}
	
	
	/*public int inflict(){
		Random rnd = new Random();
		return (rnd.nextInt(getDmgHigh()-getDmgLow())+getDmgLow());
	}*/
	
	public void attacks(Hero hero2){
		String atk = Console.readLine("Sélectionnez votre attaque :"  +
				"\n"
				+ "(0)             --- Long\n"
				+ "(1)             --- Middle\n"
				+ "(2)             --- Short\n");
		if(atk.equals("0")){
			Attacks.LongAttack(this,hero2);
		}
		else if (atk.equals("1")){
			Attacks.MiddleAttack(this, hero2);
		}
		else if (atk.equals("2")){
			Attacks.CourtAttack(this,hero2);
		}
	}
	
	public void IA(Hero ennemi)
	{
		int choix=Math.abs(rnd.nextInt()%3);
		if(choix==0)
			Attacks.CourtAttack(this, ennemi);
		if(choix==1)
			Attacks.MiddleAttack(this,ennemi);
		if(choix==2)
			Attacks.LongAttack(this, ennemi);
	}
	
	
}


package adventure.personnage;

//import java.util.Random;

import library.Console;
import adventure.equipement.*;
import adventure.combat.*;

public class Rogue extends Hero implements Armored{
	
	
	public Rogue(String name) {
		super(name, 22, 19);
		posture="attaque";
	}
	
	//final int dmgHigh = 38;
   // final int dmgLow = 24;	
    final String job = "(Rogue)";
    boolean isParrying = false;
    
	public double armor(){
		if(isParrying){
			return 1;
		}
		else {
		return 2;
		}
	}
	
	public final int Parrying = 20;

	
	public void receive(int dmg){
	   if(dmg>=40){
		   health -= dmg -5;
		   isParrying = true;
	   }
	   else{
		   health -= dmg;
	   }
	}
	
	/*public int getDmgLow(){
		return dmgLow;
	}
	
	public int getDmgHigh(){
		return dmgHigh;
	}*/
	
	
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
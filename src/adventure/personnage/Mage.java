package adventure.personnage;

import java.util.Random;
import library.Console;
import adventure.spell.*;
import adventure.equipement.*;
import adventure.combat.*;

public class Mage extends Hero implements Armored{
	
	
	public Mage(String name) {
		super(name, 17, 24);
		listesort=new Spell[]{new SpellDmg(this,5,"Feu"),new SpellDmg(this,15,"Glace")
		,new SpellDmg(this,10,"Foudre")};
		posture="focus";
	}
	private Spell[] listesort;
	//final int dmgHigh = 29;
    //final int dmgLow = 19;	
    final String job = "(Mage)";
	
	public final int spellDmg = 48;
	
	/*public int getDmgLow(){
		return dmgLow;
	}
	public int getDmgHigh(){
		return dmgHigh;
	}
	*/
	
	public Spell[] getListeSort()
	{
		return listesort;
	}
	
	public String toString(){
		return super.toString()+ " " + job;
	}
	
	
	/*public int inflict(){
		Random rnd = new Random();
		return (rnd.nextInt(getDmgHigh()-getDmgLow()));
	}*/
	
	
	
	public void attacks(Hero hero2){
		String atk = Console.readLine("Sélectionnez votre attaque :"  +
				"\n"
				+ "(0)             --- Ouvrir le menu des sorts\n"
				+ "(1)             --- Coup de bâton\n");
		if(atk.equals("0")){
			Attacks.MagieDMG(this,hero2);
		}
		else if (atk.equals("1")){
			Attacks.MiddleAttack(this, hero2);
		}
	}
	
	public void IA(Hero ennemi)
	{
		Random choix =new Random();
		if(choix.nextInt()%2==0)//on lance un sort
		{
			int choixsort=choix.nextInt();
			listesort[Math.abs(choixsort%3)].cast(ennemi, this);
		}
		else
			Attacks.MiddleAttack(this, ennemi);
	}
	
	
	
}

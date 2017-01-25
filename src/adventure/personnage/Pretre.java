package adventure.personnage;

//import java.util.Random;
import library.Console;
import adventure.spell.*;
//import adventure.equipement.*;
import adventure.combat.*;

public class Pretre extends Hero  {
	
	Spell[] listesort;
	final String job = "(Pretre)";
	
	public Pretre(String name)
	{
		super(name,20,21);
		posture="focus";
		listesort=new Spell[]{new SpellHeal(this,"Premiers secours",6),new SpellHeal(this,"Soins majeurs",18)};
	}
	
	public Spell[] getListeSort()
	{
		return listesort;
	}
	
	public String toString(){
		return super.toString()+ " " + job;
	}
	
	public void attacks(Hero hero2) {
		String atk = Console.readLine("Sélectionnez votre attaque :"  +
				"\n"
				+ "(0)             --- Ouvrir le menu des sorts\n"
				+ "(1)             --- Coup de bâton\n");
		if(atk.equals("0")){
			Attacks.MagieHeal(this);
		}
		else if (atk.equals("1")){
			Attacks.MiddleAttack(this, hero2);
		}

	}

}

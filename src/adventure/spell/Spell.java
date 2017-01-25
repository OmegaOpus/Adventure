package adventure.spell;
import adventure.personnage.Hero;

import java.util.Random;

public abstract class Spell {
	
	
	protected int coutpm;
	protected String name;
	protected Random rnd;
	
	public Spell(int coutpm, String name)
	{
		rnd=new Random();
		this.coutpm=coutpm;
		//this.dmghigh=(int)(lanceur.getIntelligence()*1.5*(1+2*coutpm/100));
		//this.dmglow=(int)(lanceur.getIntelligence()*(1+coutpm/100));;
		this.name=name;
	}
	
	public abstract void cast(Hero cible,Hero lanceur);
	
	
	public String toString()
	{
		return name+"("+coutpm+"pm)";
	}

}

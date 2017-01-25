package adventure.spell;

import adventure.personnage.Hero;

public class SpellHeal extends Spell {
	
	private int healmin,healmax;
	
	public SpellHeal(Hero lanceur,String name, int coutpm)
	{
		super(coutpm,name);
		healmax=(int)(lanceur.getIntelligence()*1.5*(1+2*coutpm/100));
		healmin=(int)(lanceur.getIntelligence()*(1+coutpm/100));;
	}

	public void cast(Hero cible, Hero lanceur) {
		int coutpm=this.coutpm;
		if(lanceur.getPosture().equals("focus"))
			coutpm/=2;
		if(lanceur.getMana()>=coutpm)
		{
			lanceur.setMana(lanceur.getMana()-coutpm);
			int heal=rnd.nextInt(healmax-healmin)+healmin;
			System.out.println(lanceur+" lance le sort"+name+" sur "+cible);
			cible.setHealth(cible.getHealth()+heal);
		}
		else
			System.out.println(lanceur+" essaie de lancer "+this+" mais échoue");


	}

}

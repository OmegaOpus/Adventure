package adventure.spell;
import adventure.personnage.Hero;

public class SpellDmg extends Spell {
	
	protected int dmglow;
	protected int dmghigh;
	
	public SpellDmg(Hero lanceur, int coutpm, String name)
	{
		super(coutpm,name);
		dmghigh=(int)(lanceur.getIntelligence()*1.5*(1+2*coutpm/100));
		dmglow=(int)(lanceur.getIntelligence()*(1+coutpm/100));;
	}
	
	public void cast(Hero cible, Hero lanceur) {
		int coutpm=this.coutpm;
		if(lanceur.getPosture().equals("focus"))
			coutpm/=2;
		if(lanceur.getMana()>=coutpm)
		{
			lanceur.setMana(lanceur.getMana()-coutpm);
			int dmg=rnd.nextInt(dmghigh-dmglow)+dmglow;
			System.out.println(lanceur+" lance le sort"+name+" sur "+cible);
			cible.receive(dmg);
		}
		else
			System.out.println(lanceur+" essaie de lancer "+this+" mais échoue");

	}

}

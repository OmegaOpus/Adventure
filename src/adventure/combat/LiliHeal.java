package adventure.combat;

import adventure.personnage.*;

public class LiliHeal {

	public static void Heal(Hero hero1, int PvIni, int PmIni){
		hero1.setOr( hero1.getOr() - 10);
		hero1.setHealth(PvIni);
		hero1.setMana(PmIni);
	}
	
	
}

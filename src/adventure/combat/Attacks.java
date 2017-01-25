package adventure.combat;

import java.util.Random;

import library.Console;
import adventure.personnage.*;
import adventure.spell.*;

public class Attacks {
	
	public static boolean menu(Hero hero1,Hero hero2)
	{
		String choice;
		boolean fuite=false;
		
		System.out.println(hero1+" se bat contre "+hero2);
		System.out.println("Vous avez actuellement : " + hero1.getMana() + " mana.");
		choice = Console.readLine(""  
				+ "(0)             --- attack\n"
				+ "(1)             --- new posture\n"
				+ "(2)             --- flee\n");
		if (choice.equals("0")){
			hero1.attacks(hero2);
			System.out.println("Vous avez " + hero1.getHealth() + " points de vie");
			System.out.println("Votre adversaire a " + hero2.getHealth() + " points de vie");

		}
		else if (choice.equals("1")){
			boolean isAGoodPos=true;
			do{
			System.out.println("Choisissez votre posture :\n " 			
					+ "(0)             --- attaque\n"
					+ "(1)             --- defense\n"
					+ "(2)             --- focus\n");
			String newposture=Console.readLine();
			if(newposture.equals("attaque")||newposture.equals("defense")||newposture.equals("focus"))
			{	
				hero1.changeposture(newposture);
				isAGoodPos=false;
			}
			}while(isAGoodPos);
			
		}
		else if (choice.equals("2")){
			Random gennum=new Random();
			int chancefuitehero1=hero1.getHealth()*gennum.nextInt(5);
			int chancefuitehero2=hero2.getHealth()*gennum.nextInt(5);
			System.out.println("chancefuitehero1="+chancefuitehero1);
			System.out.println("chancefuitehero2="+chancefuitehero2);
			if(chancefuitehero1>=chancefuitehero2)
			{
				fuite=true;
				System.out.println("Vous avez fuit");
			}
		}
		return fuite;
	}
	
	public static void LongAttack(Hero attacker, Hero defender){
		double defenderArmor = defender.armor();
		int yolodmg = (int)((attacker.inflict() * (1 - (0.06 * defenderArmor / (1 + 0.06 * defenderArmor))))*1.5);
		if(attacker.getPosture().equals("defense"))
			yolodmg/=2;
		else if(attacker.getPosture().equals("defense"))
			yolodmg*=0.75;
		System.out.println("Dommages effectués : " + yolodmg);
		defender.receive(yolodmg);
		
	}
	
	
	public static void MiddleAttack(Hero attacker, Hero defender){
		double defenderArmor = defender.armor();
		int yolodmg = (int)(attacker.inflict() * (1 - (0.06 * defenderArmor / (1 + 0.06 * defenderArmor))));
		if(attacker.getPosture().equals("defense"))
			yolodmg/=2;
		else if(attacker.getPosture().equals("defense"))
			yolodmg*=0.75;
		System.out.println("Dommages effectués : " + yolodmg);
		defender.receive(yolodmg);
		
	}
	
	
	public static void CourtAttack(Hero attacker, Hero defender){
		double defenderArmor = defender.armor();
		int yolodmg = (int)((attacker.inflict() * (1 - (0.06 * defenderArmor / (1 + 0.06 * defenderArmor))))/2);
		if(attacker.getPosture().equals("defense"))
			yolodmg/=2;
		else if(attacker.getPosture().equals("defense"))
			yolodmg*=0.75;
		System.out.println("Dommages effectués : " + yolodmg);
		defender.receive(yolodmg);
		
	}
	
	public static void MagieDMG(Mage attacker, Hero defender){
		Spell[] listesort=attacker.getListeSort();
		Integer sort;
		System.out.println("Sélectionnez votre sort :");
		for(int i=0;i<listesort.length;i++)
			System.out.println("("+i+")"+"\t\t"+listesort[i]);
		do{
		sort =new Integer (Console.readLine());
		}while(sort.intValue()<0 && sort.intValue()>=listesort.length);
		listesort[sort.intValue()].cast(defender, attacker);
	}
	
	public static void MagieHeal(Pretre attacker){
		Spell[] listesort=attacker.getListeSort();
		Integer sort;
		System.out.println("Sélectionnez votre sort :");
		for(int i=0;i<listesort.length;i++)
			System.out.println("("+i+")"+"\t\t"+listesort[i]);
		do{
		sort =new Integer (Console.readLine());
		}while(sort.intValue()<0 && sort.intValue()>=listesort.length);
		listesort[sort.intValue()].cast(attacker, attacker);
	}
}

package adventure.personnage;

import adventure.combat.Attacks;
import library.Console;

public class Team {
	
	private Hero[] team;
	
	public Team()
	{
		int nombreEquipier=Console.readInt("Nombre de Héros compris entre 1 et 4 : " );
		if(nombreEquipier>4)
			nombreEquipier=4;
		else if(nombreEquipier<=0)
			nombreEquipier=1;
		team= new Hero[nombreEquipier];
		for(int i=0;i<nombreEquipier;i++)
		{
			String tacos = Console.readLine("Sélectionnez votre classe :"  +
					"\n"
					+ "(0)             --- Rogue\n"
					+ "(1)             --- Warrior\n"
					+ "(2)             --- Mage\n"
					+ "(3)             --- Pretre\n");
			
			if (Integer.parseInt(tacos) == 0){
				team[i] = Factory.newRogue();
				}
			else if(Integer.parseInt(tacos) == 1){
				team[i] = Factory.newWarrior();
				}
			else if(Integer.parseInt(tacos) == 3){
				team[i] = Factory.newPretre();
					}
			else{
				team[i] = Factory.newMage();			}
			team[i].setName(Console.readLine(" Veuillez choisir son nom. Celui-ci le suivra durant toute la partie. \n "));

		}

	}
	
	public Hero[] getTeam()
	{
		return team;
	}
	
	public void teamAdd(Hero hero) 
	{
		if(team.length<4)
		{
			Hero[] result=new Hero[team.length+1];
			for(int i=0;i<team.length;i++)
			{
				result[i]=team[i];
			}
			result[team.length]=hero;
			team=result;
		}
	}
	
	public void teamSub (int i)
	{
		if(team.length>1 && i>1 && i<team.length)
		{
			Hero[] result=new Hero[team.length-1];
			boolean k=false;
			for(int j=0;j<team.length;j++)
			{
				if(i==j && !k)
					k=true;
				else if(!k)
					result[j]=team[j];
				else
					result[j-1]=team[j];
			
				
			}
		}
	}
	
	public void attack(Hero hero)
	{
		for(int i=0;i<team.length;i++)
			Attacks.menu(team[i], hero);
	}
	
	
}

package adventure.personnage;

import java.util.Random;

import library.Console;



public abstract class Hero {

	
	protected String name;
	protected String posture;
	protected int strength;
	protected int intelligence;
	protected int health;
	protected int mana;
	protected int or;
	protected Random rnd;
	
	
	public abstract void attacks(Hero hero2);
	public double armor(){
		return 1;
	}
	
	public void changeposture(String newposture)
	{
		posture=newposture;
	}
	
	public Hero cible(Hero[] cibles)
	{
		for(int i=0;i<cibles.length;i++)
			System.out.println("("+i+")          "+cibles[i]);
		int choix;
		choix=Console.readInt("choisissez le numéro de la cible");
		return cibles[choix];
	}
	
	public Hero(String name, int strength, int intelligence) {
		//super();
		this.name = name;
		this.strength = strength;
		this.intelligence = intelligence;
		this.health = 5 * strength;
		this.mana = intelligence * 5;
		this.or = 0;
		rnd=new Random();
	}
	
	public String toString(){
		return this.name+" dont la posture est "+this.posture+"("+this.health+")";
	}
	public int getStrength(){
		return this.strength;
	}
	public int getIntelligence(){
		return this.intelligence;
	}
	public int getHealth(){
		return this.health;
	}
	public int getMana(){
		return this.mana;
	}
	
	public int getOr(){
		return this.or;
	}
	
	public String getPosture()
	{
		return posture;
	}
	
	public void setOr(int or)
	{
		this.or=or;
	}
	
	public void setMana(int mana)
	{
		this.mana=mana;
	}
	
	public void setHealth(int health)
	{
		this.health=health;
	}
	
	public void setName(String name)
	{
		this.name=name;
	}
	
	public  int getDmgLow()
	{
		return strength;
	}
	public int getDmgHigh()
	{
		return (int)(strength*1.5);
	}
	
	
	public boolean isDead(){
		return health<=0;
	}
	
	
	public void receive(int dmg){
		if (posture.equals("defense"))
		{
			health-=(dmg/2);
			System.out.println("vous perdez "+dmg/2+"PV");
		}
		else
		{
			health -= dmg;
			System.out.println("vous perdez "+dmg+"PV");
		}
	}
	
	public int inflict(){
		return rnd.nextInt(getDmgHigh()-getDmgLow())+getDmgLow();
	}
	
	public void IA(Hero ennemi)
	{
		int dmg=inflict();
		System.out.println("dommage reçu "+dmg);
		if(posture.equals("defense"))
		{
			dmg/=2;
			System.out.println("en fait il y en a "+dmg);
		}
		
		ennemi.receive(dmg);
	}
	}


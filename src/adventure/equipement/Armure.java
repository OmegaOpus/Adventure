package adventure.equipement;

public class Armure {
	
	protected String name;
	protected int armure;
	
	public Armure(String name,int armure)
	{
		this.name=name;
		this.armure=armure;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getArmure() {
		return armure;
	}
	public void setArmure(int armure) {
		this.armure = armure;
	}
	

}

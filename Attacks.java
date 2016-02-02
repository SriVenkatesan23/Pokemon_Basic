import java.util.*;

public class Attacks {

	private String type;
	private double regD;
	private String name;
	

	public Attacks(String nName, String newType, double newRegD){
		name=nName;
		type=newType;
		regD = newRegD;
		
	}
	
	public String getType(){
		return type;
		
	}	
	
	public double getDamage(){
		
		return regD;	
		
	}
	
	
	public String getName(){
		return name;
		
	}
	public int hit(){
		int check=new Random().nextInt(99);
		if(check<5){
			return 0;
		}
		else{
			return 1;
		}
	}
	public boolean Critical(){
		int check=new Random().nextInt(99);
		if(check==3){
			return true;
		}
		else{
			return false;
		}
	}
	
	
	
}

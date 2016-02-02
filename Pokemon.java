
public class Pokemon {

	
		
private String type;
private String name;
private Attacks a1;
private Attacks a2;
private double hp;
		
public Pokemon(String newName, String newType,  Attacks n1, Attacks n2, double HP) //basic pokemon constructor
		{
			
			name=newName;
			type=newType;
			a1=n1;
			a2=n2;
			hp=HP;

		}

public String getType(){
	return type;
}
public String getName(){
	return name;
}
public double getHP(){
	return hp;
}
public Attacks getA1(){
	return a1;
}
public Attacks getA2(){
	return a2;
}
public void printOut(){
	System.out.println("YOU: ");
	System.out.println(getName());
	System.out.println(getHP() +"HP");
	System.out.println(getA1().getName());
	System.out.println(getA2().getName());
	System.out.println(" ");
}
public void ePrintOut(){
	System.out.println("ENEMY: ");
	System.out.println(getName());
	System.out.println(getHP() +"HP");
	System.out.println(" ");
}
public void hurt(double d){
	hp-=d;
}
public void heal(double d){
	if(d<(100-getHP())){
	hp+=d;}
	else if(d>(100-getHP())){
		hp+=(100-getHP());
	}
	
}

}



	
		
		
		
		
		
		
		
		
		
		
		
		
		
	

import java.util.*;
public class PokeBattle {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);


		Attacks tackle=new Attacks("Tackle","Normal", 20);
		Attacks ember = new Attacks("Ember", "Fire", 16);
		Attacks bubble = new Attacks("Bubble","Water", 16);
		Attacks vinewhip = new Attacks("Vine Whip" ,"Grass", 16);
		Attacks spark = new Attacks("Spark", "Electric" , 16);
		Attacks mudslap = new Attacks("Mud Slap", "Rock/Ground", 16);
		Attacks shadball = new Attacks("Shadow Ball", "Ghost", 16);
		Attacks lick = new Attacks ("Lick", "Ghost", 10);
		Attacks scratch = new Attacks ("Scratch", "Normal", 16);
		Attacks psybeam = new Attacks ("Psybeam", "Psychic", 12);
		
		
		
		
		

		Pokemon charm = new Pokemon("Charmander", "Fire", tackle, ember, 100.0);
		Pokemon squirt = new Pokemon("Squirtle", "Water", tackle, bubble, 100.0);
		Pokemon bulby = new Pokemon("Bulbasaur", "Grass", tackle, vinewhip, 100.0);
		Pokemon pika = new Pokemon("Pikachu", "Electric", tackle, spark, 100.0);
		Pokemon onix = new Pokemon("Onix", "Rock/Ground", tackle, mudslap, 100.0);
		Pokemon gastly = new Pokemon("Gastly", "Ghost", lick, shadball, 100.0);
		Pokemon kadabra = new Pokemon("Kadabra", "Psychic", scratch, psybeam, 100.0);
		
		
		


		ArrayList<Pokemon> poke=new ArrayList<Pokemon>();//adding pokemon to list so I can randomly choose one for the enemy
		poke.add(charm);
		poke.add(squirt);
		poke.add(bulby);
		poke.add(pika);
		poke.add(onix);
		poke.add(gastly);
		poke.add(kadabra);
		



		Pokemon user;
		Pokemon enemy;

		System.out.println("Which Pokemon will you choose?" );
		System.out.println("1) Charmander" );
		System.out.println("2) Squirtle" );
		System.out.println("3) Bulbasaur" );
		System.out.println("4) Pikachu" );
		System.out.println("5) Onix" );
		System.out.println("6) Gastly" );
		System.out.println("7) Kadabra" );

		int choice=sc.nextInt();

		if(choice==1){

			user=new Pokemon("Charmander", "Fire", tackle, ember, 100.0);
			int rand = new Random().nextInt(poke.size());
			int pCount=1;
			int epCount=1;
			int attack;
			boolean boost=false;
			boolean eboost=false;
			boolean dboost=false;
			boolean edboost=false;
			
			enemy=poke.get(rand);
			ArrayList<Attacks> eAttacks = new ArrayList<Attacks>(); 
			eAttacks.add(enemy.getA1());
			eAttacks.add(enemy.getA2());




			while(user.getHP()>0 && enemy.getHP()>0){ //while you are both still alive
				
				do{ 
					user.printOut();
					enemy.ePrintOut();


					//user attack------------------------------------------------------------------------------------------------------------------------
					try {
						Thread.sleep(1000);                 //1000 milliseconds is one second.
					} catch(InterruptedException ex) {
						Thread.currentThread().interrupt();
					}

					System.out.println("Which attack will you use? Enter number: ");
					System.out.println("1) " + user.getA1().getName() );
					System.out.println("2) " + user.getA2().getName() );
					System.out.println("3) Use Potion (" +pCount + " left)" );  
					System.out.println("4) Use Attack Boost Item "); 
					System.out.println("5) Use Defense Boost Item ");
					
					
					attack = sc.nextInt();




					if(attack==1){
						System.out.println(" ");
						System.out.println("Your " + user.getName() + " used " + user.getA1().getName()+"!");
						System.out.println(" ");
						if(user.getA1().hit()==1){
							double damage=getInf(user.getA1(),enemy, user);
							if(boost==true){
							damage*=1.25;
						}
							if(edboost==true){
								damage*=.80;
							}
							if(user.getA1().Critical()){
								System.out.println("Critical Hit!");
								damage*=2;
							}
							enemy.hurt(damage);
							if(enemy.getHP()<=0){
								System.out.println("Enemy " + enemy.getName() + " fainted!");
							}
						}
						else{
							System.out.println("Your attack missed!");
							System.out.println(" ");
						}
					}


					if(attack==2){
						System.out.println(" ");
						System.out.println("Your " + user.getName() + " used " + user.getA2().getName());
						System.out.println(" ");
						if(user.getA2().hit()==1){
							double damage=getInf(user.getA2(),enemy, user);
							if(boost==true){
								damage*=1.25;
							}
							if(edboost==true){
								damage*=.80;
							}
							if(user.getA1().Critical()){
								System.out.println("Critical Hit!");
								damage*=2;
								
							}
							enemy.hurt(damage);
							if(enemy.getHP()<=0){
								System.out.println("Enemy " + enemy.getName() + " fainted!");
							}
						}
						else{
							System.out.println("Your attack missed!");
						}
					}
					
					if(attack==3){
						
						if(pCount<=0){
							System.out.println("You have no potions left. ");
							pCount--;
						}
						if(pCount>0){
							System.out.println("");
							if(user.getHP()>50){
							System.out.println("You used a potion! Your " + user.getName() + "'s HP increased by " + (100-user.getHP()) + "!"  );
							}
							if(user.getHP()<=50){
								System.out.println("You used a potion! Your " + user.getName() + "'s HP increased by 50!");
							}
							System.out.println("");
							user.heal(50.0);
							pCount--;
						}
					}
					
					if(attack==4){
					System.out.println("You used an Attack Boost!"  );
					if(boost==true){
						System.out.println("But your " + user.getName() + "'s Attack has already been boosted!");
					}
					boost=true;	
				}
					if(attack==5){
						System.out.println("You used a Defense Boost!"  );
						if(boost==true){
							System.out.println("But your " + user.getName() + "'s Defense has already been boosted!");
						}
						dboost=true;
					}
					
					

				}while(pCount<0 && attack==3);
				//enemy attack-------------------------------------------------------------------------------------------------------------------------				
				try {
					Thread.sleep(1000);                 //1000 milliseconds is one second.
				} catch(InterruptedException ex) {
					Thread.currentThread().interrupt();
				}


				if(enemy.getHP()>0){
					System.out.println(" ");
					user.printOut();
					enemy.ePrintOut();
					int etack=new Random().nextInt(eAttacks.size()+2);
					
					

					try {
						Thread.sleep(1000);                 //1000 milliseconds is one second.
					} catch(InterruptedException ex) {
						Thread.currentThread().interrupt();
					}

					if(enemy.getHP()>20 || epCount<=0){
						if(etack==0){
							System.out.println(" ");
							System.out.println("Enemy " + enemy.getName() + " used " + enemy.getA1().getName()+"!");
							System.out.println(" ");
							if(enemy.getA1().hit()==1){
								double damage=getInf(enemy.getA1(),user, enemy);
								
								if(eboost==true){
									damage*=1.25;
								}
								if(dboost==true){
									damage*=.80;
								}
								if(user.getA1().Critical()){
									System.out.println("Critical Hit!");
									damage*=2;
									
								}
								
								user.hurt(damage);
								if(user.getHP()<=0){
									System.out.println("Your " + user.getName() + " fainted!");
								}
							}
							else{
								System.out.println("Enemy attack missed!");
								System.out.println(" ");
							}

						}
						if(etack==1){
							System.out.println(" ");
							System.out.println("Enemy " + enemy.getName() + " used " + enemy.getA2().getName());
							System.out.println(" ");
							if(enemy.getA2().hit()==1){
								double damage=getInf(enemy.getA2(),user, enemy);
								
								
								if(eboost==true){
									damage*=1.25;
								}
								if(dboost==true){
									damage*=.80;
								}
								if(user.getA1().Critical()){
									System.out.println("Critical Hit!");
									damage*=2;
									
								}
								
								user.hurt(damage);
								if(user.getHP()<=0){
									System.out.println("Your " + user.getName() + " fainted!");
								}
							}
							else{
								System.out.println("Enemy attack missed!");
							}
						}
						if(etack==2){
							System.out.println("Enemy " + enemy.getName() + " used an Attack Boost!");
							if(eboost){
								System.out.println("But enemy " + enemy.getName() + "'s Attack has already been boosted!");
							}
							eboost=true;
							
						}
						if(etack==3){
							System.out.println("Enemy " + enemy.getName() + " used a Defense Boost!");
							if(edboost){
								System.out.println("But enemy " + enemy.getName() + "'s Defense has already been boosted!");
							}
							edboost=true;
							
						}
					}

					if(enemy.getHP()<20 && epCount>0){
						System.out.println("");
						
						System.out.println("Enemy " + enemy.getName() + " used a potion! Its HP increased by 50!" );
						
						
						System.out.println("");
						enemy.heal(50.0);
						epCount--;
					}
					

				}
				try {
					Thread.sleep(1000);                 //1000 milliseconds is one second.
				} catch(InterruptedException ex) {
					Thread.currentThread().interrupt();
				}
				//--------------------------------------------------------------------------------------------------------------------------------------				


			}







		}
//------------------------------------------------------------------------------------------------------------------------------------------------
		
		if(choice==2){

			user=new Pokemon("Squirtle", "Water", tackle, bubble, 100.0);
			int rand = new Random().nextInt(poke.size());
			int pCount=1;
			int epCount=1;
			int attack;
			boolean boost=false;
			boolean eboost=false;
			boolean dboost=false;
			boolean edboost=false;
			
			enemy=poke.get(rand);
			ArrayList<Attacks> eAttacks = new ArrayList<Attacks>(); 
			eAttacks.add(enemy.getA1());
			eAttacks.add(enemy.getA2());




			while(user.getHP()>0 && enemy.getHP()>0){ //while you are both still alive
				
				do{ 
					user.printOut();
					enemy.ePrintOut();


					//user attack------------------------------------------------------------------------------------------------------------------------
					try {
						Thread.sleep(1000);                 //1000 milliseconds is one second.
					} catch(InterruptedException ex) {
						Thread.currentThread().interrupt();
					}

					System.out.println("Which attack will you use? Enter number: ");
					System.out.println("1) " + user.getA1().getName() );
					System.out.println("2) " + user.getA2().getName() );
					System.out.println("3) Use Potion (" +pCount + " left)" );  
					System.out.println("4) Use Attack Boost Item "); 
					System.out.println("5) Use Defense Boost Item ");
					
					
					attack = sc.nextInt();




					if(attack==1){
						System.out.println(" ");
						System.out.println("Your " + user.getName() + " used " + user.getA1().getName()+"!");
						System.out.println(" ");
						if(user.getA1().hit()==1){
							double damage=getInf(user.getA1(),enemy, user);
							if(boost==true){
							damage*=1.25;
						}
							if(edboost==true){
								damage*=.80;
							}
							if(user.getA1().Critical()){
								System.out.println("Critical Hit!");
								damage*=2;
							}
							enemy.hurt(damage);
							if(enemy.getHP()<=0){
								System.out.println("Enemy " + enemy.getName() + " fainted!");
							}
						}
						else{
							System.out.println("Your attack missed!");
							System.out.println(" ");
						}
					}


					if(attack==2){
						System.out.println(" ");
						System.out.println("Your " + user.getName() + " used " + user.getA2().getName());
						System.out.println(" ");
						if(user.getA2().hit()==1){
							double damage=getInf(user.getA2(),enemy, user);
							if(boost==true){
								damage*=1.25;
							}
							if(edboost==true){
								damage*=.80;
							}
							if(user.getA1().Critical()){
								System.out.println("Critical Hit!");
								damage*=2;
								
							}
							enemy.hurt(damage);
							if(enemy.getHP()<=0){
								System.out.println("Enemy " + enemy.getName() + " fainted!");
							}
						}
						else{
							System.out.println("Your attack missed!");
						}
					}
					
					if(attack==3){
						
						if(pCount<=0){
							System.out.println("You have no potions left. ");
							pCount--;
						}
						if(pCount>0){
							System.out.println("");
							if(user.getHP()>50){
							System.out.println("You used a potion! Your " + user.getName() + "'s HP increased by " + (100-user.getHP()) + "!"  );
							}
							if(user.getHP()<=50){
								System.out.println("You used a potion! Your " + user.getName() + "'s HP increased by 50!");
							}
							System.out.println("");
							user.heal(50.0);
							pCount--;
						}
					}
					
					if(attack==4){
					System.out.println("You used an Attack Boost!"  );
					if(boost==true){
						System.out.println("But your " + user.getName() + "'s Attack has already been boosted!");
					}
					boost=true;	
				}
					if(attack==5){
						System.out.println("You used a Defense Boost!"  );
						if(boost==true){
							System.out.println("But your " + user.getName() + "'s Defense has already been boosted!");
						}
						dboost=true;
					}
					
					

				}while(pCount<0 && attack==3);
				//enemy attack-------------------------------------------------------------------------------------------------------------------------				
				try {
					Thread.sleep(1000);                 //1000 milliseconds is one second.
				} catch(InterruptedException ex) {
					Thread.currentThread().interrupt();
				}


				if(enemy.getHP()>0){
					System.out.println(" ");
					user.printOut();
					enemy.ePrintOut();
					int etack=new Random().nextInt(eAttacks.size()+2);
					
					

					try {
						Thread.sleep(1000);                 //1000 milliseconds is one second.
					} catch(InterruptedException ex) {
						Thread.currentThread().interrupt();
					}

					if(enemy.getHP()>20 || epCount<=0){
						if(etack==0){
							System.out.println(" ");
							System.out.println("Enemy " + enemy.getName() + " used " + enemy.getA1().getName()+"!");
							System.out.println(" ");
							if(enemy.getA1().hit()==1){
								double damage=getInf(enemy.getA1(),user, enemy);
								if(eboost==true){
									damage*=1.25;
								}
								if(dboost==true){
									damage*=.80;
								}
								if(user.getA1().Critical()){
									System.out.println("Critical Hit!");
									damage*=2;
									
								}
								
								user.hurt(damage);
								if(user.getHP()<=0){
									System.out.println("Your " + user.getName() + " fainted!");
								}
							}
							else{
								System.out.println("Enemy attack missed!");
								System.out.println(" ");
							}

						}
						if(etack==1){
							System.out.println(" ");
							System.out.println("Enemy " + enemy.getName() + " used " + enemy.getA2().getName());
							System.out.println(" ");
							if(enemy.getA2().hit()==1){
								double damage=getInf(enemy.getA2(),user, enemy);
								
								
								if(eboost==true){
									damage*=1.25;
								}
								if(dboost==true){
									damage*=.80;
								}
								if(user.getA1().Critical()){
									System.out.println("Critical Hit!");
									damage*=2;
									
								}
								
								user.hurt(damage);
								if(user.getHP()<=0){
									System.out.println("Your " + user.getName() + " fainted!");
								}
							}
							else{
								System.out.println("Enemy attack missed!");
							}
						}
						if(etack==2){
							System.out.println("Enemy " + enemy.getName() + " used an Attack Boost!");
							if(eboost){
								System.out.println("But enemy " + enemy.getName() + "'s Attack has already been boosted!");
							}
							eboost=true;
							
						}
						if(etack==3){
							System.out.println("Enemy " + enemy.getName() + " used a Defense Boost!");
							if(edboost){
								System.out.println("But enemy " + enemy.getName() + "'s Defense has already been boosted!");
							}
							edboost=true;
							
						}
					}

					if(enemy.getHP()<20 && epCount>0){
						System.out.println("");
						
						System.out.println("Enemy " + enemy.getName() + " used a potion! Its HP increased by 50!" );
						
						
						System.out.println("");
						enemy.heal(50.0);
						epCount--;
					}
					

				}
				try {
					Thread.sleep(1000);                 //1000 milliseconds is one second.
				} catch(InterruptedException ex) {
					Thread.currentThread().interrupt();
				}
				//--------------------------------------------------------------------------------------------------------------------------------------				


			}







		}
//------------------------------------------------------------------------------------------------------------------------------------------------------
		if(choice==3){

			user=new Pokemon("Bulbasaur", "Grass", tackle, vinewhip, 100.0);
			int rand = new Random().nextInt(poke.size());
			int pCount=1;
			int epCount=1;
			int attack;
			boolean boost=false;
			boolean eboost=false;
			boolean dboost=false;
			boolean edboost=false;
		
			enemy=poke.get(rand);
			ArrayList<Attacks> eAttacks = new ArrayList<Attacks>(); 
			eAttacks.add(enemy.getA1());
			eAttacks.add(enemy.getA2());




			while(user.getHP()>0 && enemy.getHP()>0){ //while you are both still alive
				
				do{ 
					user.printOut();
					enemy.ePrintOut();


					//user attack------------------------------------------------------------------------------------------------------------------------
					try {
						Thread.sleep(1000);                 //1000 milliseconds is one second.
					} catch(InterruptedException ex) {
						Thread.currentThread().interrupt();
					}

					System.out.println("Which attack will you use? Enter number: ");
					System.out.println("1) " + user.getA1().getName() );
					System.out.println("2) " + user.getA2().getName() );
					System.out.println("3) Use Potion (" +pCount + " left)" );  
					System.out.println("4) Use Attack Boost Item "); 
					System.out.println("5) Use Defense Boost Item ");
					
					
					attack = sc.nextInt();




					if(attack==1){
						System.out.println(" ");
						System.out.println("Your " + user.getName() + " used " + user.getA1().getName()+"!");
						System.out.println(" ");
						if(user.getA1().hit()==1){
							double damage=getInf(user.getA1(),enemy, user);
							if(boost==true){
							damage*=1.25;
						}
							if(edboost==true){
								damage*=.80;
							}
							if(user.getA1().Critical()){
								System.out.println("Critical Hit!");
								damage*=2;
							}
							enemy.hurt(damage);
							if(enemy.getHP()<=0){
								System.out.println("Enemy " + enemy.getName() + " fainted!");
							}
						}
						else{
							System.out.println("Your attack missed!");
							System.out.println(" ");
						}
					}


					if(attack==2){
						System.out.println(" ");
						System.out.println("Your " + user.getName() + " used " + user.getA2().getName());
						System.out.println(" ");
						if(user.getA2().hit()==1){
							double damage=getInf(user.getA2(),enemy, user);
							if(boost==true){
								damage*=1.25;
							}
							if(edboost==true){
								damage*=.80;
							}
							if(user.getA1().Critical()){
								System.out.println("Critical Hit!");
								damage*=2;
								
							}
							enemy.hurt(damage);
							if(enemy.getHP()<=0){
								System.out.println("Enemy " + enemy.getName() + " fainted!");
							}
						}
						else{
							System.out.println("Your attack missed!");
						}
					}
					
					if(attack==3){
						
						if(pCount<=0){
							System.out.println("You have no potions left. ");
							pCount--;
						}
						if(pCount>0){
							System.out.println("");
							if(user.getHP()>50){
							System.out.println("You used a potion! Your " + user.getName() + "'s HP increased by " + (100-user.getHP()) + "!"  );
							}
							if(user.getHP()<=50){
								System.out.println("You used a potion! Your " + user.getName() + "'s HP increased by 50!");
							}
							System.out.println("");
							user.heal(50.0);
							pCount--;
						}
					}
					
					if(attack==4){
					System.out.println("You used an Attack Boost!"  );
					if(boost==true){
						System.out.println("But your " + user.getName() + "'s Attack has already been boosted!");
					}
					boost=true;	
				}
					if(attack==5){
						System.out.println("You used a Defense Boost!"  );
						if(boost==true){
							System.out.println("But your " + user.getName() + "'s Defense has already been boosted!");
						}
						dboost=true;
					}
					
					

				}while(pCount<0 && attack==3);
				//enemy attack-------------------------------------------------------------------------------------------------------------------------				
				try {
					Thread.sleep(1000);                 //1000 milliseconds is one second.
				} catch(InterruptedException ex) {
					Thread.currentThread().interrupt();
				}


				if(enemy.getHP()>0){
					System.out.println(" ");
					user.printOut();
					enemy.ePrintOut();
					int etack=new Random().nextInt(eAttacks.size()+2);
					
					

					try {
						Thread.sleep(1000);                 //1000 milliseconds is one second.
					} catch(InterruptedException ex) {
						Thread.currentThread().interrupt();
					}

					if(enemy.getHP()>20 || epCount<=0){
						if(etack==0){
							System.out.println(" ");
							System.out.println("Enemy " + enemy.getName() + " used " + enemy.getA1().getName()+"!");
							System.out.println(" ");
							if(enemy.getA1().hit()==1){
								double damage=getInf(enemy.getA1(),user, enemy);
								if(eboost==true){
									damage*=1.25;
								}
								if(dboost==true){
									damage*=.80;
								}
								if(user.getA1().Critical()){
									System.out.println("Critical Hit!");
									damage*=2;
									
								}
								
								user.hurt(damage);
								if(user.getHP()<=0){
									System.out.println("Your " + user.getName() + " fainted!");
								}
							}
							else{
								System.out.println("Enemy attack missed!");
								System.out.println(" ");
							}

						}
						if(etack==1){
							System.out.println(" ");
							System.out.println("Enemy " + enemy.getName() + " used " + enemy.getA2().getName());
							System.out.println(" ");
							if(enemy.getA2().hit()==1){
								double damage=getInf(enemy.getA2(),user, enemy);
								
								
								if(eboost==true){
									damage*=1.25;
								}
								if(dboost==true){
									damage*=.80;
								}
								if(user.getA1().Critical()){
									System.out.println("Critical Hit!");
									damage*=2;
									
								}
								
								user.hurt(damage);
								if(user.getHP()<=0){
									System.out.println("Your " + user.getName() + " fainted!");
								}
							}
							else{
								System.out.println("Enemy attack missed!");
							}
						}
						if(etack==2){
							System.out.println("Enemy " + enemy.getName() + " used an Attack Boost!");
							if(eboost){
								System.out.println("But enemy " + enemy.getName() + "'s Attack has already been boosted!");
							}
							eboost=true;
							
						}
						if(etack==3){
							System.out.println("Enemy " + enemy.getName() + " used a Defense Boost!");
							if(edboost){
								System.out.println("But enemy " + enemy.getName() + "'s Defense has already been boosted!");
							}
							edboost=true;
							
						}
					}

					if(enemy.getHP()<20 && epCount>0){
						System.out.println("");
						
						System.out.println("Enemy " + enemy.getName() + " used a potion! Its HP increased by 50!" );
						
						
						System.out.println("");
						enemy.heal(50.0);
						epCount--;
					}
					

				}
				try {
					Thread.sleep(1000);                 //1000 milliseconds is one second.
				} catch(InterruptedException ex) {
					Thread.currentThread().interrupt();
				}
				//--------------------------------------------------------------------------------------------------------------------------------------				


			}







		}
//------------------------------------------------------------------------------------------------------------------------------------------------------
		
		if(choice==4){

			user=new Pokemon("Pikachu", "Electric", tackle, spark, 100.0);
			int rand = new Random().nextInt(poke.size());
			int pCount=1;
			int epCount=1;
			int attack;
			boolean boost=false;
			boolean eboost=false;
			boolean dboost=false;
			boolean edboost=false;
			
			enemy=poke.get(rand);
			ArrayList<Attacks> eAttacks = new ArrayList<Attacks>(); 
			eAttacks.add(enemy.getA1());
			eAttacks.add(enemy.getA2());




			while(user.getHP()>0 && enemy.getHP()>0){ //while you are both still alive
				
				do{ 
					user.printOut();
					enemy.ePrintOut();


					//user attack------------------------------------------------------------------------------------------------------------------------
					try {
						Thread.sleep(1000);                 //1000 milliseconds is one second.
					} catch(InterruptedException ex) {
						Thread.currentThread().interrupt();
					}

					System.out.println("Which attack will you use? Enter number: ");
					System.out.println("1) " + user.getA1().getName() );
					System.out.println("2) " + user.getA2().getName() );
					System.out.println("3) Use Potion (" +pCount + " left)" );  
					System.out.println("4) Use Attack Boost Item "); 
					System.out.println("5) Use Defense Boost Item ");
					
					
					attack = sc.nextInt();




					if(attack==1){
						System.out.println(" ");
						System.out.println("Your " + user.getName() + " used " + user.getA1().getName()+"!");
						System.out.println(" ");
						if(user.getA1().hit()==1){
							double damage=getInf(user.getA1(),enemy, user);
							if(boost==true){
							damage*=1.25;
						}
							if(edboost==true){
								damage*=.80;
							}
							if(user.getA1().Critical()){
								System.out.println("Critical Hit!");
								damage*=2;
							}
							enemy.hurt(damage);
							if(enemy.getHP()<=0){
								System.out.println("Enemy " + enemy.getName() + " fainted!");
							}
						}
						else{
							System.out.println("Your attack missed!");
							System.out.println(" ");
						}
					}


					if(attack==2){
						System.out.println(" ");
						System.out.println("Your " + user.getName() + " used " + user.getA2().getName());
						System.out.println(" ");
						if(user.getA2().hit()==1){
							double damage=getInf(user.getA2(),enemy, user);
							if(boost==true){
								damage*=1.25;
							}
							if(edboost==true){
								damage*=.80;
							}
							if(user.getA1().Critical()){
								System.out.println("Critical Hit!");
								damage*=2;
								
							}
							enemy.hurt(damage);
							if(enemy.getHP()<=0){
								System.out.println("Enemy " + enemy.getName() + " fainted!");
							}
						}
						else{
							System.out.println("Your attack missed!");
						}
					}
					
					if(attack==3){
						
						if(pCount<=0){
							System.out.println("You have no potions left. ");
							pCount--;
						}
						if(pCount>0){
							System.out.println("");
							if(user.getHP()>50){
							System.out.println("You used a potion! Your " + user.getName() + "'s HP increased by " + (100-user.getHP()) + "!"  );
							}
							if(user.getHP()<=50){
								System.out.println("You used a potion! Your " + user.getName() + "'s HP increased by 50!");
							}
							System.out.println("");
							user.heal(50.0);
							pCount--;
						}
					}
					
					if(attack==4){
					System.out.println("You used an Attack Boost!"  );
					if(boost==true){
						System.out.println("But your " + user.getName() + "'s Attack has already been boosted!");
					}
					boost=true;	
				}
					if(attack==5){
						System.out.println("You used a Defense Boost!"  );
						if(boost==true){
							System.out.println("But your " + user.getName() + "'s Defense has already been boosted!");
						}
						dboost=true;
					}
					
					

				}while(pCount<0 && attack==3);
				//enemy attack-------------------------------------------------------------------------------------------------------------------------				
				try {
					Thread.sleep(1000);                 //1000 milliseconds is one second.
				} catch(InterruptedException ex) {
					Thread.currentThread().interrupt();
				}


				if(enemy.getHP()>0){
					System.out.println(" ");
					user.printOut();
					enemy.ePrintOut();
					int etack=new Random().nextInt(eAttacks.size()+2);
					
					

					try {
						Thread.sleep(1000);                 //1000 milliseconds is one second.
					} catch(InterruptedException ex) {
						Thread.currentThread().interrupt();
					}

					if(enemy.getHP()>20 || epCount<=0){
						if(etack==0){
							System.out.println(" ");
							System.out.println("Enemy " + enemy.getName() + " used " + enemy.getA1().getName()+"!");
							System.out.println(" ");
							if(enemy.getA1().hit()==1){
								double damage=getInf(enemy.getA1(),user, enemy);
								if(eboost==true){
									damage*=1.25;
								}
								if(dboost==true){
									damage*=.80;
								}
								if(user.getA1().Critical()){
									System.out.println("Critical Hit!");
									damage*=2;
									
								}
								
								user.hurt(damage);
								if(user.getHP()<=0){
									System.out.println("Your " + user.getName() + " fainted!");
								}
							}
							else{
								System.out.println("Enemy attack missed!");
								System.out.println(" ");
							}

						}
						if(etack==1){
							System.out.println(" ");
							System.out.println("Enemy " + enemy.getName() + " used " + enemy.getA2().getName());
							System.out.println(" ");
							if(enemy.getA2().hit()==1){
								double damage=getInf(enemy.getA2(),user, enemy);
								
								
								if(eboost==true){
									damage*=1.25;
								}
								if(dboost==true){
									damage*=.80;
								}
								if(user.getA1().Critical()){
									System.out.println("Critical Hit!");
									damage*=2;
									
								}
								
								user.hurt(damage);
								if(user.getHP()<=0){
									System.out.println("Your " + user.getName() + " fainted!");
								}
							}
							else{
								System.out.println("Enemy attack missed!");
							}
						}
						if(etack==2){
							System.out.println("Enemy " + enemy.getName() + " used an Attack Boost!");
							if(eboost){
								System.out.println("But enemy " + enemy.getName() + "'s Attack has already been boosted!");
							}
							eboost=true;
							
						}
						if(etack==3){
							System.out.println("Enemy " + enemy.getName() + " used a Defense Boost!");
							if(edboost){
								System.out.println("But enemy " + enemy.getName() + "'s Defense has already been boosted!");
							}
							edboost=true;
							
						}
					}

					if(enemy.getHP()<20 && epCount>0){
						System.out.println("");
						
						System.out.println("Enemy " + enemy.getName() + " used a potion! Its HP increased by 50!" );
						
						
						System.out.println("");
						enemy.heal(50.0);
						epCount--;
					}
					

				}
				try {
					Thread.sleep(1000);                 //1000 milliseconds is one second.
				} catch(InterruptedException ex) {
					Thread.currentThread().interrupt();
				}
				//--------------------------------------------------------------------------------------------------------------------------------------				


			}







		}
//-------------------------------------------------------------------------------------------------------------------------------------------------
		if(choice==5){

			user=new Pokemon("Onix", "Rock/Ground", tackle, mudslap, 100.0);
			int rand = new Random().nextInt(poke.size());
			int pCount=1;
			int epCount=1;
			int attack;
			boolean boost=false;
			boolean eboost=false;
			boolean dboost=false;
			boolean edboost=false;
			
			enemy=poke.get(rand);
			ArrayList<Attacks> eAttacks = new ArrayList<Attacks>(); 
			eAttacks.add(enemy.getA1());
			eAttacks.add(enemy.getA2());




			while(user.getHP()>0 && enemy.getHP()>0){ //while you are both still alive
				
				do{ 
					user.printOut();
					enemy.ePrintOut();


					//user attack------------------------------------------------------------------------------------------------------------------------
					try {
						Thread.sleep(1000);                 //1000 milliseconds is one second.
					} catch(InterruptedException ex) {
						Thread.currentThread().interrupt();
					}

					System.out.println("Which attack will you use? Enter number: ");
					System.out.println("1) " + user.getA1().getName() );
					System.out.println("2) " + user.getA2().getName() );
					System.out.println("3) Use Potion (" +pCount + " left)" );  
					System.out.println("4) Use Attack Boost Item "); 
					System.out.println("5) Use Defense Boost Item ");
					
					
					attack = sc.nextInt();




					if(attack==1){
						System.out.println(" ");
						System.out.println("Your " + user.getName() + " used " + user.getA1().getName()+"!");
						System.out.println(" ");
						if(user.getA1().hit()==1){
							double damage=getInf(user.getA1(),enemy, user);
							if(boost==true){
							damage*=1.25;
						}
							if(edboost==true){
								damage*=.80;
							}
							if(user.getA1().Critical()){
								System.out.println("Critical Hit!");
								damage*=2;
							}
							enemy.hurt(damage);
							if(enemy.getHP()<=0){
								System.out.println("Enemy " + enemy.getName() + " fainted!");
							}
						}
						else{
							System.out.println("Your attack missed!");
							System.out.println(" ");
						}
					}


					if(attack==2){
						System.out.println(" ");
						System.out.println("Your " + user.getName() + " used " + user.getA2().getName());
						System.out.println(" ");
						if(user.getA2().hit()==1){
							double damage=getInf(user.getA2(),enemy, user);
							if(boost==true){
								damage*=1.25;
							}
							if(edboost==true){
								damage*=.80;
							}
							if(user.getA1().Critical()){
								System.out.println("Critical Hit!");
								damage*=2;
								
							}
							enemy.hurt(damage);
							if(enemy.getHP()<=0){
								System.out.println("Enemy " + enemy.getName() + " fainted!");
							}
						}
						else{
							System.out.println("Your attack missed!");
						}
					}
					
					if(attack==3){
						
						if(pCount<=0){
							System.out.println("You have no potions left. ");
							pCount--;
						}
						if(pCount>0){
							System.out.println("");
							if(user.getHP()>50){
							System.out.println("You used a potion! Your " + user.getName() + "'s HP increased by " + (100-user.getHP()) + "!"  );
							}
							if(user.getHP()<=50){
								System.out.println("You used a potion! Your " + user.getName() + "'s HP increased by 50!");
							}
							System.out.println("");
							user.heal(50.0);
							pCount--;
						}
					}
					
					if(attack==4){
					System.out.println("You used an Attack Boost!"  );
					if(boost==true){
						System.out.println("But your " + user.getName() + "'s Attack has already been boosted!");
					}
					boost=true;	
				}
					if(attack==5){
						System.out.println("You used a Defense Boost!"  );
						if(boost==true){
							System.out.println("But your " + user.getName() + "'s Defense has already been boosted!");
						}
						dboost=true;
					}
					
					

				}while(pCount<0 && attack==3);
				//enemy attack-------------------------------------------------------------------------------------------------------------------------				
				try {
					Thread.sleep(1000);                 //1000 milliseconds is one second.
				} catch(InterruptedException ex) {
					Thread.currentThread().interrupt();
				}


				if(enemy.getHP()>0){
					System.out.println(" ");
					user.printOut();
					enemy.ePrintOut();
					int etack=new Random().nextInt(eAttacks.size()+2);
					
					

					try {
						Thread.sleep(1000);                 //1000 milliseconds is one second.
					} catch(InterruptedException ex) {
						Thread.currentThread().interrupt();
					}

					if(enemy.getHP()>20 || epCount<=0){
						if(etack==0){
							System.out.println(" ");
							System.out.println("Enemy " + enemy.getName() + " used " + enemy.getA1().getName()+"!");
							System.out.println(" ");
							if(enemy.getA1().hit()==1){
								double damage=getInf(enemy.getA1(),user, enemy);
								if(eboost==true){
									damage*=1.25;
								}
								if(dboost==true){
									damage*=.80;
								}
								if(user.getA1().Critical()){
									System.out.println("Critical Hit!");
									damage*=2;
									
								}
								
								user.hurt(damage);
								if(user.getHP()<=0){
									System.out.println("Your " + user.getName() + " fainted!");
								}
							}
							else{
								System.out.println("Enemy attack missed!");
								System.out.println(" ");
							}

						}
						if(etack==1){
							System.out.println(" ");
							System.out.println("Enemy " + enemy.getName() + " used " + enemy.getA2().getName());
							System.out.println(" ");
							if(enemy.getA2().hit()==1){
								double damage=getInf(enemy.getA2(),user, enemy);
								
								
								if(eboost==true){
									damage*=1.25;
								}
								if(dboost==true){
									damage*=.80;
								}
								if(user.getA1().Critical()){
									System.out.println("Critical Hit!");
									damage*=2;
									
								}
								
								user.hurt(damage);
								if(user.getHP()<=0){
									System.out.println("Your " + user.getName() + " fainted!");
								}
							}
							else{
								System.out.println("Enemy attack missed!");
							}
						}
						if(etack==2){
							System.out.println("Enemy " + enemy.getName() + " used an Attack Boost!");
							if(eboost){
								System.out.println("But enemy " + enemy.getName() + "'s Attack has already been boosted!");
							}
							eboost=true;
							
						}
						if(etack==3){
							System.out.println("Enemy " + enemy.getName() + " used a Defense Boost!");
							if(edboost){
								System.out.println("But enemy " + enemy.getName() + "'s Defense has already been boosted!");
							}
							edboost=true;
							
						}
					}

					if(enemy.getHP()<20 && epCount>0){
						System.out.println("");
						
						System.out.println("Enemy " + enemy.getName() + " used a potion! Its HP increased by 50!" );
						
						
						System.out.println("");
						enemy.heal(50.0);
						epCount--;
					}
					

				}
				try {
					Thread.sleep(1000);                 //1000 milliseconds is one second.
				} catch(InterruptedException ex) {
					Thread.currentThread().interrupt();
				}
				//--------------------------------------------------------------------------------------------------------------------------------------				


			}







		}
//--------------------------------------------------------------------------------------------------------------------------------------------------		
		if(choice==6){

			user=new Pokemon("Gastly", "Ghost", lick, shadball, 100.0);
			int rand = new Random().nextInt(poke.size());
			int pCount=1;
			int epCount=1;
			int attack;
			boolean boost=false;
			boolean eboost=false;
			boolean dboost=false;
			boolean edboost=false;
			
			enemy=poke.get(rand);
			ArrayList<Attacks> eAttacks = new ArrayList<Attacks>(); 
			eAttacks.add(enemy.getA1());
			eAttacks.add(enemy.getA2());




			while(user.getHP()>0 && enemy.getHP()>0){ //while you are both still alive
				
				do{ 
					user.printOut();
					enemy.ePrintOut();


					//user attack------------------------------------------------------------------------------------------------------------------------
					try {
						Thread.sleep(1000);                 //1000 milliseconds is one second.
					} catch(InterruptedException ex) {
						Thread.currentThread().interrupt();
					}

					System.out.println("Which attack will you use? Enter number: ");
					System.out.println("1) " + user.getA1().getName() );
					System.out.println("2) " + user.getA2().getName() );
					System.out.println("3) Use Potion (" +pCount + " left)" );  
					System.out.println("4) Use Attack Boost Item "); 
					System.out.println("5) Use Defense Boost Item ");
					
					
					attack = sc.nextInt();




					if(attack==1){
						System.out.println(" ");
						System.out.println("Your " + user.getName() + " used " + user.getA1().getName()+"!");
						System.out.println(" ");
						if(user.getA1().hit()==1){
							double damage=getInf(user.getA1(),enemy, user);
							if(boost==true){
							damage*=1.25;
						}
							if(edboost==true){
								damage*=.80;
							}
							if(user.getA1().Critical()){
								System.out.println("Critical Hit!");
								damage*=2;
							}
							enemy.hurt(damage);
							if(enemy.getHP()<=0){
								System.out.println("Enemy " + enemy.getName() + " fainted!");
							}
						}
						else{
							System.out.println("Your attack missed!");
							System.out.println(" ");
						}
					}


					if(attack==2){
						System.out.println(" ");
						System.out.println("Your " + user.getName() + " used " + user.getA2().getName());
						System.out.println(" ");
						if(user.getA2().hit()==1){
							double damage=getInf(user.getA2(),enemy, user);
							if(boost==true){
								damage*=1.25;
							}
							if(edboost==true){
								damage*=.80;
							}
							if(user.getA1().Critical()){
								System.out.println("Critical Hit!");
								damage*=2;
								
							}
							enemy.hurt(damage);
							if(enemy.getHP()<=0){
								System.out.println("Enemy " + enemy.getName() + " fainted!");
							}
						}
						else{
							System.out.println("Your attack missed!");
						}
					}
					
					if(attack==3){
						
						if(pCount<=0){
							System.out.println("You have no potions left. ");
							pCount--;
						}
						if(pCount>0){
							System.out.println("");
							if(user.getHP()>50){
							System.out.println("You used a potion! Your " + user.getName() + "'s HP increased by " + (100-user.getHP()) + "!"  );
							}
							if(user.getHP()<=50){
								System.out.println("You used a potion! Your " + user.getName() + "'s HP increased by 50!");
							}
							System.out.println("");
							user.heal(50.0);
							pCount--;
						}
					}
					
					if(attack==4){
					System.out.println("You used an Attack Boost!"  );
					if(boost==true){
						System.out.println("But your " + user.getName() + "'s Attack has already been boosted!");
					}
					boost=true;	
				}
					if(attack==5){
						System.out.println("You used a Defense Boost!"  );
						if(boost==true){
							System.out.println("But your " + user.getName() + "'s Defense has already been boosted!");
						}
						dboost=true;
					}
					
					

				}while(pCount<0 && attack==3);
				//enemy attack-------------------------------------------------------------------------------------------------------------------------				
				try {
					Thread.sleep(1000);                 //1000 milliseconds is one second.
				} catch(InterruptedException ex) {
					Thread.currentThread().interrupt();
				}


				if(enemy.getHP()>0){
					System.out.println(" ");
					user.printOut();
					enemy.ePrintOut();
					int etack=new Random().nextInt(eAttacks.size()+2);
					
					

					try {
						Thread.sleep(1000);                 //1000 milliseconds is one second.
					} catch(InterruptedException ex) {
						Thread.currentThread().interrupt();
					}

					if(enemy.getHP()>20 || epCount<=0){
						if(etack==0){
							System.out.println(" ");
							System.out.println("Enemy " + enemy.getName() + " used " + enemy.getA1().getName()+"!");
							System.out.println(" ");
							if(enemy.getA1().hit()==1){
								double damage=getInf(enemy.getA1(),user, enemy);
								if(eboost==true){
									damage*=1.25;
								}
								if(dboost==true){
									damage*=.80;
								}
								if(user.getA1().Critical()){
									System.out.println("Critical Hit!");
									damage*=2;
									
								}
								
								user.hurt(damage);
								if(user.getHP()<=0){
									System.out.println("Your " + user.getName() + " fainted!");
								}
							}
							else{
								System.out.println("Enemy attack missed!");
								System.out.println(" ");
							}

						}
						if(etack==1){
							System.out.println(" ");
							System.out.println("Enemy " + enemy.getName() + " used " + enemy.getA2().getName());
							System.out.println(" ");
							if(enemy.getA2().hit()==1){
								double damage=getInf(enemy.getA2(),user, enemy);
								
								
								if(eboost==true){
									damage*=1.25;
								}
								if(dboost==true){
									damage*=.80;
								}
								if(user.getA1().Critical()){
									System.out.println("Critical Hit!");
									damage*=2;
									
								}
								
								user.hurt(damage);
								if(user.getHP()<=0){
									System.out.println("Your " + user.getName() + " fainted!");
								}
							}
							else{
								System.out.println("Enemy attack missed!");
							}
						}
						if(etack==2){
							System.out.println("Enemy " + enemy.getName() + " used an Attack Boost!");
							if(eboost){
								System.out.println("But enemy " + enemy.getName() + "'s Attack has already been boosted!");
							}
							eboost=true;
							
						}
						if(etack==3){
							System.out.println("Enemy " + enemy.getName() + " used a Defense Boost!");
							if(edboost){
								System.out.println("But enemy " + enemy.getName() + "'s Defense has already been boosted!");
							}
							edboost=true;
							
						}
					}

					if(enemy.getHP()<20 && epCount>0){
						System.out.println("");
						
						System.out.println("Enemy " + enemy.getName() + " used a potion! Its HP increased by 50!" );
						
						
						System.out.println("");
						enemy.heal(50.0);
						epCount--;
					}
					

				}
				try {
					Thread.sleep(1000);                 //1000 milliseconds is one second.
				} catch(InterruptedException ex) {
					Thread.currentThread().interrupt();
				}
				//--------------------------------------------------------------------------------------------------------------------------------------				


			}







		}
//------------------------------------------------------------------------------------------------------------------------------------------------------

		if(choice==7){

			user=new Pokemon("Kadabra", "Psychic",scratch, psybeam, 100.0);
			int rand = new Random().nextInt(poke.size());
			int pCount=1;
			int epCount=1;
			int attack;
			boolean boost=false;
			boolean eboost=false;
			boolean dboost=false;
			boolean edboost=false;
			
			enemy=poke.get(rand);
			ArrayList<Attacks> eAttacks = new ArrayList<Attacks>(); 
			eAttacks.add(enemy.getA1());
			eAttacks.add(enemy.getA2());




			while(user.getHP()>0 && enemy.getHP()>0){ //while you are both still alive
				
				do{ 
					user.printOut();
					enemy.ePrintOut();


					//user attack------------------------------------------------------------------------------------------------------------------------
					try {
						Thread.sleep(1000);                 //1000 milliseconds is one second.
					} catch(InterruptedException ex) {
						Thread.currentThread().interrupt();
					}

					System.out.println("Which attack will you use? Enter number: ");
					System.out.println("1) " + user.getA1().getName() );
					System.out.println("2) " + user.getA2().getName() );
					System.out.println("3) Use Potion (" +pCount + " left)" );  
					System.out.println("4) Use Attack Boost Item "); 
					System.out.println("5) Use Defense Boost Item ");
					
					
					attack = sc.nextInt();




					if(attack==1){
						System.out.println(" ");
						System.out.println("Your " + user.getName() + " used " + user.getA1().getName()+"!");
						System.out.println(" ");
						if(user.getA1().hit()==1){
							double damage=getInf(user.getA1(),enemy, user);
							if(boost==true){
							damage*=1.25;
						}
							if(edboost==true){
								damage*=.80;
							}
							if(user.getA1().Critical()){
								System.out.println("Critical Hit!");
								damage*=2;
							}
							enemy.hurt(damage);
							if(enemy.getHP()<=0){
								System.out.println("Enemy " + enemy.getName() + " fainted!");
							}
						}
						else{
							System.out.println("Your attack missed!");
							System.out.println(" ");
						}
					}


					if(attack==2){
						System.out.println(" ");
						System.out.println("Your " + user.getName() + " used " + user.getA2().getName());
						System.out.println(" ");
						if(user.getA2().hit()==1){
							double damage=getInf(user.getA2(),enemy, user);
							if(boost==true){
								damage*=1.25;
							}
							if(edboost==true){
								damage*=.80;
							}
							if(user.getA1().Critical()){
								System.out.println("Critical Hit!");
								damage*=2;
								
							}
							enemy.hurt(damage);
							if(enemy.getHP()<=0){
								System.out.println("Enemy " + enemy.getName() + " fainted!");
							}
						}
						else{
							System.out.println("Your attack missed!");
						}
					}
					
					if(attack==3){
						
						if(pCount<=0){
							System.out.println("You have no potions left. ");
							pCount--;
						}
						if(pCount>0){
							System.out.println("");
							if(user.getHP()>50){
							System.out.println("You used a potion! Your " + user.getName() + "'s HP increased by " + (100-user.getHP()) + "!"  );
							}
							if(user.getHP()<=50){
								System.out.println("You used a potion! Your " + user.getName() + "'s HP increased by 50!");
							}
							System.out.println("");
							user.heal(50.0);
							pCount--;
						}
					}
					
					if(attack==4){
					System.out.println("You used an Attack Boost!"  );
					if(boost==true){
						System.out.println("But your " + user.getName() + "'s Attack has already been boosted!");
					}
					boost=true;	
				}
					if(attack==5){
						System.out.println("You used a Defense Boost!"  );
						if(boost==true){
							System.out.println("But your " + user.getName() + "'s Defense has already been boosted!");
						}
						dboost=true;
					}
					
					

				}while(pCount<0 && attack==3);
				//enemy attack-------------------------------------------------------------------------------------------------------------------------				
				try {
					Thread.sleep(1000);                 //1000 milliseconds is one second.
				} catch(InterruptedException ex) {
					Thread.currentThread().interrupt();
				}


				if(enemy.getHP()>0){
					System.out.println(" ");
					user.printOut();
					enemy.ePrintOut();
					int etack=new Random().nextInt(eAttacks.size()+2);
					
					

					try {
						Thread.sleep(1000);                 //1000 milliseconds is one second.
					} catch(InterruptedException ex) {
						Thread.currentThread().interrupt();
					}

					if(enemy.getHP()>20 || epCount<=0){
						if(etack==0){
							System.out.println(" ");
							System.out.println("Enemy " + enemy.getName() + " used " + enemy.getA1().getName()+"!");
							System.out.println(" ");
							if(enemy.getA1().hit()==1){
								double damage=getInf(enemy.getA1(),user, enemy);
								if(eboost==true){
									damage*=1.25;
								}
								if(dboost==true){
									damage*=.80;
								}
								if(user.getA1().Critical()){
									System.out.println("Critical Hit!");
									damage*=2;
									
								}
								
								user.hurt(damage);
								if(user.getHP()<=0){
									System.out.println("Your " + user.getName() + " fainted!");
								}
							}
							else{
								System.out.println("Enemy attack missed!");
								System.out.println(" ");
							}

						}
						if(etack==1){
							System.out.println(" ");
							System.out.println("Enemy " + enemy.getName() + " used " + enemy.getA2().getName());
							System.out.println(" ");
							if(enemy.getA2().hit()==1){
								double damage=getInf(enemy.getA2(),user, enemy);
								
								
								if(eboost==true){
									damage*=1.25;
								}
								if(dboost==true){
									damage*=.80;
								}
								if(user.getA1().Critical()){
									System.out.println("Critical Hit!");
									damage*=2;
									
								}
								
								user.hurt(damage);
								if(user.getHP()<=0){
									System.out.println("Your " + user.getName() + " fainted!");
								}
							}
							else{
								System.out.println("Enemy attack missed!");
							}
						}
						if(etack==2){
							System.out.println("Enemy " + enemy.getName() + " used an Attack Boost!");
							if(eboost){
								System.out.println("But enemy " + enemy.getName() + "'s Attack has already been boosted!");
							}
							eboost=true;
							
						}
						if(etack==3){
							System.out.println("Enemy " + enemy.getName() + " used a Defense Boost!");
							if(edboost){
								System.out.println("But enemy " + enemy.getName() + "'s Defense has already been boosted!");
							}
							edboost=true;
							
						}
					}

					if(enemy.getHP()<20 && epCount>0){
						System.out.println("");
						
						System.out.println("Enemy " + enemy.getName() + " used a potion! Its HP increased by 50!" );
						
						
						System.out.println("");
						enemy.heal(50.0);
						epCount--;
					}
					

				}
				try {
					Thread.sleep(1000);                 //1000 milliseconds is one second.
				} catch(InterruptedException ex) {
					Thread.currentThread().interrupt();
				}
				//--------------------------------------------------------------------------------------------------------------------------------------				


			}







		}
//------------------------------------------------------------------------------------------------------------------------------------------------------



	}


	//methods---------------------------------------------------------------------------------------------------------------------------------------

	public static double getInf(Attacks x, Pokemon y, Pokemon u){

		if(   u.getType().equals( x.getType() )    ){ //STAB added



			if(x.getType().equals(y.getType())){

				if(!x.getType().equals("Ghost")){
					System.out.println("It's not very effective... ");
					return (x.getDamage()/2.0)*1.5;
				}

				if(x.getType().equals("Ghost")){
					System.out.println("It's super effective! ");
					return (x.getDamage()*3.0);
				}


			}
			if(x.getType().equals("Grass") && y.getType().equals("Fire")                 ){ //if attack is used on resistant type, damage is halved
				System.out.println("It's not very effective... ");
				return (x.getDamage()/2.0)*1.5;

			}

			if(x.getType().equals("Grass") && y.getType().equals("Water")                 ){//if attack used on weak type, damage doubled

				System.out.println("It's super effective! ");
				return x.getDamage()*3.0;

			}
			if(x.getType().equals("Grass") && y.getType().equals("Rock/Ground")                 ){//if attack used on weak type, damage doubled

				System.out.println("It's super effective! ");
				return x.getDamage()*3.0;

			}
			if(x.getType().equals("Water") && y.getType().equals("Grass")                 ){
				System.out.println("It's not very effective... ");
				return (x.getDamage()/2.0)*1.5;

			}
			if(x.getType().equals("Water") && y.getType().equals("Electric")                 ){
				System.out.println("It's not very effective... ");
				return (x.getDamage()/2.0)*1.5;

			}

			if(x.getType().equals("Water") && y.getType().equals("Fire")                 ){
				System.out.println("It's super effective! ");
				return x.getDamage()*3.0;

			}
			if(x.getType().equals("Water") && y.getType().equals("Rock/Ground")                 ){
				System.out.println("It's super effective! ");
				return x.getDamage()*3.0;

			}
			if(x.getType().equals("Fire") && y.getType().equals("Water")                 ){
				System.out.println("It's not very effective... ");
				return (x.getDamage()/2.0)*1.5;

			}
			if(x.getType().equals("Fire") && y.getType().equals("Rock/Ground")                 ){
				System.out.println("It's not very effective... ");
				return (x.getDamage()/2.0)*1.5;

			}
			if(x.getType().equals("Fire") && y.getType().equals("Grass")                 ){
				System.out.println("It's super effective! ");
				return x.getDamage()*3.0;

			}
			if(x.getType().equals("Electric") &&y.getType().equals("Water")){
				System.out.println("It's super effective! ");
				return x.getDamage()*3.0;
			}
			if(x.getType().equals("Electric") && y.getType().equals("Grass")                 ){
				System.out.println("It's not very effective... ");
				return (x.getDamage()/2.0)*1.5;

			}
			if(x.getType().equals("Electric") && y.getType().equals("Rock/Ground")) {
				System.out.println("It has no effect on the enemy!" );
				return 0;
			}
			if(x.getType().equals("Rock/Ground") && y.getType().equals("Water")                 ){
				System.out.println("It's not very effective... ");
				return (x.getDamage()/2.0)*1.5;

			}
			if(x.getType().equals("Rock/Ground") && y.getType().equals("Grass")                 ){
				System.out.println("It's not very effective... ");
				return x.getDamage()*0.75;

			}
			if(x.getType().equals("Rock/Ground") &&y.getType().equals("Fire")){
				System.out.println("It's super effective! ");
				return x.getDamage()*3.0;

			}
			if(x.getType().equals("Rock/Ground") &&y.getType().equals("Electric")){
				System.out.println("It's super effective! ");
				return x.getDamage()*3.0;

			}
			if(x.getType().equals("Normal") && y.getType().equals("Ghost")) {
				System.out.println("It has no effect on the enemy!" );
				return 0;
			}
			if(x.getType().equals("Normal") && y.getType().equals("Rock/Ground")                 ){
				System.out.println("It's not very effective... ");
				return (x.getDamage()/2.0)*1.5;

			}
			if(x.getType().equals("Psychic") &&y.getType().equals("Ghost")){
				System.out.println("It's super effective! ");
				return x.getDamage()*3.0;

			}
			if(x.getType().equals("Ghost") &&y.getType().equals("Psychic")){
				System.out.println("It's super effective! ");
				return x.getDamage()*3.0;

			}
			

			else{                                                                                 //if attack or pokemon type is normal, then regular damage + STAB
				return x.getDamage()*1.5;
			}





		}






		else{



			if(x.getType().equals(y.getType())){

				if(!x.getType().equals("Ghost")){
					System.out.println("It's not very effective... ");
					return (x.getDamage()/2.0);
				}

				if(x.getType().equals("Ghost")){
					System.out.println("It's super effective! ");
					return (x.getDamage()*2.0)*1.5;
				}


			}
			if(x.getType().equals("Grass") && y.getType().equals("Fire")                 ){ //if attack is used on resistant type, damage is halved
				System.out.println("It's not very effective... ");
				return (x.getDamage()/2.0);

			}

			if(x.getType().equals("Grass") && y.getType().equals("Water")                 ){//if attack used on weak type, damage doubled

				System.out.println("It's super effective! ");
				return x.getDamage()*2.0;

			}
			if(x.getType().equals("Grass") && y.getType().equals("Rock/Ground")                 ){//if attack used on weak type, damage doubled

				System.out.println("It's super effective! ");
				return x.getDamage()*2.0;

			}
			if(x.getType().equals("Water") && y.getType().equals("Grass")                 ){
				System.out.println("It's not very effective... ");
				return (x.getDamage()/2.0);

			}
			if(x.getType().equals("Water") && y.getType().equals("Electric")                 ){
				System.out.println("It's not very effective... ");
				return (x.getDamage()/2.0);

			}

			if(x.getType().equals("Water") && y.getType().equals("Fire")                 ){
				System.out.println("It's super effective! ");
				return x.getDamage()*2.0;

			}
			if(x.getType().equals("Water") && y.getType().equals("Rock/Ground")                 ){
				System.out.println("It's super effective! ");
				return x.getDamage()*2.0;

			}
			if(x.getType().equals("Fire") && y.getType().equals("Water")                 ){
				System.out.println("It's not very effective... ");
				return (x.getDamage()/2.0);

			}
			if(x.getType().equals("Fire") && y.getType().equals("Rock/Ground")                 ){
				System.out.println("It's not very effective... ");
				return (x.getDamage()/2.0);

			}
			if(x.getType().equals("Fire") && y.getType().equals("Grass")                 ){
				System.out.println("It's super effective! ");
				return x.getDamage()*2.0;

			}
			if(x.getType().equals("Electric") &&y.getType().equals("Water")){
				System.out.println("It's super effective! ");
				return x.getDamage()*2.0;
			}
			if(x.getType().equals("Electric") && y.getType().equals("Grass")                 ){
				System.out.println("It's not very effective... ");
				return (x.getDamage()/2.0);

			}
			if(x.getType().equals("Electric") && y.getType().equals("Rock/Ground")) {
				System.out.println("It has no effect on the enemy!" );
				return 0;
			}
			if(x.getType().equals("Rock/Ground") && y.getType().equals("Water")                 ){
				System.out.println("It's not very effective... ");
				return (x.getDamage()/2.0);

			}
			if(x.getType().equals("Rock/Ground") && y.getType().equals("Grass")                 ){
				System.out.println("It's not very effective... ");
				return x.getDamage()*.5;

			}
			if(x.getType().equals("Rock/Ground") &&y.getType().equals("Fire")){
				System.out.println("It's super effective! ");
				return x.getDamage()*2.0;

			}
			if(x.getType().equals("Rock/Ground") &&y.getType().equals("Electric")){
				System.out.println("It's super effective! ");
				return x.getDamage()*2.0;

			}
			if(x.getType().equals("Normal") && y.getType().equals("Ghost")) {
				System.out.println("It has no effect on the enemy!" );
				return 0;
			}
			if(x.getType().equals("Normal") && y.getType().equals("Rock/Ground")                 ){
				System.out.println("It's not very effective... ");
				return x.getDamage()*.5;

			}
			if(x.getType().equals("Psychic") &&y.getType().equals("Ghost")){
				System.out.println("It's super effective! ");
				return x.getDamage()*2.0;

			}
			if(x.getType().equals("Ghost") &&y.getType().equals("Psychic")){
				System.out.println("It's super effective! ");
				return x.getDamage()*2.0;

			}

			else{                                                                                 //if attack or pokemon type is normal, then regular damage + STAB
				return x.getDamage();
			}





		}


	}

}

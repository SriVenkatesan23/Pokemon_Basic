import java.util.*;
public class PokeBattle {
  //add pidg to list, add typing, add method for pidgk
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);



		Attacks tackle=new Attacks("Tackle","Normal", 18);
		Attacks ember = new Attacks("Ember", "Fire", 16);
		Attacks bubble = new Attacks("Bubble","Water", 16);
		Attacks vinewhip = new Attacks("Vine Whip" ,"Grass", 16);
		Attacks spark = new Attacks("Spark", "Electric" , 16);
		Attacks rockthrow = new Attacks("Rock Throw", "Rock", 16);
		Attacks shadball = new Attacks("Shadow Ball", "Ghost", 16);
		Attacks lick = new Attacks ("Lick", "Ghost", 10);
		Attacks scratch = new Attacks ("Scratch", "Normal", 16);
		Attacks psybeam = new Attacks ("Psybeam", "Psychic", 12);
		Attacks psting = new Attacks ("Poison Sting", "Poison", 14);
		Attacks pound = new Attacks ("Pound", "Normal", 20);
		Attacks slam = new Attacks ("Slam", "Normal", 26);
		Attacks wingattack = new Attacks ("Wing Attack", "Flying", 16);
		Attacks brick = new Attacks ("Brick Break", "Fighting", 16);
		Attacks x = new Attacks ("XScissor", "Bug", 20);
		Attacks crunch = new Attacks ("Crunch", "Dark", 20);
		Attacks mudslap = new Attacks ("Mud Slap", "Ground", 16);
		






		Pokemon charm = new Pokemon("Charmander", "Fire", tackle, ember, 100.0);
		Pokemon squirt = new Pokemon("Squirtle", "Water", tackle, bubble, 100.0);
		Pokemon bulby = new Pokemon("Bulbasaur", "Grass", tackle, vinewhip, 100.0);
		Pokemon pika = new Pokemon("Pikachu", "Electric", tackle, spark, 100.0);
		Pokemon onix = new Pokemon("Onix", "Rock", tackle, rockthrow, 100.0);
		Pokemon gastly = new Pokemon("Gastly", "Ghost", lick, shadball, 100.0);
		Pokemon kadabra = new Pokemon("Kadabra", "Psychic", scratch, psybeam, 100.0);
		Pokemon arbok = new Pokemon("Arbok", "Poison", pound, psting, 100.0);
		Pokemon meowth = new Pokemon ("Meowth", "Normal", pound, slam, 100.0 );
		Pokemon pidg = new Pokemon ("Pidgeotto", "Flying", scratch, wingattack, 100.0);
		Pokemon mach = new Pokemon ("Machoke", "Fighting", pound, brick, 100.0);
		Pokemon pins = new Pokemon ("Pinsir", "Bug", pound, x, 100.0);
		Pokemon umb = new Pokemon("Umbreon", "Dark", tackle, crunch, 100.0);
		Pokemon sandslash = new Pokemon("Sandslash", "Ground", scratch, mudslap, 100.0);







		ArrayList<Pokemon> poke=new ArrayList<Pokemon>();//adding pokemon to list so I can randomly choose one for the enemy
		poke.add(charm);
		poke.add(squirt);
		poke.add(bulby);
		poke.add(pika);
		poke.add(onix);
		poke.add(gastly);
		poke.add(kadabra);
		poke.add(arbok);
		poke.add(meowth);
		poke.add(pidg);
		poke.add(mach);
		poke.add(umb);
		poke.add(pins);
		poke.add(sandslash);





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
		System.out.println("8) Arbok" );
		System.out.println("9) Meowth" );
		System.out.println("10) Pidgeotto" );
		System.out.println("11) Machoke" );
		System.out.println("12) Umbreon" );
		System.out.println("13) Pinsir" );
		System.out.println("14) Sandslash" );
		

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

			user=new Pokemon("Onix", "Rock", tackle, rockthrow, 100.0);
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
		if(choice==8){

			user=new Pokemon("Arbok", "Poison", pound, psting, 100.0);
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
		if(choice==9){

			user=new Pokemon("Meowth", "Normal", pound, slam, 100.0);
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
		if(choice==10){

			user=new Pokemon("Pidgeotto", "Flying", scratch, wingattack, 100.0);
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
		if(choice==11){

			user=new Pokemon("Machoke", "Fighting", pound, brick, 100.0);
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
		if(choice==12){

			user=new Pokemon("Umbreon", "Dark", tackle, crunch, 100.0);
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
		if(choice==13){

			user=new Pokemon("Pinsir", "Bug", pound, x, 100.0);
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
		if(choice==14){

			user=new Pokemon("Sandslash", "Ground", scratch, mudslap, 100.0);
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



	}


	//methods---------------------------------------------------------------------------------------------------------------------------------------

	public static double getInf(Attacks x, Pokemon y, Pokemon u){

		if(   u.getType().equals( x.getType() ) && !u.getType().equals("Normal")){ //STAB added



			if(x.getType().equals(y.getType()) && !x.getType().equals("Normal")  ){

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
			if(x.getType().equals("Grass") && y.getType().equals("Rock")                 ){//if attack used on weak type, damage doubled

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
			if(x.getType().equals("Water") && y.getType().equals("Rock")                 ){
				System.out.println("It's super effective! ");
				return x.getDamage()*3.0;

			}
			if(x.getType().equals("Fire") && y.getType().equals("Water")                 ){
				System.out.println("It's not very effective... ");
				return (x.getDamage()/2.0)*1.5;

			}
			if(x.getType().equals("Fire") && y.getType().equals("Rock")                 ){
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
			
			if(x.getType().equals("Rock") && y.getType().equals("Water")                 ){
				System.out.println("It's not very effective... ");
				return (x.getDamage()/2.0)*1.5;

			}
			if(x.getType().equals("Rock") && y.getType().equals("Grass")                 ){
				System.out.println("It's not very effective... ");
				return x.getDamage()*0.75;

			}
			if(x.getType().equals("Rock") && y.getType().equals("Ground")                 ){
				System.out.println("It's not very effective... ");
				return x.getDamage()*0.75;

			}
			if(x.getType().equals("Rock") &&y.getType().equals("Fire")){
				System.out.println("It's super effective! ");
				return x.getDamage()*3.0;

			}
			if(x.getType().equals("Rock") &&y.getType().equals("Flying")){
				System.out.println("It's super effective! ");
				return x.getDamage()*3.0;

			}
			
			if(x.getType().equals("Normal") && y.getType().equals("Ghost")) {
				System.out.println("It has no effect on the enemy!" );
				return 0;
			}
			if(x.getType().equals("Normal") && y.getType().equals("Rock")                 ){
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
			if(x.getType().equals("Ghost") && y.getType().equals("Normal")) {
				System.out.println("It has no effect on the enemy!" );
				return 0;
			}
			if(x.getType().equals("Poison") &&y.getType().equals("Grass")){
				System.out.println("It's super effective! ");
				return x.getDamage()*3.0;

			}
			if(x.getType().equals("Psychic") &&y.getType().equals("Poison")){
				System.out.println("It's super effective! ");
				return x.getDamage()*3.0;

			}
			
			if(x.getType().equals("Poison") && y.getType().equals("Rock")                 ){
				System.out.println("It's not very effective... ");
				return (x.getDamage()/2.0)*1.5;

			}
			if(x.getType().equals("Poison") && y.getType().equals("Psychic")                 ){
				System.out.println("It's not very effective... ");
				return (x.getDamage()/2.0)*1.5;

			}
			if(x.getType().equals("Flying") && y.getType().equals("Electric")                 ){
				System.out.println("It's not very effective... ");
				return (x.getDamage()/2.0)*1.5;

			}
			if(x.getType().equals("Flying") && y.getType().equals("Rock")                 ){
				System.out.println("It's not very effective... ");
				return (x.getDamage()/2.0)*1.5;

			}
			if(x.getType().equals("Flying") &&y.getType().equals("Grass")){
				System.out.println("It's super effective! ");
				return x.getDamage()*3.0;

			}
			if(x.getType().equals("Flying") &&y.getType().equals("Fighting")){
				System.out.println("It's super effective! ");
				return x.getDamage()*3.0;

			}
			if(x.getType().equals("Psychic") &&y.getType().equals("Fighting")){
				System.out.println("It's super effective! ");
				return x.getDamage()*3.0;

			}
			if(x.getType().equals("Fighting") &&y.getType().equals("Normal")){
				System.out.println("It's super effective! ");
				return x.getDamage()*3.0;

			}
			if(x.getType().equals("Fighting") &&y.getType().equals("Rock")){
				System.out.println("It's super effective! ");
				return x.getDamage()*3.0;

			}
			if(x.getType().equals("Fighting") && y.getType().equals("Psychic")                 ){
				System.out.println("It's not very effective... ");
				return (x.getDamage()/2.0)*1.5;

			}
			if(x.getType().equals("Fighting") && y.getType().equals("Flying")                 ){
				System.out.println("It's not very effective... ");
				return (x.getDamage()/2.0)*1.5;

			}
			if(x.getType().equals("Normal") && y.getType().equals("Fighting")                 ){
				System.out.println("It's not very effective... ");
				return (x.getDamage()/2.0)*1.5;

			}
			if(x.getType().equals("Fighting") && y.getType().equals("Ghost")) {
				System.out.println("It has no effect on the enemy!" );
				return 0;
			}
			if(x.getType().equals("Ghost") && y.getType().equals("Dark")) {
				System.out.println("It's not very effective... ");
				return (x.getDamage()/2.0)*1.5;
			}
			if(x.getType().equals("Psychic") && y.getType().equals("Dark")) {
				System.out.println("It has no effect on the enemy!" );
				return 0;
			}
			
			if(x.getType().equals("Dark") && y.getType().equals("Fighting")) {
				System.out.println("It's not very effective... ");
				return (x.getDamage()/2.0)*1.5;
			}
			if(x.getType().equals("Fighting") &&y.getType().equals("Dark")){
				System.out.println("It's super effective! ");
				return x.getDamage()*3.0;

			}
			if(x.getType().equals("Bug") &&y.getType().equals("Dark")){
				System.out.println("It's super effective! ");
				return x.getDamage()*3.0;

			}
			if(x.getType().equals("Dark") &&y.getType().equals("Psychic")){
				System.out.println("It's super effective! ");
				return x.getDamage()*3.0;

			}
			if(x.getType().equals("Dark") &&y.getType().equals("Ghost")){
				System.out.println("It's super effective! ");
				return x.getDamage()*3.0;

			}
			if(x.getType().equals("Bug") &&y.getType().equals("Psychic")){
				System.out.println("It's super effective! ");
				return x.getDamage()*3.0;

			}
			if(x.getType().equals("Bug") &&y.getType().equals("Grass")){
				System.out.println("It's super effective! ");
				return x.getDamage()*3.0;

			}
			if(x.getType().equals("Bug") &&y.getType().equals("Rock")){
				System.out.println("It's not very effective... ");
				return (x.getDamage()/2.0)*1.5;
			}
			if(x.getType().equals("Bug") &&y.getType().equals("Flying")){
				System.out.println("It's not very effective... ");
				return (x.getDamage()/2.0)*1.5;
			}
			if(x.getType().equals("Bug") &&y.getType().equals("Fire")){
				System.out.println("It's not very effective... ");
				return (x.getDamage()/2.0)*1.5;
			}
			if(x.getType().equals("Fire") &&y.getType().equals("Bug")){
				System.out.println("It's super effective! ");
				return x.getDamage()*3.0;

			}
			if(x.getType().equals("Flying") &&y.getType().equals("Bug")){
				System.out.println("It's super effective! ");
				return x.getDamage()*3.0;

			}
			if(x.getType().equals("Rock") &&y.getType().equals("Bug")){
				System.out.println("It's super effective! ");
				return x.getDamage()*3.0;

			}
			if(x.getType().equals("Ground") &&y.getType().equals("Electric")){
				System.out.println("It's super effective! ");
				return x.getDamage()*3.0;

			}
			if(x.getType().equals("Ground") &&y.getType().equals("Fire")){
				System.out.println("It's super effective! ");
				return x.getDamage()*3.0;

			}
			if(x.getType().equals("Ground") &&y.getType().equals("Rock")){
				System.out.println("It's super effective! ");
				return x.getDamage()*3.0;

			}
			if(x.getType().equals("Ground") &&y.getType().equals("Poison")){
				System.out.println("It's super effective! ");
				return x.getDamage()*3.0;

			}
			if(x.getType().equals("Ground") &&y.getType().equals("Grass")){
				System.out.println("It's not very effective... ");
				return (x.getDamage()/2.0)*1.5;
			}
			if(x.getType().equals("Ground") &&y.getType().equals("Bug")){
				System.out.println("It's not very effective... ");
				return (x.getDamage()/2.0)*1.5;
			}
			if(x.getType().equals("Poison") &&y.getType().equals("Ground")){
				System.out.println("It's not very effective... ");
				return (x.getDamage()/2.0)*1.5;
			}
			if(x.getType().equals("Grass") &&y.getType().equals("Ground")){
				System.out.println("It's super effective! ");
				return x.getDamage()*3.0;

			}
			if(x.getType().equals("Water") &&y.getType().equals("Ground")){
				System.out.println("It's super effective! ");
				return x.getDamage()*3.0;

			}
			if(x.getType().equals("Ground") && y.getType().equals("Flying")) {
				System.out.println("It has no effect on the enemy!" );
				return 0;
			}
			if(x.getType().equals("Electric") && y.getType().equals("Ground")) {
				System.out.println("It has no effect on the enemy!" );
				return 0;
			}
			
			

			else{                                                                                 //if attack or pokemon type is normal, then regular damage + STAB
				return x.getDamage()*1.5;
			}





		}






		else{



			if(x.getType().equals(y.getType()) && !x.getType().equals("Normal")  ){

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
			if(x.getType().equals("Grass") && y.getType().equals("Rock")                 ){//if attack used on weak type, damage doubled

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
			if(x.getType().equals("Water") && y.getType().equals("Rock")                 ){
				System.out.println("It's super effective! ");
				return x.getDamage()*2.0;

			}
			if(x.getType().equals("Fire") && y.getType().equals("Water")                 ){
				System.out.println("It's not very effective... ");
				return (x.getDamage()/2.0);

			}
			if(x.getType().equals("Fire") && y.getType().equals("Rock")                 ){
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
			
			if(x.getType().equals("Rock") && y.getType().equals("Water")                 ){
				System.out.println("It's not very effective... ");
				return (x.getDamage()/2.0);

			}
			if(x.getType().equals("Rock") && y.getType().equals("Grass")                 ){
				System.out.println("It's not very effective... ");
				return x.getDamage()*0.5;

			}
			if(x.getType().equals("Rock") && y.getType().equals("Ground")                 ){
				System.out.println("It's not very effective... ");
				return x.getDamage()*0.5;

			}
			if(x.getType().equals("Rock") &&y.getType().equals("Fire")){
				System.out.println("It's super effective! ");
				return x.getDamage()*2.0;

			}
			if(x.getType().equals("Rock") &&y.getType().equals("Flying")){
				System.out.println("It's super effective! ");
				return x.getDamage()*2.0;

			}
			
			if(x.getType().equals("Normal") && y.getType().equals("Ghost")) {
				System.out.println("It has no effect on the enemy!" );
				return 0;
			}
			if(x.getType().equals("Normal") && y.getType().equals("Rock")                 ){
				System.out.println("It's not very effective... ");
				return (x.getDamage()/2.0);

			}
			if(x.getType().equals("Psychic") &&y.getType().equals("Ghost")){
				System.out.println("It's super effective! ");
				return x.getDamage()*2.0;

			}
			if(x.getType().equals("Ghost") &&y.getType().equals("Psychic")){
				System.out.println("It's super effective! ");
				return x.getDamage()*2.0;

			}
			if(x.getType().equals("Ghost") && y.getType().equals("Normal")) {
				System.out.println("It has no effect on the enemy!" );
				return 0;
			}
			if(x.getType().equals("Poison") &&y.getType().equals("Grass")){
				System.out.println("It's super effective! ");
				return x.getDamage()*2.0;

			}
			if(x.getType().equals("Psychic") &&y.getType().equals("Poison")){
				System.out.println("It's super effective! ");
				return x.getDamage()*2.0;

			}
			
			if(x.getType().equals("Poison") && y.getType().equals("Rock")                 ){
				System.out.println("It's not very effective... ");
				return (x.getDamage()/2.0);

			}
			if(x.getType().equals("Poison") && y.getType().equals("Psychic")                 ){
				System.out.println("It's not very effective... ");
				return (x.getDamage()/2.0);

			}
			if(x.getType().equals("Flying") && y.getType().equals("Electric")                 ){
				System.out.println("It's not very effective... ");
				return (x.getDamage()/2.0);

			}
			if(x.getType().equals("Flying") && y.getType().equals("Rock")                 ){
				System.out.println("It's not very effective... ");
				return (x.getDamage()/2.0);

			}
			if(x.getType().equals("Flying") &&y.getType().equals("Grass")){
				System.out.println("It's super effective! ");
				return x.getDamage()*2.0;

			}
			if(x.getType().equals("Flying") &&y.getType().equals("Fighting")){
				System.out.println("It's super effective! ");
				return x.getDamage()*2.0;

			}
			if(x.getType().equals("Psychic") &&y.getType().equals("Fighting")){
				System.out.println("It's super effective! ");
				return x.getDamage()*2.0;

			}
			if(x.getType().equals("Fighting") &&y.getType().equals("Normal")){
				System.out.println("It's super effective! ");
				return x.getDamage()*2.0;

			}
			if(x.getType().equals("Fighting") &&y.getType().equals("Rock")){
				System.out.println("It's super effective! ");
				return x.getDamage()*2.0;

			}
			if(x.getType().equals("Fighting") && y.getType().equals("Psychic")                 ){
				System.out.println("It's not very effective... ");
				return (x.getDamage()/2.0);

			}
			if(x.getType().equals("Fighting") && y.getType().equals("Flying")                 ){
				System.out.println("It's not very effective... ");
				return (x.getDamage()/2.0);

			}
			if(x.getType().equals("Normal") && y.getType().equals("Fighting")                 ){
				System.out.println("It's not very effective... ");
				return (x.getDamage()/2.0);

			}
			if(x.getType().equals("Fighting") && y.getType().equals("Ghost")) {
				System.out.println("It has no effect on the enemy!" );
				return 0;
			}
			if(x.getType().equals("Ghost") && y.getType().equals("Dark")) {
				System.out.println("It's not very effective... ");
				return (x.getDamage()/2.0);
			}
			if(x.getType().equals("Psychic") && y.getType().equals("Dark")) {
				System.out.println("It has no effect on the enemy!" );
				return 0;
			}
			
			if(x.getType().equals("Dark") && y.getType().equals("Fighting")) {
				System.out.println("It's not very effective... ");
				return (x.getDamage()/2.0);
			}
			if(x.getType().equals("Fighting") &&y.getType().equals("Dark")){
				System.out.println("It's super effective! ");
				return x.getDamage()*2.0;

			}
			if(x.getType().equals("Bug") &&y.getType().equals("Dark")){
				System.out.println("It's super effective! ");
				return x.getDamage()*2.0;

			}
			if(x.getType().equals("Dark") &&y.getType().equals("Psychic")){
				System.out.println("It's super effective! ");
				return x.getDamage()*2.0;

			}
			if(x.getType().equals("Dark") &&y.getType().equals("Ghost")){
				System.out.println("It's super effective! ");
				return x.getDamage()*2.0;

			}
			if(x.getType().equals("Bug") &&y.getType().equals("Psychic")){
				System.out.println("It's super effective! ");
				return x.getDamage()*2.0;

			}
			if(x.getType().equals("Bug") &&y.getType().equals("Grass")){
				System.out.println("It's super effective! ");
				return x.getDamage()*2.0;

			}
			if(x.getType().equals("Bug") &&y.getType().equals("Rock")){
				System.out.println("It's not very effective... ");
				return (x.getDamage()/2.0);
			}
			if(x.getType().equals("Bug") &&y.getType().equals("Flying")){
				System.out.println("It's not very effective... ");
				return (x.getDamage()/2.0);
			}
			if(x.getType().equals("Bug") &&y.getType().equals("Fire")){
				System.out.println("It's not very effective... ");
				return (x.getDamage()/2.0);
			}
			if(x.getType().equals("Fire") &&y.getType().equals("Bug")){
				System.out.println("It's super effective! ");
				return x.getDamage()*2.0;

			}
			if(x.getType().equals("Flying") &&y.getType().equals("Bug")){
				System.out.println("It's super effective! ");
				return x.getDamage()*2.0;

			}
			if(x.getType().equals("Rock") &&y.getType().equals("Bug")){
				System.out.println("It's super effective! ");
				return x.getDamage()*2.0;

			}
		
		if(x.getType().equals("Ground") &&y.getType().equals("Electric")){
			System.out.println("It's super effective! ");
			return x.getDamage()*3.0;

		}
		if(x.getType().equals("Ground") &&y.getType().equals("Fire")){
			System.out.println("It's super effective! ");
			return x.getDamage()*3.0;

		}
		if(x.getType().equals("Ground") &&y.getType().equals("Rock")){
			System.out.println("It's super effective! ");
			return x.getDamage()*3.0;

		}
		if(x.getType().equals("Ground") &&y.getType().equals("Poison")){
			System.out.println("It's super effective! ");
			return x.getDamage()*3.0;

		}
		if(x.getType().equals("Ground") &&y.getType().equals("Grass")){
			System.out.println("It's not very effective... ");
			return (x.getDamage()/2.0)*1.5;
		}
		if(x.getType().equals("Ground") &&y.getType().equals("Bug")){
			System.out.println("It's not very effective... ");
			return (x.getDamage()/2.0)*1.5;
		}
		if(x.getType().equals("Poison") &&y.getType().equals("Ground")){
			System.out.println("It's not very effective... ");
			return (x.getDamage()/2.0)*1.5;
		}
		if(x.getType().equals("Grass") &&y.getType().equals("Ground")){
			System.out.println("It's super effective! ");
			return x.getDamage()*3.0;

		}
		if(x.getType().equals("Water") &&y.getType().equals("Ground")){
			System.out.println("It's super effective! ");
			return x.getDamage()*3.0;

		}
		if(x.getType().equals("Ground") && y.getType().equals("Flying")) {
			System.out.println("It has no effect on the enemy!" );
			return 0;
		}
		if(x.getType().equals("Electric") && y.getType().equals("Ground")) {
			System.out.println("It has no effect on the enemy!" );
			return 0;
		}

			else{                                                                                 //if attack or pokemon type is normal, then regular damage + STAB
				return x.getDamage();
			}





		}


	}

}

import java.util.*;

interface vehicleControls{
	public void start();
	public void stop();
}

interface Vehicle{
	void accelerate();
	public void shiftUp();
	public void shiftDown();
	public void brake();
	public void status();
};

class Bike implements Vehicle,vehicleControls{
	
	int engineStatus=0;			//Engine On/Off
	int currGear;				//current gear condition
	int currSpeed;				//current speed
	int avgSpeed;				//average speed for first gear
	
	public void start() {		//Start the Engine
		engineStatus=1;
	}
	
	public void stop() {		//stop the bike and Turn off the engine
		currGear=0;
		currSpeed=0;
		engineStatus=0;
	}
	
	Bike()						//Constructor for Bike
	{
		this.currGear=0;		//neutral condition
		this.currSpeed=0;		//initial speed will be zero
		this.avgSpeed=10;		//setting the Average Speed to bike
		
		this.status();
	}
	
	Bike(int avg)				//Constructor to set the speed of Car
	{
		this.currGear=0;		//neutral condition
		this.currSpeed=0;		//initial speed will be zero
		this.avgSpeed=avg;		//setting the average speed
		
		this.status();
	}
	
	public void accelerate() {
		switch(currGear)
		{
		
		case 0:{
			System.out.println("Bike is in Neutral, Shift Up");
			break;
		}
		case 1: {
			if(currSpeed<avgSpeed)	currSpeed+=10;						//checking if max speed attained for the gear
			else	System.out.println("Shift Up, to Increse Speed");	//suggesting to shift up
			break;
		}
		case 2:{
			if(currSpeed<avgSpeed*2)	currSpeed+=10;					//checking if max speed attained for the gear
			else	System.out.println("Shift Up, to Increse Speed");	//suggesting to shift up
			break;
		}
		case 3:{
			if(currSpeed<avgSpeed*3)	currSpeed+=10;					//checking if max speed attained for the gear
			else	System.out.println("Shift Up, to Increse Speed");	//suggesting to shift up
			break;
		}
		case 4:{
			if(currSpeed<avgSpeed*4)	currSpeed+=10;					//checking if max speed attained for the gear
			else	System.out.println("Shift Up, to Increse Speed");	//suggesting to shift up
			break;
		}
		case 5:{
			if(currSpeed<avgSpeed*5)	currSpeed+=10;					//checking if max speed attained for the gear
			else	System.out.println("Max Speed Reached");			//suggesting to shift up
			break;
		}
		}
	}
	
	public void shiftUp() {
		if(currGear<=5) currGear+=1;
		else	System.out.println("Currently On maximum Gear");
	}
	
	public void shiftDown() {
		if(currGear>0) currGear-=1;
		else System.out.println("The Bike is Already in Neutral Condition");
	}
	
	public void brake() {
		if(currSpeed>0) currSpeed-=10;
		if(currSpeed==0)	System.out.println("Bike has Stopped");
	}
	
	public void status() {	
		System.out.println("\nStatus: "+(engineStatus==1 ? "Engine ON":"Engine OFF"));
		System.out.println("Speed: "+currSpeed);
		System.out.println("Gear: "+(currGear==0 ? "Neutral":currGear));
	}
}

class Car extends Bike{
	
	Car() {
		super(20);
		// TODO Auto-generated constructor stub
	}
}

class Bicycle extends Bike{
	
	Bicycle() {
		super(3);
		this.currGear=1;
	}
}

public class Assignment_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int choice=0;
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Bike Selected");
		Bike vehicle;								//creating the reference of bike class
		
		System.out.println("1. Bike");
		System.out.println("2. Car");
		System.out.println("3. Bicycle");
		System.out.print("Select One Vehicle: ");
		choice=sc.nextInt();
		
		//vehicle selection
		switch(choice)
		{
		case 1:{
			System.out.println("BIKE SELECTED");
			vehicle=new Bike();
			break;
		}
		case 2:{
			System.out.println("CAR SELECTED");
			vehicle=new Car();
			break;
		}
		case 3:{
			System.out.println("BICYCLE SELECTED");
			vehicle=new Bicycle();
			break;
		}
		default:{
			System.out.println("Invalid Choice");
			return;
		}
		}
		
		choice=0;
		
		//menu to perform operations with the vehicle
		while(choice<7)
		{
			System.out.println("1. Start");
			System.out.println("2. Accelerate");
			System.out.println("3. Shift Up");
			System.out.println("4. Shift Down");
			System.out.println("5. Brake");
			System.out.println("6. Stop");
			System.out.print("Operation: ");
			choice=sc.nextInt();
			
			switch(choice)						//performing the current operation
			{
			case 1:{
				vehicle.start();
				break;
			}
			case 2:{
				vehicle.accelerate();
				break;
			}
			case 3: {
				vehicle.shiftUp();
				break;
			}
			case 4: {
				vehicle.shiftDown();
				break;
			}
			case 5: {
				vehicle.brake();
				break;
			}
			case 6: {
				vehicle.stop();
				vehicle.status();
				return;
			}
			}
			
			vehicle.status();
			System.out.println();
		}
		
		
	}

}

/*
 * Bike Selected
1. Bike
2. Car
3. Bicycle
Select One Vehicle: 2
CAR SELECTED

Status: Engine OFF
Speed: 0
Gear: Neutral
1. Start
2. Accelerate
3. Shift Up
4. Shift Down
5. Brake
6. Stop
Operation: 1

Status: Engine ON
Speed: 0
Gear: Neutral

1. Start
2. Accelerate
3. Shift Up
4. Shift Down
5. Brake
6. Stop
Operation: 2
Bike is in Neutral, Shift Up

Status: Engine ON
Speed: 0
Gear: Neutral

1. Start
2. Accelerate
3. Shift Up
4. Shift Down
5. Brake
6. Stop
Operation: 3

Status: Engine ON
Speed: 0
Gear: 1

1. Start
2. Accelerate
3. Shift Up
4. Shift Down
5. Brake
6. Stop
Operation: 2

Status: Engine ON
Speed: 10
Gear: 1

1. Start
2. Accelerate
3. Shift Up
4. Shift Down
5. Brake
6. Stop
Operation: 2

Status: Engine ON
Speed: 20
Gear: 1

1. Start
2. Accelerate
3. Shift Up
4. Shift Down
5. Brake
6. Stop
Operation: 2
Shift Up, to Increse Speed

Status: Engine ON
Speed: 20
Gear: 1

1. Start
2. Accelerate
3. Shift Up
4. Shift Down
5. Brake
6. Stop
Operation: 
3

Status: Engine ON
Speed: 20
Gear: 2

1. Start
2. Accelerate
3. Shift Up
4. Shift Down
5. Brake
6. Stop
Operation: 2

Status: Engine ON
Speed: 30
Gear: 2

1. Start
2. Accelerate
3. Shift Up
4. Shift Down
5. Brake
6. Stop
Operation: 2

Status: Engine ON
Speed: 40
Gear: 2

1. Start
2. Accelerate
3. Shift Up
4. Shift Down
5. Brake
6. Stop
Operation: 2
Shift Up, to Increse Speed

Status: Engine ON
Speed: 40
Gear: 2

1. Start
2. Accelerate
3. Shift Up
4. Shift Down
5. Brake
6. Stop
Operation: 4

Status: Engine ON
Speed: 40
Gear: 1

1. Start
2. Accelerate
3. Shift Up
4. Shift Down
5. Brake
6. Stop
Operation: 5

Status: Engine ON
Speed: 30
Gear: 1

1. Start
2. Accelerate
3. Shift Up
4. Shift Down
5. Brake
6. Stop
Operation: 5

Status: Engine ON
Speed: 20
Gear: 1

1. Start
2. Accelerate
3. Shift Up
4. Shift Down
5. Brake
6. Stop
Operation: 6

Status: Engine OFF
Speed: 0
Gear: Neutral

1. Start
2. Accelerate
3. Shift Up
4. Shift Down
5. Brake
6. Stop
Operation: 
*/

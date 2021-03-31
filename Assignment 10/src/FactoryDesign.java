import java.util.*;
 interface Car {
	void Specs();
}
class CarFactory {
	public Car getCar(String carType) {
		if(carType==null) {
			return null;
		}
		else if(carType=="SEDAN") {
			return new Sedan();
		}
		else if(carType=="HATCHBACK") {
			return new Hatchback();
		}
		else if(carType=="SUV") {
			return new Suv();
		}
		return null;
	}
}

 class Hatchback implements Car {
		public void Specs() {
		System.out.println("-------------HactckBack---------------");
		System.out.println("1. 2 Wheel Drive");
		System.out.println("2. Compact Boot");
		System.out.println("3. 5 Seater");
		System.out.println("4. 3 AIrBags");
		}
	}
 class Sedan implements Car {
	 public void Specs() {
			System.out.println("-------------Sedan---------------");
			System.out.println("1. 4 Wheel Drive");
			System.out.println("2. Extra Boot Space");
			System.out.println("3. 5 Seater");
			System.out.println("4. 5 AIrBags");
			}
	}
 class Suv implements Car{
	 public void Specs() {
			System.out.println("-------------Sedan---------------");
			System.out.println("1. 4 Wheel Drive");
			System.out.println("2. Extra Boot Space");
			System.out.println("3. 7 Seater");
			System.out.println("4. 7 AIrBags");
			}
	}
 
 public class FactoryDesign {

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			CarFactory carfactory=new CarFactory();
			
			Car car1=carfactory.getCar("SEDAN");
			car1.Specs();
			
			Car car2=carfactory.getCar("HATCHBACK");
			car1.Specs();

			Car car3=carfactory.getCar("SUV");
			car1.Specs();
		}

}
 
 /*
 -------------Sedan---------------
 1. 4 Wheel Drive
 2. Extra Boot Space
 3. 5 Seater
 4. 5 AIrBags
 -------------Sedan---------------
 1. 4 Wheel Drive
 2. Extra Boot Space
 3. 5 Seater
 4. 5 AIrBags
 -------------Sedan---------------
 1. 4 Wheel Drive
 2. Extra Boot Space
 3. 5 Seater
 4. 5 AIrBags
 */

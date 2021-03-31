class MotorBike{
	static int speed;
	static int accn;
	static int weight;
	
	public void pt()
	{
		System.out.println("Speed = "+this.speed);
		System.out.println("Acceleration = "+this.accn);
		System.out.println("Weight = "+this.weight);
	}
	
	public void main(String args[])
	{
		this.pt();
	}
}
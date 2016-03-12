package components;

public class Vector {

	private double x, y, z;
	
	public Vector(){
		x = 0;
		y = 0;
		z = 0;
	}
	
	public Vector(double x, double y, double z){
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public double getX(){
		return x;
	}
	
	public double getY(){
		return y;
	}
	
	public double getZ(){
		return z;
	}
	
	public void setX(double x){
		this.x = x;
	}
	
	public void setY(double y){
		this.y = y;
	}
	
	public void setZ(double z){
		this.z = z;
	}
	
	public Vector add(Vector vec2){
		double resX = this.x + vec2.getX();
		double resY = this.y + vec2.getY();
		double resZ = this.z + vec2.getZ();
		
		return new Vector(resX, resY, resZ);
	}
	
	public Vector subtract(Vector vec2){
		double resX = this.x - vec2.getX();
		double resY = this.y - vec2.getY();
		double resZ = this.z - vec2.getZ();
		
		return new Vector(resX, resY, resZ);
	}
	
	public Vector multiply(double scale){
		double resX = this.x * scale;
		double resY = this.y * scale;
		double resZ = this.z * scale;
		
		return new Vector(resX, resY, resZ);
	}
	
	public Vector divide(double scale){
		if(scale == 0){
			System.out.println("Division by 0 of a vector!");
		}
		
		double resX = this.x / scale;
		double resY = this.y / scale;
		double resZ = this.z / scale;
		
		return new Vector(resX, resY, resZ);
	}
	
	public double dotProduct(Vector vec2){
		double result = this.x * vec2.getX() + this.y * vec2.getY() + this.z * vec2.getZ();
		return result;
	}
	
	public Vector crossProduct(Vector vec2){
		double resX = this.y * vec2.getZ() - this.z * vec2.getY();
		double resY = this.z * vec2.getX() - this.x * vec2.getZ();
		double resZ = this.x * vec2.getY() - this.y * vec2.getX();
		
		return new Vector(resX, resY, resZ);
	}
	
	public double length(){
		return Math.sqrt(this.dotProduct(this));
	}
	
	public Vector normalize(){
		return this.divide(this.length());
	}
	
	public Vector invert(){
		double resX = -this.x;
		double resY = -this.y;
		double resZ = -this.z;
		
		return new Vector(resX, resY, resZ);
	}
	
	public void print(){
		System.out.println("" + x + "" + y + "" + z);
	}
	
}

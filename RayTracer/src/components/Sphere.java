package components;

public class Sphere {
	private double radius;
	private Vector position;
	private MyColor color;
	
	public Sphere(){
		radius = 1;
		position = new Vector(0, 0, 0);
		color = new MyColor(200, 200, 200);
	}
	
	public Sphere(Vector position, double radius, MyColor color){
		this.radius = radius;
		this.position = position;
		this.color = color;
	}
	
	public void setPosition(Vector position){
		this.position = position;
	}
	
	public void setRadius(double radius){
		this.radius = radius;
	}
	
	public void setColor(MyColor color){
		this.color = color;
	}
	
	public Vector getPosition(){
		return position;
	}
	
	public double getRadius(){
		return radius;
	}
	
	public MyColor getColor(){
		return color;
	}
	
	public Vector checkCollision(Ray incomingRay){
		Vector rayOriginToCenter = position.subtract(incomingRay.getOrigin());
		double dotProduct = rayOriginToCenter.dotProduct(incomingRay.getDirection());
		
		double dSquare = rayOriginToCenter.dotProduct(rayOriginToCenter) - dotProduct * dotProduct;
		
		if(dSquare > radius * radius)
			return null;
		
		if(dotProduct < 0)
			return null;
		
		double distance = Math.sqrt(radius * radius - dSquare);
		return incomingRay.getOrigin().add(incomingRay.getDirection().multiply(dotProduct - distance));
	}
	
	public Vector getNormalAtPoint(Vector point){
		return position.subtract(point).normalize();
	}
}

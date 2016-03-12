package components;

public class Plane {
	private Vector position, normal;
	private MyColor color;
	
	public Plane(){
		position = new Vector(0, 0, 0);
		normal = new Vector(0, 1, 0);
		color = new MyColor(100, 100, 100);
	}

	public Plane(Vector position, Vector normal, MyColor color) {
		this.position = position;
		this.normal = normal;
		this.color = color;
	}
	
	public Vector getPosition() {
		return position;
	}

	public Vector getNormal() {
		return normal.invert();
	}

	public MyColor getColor() {
		return color;
	}

	public void setPosition(Vector position) {
		this.position = position;
	}

	public void setNormal(Vector normal) {
		this.normal = normal;
	}

	public void setColor(MyColor color) {
		this.color = color;
	}
	
	public Vector checkCollision(Ray incomingRay){
		double denominator = normal.dotProduct(incomingRay.getDirection());
		
		if(denominator < 0){
			Vector rayToPlane = position.subtract(incomingRay.getOrigin());
			double t = rayToPlane.dotProduct(normal) / denominator;
			return incomingRay.getOrigin().add(incomingRay.getDirection().multiply(t));
		}
		
		return null;
	}
}

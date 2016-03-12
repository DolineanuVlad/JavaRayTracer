package components;

public class Ray {
	private Vector origin;
	private Vector direction;
	
	public Ray(){
		origin = new Vector(0, 0, 0);
		direction = new Vector(0, 0, 0);
	}
	
	public Ray(Vector origin, Vector direction){
		this.origin = origin;
		this.direction = direction;
	}
	
	public void setOrigin(Vector origin){
		this.origin = origin;
	}
	
	public void setDirection(Vector direction){
		this.direction = direction;
	}
	
	public Vector getOrigin(){
		return origin;
	}
	
	public Vector getDirection(){
		return direction;
	}
}

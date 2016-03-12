package components;

public class Face {

	private Vector vertex1, vertex2, vertex3, normal;
	private MyColor color;
	
	public Face(Vector vertex1, Vector vertex2, Vector vertex3, Vector normal, MyColor color){
		this.vertex1 = vertex1;
		this.vertex2 = vertex2;
		this.vertex3 = vertex3;
		this.normal = normal;
		this.color = color;
	}
	
	public Vector checkCollision(Ray incomingRay){
		
		return null;
	}
	
}

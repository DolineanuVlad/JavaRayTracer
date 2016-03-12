package components;

public class Camera {
	private Vector position, lookAt, down, right;
	
	public Camera(){
		position = new Vector(0, 1.8, -5);
		lookAt = new Vector(0, 0, 1);
		down = new Vector(0, -1, 0);
		right = new Vector(1, 0, 0);
	}
	
	public Camera(Vector position, Vector lookAt, Vector down, Vector right){
		this.position = position;
		this.lookAt = lookAt;
		this.down = down;
		this.right = right;
	}

	public Vector getPosition() {
		return position;
	}

	public Vector getLookAt() {
		return lookAt;
	}

	public Vector getDown() {
		return down;
	}

	public Vector getRight() {
		return right;
	}

	public void setPosition(Vector position) {
		this.position = position;
	}

	public void setLookAt(Vector lookAt) {
		this.lookAt = lookAt;
	}

	public void setDown(Vector down) {
		this.down = down;
	}

	public void setRight(Vector right) {
		this.right = right;
	}
	
	
}

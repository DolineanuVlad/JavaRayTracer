package components;

public class LightSource {
	private Vector position;
	private MyColor color;
	
	public LightSource(){
		position = new Vector(0, 0, 0);
		color = new MyColor(255, 255, 255);
	}
	
	public LightSource(Vector position, MyColor color){
		this.position = position;
		this.color = color;
	}

	public Vector getPosition() {
		return position;
	}

	public MyColor getColor() {
		return color;
	}

	public void setPosition(Vector position) {
		this.position = position;
	}

	public void setColor(MyColor color) {
		this.color = color;
	}
	
	
}

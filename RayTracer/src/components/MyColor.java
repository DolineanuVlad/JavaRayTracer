package components;

public class MyColor {
	private int red, green, blue;
	
	public MyColor(){
		red = 0;
		green = 0;
		blue = 0;
	}
	
	public MyColor(int red, int green, int blue){
		if(red > 255)
			red = 255;
		if(green > 255)
			green = 255;
		if(blue > 255)
			blue = 255;
		if(red < 0)
			red = 0;
		if(green < 0)
			green = 0;
		if(blue < 0)
			blue = 0;
		this.red = red;
		this.green = green;
		this.blue = blue;
	}
	
	public void setRed(int red){
		this.red = red;
	}
	
	public void setGreen(int green){
		this.green = green;
	}
	
	public void setBlue(int blue){
		this.blue = blue;
	}
	
	public int getRed(){
		return red;
	}
	
	public int getGreen(){
		return green;
	}
	
	public int getBlue(){
		return blue;
	}
	
	public MyColor clamp(){
		MyColor temp = new MyColor(red, green, blue);
		
		if(temp.getRed() > 255)
			temp.setRed(255);
		if(temp.getGreen() > 255)
			temp.setGreen(255);
		if(temp.getBlue() > 255)
			temp.setBlue(255);
		
		if(temp.getRed() < 0)
			temp.setRed(0);
		if(temp.getGreen() < 0)
			temp.setGreen(0);
		if(temp.getBlue() < 0)
			temp.setBlue(0);
		
		return temp;
	}
	
	public MyColor add(MyColor col2){
		int resRed = red + col2.getRed();
		int resGreen = green + col2.getGreen();
		int resBlue = blue + col2.getBlue();
		
		return new MyColor(resRed, resGreen, resBlue).clamp();
	}
	
	public MyColor subtract(MyColor col2){
		int resRed = red - col2.getRed();
		int resGreen = green - col2.getGreen();
		int resBlue = blue - col2.getBlue();
		
		return new MyColor(resRed, resGreen, resBlue).clamp();
	}
	
	public MyColor multiply(double scale){
		int resRed = (int)(red * scale);
		int resGreen = (int)(green * scale);
		int resBlue = (int)(blue * scale);
		
		return new MyColor(resRed, resGreen, resBlue).clamp();
	}
	
	
}

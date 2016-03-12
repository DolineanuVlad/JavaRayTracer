package utility;

import java.util.ArrayList;

import components.LightSource;
import components.MyColor;
import components.Ray;
import components.Sphere;
import components.Vector;

public class ColorUtil {

	public static MyColor getColorForPoint(MyColor objectColor, Vector normal, Ray currentRay, LightSource light, Vector collisionPoint, ArrayList<Sphere> spheres, Sphere activeSphere){
		MyColor finalColor;
		double ambientLevel = 0.3;
		finalColor = objectColor.multiply(ambientLevel);
		
		double dotProduct = normal.dotProduct(collisionPoint.subtract(light.getPosition()));
		double modules = normal.length() * collisionPoint.subtract(light.getPosition()).length();
		
		double cosAngle = dotProduct / modules;
		
		MyColor diffuse = objectColor.multiply(cosAngle);
		
		if(!Shadow.checkShadow(collisionPoint, light, spheres, activeSphere))
			return finalColor.add(diffuse).clamp();
		else
			return finalColor;
	}
	
}

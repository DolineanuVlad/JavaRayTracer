package utility;

import java.util.ArrayList;

import components.LightSource;
import components.Ray;
import components.Sphere;
import components.Vector;

public class Shadow {

	public static boolean checkShadow(Vector collisionPoint, LightSource source, ArrayList<Sphere> spheres, Sphere activeSphere){
		boolean shadowed = false;
		Vector rayDirection = source.getPosition().subtract(collisionPoint).normalize();
		Ray shadowRay = new Ray(collisionPoint, rayDirection);
		double distanceBetweenPointAndLight = source.getPosition().subtract(collisionPoint).length();
		
		for(Sphere s : spheres){
			if(s.checkCollision(shadowRay) != null && s.checkCollision(shadowRay).subtract(collisionPoint).length() < distanceBetweenPointAndLight && s != activeSphere && s.checkCollision(shadowRay).subtract(collisionPoint).length() > 0){
				shadowed = true;
				break;
			}
		}
		
		return shadowed;	
	}
	
}

package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JPanel;

import components.Camera;
import components.LightSource;
import components.MyColor;
import components.Plane;
import components.Ray;
import components.Sphere;
import components.Vector;
import utility.ColorUtil;
import utility.Constants;

public class Screen extends JPanel{
	
	Main main;

	Sphere sphere1 = new Sphere(new Vector(0, 1, 3), 1, new MyColor(25, 25, 100));
	Sphere sphere2 = new Sphere(new Vector(2.5, 1, 2.5), 1, new MyColor(25, 100, 25));
	Sphere sphere3 = new Sphere(new Vector(-2.5, 1, 2), 1, new MyColor(25, 100, 100));
	Sphere sphere4 = new Sphere(new Vector(1, 0.5, 1), 0.5, new MyColor(200, 200, 200));
	ArrayList<Sphere> spheres;
	
	Plane plane1 = new Plane(new Vector(0, 0, 0), Constants.j, new MyColor(180, 50, 50));
	LightSource source1 = new LightSource(new Vector(10, 4, -3), new MyColor(255, 255, 255));
	
	MyColor backgroundColor = new MyColor(200, 200, 255);
	
	Vector camPos = new Vector(0, 1.8, -5);
	Vector camTarget = new Vector(0, 0, 3);
	Vector camLookAt = camTarget.subtract(camPos).normalize();
	Vector camRight = Constants.j.crossProduct(camLookAt).normalize();
	Vector camDown = camRight.crossProduct(camLookAt).normalize();
	
	Camera camera = new Camera(camPos, camLookAt, camDown, camRight);
	
	public Screen(Main main){
		this.main = main;
		spheres = new ArrayList<Sphere>();
		spheres.add(sphere1);
		spheres.add(sphere2);
		spheres.add(sphere3);
		spheres.add(sphere4);
		
	}
	
	private BufferedImage generateImage(){
		BufferedImage image = new BufferedImage(Constants.width, Constants.height, BufferedImage.TYPE_INT_RGB);
		
		long start = System.nanoTime();
		for(int y=0; y<Constants.height; y++){
			for(int x=0; x<Constants.width; x++){
				Vector horizontalDisplacement = camera.getRight().multiply((double)(x - 640) * 2 / 1422);
				Vector verticalDisplacement = camera.getDown().multiply((double)(y - 360) * 2 / 1440);
				Vector rayScreenPoint = camera.getPosition().add(camera.getLookAt()).add(horizontalDisplacement).add(verticalDisplacement);
				Vector rayDirection = rayScreenPoint.subtract(camera.getPosition()).normalize();
				
				Ray currentRay = new Ray(camera.getPosition(), rayDirection);
				
				MyColor currentColor = backgroundColor;
				
				Vector collisionPlane = plane1.checkCollision(currentRay);
				Vector collisionSphere = null;
				
				Sphere activeSphere = null;
				
				for(Sphere currentSphere : spheres){
					if(collisionSphere == null){
						if(currentSphere.checkCollision(currentRay) != null){
							collisionSphere = currentSphere.checkCollision(currentRay);
							activeSphere = currentSphere;
						}
					} else {
						double dist = 999999999;
						if(currentSphere.checkCollision(currentRay) != null)
							dist = currentSphere.checkCollision(currentRay).subtract(camera.getPosition()).length();
						if(dist < collisionSphere.subtract(camera.getPosition()).length()){
							collisionSphere = currentSphere.checkCollision(currentRay);
							activeSphere = currentSphere;
						}
					}						
				}
				
				double distanceToPlane = -1;
				double distanceToSphere = -1;
				
				if(collisionSphere != null)
					distanceToSphere = collisionSphere.subtract(camera.getPosition()).length();
				if(collisionPlane != null)
					distanceToPlane = collisionPlane.subtract(camera.getPosition()).length();
				
				if(distanceToPlane >= 0 && distanceToSphere == -1){ // ONLY PLANE
						currentColor = ColorUtil.getColorForPoint(plane1.getColor(), plane1.getNormal(), currentRay, source1, collisionPlane, spheres, activeSphere);
				}
				
				if(distanceToPlane == -1 && distanceToSphere >= 0){ // ONLY SPHERE
						currentColor = ColorUtil.getColorForPoint(activeSphere.getColor(), activeSphere.getNormalAtPoint(collisionSphere), currentRay, source1, collisionSphere, spheres, activeSphere);
				}
				
				if(distanceToPlane >= 0 && distanceToSphere >= 0){ //BOTH
					if(distanceToPlane < distanceToSphere){
							currentColor = ColorUtil.getColorForPoint(plane1.getColor(), plane1.getNormal(), currentRay, source1, collisionPlane, spheres, activeSphere);
					} else {
							currentColor = ColorUtil.getColorForPoint(activeSphere.getColor(), activeSphere.getNormalAtPoint(collisionSphere), currentRay, source1, collisionSphere, spheres, activeSphere);
					}
				}
				
				//FILL THE IMAGE
				int rgb = (currentColor.getRed() << 16) | (currentColor.getGreen() << 8 | currentColor.getBlue());
				
				image.setRGB(x, y, rgb);
			}
		}
		long end = System.nanoTime();
		System.out.println((end - start) / 1000000000f);
		return image;
	}
	
	public void paint(Graphics g){
		g.setColor(new Color(255, 255, 255));
		g.drawImage(generateImage(), 0, 0, null);
		main.requestFocus();
	}
	
	public void updateCamera(double direction){
		
		camPos = camPos.add(new Vector(direction, 0, 0));
		camLookAt = camTarget.subtract(camPos).normalize();
		camRight = Constants.j.crossProduct(camLookAt).normalize();
		camDown = camRight.crossProduct(camLookAt).normalize();
		
		camera.setPosition(camPos);
		camera.setLookAt(camLookAt);
		camera.setDown(camDown);
		camera.setRight(camRight);
		System.out.println("update!!");
		repaint();
	}
	
}

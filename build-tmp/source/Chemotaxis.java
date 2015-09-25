import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Chemotaxis extends PApplet {

 //declare bacteria variables here   
Bacteria [] johns;
 public void setup()   
 {   
 	background(0);
 	size(500,500);  
 	frameRate(70);
 	johns = new Bacteria[800];
 	for(int jNum=0; jNum<johns.length; jNum++)
 	{
 		johns[jNum] = new Bacteria((int)(Math.random()*700)-100,(int)(Math.random()*700)-100);
 	}  
 }   
 public void draw()   
 {
 	fill(0,0,0,75);
 	rect(0,0,500,500);
 	for(int jNum=0; jNum<johns.length; jNum++)
 	{
 		johns[jNum].walk();
  		johns[jNum].show();
  		johns[jNum].fusion(); 
 	}
 }  
 
 class Bacteria    
 { 
 	int myX,myY, myColor;
 	Bacteria(int x, int y)
 	{
 		myX=x;
 		myY=y;
 		myColor = color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255));
 	}
 	public void show()
 	{
 		fill(myColor);
 		ellipse(myX,myY,10,10);
  	}

  	public void walk()
  	{
  		myX = myX + (int)(Math.random()*3)-1;
  		myY = myY + (int)(Math.random()*3)-1;
  	}	

    public void fusion()
    {
 	  if(mousePressed == true)
 	   {
 	    if(mouseX > myX)
 	     {
 		   myX += 2;
 	     } 
 	     if(mouseX < myX)
 	     {
 		   myX -= 2;
 	     } 
 	     if(mouseY < myY)
 	     {
 		   myY -= 2;
 	     } 
 	     if(mouseY > myY)
 	     {
 		   myY += 2;
 	     } 
     }
     if(mousePressed == false)
 	   {
 	    if(mouseX > myX)
 	     {
 		   myX -= 1.5f;
 	     } 
 	     if(mouseX < myX)
 	     {
 		   myX += 1.5f;
 	     } 
 	     if(mouseY < myY)
 	     {
 		   myY += 1.5f;
 	     } 
 	     if(mouseY > myY)
 	     {
 		   myY -= 1.5f;
 	     } 
     }
   }
}    
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Chemotaxis" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}

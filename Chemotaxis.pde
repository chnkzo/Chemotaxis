 //declare bacteria variables here   
Bacteria [] johns;
 void setup()   
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
 void draw()   
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
 	void show()
 	{
 		fill(myColor);
 		ellipse(myX,myY,10,10);
  	}

  	void walk()
  	{
  		myX = myX + (int)(Math.random()*3)-1;
  		myY = myY + (int)(Math.random()*3)-1;
  	}	

    void fusion()
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
 		   myX -= 1.5;
 	     } 
 	     if(mouseX < myX)
 	     {
 		   myX += 1.5;
 	     } 
 	     if(mouseY < myY)
 	     {
 		   myY += 1.5;
 	     } 
 	     if(mouseY > myY)
 	     {
 		   myY -= 1.5;
 	     } 
     }
   }
}    

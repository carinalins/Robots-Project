/*Xmas project by JennyTrainor

coded by @carinalins (:

This is my BluePrint.
*/

import processing.core.PApplet;

public class Robots extends PApplet{

	int colour;
	float xPos1;
	float yPos1;
	float xPos2;
	float yPos2;
	float xPos3;
	float yPos3;
	float xSpeed;
	float ySpeed;
	float xSpeedCharlie;
	float ySpeedCharlie;
	float centroidX;
	float centroidY;
	float xLen1;
	float xLen2;
	float xLen3;
	float yLen1;
	float yLen2;
	float yLen3;
	boolean alive1;
	boolean alive2;
	boolean alive3;
	
	boolean scWidth;
	boolean scHeight;
	boolean scX;
	boolean scY;
	
	int randomNum;

	PApplet parent;
	/*in my Constructor i define the positions/coordinates for each method that will be applied along the code,
	I created some booleans statments to check if the first, second and third robots are "alive", in other words, giving a life to them to start moving on screen
	PLEASE NOTE: if i change my boolean statment to false (on my main method) it will not move, or not have a "life".
	I'm also importing the Processing library to use the random function for BOB. :)
	*/
	public Robots(PApplet p, int colour, float xPos1, float yPos1, float xPos2,	float yPos2, float xPos3, float yPos3, boolean alive1, boolean alive2, boolean alive3){
		parent = p;
		this.colour = colour;
		this.xPos1 = xPos1;
		this.yPos1 = yPos1;
		this.xPos2 = xPos2;
		this.yPos2 = yPos2;
		this.xPos3 = xPos3;
		this.yPos3 = yPos3;
		this.alive1 = alive1;
		this.alive2 = alive2;
		this.alive3 = alive3;
		this.xSpeedCharlie=1;
		this.ySpeedCharlie=1;
		//calculating the center of triangles
		this.centroidX=(xPos1+xPos2+xPos3)/3;
		this.centroidY=(yPos1+yPos2+yPos3)/3;
		//re-drawing my triangle 
		this.xLen1=centroidX-xPos1;
		this.yLen1=centroidY-yPos1;
		this.xLen2= xPos2-centroidX;
		this.yLen2= yPos2-centroidY;
		this.xLen3=centroidX-xPos3;
		this.yLen3=yPos3-centroidY;
		//defining 8 diferents directions for BOB
		this.randomNum=round(random(1,8));
		

	}

	public void display(){
		//drawing my triangles for the output on screen
		parent.noStroke();
		parent.fill(colour);

		parent.triangle(xPos1, yPos1, xPos2, yPos2, xPos3, yPos3);
		parent.fill(0);
		parent.ellipse(xPos1,yPos1,3,3);
	}

	public void speed(){
		//giving a certain speed for all coordinates
		centroidX = centroidX + xSpeed;
		centroidY = centroidY + ySpeed;

		xPos1 = xPos1 + xSpeed;
		xPos2 = xPos2 + xSpeed;
		xPos3 = xPos3 + xSpeed;

		yPos1 = yPos1 + ySpeed;
		yPos2 = yPos2 + ySpeed;
		yPos3 = yPos3 + ySpeed;
	}

	//the following 8 methods are giving diferent directions for my triangles with a given speed,
	//in case of changing the speed of them it must be done here.
	public void up(){ 
		xSpeed=0;
		ySpeed=-1;
	}

	public void down(){
		xSpeed=0;
		ySpeed=1;
	}

	public void right(){
		xSpeed=1;
		ySpeed=0;
	}

	public void left(){
		xSpeed=-1;
		ySpeed=0;
	}

	public void rightDown(){
		xSpeed=1;
		ySpeed=1;
	}

	public void upLeft(){
		xSpeed=-1;
		ySpeed=-1;
	}

	public void downLeft(){
		xSpeed=-1;
		ySpeed=1;
	}

	public void upRight(){
		xSpeed=1;
		ySpeed=-1;
	}

	public void screenSize(){

		if(xPos1>=parent.width-20){
			scWidth=true;
		}else{
			scWidth=false;
		}
		if(yPos1>=parent.height-20){
			scHeight=true;
		}else{
			scHeight=false;
		}
		if(yPos1<=0+20){
			scX=true;
		}else{
			scX=false;
		}
		if(xPos1<=0+20){
			scY=true;
		}else{
			scY=false;
		}


	}

	public void turnRight(){ // 90 clockwise
		
		xPos1 = centroidX + yLen1;
		yPos1 = centroidY + xLen1;

		xPos2 = centroidX - yLen2;
		yPos2 = centroidY - xLen2;

		xPos3 =centroidX - yLen3;
		yPos3 = centroidY + xLen3;

	}

	public void turnLeft(){ //90 anticlockwise
		
		xPos1 = centroidX - yLen1;
		yPos1 = centroidY - xLen1;

		xPos2 = centroidX + yLen2;
		yPos2 = centroidY + xLen2;

		xPos3 =centroidX + yLen3;
		yPos3 = centroidY - xLen3;

	}

	public void turnDown(){ //180 degrees
		
		xPos1 = centroidX;
		yPos1 = centroidY + yLen1;

		xPos2 = centroidX + xLen2;
		yPos2 = centroidY - yLen2;

		xPos3 =centroidX - xLen3;
		yPos3 = centroidY - yLen3;

	}

	public void turnUp(){ //360 degrees or original position
		
		xPos1 = centroidX;
		yPos1 = centroidY-yLen1;

		xPos2 = centroidX-xLen2;
		yPos2 = centroidY+yLen2;

		xPos3 = centroidX+xLen3;
		yPos3 = centroidY+yLen3;

	}
	
	public void alice(){
			//we first check if Alice is alive with this loop.
			while(alive1==true){
				
			//because i drew my triangle in the middle of screen I start checking if it is in the middle of screen before to start moving.
			if(scHeight!=true&&scWidth!=true&&scX!=true&&scY!=true){
				right();
			}

			if(scWidth==true) {
				turnDown();
				down();
				
			}

			if(scHeight==true) {
					centroidY=parent.height-20;
					turnLeft();
					left();

			}

			if (xPos1<=0) {
				centroidX=20;
				turnUp();

				up();
			
			}
			if (scX==true&&scWidth!=true) {
				turnRight();
				right();
			}

			break;	
			}	
		}


		/*This is my second robot BOB which will be able to do a random walk
		*/
		public void randomWalk(){
			
			//checking if BOB is alive
			while(alive2==true){
								
						//defining the random positions he can have. In total=8 diferent positions.
						if(randomNum==1){
							turnRight();
							right();
												
						} else if (randomNum==2){
							turnDown();
							down();
													
						} else if (randomNum==3) {
							turnLeft();
							left();
									
						} else if (randomNum==4) {
							turnUp();
							up();
												
						} else if (randomNum==5) {
							
							rightDown();
							
						} else if (randomNum==6) {
							
							upLeft();
							
						} else if (randomNum==7) {
							downLeft();
							
						} else if (randomNum==8) {
							upRight();
							
						}
						// checking right edge of screen
						if(centroidX>=parent.width-12) {
						randomNum = round(random(1,8));
						}
						//checking bottom edge of screen
						if(yPos1>=parent.height-8) {
							turnUp();
							upRight();
						randomNum = round(random(1,8));

						}
						//checking left edge of screen
						if(xPos1<=12) {
						turnRight();
						right();
						randomNum = round(random(1,8));
			
						}
						//checking top edge of screen
						if(yPos1<=12) {

						randomNum = round(random(1,8));
						}
						//top right corner
						if (centroidX>=parent.width-12&&centroidY<=0) {
							turnLeft();
							downLeft();
							randomNum = round(random(1,8));
						}
						//bottom right corner 
						if (centroidY>=parent.height-12&&centroidX>=parent.width-12) {
							turnLeft();
							upLeft();
							randomNum = round(random(1,8));
							
						}
						//bottom left corner
						if (centroidY>=parent.height-12&&centroidX<=0) {
							turnUp();
							upRight();
							randomNum = round(random(1,8));
							
						}
						//top left corner
						if (centroidY<=0&&centroidX<=0){
							turnRight();
							rightDown();
							randomNum = round(random(1,8));
						} 

						break;
			}
		}


		/*This is my third Robot Charlie which will be controlled by keyboard and not able to leave the screen
		if you want to STOP the robot press "SHIFT" and then press one of the arrows again to continue the walk.

		*/
		public void controledByArrows(){
			while(alive3==true){
				
				if (parent.keyCode == parent.UP && yPos1>=0+12) {
					turnUp();
					goingUp();
					
				} else if (parent.keyCode == parent.DOWN && yPos1<=parent.height-3) {
					turnDown();
					goingDown();			

				} else if (parent.keyCode == parent.RIGHT && xPos3<=parent.width-20) {
					turnRight();
					goingRight();
	

				} else if (parent.keyCode == parent.LEFT && xPos2>=0+20) {
					turnLeft();
					goingLeft();
				}

			break;
			}
				
					
		}
		// i have decided to do different methods to move Charlie on screen (i know i could have less lines of code if i did in only one method)
		// because I didnt want my code to be the same of most codes that I found on my research.
		public void goingRight(){

					xPos1 += xSpeedCharlie;
					xPos2 += xSpeedCharlie;
					xPos3 += xSpeedCharlie;
					centroidX += xSpeedCharlie; //moving the centroid as well
		}

		public void goingUp(){
					yPos1 -= ySpeedCharlie;
					yPos2 -= ySpeedCharlie;
					yPos3 -= ySpeedCharlie;
					centroidY -= ySpeedCharlie;
		}
		public void goingDown(){
					yPos1 += ySpeedCharlie;
					yPos2 += ySpeedCharlie;
					yPos3 += ySpeedCharlie;
					centroidY += ySpeedCharlie;
		}
		public void goingLeft(){
					xPos1 -= xSpeedCharlie;
					xPos2 -= xSpeedCharlie;
					xPos3 -= xSpeedCharlie;
					centroidX -= xSpeedCharlie;
		}

}
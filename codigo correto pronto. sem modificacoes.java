/*checking if robot Alice can turn 360 degrees

@carinakkls (:

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
	float xSpeed=0;
	float ySpeed=0;
	float xSpeedBob=0;
	float ySpeedBob=0;
	float xSpeedCharlie=1;
	float ySpeedCharlie=1;
	float centroidX=(xPos1+xPos2+xPos3)/3;
	float centroidY=(yPos1+yPos2+yPos3)/3;
	float centroidXCo1=centroidX+xPos1+yPos1;
	float centroidXCo2;
	float centroidXCo3;
	
	float sizeBall;
	float circBall;
	float scSizeX;
	float scSizeY;
	float scSizeWidth;
	float scSizeHeight;
	PApplet parent;
	boolean scWidth = false;
	boolean scHeight = false;
	boolean scX = false;
	boolean scY = false;
	boolean alive1 = false;
	boolean alive2 = false;
	boolean alive3 = false;
	int randomNum=round(random(1,4));

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
		

	}

	public void display1(){
		
		parent.noStroke();
		//drawing the first robot Alice
		parent.fill(colour);
		parent.triangle(xPos1, yPos1, xPos2, yPos2, xPos3, yPos3);
		parent.fill(0);
		parent.ellipse(xPos1,yPos1,3,3);
	}

	public void display2(){
		//drawing the second robot Bob
		parent.fill(colour);
		parent.triangle(xPos1,yPos1,xPos2,yPos2,xPos3,yPos3);
		parent.fill(0);
		parent.ellipse(xPos1,yPos1,3,3);
	}

	public void display3(){
		//drawing the third robot Charlie
		parent.fill(colour);
		parent.triangle(xPos1,yPos1,xPos2,yPos2,xPos3,yPos3);
		parent.fill(0);
		parent.ellipse(xPos1,yPos1,3,3);

	}

	public void speed(){
		xPos1 = xPos1 + xSpeed;
		xPos2 = xPos2 + xSpeed;
		xPos3 = xPos3 + xSpeed;

		yPos1 = yPos1 + ySpeed;
		yPos2 = yPos2 + ySpeed;
		yPos3 = yPos3 + ySpeed;
	}

	public void stop(){
		alive2=false;
		xSpeed=0;
		ySpeed=0;
	}


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

	public void screenSize(){

		if(xPos1>=parent.width-12){
			scWidth=true;
		}else{
			scWidth=false;
		}
		if(yPos1>=parent.height-12){
			scHeight=true;
		}else{
			scHeight=false;
		}
		if(xPos1<=0+12){
			scX=true;
		}else{
			scX=false;
		}
		if(yPos1<=0+12){
			scY=true;
		}else{
			scY=false;
		}


	}

	public void turnRight(){
		

	}
	
	public void alice(){
			
			while(alive1==true){
		
			if(scHeight!=true&&scWidth!=true&&scX!=true&&scY!=true){
				up();
			}
			if(scWidth==true&&scY==true) {
				down();
				
			}

			if(scHeight==true) {
			left();
			
			}
			if (scX==true) {
			up();
			
			}
			if (scY==true&&scWidth!=true) {
			right();
			}
		System.out.println("width"+scWidth);
		System.out.println("Height"+scHeight);
		System.out.println("X"+scX);
		System.out.println("Y"+scY);
		System.out.println("X1 = "+ xPos1 + " Y1 = " +yPos1);
				System.out.println("X2 = "+ xPos2 + " Y2 = " +yPos2);
				System.out.println("X3 = "+ xPos3 + " Y3 = " +yPos3);
		
			//continue;
			break;	
			}	
		}

		public void randomWalk(){
			
			
			while(alive2==true){
					//cheking up side of the screen (the y coordinate)
				/*if (xPos1>=1 && xPos1<=parent.width-12 && yPos1>=1 && yPos1<=12 &&
					xPos2>=1 && xPos2<=parent.width-12 && yPos2>=1 && yPos2<=12 &&
					xPos3>=1 && xPos3<=parent.width-12 && yPos3>=1 && yPos3<=12) {
					randomNum = round(random(1,4));
					yPos1 +=1;
					//random walk probarly to the right 
				} else if (xPos1>=parent.width-11 && xPos1<=parent.width && yPos1>=1 && yPos1<=parent.height-12 &&
					xPos2>=parent.width-11 && xPos2<=parent.width && yPos2>=1 && yPos2<=parent.height-12 &&
					xPos3>=parent.width-11 && xPos3<=parent.width && yPos3>=1 && yPos3<=parent.height-12) {
					randomNum = round(random(1,4));
					xPos1 -=1;
					//cheking down side of the screen (the height)
				} else if (xPos1>=13 && xPos1<=parent.width && yPos1 >= parent.height-11 && yPos1<=parent.width &&
					xPos2>=13 && xPos2<=parent.width && yPos2>=parent.height-11 && yPos2<=parent.width &&
					xPos3>=13 && xPos3<=parent.width && yPos3>= parent.height-11 && yPos3<=parent.width) {
					randomNum = round(random(1,4));
					yPos1 -= 1;
					//random walk probarly to the left
				} else if (xPos1>=1 && xPos1<= 12 && yPos1<=parent.height && yPos1>=13 &&
					xPos2>=1 && xPos2<= 12 && yPos2<= parent.height && yPos2>=13 &&
					xPos3>=1 && xPos3<= 12 && yPos3<= parent.height && yPos3>=13) {
					round(random(1,4));
					xPos1 += 1;
				}*/

				
					
						if(randomNum==1){
							right();
												
						} else if (randomNum==2){
							down();
													
						} else if (randomNum==3) {
							left();
									
						} else if (randomNum==4) {
							up();
												
						}

						
					//if (scSizeHeight<= parent.height-12 && scSizeWidth<= parent.width-12 && scSizeX>=0 && scSizeY>=0) {
						//randomNum=4;
						
						if (scY==true) {

							randomNum = round(random(1,4));
								/*yPos1 += ySpeed;
								yPos2 += ySpeed;
								yPos3 += ySpeed;
								xPos1 += xSpeed;
								xPos2 += xSpeed;
								xPos3 += xSpeed;*/


							
							//alive2=true;
					
						}
											
					//}

					if(scWidth==true) {
						xPos1 -= 1;
						xPos2 -= 1;
						xPos3 -= 1;
						/*yPos1 -= 1;
						yPos2 -= 1;
						yPos3 -= 1;*/
						randomNum = round(random(1,4));
					
					}

					if(scHeight==true){
							/*xPos1 -= 1;
							xPos2 -= 1;
							xPos3 -= 1;*/
							yPos1 -= 1;
							yPos2 -= 1;
							yPos3 -= 1;
						randomNum = round(random(1,4));
					

					}
					if (scX==true) {
							xPos1 += 1;
							xPos2 += 1;
							xPos3 += 1;
							/*yPos1 += 1;
							yPos2 += 1;
							yPos3 += 1;*/
						randomNum = round(random(1,4));
						
				
			
					}
					

					if (scHeight==true && scX == true) {
							/*xPos1 += 1;
							xPos2 += 1;
							xPos3 += 1;
							yPos1 -= 1;
							yPos2 -= 1;
							yPos3 -= 1;*/
						randomNum = round(random(1,4));
						
					}

					if (scX==true && scY==true) {
							/*xPos1 += 1;
							xPos2 += 1;
							xPos3 += 1;
							yPos1 += 1;
							yPos2 += 1;
							yPos3 += 1;*/
						randomNum = round(random(1,4));
						
					}

					if (scY==true && scWidth==true) {
							/*xPos1 -= 1;
							xPos2 -= 1;
							xPos3 -= 1;
							yPos1 += 1;
							yPos2 += 1;
							yPos3 += 1;*/
						randomNum = round(random(1,4));
						
					}

					if (scWidth==true && scHeight==true) {
							/*xPos1 -= 1;
							xPos2 -= 1;
							xPos3 -= 1;
							yPos1 -= 1;
							yPos2 -= 1;
							yPos3 -= 1;*/
						randomNum = round(random(1,4));
						
					}


						break;
			}
		}

		public void controledByArrows(){
		
			while(alive3==true){
					
				/*if (parent.keyPressed==true) {
						if (key == parent.UP) {
      					yPos1 -= ySpeedCharlie;
						yPos2 -= ySpeedCharlie;
						yPos3 -= ySpeedCharlie;

    					} else if (key == parent.DOWN){

    					yPos1 += ySpeedCharlie;
						yPos2 += ySpeedCharlie;
						yPos3 += ySpeedCharlie;
		
						} else if (key == parent.RIGHT) {
							xPos1 += xSpeedCharlie;
							xPos2 += xSpeedCharlie;
							xPos3 += xSpeedCharlie;
							
						} else if (key == parent.LEFT) {

							xPos1 -= xSpeedCharlie;
							xPos2 -= xSpeedCharlie;
							xPos3 -= xSpeedCharlie;
							
						}
					}*/
				
			
				if (parent.keyCode == parent.UP && yPos1>=0+12) {
					yPos1 -= ySpeedCharlie;
					yPos2 -= ySpeedCharlie;
					yPos3 -= ySpeedCharlie;


					
				} else if (parent.keyCode == parent.DOWN && yPos2<=parent.height && yPos3<=parent.height) {
					yPos1 += ySpeedCharlie;
					yPos2 += ySpeedCharlie;
					yPos3 += ySpeedCharlie;

			

				} else if (parent.keyCode == parent.RIGHT && xPos3<=parent.width) {
					xPos1 += xSpeedCharlie;
					xPos2 += xSpeedCharlie;
					xPos3 += xSpeedCharlie;

				} else if (parent.keyCode == parent.LEFT && xPos2>=0) {
					xPos1 -= xSpeedCharlie;
					xPos2 -= xSpeedCharlie;
					xPos3 -= xSpeedCharlie;

						
				}


					
				
			
			break;
			}
				
					
		}
}
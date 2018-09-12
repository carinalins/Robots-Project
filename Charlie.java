import processing.core.PApplet;

public class Charlie extends PApplet{

	int colour;
	float xPos1;
	float yPos1;
	float xPos2;
	float yPos2;
	float xPos3;
	float yPos3;
	float xSpeed=1;
	float ySpeed=1;
	PApplet parent;
	float scSizeX;
	float scSizeY;
	float scSizeWidth;
	float scSizeHeight;


	public Charlie(PApplet p, int colour, float xPos1, float yPos1, float xPos2, float yPos2, float xPos3, float yPos3){
		parent = p;
		this.colour = colour;
		this.xPos1 = xPos1;
		this.yPos1 = yPos1;
		this.xPos2 = xPos2;
		this.yPos2 = yPos2;
		this.xPos3 = xPos3;
		this.yPos3 = yPos3;
		
		
	}

		public void display(){
		
		//parent.noStroke();
		//drawing the first robot Charlie
		parent.fill(colour);
		parent.triangle(xPos1, yPos1, xPos2, yPos2, xPos3, yPos3);
		parent.fill(0);
		parent.ellipse(xPos1,yPos1,3,3);
		}


		public void controledByArrows(){
		
			//if (xSpeed>0 && ySpeed>0) {
				
			
				if (parent.keyCode == parent.UP) {
					yPos1 -= ySpeed;
					yPos2 -= ySpeed;
					yPos3 -= ySpeed;

					
				} else if (parent.keyCode == parent.DOWN) {
					yPos1 += ySpeed;
					yPos2 += ySpeed;
					yPos3 += ySpeed;

			

				} else if (parent.keyCode == parent.RIGHT) {
					xPos1 += xSpeed;
					xPos2 += xSpeed;
					xPos3 += xSpeed;

				} else if (parent.keyCode == parent.LEFT) {
					xPos1 -= xSpeed;
					xPos2 -= xSpeed;
					xPos3 -= xSpeed;

						
				}

				
					
				}

				

}

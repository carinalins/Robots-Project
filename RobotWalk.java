import processing.core.PApplet;

public class RobotWalk extends PApplet{

	int quantity = 3; //how many flakes
	int colour = 255;
	float[] xPosition = new float[quantity];
	float[] yPosition = new float[quantity];
	int[] robSize = new int[quantity];
	int minRobSize = 1;
	int maxRobSize = 5;
	int[] direction = new int[quantity];
	PApplet parent;


	public static void main(String[] args) {
		PApplet.main("RobotWalk");
	}

	public void settings(){
		size(1000,500);
	}

	public void setup(){
		for(int i=0; i<quantity; i++){
			xPosition[i] = random(0, width);
			yPosition[i] = random(0, height);
			robSize[i] = round(random(minRobSize, maxRobSize));
			round(random(0,1));
			// random (a,b) picks a random number between a and b

		}
	}


	public void draw(){
		background(0);
		
		for(int i=0; i<xPosition.length; i++){
			fill(colour);
			triangle(xPosition[i], yPosition[i], xPosition[i], yPosition[i], xPosition[i], yPosition[i]);
			//flakes fall so uptade the y position not x

			yPosition[i] += robSize[i];

			//check if flakes fall off screen
			if(yPosition[i] > height + 5){
				//yPosition[i] = -flakeSize[i]; //redraw them at the top

				if(direction[i] == 0){
				//xPosition[i] += (float)flakeSize[i]/10;

				} else {
				xPosition[i] -= (float)robSize[i]/10;
				}
			}
			if(xPosition[i]>width+robSize[i] || xPosition[i]<robSize[i] || yPosition[i]>height + robSize[i]){

				xPosition[i] = random(0,width);
				yPosition[i] = -robSize[i];

			}

			//yPosition[i] += flakeSize[i];
		}

	}
}

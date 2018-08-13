/*Xmas project by JennyTrainor

coded by @carinalins (:

This is my Main Method.

*/

import processing.core.PApplet;

public class UseRobots extends PApplet{

		Robots[] robs;

		public static void main(String[] args) {
		
		PApplet.main("UseRobots");

		}

		public void settings(){
			size(500,500);
		}
		/*setting up the robots on screen with a given width, height, speed to check is they are "alive", i have created some booleans statments
		so they can walk*/
	public void setup(){
		robs = new Robots[3];
		//first Robot is Alice and it is GREEN.
		robs[0] = new Robots(this, color(0,255,0),width/2,height/2,width/2-20,height/2+20,width/2+20,height/2+20,true, false, false);
		//second Robot is BOB and it is RED.
		robs[1] = new Robots(this, color(255,0,0), width/3, height/3, width/3-15,height/3+15,width/3+15,height/3+15,false, true, false);
		//third Robot is Charlie and it is BLUE. Please remember to click on Processing Screen before to activate the keyboard.
		robs[2] = new Robots(this, color(0,0,255), width/2, height/2, width/2-10,height/2+10,width/2+10,height/2+10,false, false, true); 
		
	}

	public void draw(){
		background(255);
		for(int i=0; i<robs.length; i++){

			robs[i].speed();
			robs[i].display();
			robs[i].screenSize();

		}
			robs[0].alice();
			robs[1].randomWalk();
			robs[2].controledByArrows();
			
	}
	
}

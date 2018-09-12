import processing.core.PApplet;

public class UseCharlie extends PApplet{

		Charlie[] c;

		public static void main(String[] args) {
		
		PApplet.main("UseCharlie");

		}

		public void settings(){
			size(1000,500);
		}

	public void setup(){
		c = new Charlie[1];

		
		c[0] = new Charlie(this, color(0,0,255), width/2, height/2, width/2-10,height/2+10,width/2+10,height/2+10);
		
	}

	public void draw(){
		background(255);
		for(int i=0; i<c.length; i++){

			c[i].display();
			c[i].controledByArrows();
			//c[i].charlie();
		}
	}
}
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

public class garage extends PApplet {

Robot bob, alice, charlie;
public void setup(){
  
  bob = new Patrol(0,-45,45,0,0,45,250,250);
  alice = new Patrol(0,-45,45,0,0,45,60,60);
  charlie = new Patrol(0,-45,45,0,0,45,400,400);
}
public void draw(){
  background(255);
  bob.display(new Robot[]{alice,charlie});
  alice.display(new Robot[]{bob,charlie});
  charlie.display(new Robot[]{alice,bob});
}
class Patrol extends Robot {
  Boolean colision;
  int backCount;
  Patrol(float x1,float y1,float x2,float y2,float x3,float y3, float x, float y){
      this.x1 = x1;
      this.y1 = y1;
      this.x2 = x2;
      this.y2 = y2;
      this.x3 = x3;
      this.y3 = y3;
      this.x = x;
      this.y = y;
      this.movingX = 0;
      this.movingY = 0;
      this.colision = false;
      backCount = 0;
  }
  public boolean checkColision(Robot[] robots){
    if(!colision){
      if(width < this.x+45 && this.movingX > 0){
          colision = true;
        }else
        if(0 > this.x-45 && this.movingX < 0){
          colision = true;
        }else 
        if(height < this.y+45 && this.movingY > 0){
          colision = true;
        }else
        if(0 > this.y-45 && this.movingY < 0){
          colision = true;
        }
       for(int i = 0;i< robots.length;i++){
         Robot robot = robots[i];
         if((robot.x >= this.x-45 && robot.x <= this.x+45) && (robot.y >= this.y-45 && robot.y <= this.y+45)){
            colision = true; 
         }
       }
    }
   return false; 
  }
  public @Override
  void display(Robot[] robots){
    checkColision(robots);
    pushMatrix();
    translate(this.x,this.y);
    triangle(this.x1,this.y1,this.x2,this.y2,this.x3,this.y3);
    popMatrix();
    if(!colision){
      
      if(this.movingX == 0 && this.movingY == 0){
          this.movingX = 1;
      }
      move(this.movingX,this.movingY);
    }else{
      move(this.movingX*(-1),this.movingY*(-1));
      backCount++;
      if(backCount > 40){
         backCount = 0;
         colision = false;
          float r = random(2);
          if(r > 1){
            turnRight(); 
          }else{
            turnLeft();
          }
      }
    }
  }
}
public abstract class Robot{
  float x1,y1,x2,y2,x3,y3;
  float x,y;
  float movingX, movingY;
  public void move(float x,float y){
    this.x = this.x+x;  
    this.y = this.y+y;
  }
  public void display(Robot[] robots){
    pushMatrix();
    translate(this.x,this.y);
    triangle(x1,y1,x2,y2,x3,y3);
    popMatrix();
  }
  
  public void turnLeft(){
    x3 = x2;
    y3 = y2;
    x2 = x1;
    y2 = y1;
    x1 = x3*(-1);
    y1 = y3*(-1);
    if(this.movingX > 0){
      this.movingX = 0;
      this.movingY = -1;
    }else if(this.movingX < 0){
      this.movingX = 0;
      this.movingY = 1;
    }else if(this.movingY > 0){
      this.movingX = 1;
      this.movingY = 0;
    }else if(this.movingY < 0){
      this.movingX = -1;
      this.movingY = 0;
    }
  }
  public void turnRight(){
    x1 = x2;
    y1 = y2;
    x2 = x3;
    y2 = y3;
    x3 = x1*(-1);
    y3 = y1*(-1);
    if(this.movingX < 0){
      this.movingX = 0;
      this.movingY = -1;
    }else if(this.movingX > 0){
      this.movingX = 0;
      this.movingY = 1;
    }else if(this.movingY < 0){
      this.movingX = 1;
      this.movingY = 0;
    }else if(this.movingY > 0){
      this.movingX = -1;
      this.movingY = 0;
    }
  }
  @Override
  public String toString() {
    return "Robot [\n\tx1=" + x1 + ", \n\ty1=" + y1 + ", \n\tx2=" + x2
        + ", \n\ty2=" + y2 + ", \n\tx3=" + x3 + ", \n\ty3=" + y3
        + ", \n\tx=" + x + ", \n\ty=" + y + ", \n\tmovingX=" + movingX
        + ", \n\tmovingY=" + movingY + "\n]";
  }
}
  public void settings() {  size(600,600); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "garage" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
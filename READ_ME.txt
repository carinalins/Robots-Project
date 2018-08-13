Name: Carina Ferreira Lins
Student number: 2016308

My code does the following:

file 1 "Robots":
This file is my Blue Print.
	
	1. In this file i set the Costructor and I set different methods, such as, display/speed/etc.

In my Constructor I define the positions for each method that will be applied along the code,
I've created some booleans statments to check if the first, second and third robots are "alive", in other words,
giving a life to them to start moving pixels on screen.

	2. In this file I've also created methods for translation of image, rotation and movements.
	Methods to check the boundaries of screen size in addition.

	3. I have 3 different methods for each Robot.
	Alice -> alice(), Bob -> randomWalk() and Charlie -> controledByArrows().

	
file 2 "UseRobots":

	1. This file is where my main method is and where I set up coordinates for each robot on screen
	with a given width, height and speed to check is they are "alive",
	I have created some booleans statments so they can walk.

		PLEASE NOTE: if i change my boolean statment to false (on my main method) it will not move,
		or not have a "life". 

	2. Alice is GREEN.
	   Bob is RED.
	   Charlie is BLUE. NOTE: TO stop Charlie you can press any key.

To compile my code:

	1. Acess the comand line and change the direction to where you have saved the file.
	Don't forget to have the "core.jar" extention on the same folder to import the Processing library. 

	2. Type this to compile both files: javac -cp ".;core.jar" UseRobots.java Robots.java



To run my code:

	1. Type this to start the program: java -cp ".;core.jar" UseRobots

	Don't forget to click on screen of program to activate the keyboard for Charlie. :)

Have fun! :)
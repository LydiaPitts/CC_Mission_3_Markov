# Mission 3: A Markov Distinction
Computational Creativity Lab, description being "Use a Markov chain (or Markov model) to create a piece of visual art that you would find meaningful."

**System Title: Facing Markov**

Lydia Pitts

In this project, I knew the technical elements that needed to be involved -- I needed a Markov Chain and I needed visual Art. As Bowdoin's Offer of the College says, I consider "art an intimate friend," and it is something that I spend a significant ammount of time engaging with. I wanted a way to incorportate my own physical works into my system. People really fascinate me, and that is what I predominately create in my own artistic practices. This inspired you to use elements of my portraits to create a Picasso-esque, computer generated face. I love computer science, and I love doing art, but it is not often that I get to combine these two things in class. Not only was the content I chose meaningful to me, but the languages are as well. This summer I took two very short LinkedIn learning course in html and css, but I had never actually had the time to use them. It took a lot of time to re-learn the syntax and how to implement these languages. I have no idea what I want careerpath I want to follow, so to practice a little bit of full-stack work helps me learn not only what I like/don't like, but allows me to practice skills that give me the most autonomy in the future.

The challenge of multiple, and new, languages as well as applying concepts I knew to execute concepts I was learning, really pushed me as a computer scientist. It was important for me to know I understood the concept of a Markov Chain, so I hoped to explore this concept in Java -- a language familar to me. This familiarity allowed me to practice taking out a pencil and paper, drawing out a diagram and walking through the program before I started coding. This familiarity let me step away from my nervous habit of over-googling, and build good habits of really thinking through and crafting my approach. I pushed myself out of my comfort zome to create the visual represenation. It was important to me to use some skills that I struggled with before, and try something totally knew. Due to not knowing javascript, or how to extend beyond html/css, it took an imense amount of problemsolving. I know this is an area I have to improve uppon, and this is potential next steps for me (not necessarily in this class, but certainly in the future). 

Overall I was challenged in a very meaningful way throughout Mission 3!

**Is This System Creative?**


**Code Description**

This system creates html files to display images from sections my own artwork in the representation of a face. The images themselves can be found in the Images folder where they are separated into their categories: Eyes, Nose, and Mouth. 

Mission3.java is Java code that utilizes a Markov Chain in order to select which images to use for each facial feature (Left eye, right eye, nose and mouth), and then produces the display html files. Each feature's selection process relates to the previous selected feature. The left eye is the prior, the selection between the right eye images is influenced by what was selected for the left eye, and the nose is indluenced by right eye, and the mouth is influenced by the nose. Each function has clear documentation, and to read through the comments allows one to understand each function as well as the general flow of the program.

Mission3_Formatting.css is purely styling for the html files that are produced by Mission3.java. This is the code that makes the face appear in the order and organization of a face.

Examples Folder is a folder that contains a copy of the images and Mission3_Formatting.css (so that the filepath can reach the images and has the formatting availible), as well as File0.html-file5.html. These html files are examples of outputs from my system, and can be viewed in the browser.

Demo Folder contains a screen recording of myself walking through and running my code.


**Set Up and Run This Code**

To begin running this code, you will need an IDE in which you are able to run Java. Simply open the Mission3.java file, and hit run. This program will automatically generate html files. In order to view the html files, I suggest that you use a laptop or desktop with access to a browser. Open the html files in the browser and you can see the representation of a face!


**Works Cited**

- https://howtodoinjava.com/java/io/how-to-create-a-new-file-in-java/
- https://www.java67.com/2015/07/how-to-append-text-to-existing-file-in-java-example.html 
- https://www.youtube.com/watch?v=pV0v_3YRQoM 
- https://www.linkedin.com/learning/css-essential-training-3/optimizing-images-and-retina-displays?u=78048322 
- https://www.linkedin.com/learning/html-essential-training-4/what-is-html?u=78048322


A README file (readable by GitHub) that contains your system documentation.
In addition to describing how to set up and run the code, the documentation should include a title for your system and a description of your work.

Include a discussion of whether you believe your system is creative (and why or why not).
Finally, please make sure to credit your sources, including your peers if you worked with them.


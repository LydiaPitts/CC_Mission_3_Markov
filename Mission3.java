/**
 * Lydia Pitts
 * Mission 3: A Markov Distinction
 * 09/17/20
 * This code creates html files displaying images from sections my own artwork to represent a face.
 * It utilizes a Markov Chain in order to select which images to use for each facial feature (Left eye
 * right eye, nose and mouth) -- Each feature's image selection relates to the previous feature's selection.
 */

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Mission3 {
    /**
     * Get fuction for the array containing strings for the file paths of each eye photo.
     * @return array containing the file paths for each eye photo
     */
    public static String[] eyes (){
        String[] eyes = { "./Images/Eyes/LeftEye1.jpeg",
            "./Images/Eyes/LeftEye2.jpeg",
            "./Images/Eyes/LeftEye3.jpeg",
            "./Images/Eyes/RightEye1.jpeg",
            "./Images/Eyes/RightEye2.jpeg",
            "./Images/Eyes/RightEye3.jpeg"};
        return eyes;
    }

    /**
     * Get fuction for the array containing strings for the file paths of each nose photo.
     * @return array containing the file paths for each nose photo
     */
    public static String[] noses (){
        String[] noses = { "./Images/Nose/Nose1.jpeg",
            "./Images/Nose/Nose2.jpeg",
            "./Images/Nose/Nose3.jpeg",
            "./Images/Nose/Nose4.jpeg"};
        return noses;
    }

    /**
     * Get fuction for the array containing strings for the file paths of each mouth photo.
     * @returnarray containing the file paths for each mouth photo
     */
    public static String[] mouths (){
        String[] mouths = { "./Images/Mouth/Mouth1.jpeg",
        "./Images/Mouth/Mouth2.jpeg",
        "./Images/Mouth/Mouth3.jpeg",
        "./Images/Mouth/Mouth4.jpeg"};
        return mouths;
    }

    /**
     * Finds the specific file path by recieving an array containing file paths of the 
     *  appropriate type of image, and uses in the passed in index to return the path string.
     * @param images containing file paths of either eye, nose, or mouth images
     * @param index integer specifying the index of the correct path in the array 
     * @return String of the file path to an image
     */
    public static String getImagePath (String[] images, int index){
        return images[index];
    }

    /**
     * Generates a random number between 0 and 9. This number can be used for the index of 
     *  a probability array.
     * @return random integer between 0 and 9
     */
    public static int randomNum (){
        int randNum = (int) (Math.random() * 9); 
        return randNum;
    }

    /**
     * Outputs the index to be used on on of the image arrays (found in eyes(), noses(), mouths())
     *  based on probabilities. A probabilityArray is passed in based on the given transition 
     *  matracy -- The indicies of the probabilityArray coorelate to the indeicies of the image array, 
     *  and the integer inside representing the probility of each image being selected based on what 
     *  image was previously displayed. Probabilities are represented in integers instead of decimals
     *  because that number represents the number of times each index will appear in the indexArray.
     *  If probabilityArray[0] = 3 (30% chance of selection), then 0 is put into the indexArray 3 times. 
     *  The indexArray is size 10 because each item has a 10% chance of selection when you idex it with
     *  a random number. This functio inputs the appropriate proportions of the indexes to the image arrays
     *  in indexArray, and selects a random index from that array, and outputs that index.
     * @param probabilityArray array of index probabilites from a transition matrix
     * @return the index to an image array for a selected image
     */
    public static int getIndexFromProbability (int[] probabilityArray){
        int[] indexArray = new int[10];
        int arrayIndex = 0;
        for (int i = 0; i < probabilityArray.length; i++){
            int indexProb = probabilityArray[i];
            while(indexProb > 0){
                indexArray[arrayIndex] = i;
                arrayIndex++;
                indexProb--;
            }
        }
        int index = indexArray[randomNum()];
        return index;
    }

    /**
     * The left eye is the Prior - or the initial state vector, and the output from this initial state.
     *  leftEyeProbability is the same idea as indexArray in getIndexFromProbability(probabilityArray),
     *  and the proccess of selecting/return an index for image array gotten from eyes().
     * @return an index to the eyes() array for the selected image
     */
    public static int eye1 (){
        int[] leftEyeProbability = {0, 1, 1, 1, 2, 2, 2, 4, 3, 5};
        int index = leftEyeProbability[randomNum()];
        return index;
    }

    /**
     * Handles the state change/addition of the right eye. rightEyeProbability is the transition matrix,
     *  where the rows represent the left eye, and the rows represent the right eye. The items inside 
     *  of the array are the probability of each particular image for the right eye being selected given 
     *  that a particular left eye was select. Usually this probability is represented in decimals, but 
     *  for ease of the program (seen in getIndexFromProbability), I muliplied these values by 10. The
     *  input eyeOneIndex points to the row that coorelates with the probabilities given that eyes()[eyeOneIndex]
     *  was the image. These probabilities are is used in getIndexFromProbability(), and the output is the
     *  index used on eyes() to determine the image filepath.
     * @param eyeOneIndex 
     * @return
     */
    public static int eye2 (int eyeOneIndex){
        int[][] rightEyeProbability = {
            {0, 0, 1, 1, 1, 2,},
            {0, 1, 2, 1, 3, 3},
            {1, 1, 1, 2, 3, 2},
            {1, 0, 4, 0, 1, 4},
            {1, 1, 0, 3, 1, 4},
            {1, 1, 1, 2, 2, 1}
        };
        int[] probArray = rightEyeProbability[eyeOneIndex];
        return getIndexFromProbability(probArray);
    }

    /**
     * Handles the state change/addition of the nose. noseProbability is the transition matrix,
     *  where the rows represent the right eye, and the rows represent the nose. The items inside 
     *  of the array are the probability of each particular image for the nose being selected given 
     *  that a particular right eye was select. Usually this probability is represented in decimals, but 
     *  for ease of the program (seen in getIndexFromProbability), I muliplied these values by 10. The
     *  input eyeTwoIndex points to the row that coorelates with the probabilities given that eyes()[eyeTwoIndex]
     *  was the image. These probabilities are is used in getIndexFromProbability(), and the output is the
     *  index used on nose() to determine the image filepath.
     * @param eyeTwoIndex
     * @return
     */
    public static int nose (int eyeTwoIndex){
        int[][] noseProbability = {
            {4, 2, 2, 2},
            {1, 2, 3, 4},
            {1, 2, 2, 5},
            {1, 2, 3, 3},
            {6, 2, 1, 1},
            {3, 4, 2, 1}
        };
        int[] probArray = noseProbability[eyeTwoIndex];
        return getIndexFromProbability(probArray);
    }

    /**
     * Handles the state change/addition of the mouth. mouthProbability is the transition matrix,
     *  where the rows represent the nose, and the rows represent the mouth. The items inside 
     *  of the array are the probability of each particular image for the mouth being selected given 
     *  that a particular nose was select. Usually this probability is represented in decimals, but 
     *  for ease of the program (seen in getIndexFromProbability), I muliplied these values by 10. The
     *  input noseIndex points to the row that coorelates with the probabilities given that nose()[noseIndex]
     *  was the image. These probabilities are is used in getIndexFromProbability(), and the output is the
     *  index used on mouth() to determine the image filepath.
     * @param noseIndex
     * @return
     */
    public static int mouth (int noseIndex){
        int[][] mouthProbability = {
            {1, 3, 4, 2},
            {3, 2, 2, 3},
            {1, 1, 3, 5},
            {1, 1, 2, 6}
        };
        int[] probArray = mouthProbability[noseIndex];
        return getIndexFromProbability(probArray);
    }

    /**
     * A customizable get fuction for the string representation of the display html file.
     * @param eye1 filepath to the selected left eye
     * @param eye2 filepath to the selected right eye
     * @param nose filepath to the selected nose
     * @param mouth filepath to the selected mouth
     * @return String representation of the display html file
     */
    public static String fileString(String eye1, String eye2, String nose, String mouth){
        return "<!DOCTYPE html>" + "\n" + 
        "<html lang=\"en\">"  + "\n" +
        "  <head>"  + "\n" +
        "    <meta charset=\"UTF-8\">" + "\n" + 
        "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">"  + "\n" +
        "    <title>Basic HTML Page</title>"  + "\n" + 
        "    <link rel=\"stylesheet\" href=\"Mission3_Formatting.css\">"  + "\n" +
        "  </head>" + "\n" +
        "  <body>" + "\n" +
        "    <h1>Markov Face</h1>" + "\n" +
        "    <h2>Lydia Pitts: Mission 3</h2>" + "\n" +
        "    <div class=\"Face\"> " + "\n" +
        "        <div class=\"Eyes_Nose\">" + "\n" + 
        "            <img class=\"leftEye\" src=\"" + eye1 + "\"></img>" + "\n" + 
        "            <img class=\"rightEye\" src=\"" + eye2 + "\"></img>" + "\n" + 
        "        </div>" + "\n" + 
        "        <img class=\"nose\" src=\"" + nose + "\"></img>" + "\n" + 
        "        <img class=\"mouth\" src=\"" + mouth + "\"></img>" + "\n" + 
        "    </div>" + "\n" + 
        "  </body>" + "\n" + 
        "</html>"
        ;
    }

    /**
     * Makes a new html file and uses the fileString() function to write to it. Customizes
     *  the filepaths and file name as well. These html files are how to view this code's 
     *  results.
     * @param fileName unused filename for new file
     * @param eye1 filepath to the selected left eye
     * @param eye2 filepath to the selected right eye
     * @param nose filepath to the selected nose
     * @param mouth filepath to the selected mouth
     */
    public static void makeHTML (String fileName, String eye1, String eye2, String nose, String mouth) {
        File file = new File(fileName);
        try {
            if (file.createNewFile()) {
                System.out.println("File is created!");
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        String string = fileString(eye1, eye2, nose, mouth);
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            bw.write(string);
            bw.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * Uses the other functions to get all the images using a Markov Chain and
     *  produces an html file in order to display these images. It iterates 
     *  six times in order to show the variety of outputs it can create.
     */
    public static void main(String[] args) {
        for(int i =0; i <6; i++){
            int eye1 = eye1();
            String eye1_image = getImagePath(eyes(), eye1);

            int eye2 = eye2(eye1);
            String eye2_image = getImagePath(eyes(), eye2);

            int nose = nose(eye2);
            String nose_image = getImagePath(noses(), nose);

            int mouth = mouth(nose);
            String mouth_image = getImagePath(mouths(), mouth);

            String fileName = "File" + i + ".html";
            makeHTML(fileName, eye1_image, eye2_image, nose_image, mouth_image);
        }
    }
}
import javax.swing.ImageIcon;

public class Mission3 {

    public static String[] eyes (){
        String[] eyes = { "./Images/Eyes/LeftEye1.jpeg",
            "./Images/Eyes/LeftEye2.jpeg",
            "./Images/Eyes/LeftEye3.jpeg",
            "./Images/Eyes/RightEye1.jpeg",
            "./Images/Eyes/RightEye2.jpeg",
            "./Images/Eyes/RightEye3.jpeg"};
        return eyes;
    }

    public static String[] noses (){
        String[] noses = { "./Images/Nose/Nose1.jpeg",
            "./Images/Nose/Nose2.jpeg",
            "./Images/Nose/Nose3.jpeg",
            "./Images/Nose/Nose4.jpeg"};
        return noses;
    }

    public static String[] mouths (){
        String[] mouths = { "./Images/Mouth/Mouth1.jpeg",
        "./Images/Mouth/Mouth2.jpeg",
        "./Images/Mouth/Mouth3.jpeg",
        "./Images/Mouth/Mouth4.jpeg"};
        return mouths;
    }


    public static String getImagePath (String[] images, int index){
        return images[index];
    }

    public static int randomNum (){
        int randNum = (int) (Math.random() * 9); 
        return randNum;
    }

    public static int getIndexFromProbability (int[] probabilityArray){
        int[] probArray = new int[10];
        int arrayIndex = 0;
        for (int i = 0; i < probabilityArray.length; i++){
            int indexProb = probabilityArray[i];
            while(indexProb > 0){
                probArray[arrayIndex] = i;
                arrayIndex++;
                indexProb--;
            }
        }
        /**for(int i = 0; i < 10; i++){
            System.out.println(probArray[i]);
        }*/
        int index = probArray[randomNum()];
        return index;
    }


    public static int eye1 (){
        int[] leftEyeProbability = {0, 1, 1, 1, 2, 2, 2, 4, 3, 5};
       /**  for(int i = 0; i < 10; i++){
            System.out.println(leftEyeProbability[i]);
        }*/
        
        //System.out.println(randNum);
        int index = leftEyeProbability[randomNum()];
        return index;
    }

    /**
     * Instead of decimals, each integer represents the probability of each image occuring) 
     * 
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

    public static int nose (int eyeOneIndex){
        int[][] noseProbability = {
            {4, 2, 2, 2},
            {4, 4, 1, 1},
            {2, 1, 2, 5},
            {3, 2, 2, 3},
            {6, 2, 1, 1},
            {3, 4, 2, 1}
        };
        int[] probArray = noseProbability[eyeOneIndex];
        return getIndexFromProbability(probArray);
    }

    public static int mouth (int eyeOneIndex){
        int[][] mouthProbability = {
            {1, 3, 4, 2},
            {3, 2, 2, 3},
            {1, 1, 3, 5},
            {1, 1, 2, 6},
            {4, 1, 4, 1},
            {3, 4, 2, 1}
        };
        int[] probArray = mouthProbability[eyeOneIndex];
        return getIndexFromProbability(probArray);
    }


    /**
     * 
     */
    public static void main(String[] args) {
        int eye1 = eye1();
        String eye1_image = getImagePath(eyes(), eye1);
        System.out.println(eye1_image);
        System.out.println("---------------");

        int eye2 = eye2(eye1);
        String eye2_image = getImagePath(eyes(), eye2);
        System.out.println(eye2_image);
        System.out.println("---------------");

        int nose = nose(eye2);
        String nose_image = getImagePath(noses(), nose);
        System.out.println(nose_image);
        System.out.println("---------------");

        int mouth = mouth(nose);
        String mouth_image = getImagePath(mouths(), mouth);
        System.out.println(mouth_image);
        System.out.println("---------------");

    }

}
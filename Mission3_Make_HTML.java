import java.awt.Canvas;
import java.awt.Graphics;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFrame;

public class Mission3_Make_HTML {

    
    public static void main(String[] args) throws IOException {
        File file = new File("testFile1.html");
        //Create the file
        if (file.createNewFile())
        {
            System.out.println("File is created!");
        } else {
            System.out.println("File already exists.");
        }
        String string = "<div> <h1> Some html </h1></div>";
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            bw.write(string);
            bw.close();
        } catch (IOException e){
            e.printStackTrace();
        }

    }
}

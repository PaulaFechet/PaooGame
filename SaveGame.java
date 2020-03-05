import javax.swing.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.*;
import java.util.ArrayList;

public class SaveGame {


    public class SaveObjects {

        public void afisare() {

// Create some data objects for us to save.
            boolean powerSwitch = true;
            int x = 9, y = 150, z = 675;
            String name = "Galormadron", setting = "on", plant = "rutabaga";
            ArrayList stuff = new ArrayList();
            stuff.add("One");
            stuff.add("Two");
            stuff.add("Three");
            stuff.add("Four");
            stuff.add("Five");

            try {  // Catch errors in I/O if necessary.
// Open a file to write to, named SavedObj.sav.
                FileOutputStream saveFile = new FileOutputStream("C:\\Users\\Paula\\IdeaProjects\\JOC_PAOO\\save");

// Create an ObjectOutputStream to put objects into save file.
                ObjectOutputStream save = new ObjectOutputStream(saveFile);

// Now we do the save.
                save.writeObject(powerSwitch);
                save.writeObject(x);
                save.writeObject(y);
                save.writeObject(z);
                save.writeObject(name);
                save.writeObject(setting);
                save.writeObject(plant);
                save.writeObject(stuff);

// Close the file.
                save.close(); // This also closes saveFile.
            } catch (Exception exc) {
                exc.printStackTrace(); // If there was an error, print the info.
            }
        }
    }
}



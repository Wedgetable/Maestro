/**
 * Created by Wedge on 9/26/2015.
 */
import org.jfugue.midi.MidiFileManager;
import org.jfugue.player.Player;
import org.jfugue.pattern.Pattern;

import java.io.File;
import java.io.IOException;

public class SongWriter {
    public static void main(String[] args) {
        Pattern p1 = new Pattern("I[Choir_Aahs] D5q E5q C5q C4q G4q.");
        try {
            MidiFileManager.savePatternToMidi(p1, new File("myfile.mid"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
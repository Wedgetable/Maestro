/**
 * Created by Wedge on 9/26/2015 AND THEN MODIFIED.
 */
import org.jfugue.midi.MidiFileManager;
import org.jfugue.player.Player;
import org.jfugue.pattern.Pattern;

import javax.sound.midi.InvalidMidiDataException;
import java.io.File;
import java.io.IOException;

public class SongReader {
    public static void main(String[] args) throws IOException, InvalidMidiDataException {
        Pattern p1 = null;

        try {
            p1 = MidiFileManager.loadPatternFromMidi(new File("FinalBoss-danger.mid"));
        } catch (Exception e) {
            e.printStackTrace();
        }

//        System.out.println(p1);

        Pattern p2 = new Pattern(MidiFileManager.loadPatternFromMidi(new File("decisive_battle.mid")));

        String stringVar = p2.toString().replaceAll("R/\\d\\.\\d+E-\\d+", "")   // Removing very short rests
                                        .replaceAll("(a\\d+)?(d\\d+)?\\b", ""); // Removing velocity information

        System.out.println("stringVar from p2: " + stringVar);

        MidiFileManager.savePatternToMidi(new Pattern(stringVar), new File("myfile2.mid"));

        Pattern p3 = MidiFileManager.loadPatternFromMidi(new File("myfile2.mid"));

        System.out.println("p3: " + p3);

    }

    String NoteLengthCoerce(String numString, double divisor) {
        Double num = Double.parseDouble(numString);

        num = (Math.round(num * divisor))/divisor;

        return num.toString();
    }

    String NoteLengthToString(String numString) {
        Double num = Double.parseDouble(numString);

        String noteLenStr = "";

        char[] charArr = new char[]{'w', 'h', 'q', 'i', 's', 't', 'x', 'o'};

        int numChars;

        for (int i = 0; i < charArr.length; ++i) {
            numChars = ((Double) (num * Math.pow(2, i))).intValue();
            num -= numChars / Math.pow(2, i);
            for (int j = 0; j < numChars; ++j) {
                noteLenStr += charArr[i];
            }
        }

        return noteLenStr;
    }
}

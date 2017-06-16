package techkids.com.android9_hw_drumpad.soundPlayers;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;

import java.util.HashMap;

/**
 * Created by tungthanh.1497 on 06/17/2017.
 */

public class SoundPlayer {
    public static SoundPool soundPool = new SoundPool(12, AudioManager.STREAM_MUSIC, 1);
    public static HashMap<String, Integer> noteMap = new HashMap<>();


    public static void loadSounds(Context context) {
        loadSound("iv_01_a", "a_sound01", context);
        loadSound("iv_02_a", "a_sound02", context);
        loadSound("iv_03_a", "a_sound03", context);
        loadSound("iv_04_a", "a_sound04", context);
        loadSound("iv_05_a", "a_sound05", context);
        loadSound("iv_06_a", "a_sound06", context);
        loadSound("iv_07_a", "a_sound07", context);
        loadSound("iv_08_a", "a_sound08", context);
        loadSound("iv_09_a", "a_sound09", context);
        loadSound("iv_10_a", "a_sound10", context);
        loadSound("iv_11_a", "a_sound11", context);
        loadSound("iv_12_a", "a_sound12", context);
        loadSound("iv_01_b", "b_sound01", context);
        loadSound("iv_02_b", "b_sound02", context);
        loadSound("iv_03_b", "b_sound03", context);
        loadSound("iv_04_b", "b_sound04", context);
        loadSound("iv_05_b", "b_sound05", context);
        loadSound("iv_06_b", "b_sound06", context);
        loadSound("iv_07_b", "b_sound07", context);
        loadSound("iv_08_b", "b_sound08", context);
        loadSound("iv_09_b", "b_sound09", context);
        loadSound("iv_10_b", "b_sound10", context);
        loadSound("iv_11_b", "b_sound11", context);
        loadSound("iv_12_b", "b_sound12", context);
    }

    public static int loadSound(String note, String fileName, Context context) {
        int id = context.getResources().getIdentifier(fileName, "raw", context.getPackageName());
        int soundID = soundPool.load(context, id, 1);
        noteMap.put(note, soundID);
        return id;
    }

    public static void playSound(String note) {
        int soundID = noteMap.get(note);
        soundPool.play(soundID, 1, 1, 1, 0, 1);
    }
}

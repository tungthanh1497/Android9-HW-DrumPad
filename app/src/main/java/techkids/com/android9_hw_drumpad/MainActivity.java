package techkids.com.android9_hw_drumpad;

import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<ImageView> imageViews;
    List<Boolean> statusList;


    private SoundPool soundPool;
    private AudioManager audioManager;
    // Maximumn sound stream.
    private static final int MAX_STREAMS = 5;
    // Stream type.
    private static final int streamType = AudioManager.STREAM_MUSIC;
    private boolean loaded;
    private float volume;


    private int sound01;
    private int sound02;
    private int sound03;
    private int sound04;
    private int sound05;
    private int sound06;
    private int sound07;
    private int sound08;
    private int sound09;
    private int sound10;
    private int sound11;
    private int sound12;
    private int sound13;
    private int sound14;
    private int sound15;

    public void playSound01(View view) {
        if (loaded) {
            float leftVolumn = volume;
            float rightVolumn = volume;
            int streamId = this.soundPool.play(this.sound01, leftVolumn, rightVolumn, 1, 0, 1f);
        }
    }

    public void playSound02(View view) {
        if (loaded) {
            float leftVolumn = volume;
            float rightVolumn = volume;
            int streamId = this.soundPool.play(this.sound02, leftVolumn, rightVolumn, 1, 0, 1f);
        }
    }

    public void playSound03(View view) {
        if (loaded) {
            float leftVolumn = volume;
            float rightVolumn = volume;
            int streamId = this.soundPool.play(this.sound03, leftVolumn, rightVolumn, 1, 0, 1f);
        }
    }

    public void playSound04(View view) {
        if (loaded) {
            float leftVolumn = volume;
            float rightVolumn = volume;
            int streamId = this.soundPool.play(this.sound04, leftVolumn, rightVolumn, 1, 0, 1f);
        }
    }

    public void playSound05(View view) {
        if (loaded) {
            float leftVolumn = volume;
            float rightVolumn = volume;
            int streamId = this.soundPool.play(this.sound05, leftVolumn, rightVolumn, 1, 0, 1f);
        }
    }

    public void playSound06(View view) {
        if (loaded) {
            float leftVolumn = volume;
            float rightVolumn = volume;
            int streamId = this.soundPool.play(this.sound06, leftVolumn, rightVolumn, 1, 0, 1f);
        }
    }

    public void playSound07(View view) {
        if (loaded) {
            float leftVolumn = volume;
            float rightVolumn = volume;
            int streamId = this.soundPool.play(this.sound07, leftVolumn, rightVolumn, 1, 0, 1f);
        }
    }

    public void playSound08(View view) {
        if (loaded) {
            float leftVolumn = volume;
            float rightVolumn = volume;
            int streamId = this.soundPool.play(this.sound08, leftVolumn, rightVolumn, 1, 0, 1f);
        }
    }

    public void playSound09(View view) {
        if (loaded) {
            float leftVolumn = volume;
            float rightVolumn = volume;
            int streamId = this.soundPool.play(this.sound09, leftVolumn, rightVolumn, 1, 0, 1f);
        }
    }

    public void playSound10(View view) {
        if (loaded) {
            float leftVolumn = volume;
            float rightVolumn = volume;
            int streamId = this.soundPool.play(this.sound10, leftVolumn, rightVolumn, 1, 0, 1f);
        }
    }

    public void playSound11(View view) {
        if (loaded) {
            float leftVolumn = volume;
            float rightVolumn = volume;
            int streamId = this.soundPool.play(this.sound11, leftVolumn, rightVolumn, 1, 0, 1f);
        }
    }

    public void playSound12(View view) {
        if (loaded) {
            float leftVolumn = volume;
            float rightVolumn = volume;
            int streamId = this.soundPool.play(this.sound12, leftVolumn, rightVolumn, 1, 0, 1f);
        }
    }

    public void playSound13(View view) {
        if (loaded) {
            float leftVolumn = volume;
            float rightVolumn = volume;
            int streamId = this.soundPool.play(this.sound13, leftVolumn, rightVolumn, 1, 0, 1f);
        }
    }

    public void playSound14(View view) {
        if (loaded) {
            float leftVolumn = volume;
            float rightVolumn = volume;
            int streamId = this.soundPool.play(this.sound14, leftVolumn, rightVolumn, 1, 0, 1f);
        }
    }

    public void playSound15(View view) {
        if (loaded) {
            float leftVolumn = volume;
            float rightVolumn = volume;
            int streamId = this.soundPool.play(this.sound15, leftVolumn, rightVolumn, 1, 0, 1f);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageViews = new ArrayList<>();
        imageViews.add((ImageView) findViewById(R.id.iv_01));
        imageViews.add((ImageView) findViewById(R.id.iv_02));
        imageViews.add((ImageView) findViewById(R.id.iv_03));
        imageViews.add((ImageView) findViewById(R.id.iv_04));
        imageViews.add((ImageView) findViewById(R.id.iv_05));
        imageViews.add((ImageView) findViewById(R.id.iv_06));
        imageViews.add((ImageView) findViewById(R.id.iv_07));
        imageViews.add((ImageView) findViewById(R.id.iv_08));
        imageViews.add((ImageView) findViewById(R.id.iv_09));
        imageViews.add((ImageView) findViewById(R.id.iv_10));
        imageViews.add((ImageView) findViewById(R.id.iv_11));
        imageViews.add((ImageView) findViewById(R.id.iv_12));
        imageViews.add((ImageView) findViewById(R.id.iv_13));
        imageViews.add((ImageView) findViewById(R.id.iv_14));
        imageViews.add((ImageView) findViewById(R.id.iv_15));

        statusList = new ArrayList<>();
        for (ImageView imageView : imageViews) {
            statusList.add(false);
        }


        // AudioManager audio settings for adjusting the volume
        audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);

        // Current volumn Index of particular stream type.
        float currentVolumeIndex = (float) audioManager.getStreamVolume(streamType);

        // Get the maximum volume index for a particular stream type.
        float maxVolumeIndex = (float) audioManager.getStreamMaxVolume(streamType);

        // Volumn (0 --> 1)
        this.volume = currentVolumeIndex / maxVolumeIndex;

        // Suggests an audio stream whose volume should be changed by
        // the hardware volume controls.
        this.setVolumeControlStream(streamType);

        // For Android SDK >= 21
        if (Build.VERSION.SDK_INT >= 21) {

            AudioAttributes audioAttrib = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_GAME)
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .build();

            SoundPool.Builder builder = new SoundPool.Builder();
            builder.setAudioAttributes(audioAttrib).setMaxStreams(MAX_STREAMS);

            this.soundPool = builder.build();
        }
        // for Android SDK < 21
        else {
            // SoundPool(int maxStreams, int streamType, int srcQuality)
            this.soundPool = new SoundPool(MAX_STREAMS, AudioManager.STREAM_MUSIC, 0);
        }

        // When Sound Pool load complete.
        this.soundPool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
            @Override
            public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
                loaded = true;
            }
        });


        this.sound01 = this.soundPool.load(this, R.raw.sound01, 1);
        this.sound02 = this.soundPool.load(this, R.raw.sound02, 1);
        this.sound03 = this.soundPool.load(this, R.raw.sound03, 1);
        this.sound04 = this.soundPool.load(this, R.raw.sound04, 1);
        this.sound05 = this.soundPool.load(this, R.raw.sound05, 1);
        this.sound06 = this.soundPool.load(this, R.raw.sound06, 1);
        this.sound07 = this.soundPool.load(this, R.raw.sound07, 1);
        this.sound08 = this.soundPool.load(this, R.raw.sound08, 1);
        this.sound09 = this.soundPool.load(this, R.raw.sound09, 1);
        this.sound10 = this.soundPool.load(this, R.raw.sound10, 1);
        this.sound11 = this.soundPool.load(this, R.raw.sound11, 1);
        this.sound12 = this.soundPool.load(this, R.raw.sound12, 1);
        this.sound13 = this.soundPool.load(this, R.raw.sound13, 1);
        this.sound14 = this.soundPool.load(this, R.raw.sound14, 1);
        this.sound15 = this.soundPool.load(this, R.raw.sound15, 1);


    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_UP) {
            for (ImageView imageView : imageViews) {
                imageView.setImageResource(R.drawable.default_button);
            }
            for (int i = 0; i < statusList.size(); i++) {
                statusList.set(i, false);
            }
            return false;
        } else {
            for (int i = 0; i < imageViews.size(); i++) {
                ImageView imageView = imageViews.get(i);
                if (isInside(event.getX(), event.getY(), imageView)) {
                    if (!statusList.get(i)) {
                        imageView.setImageResource(R.drawable.pressed_button);
                        statusList.set(i, true);
                        if (imageView.getTag().equals("iv_01")) {
                            playSound01(new View(getBaseContext()));
                            break;
                        }
                        if (imageView.getTag().equals("iv_02")) {
                            playSound02(new View(getBaseContext()));
                            break;
                        }
                        if (imageView.getTag().equals("iv_03")) {
                            playSound03(new View(getBaseContext()));
                            break;
                        }
                        if (imageView.getTag().equals("iv_04")) {
                            playSound04(new View(getBaseContext()));
                            break;
                        }
                        if (imageView.getTag().equals("iv_05")) {
                            playSound05(new View(getBaseContext()));
                            break;
                        }
                        if (imageView.getTag().equals("iv_06")) {
                            playSound06(new View(getBaseContext()));
                            break;
                        }
                        if (imageView.getTag().equals("iv_07")) {
                            playSound07(new View(getBaseContext()));
                            break;
                        }
                        if (imageView.getTag().equals("iv_08")) {
                            playSound08(new View(getBaseContext()));
                            break;
                        }
                        if (imageView.getTag().equals("iv_09")) {
                            playSound09(new View(getBaseContext()));
                            break;
                        }
                        if (imageView.getTag().equals("iv_10")) {
                            playSound10(new View(getBaseContext()));
                            break;
                        }
                        if (imageView.getTag().equals("iv_11")) {
                            playSound11(new View(getBaseContext()));
                            break;
                        }
                        if (imageView.getTag().equals("iv_12")) {
                            playSound12(new View(getBaseContext()));
                            break;
                        }
                        if (imageView.getTag().equals("iv_13")) {
                            playSound13(new View(getBaseContext()));
                            break;
                        }
                        if (imageView.getTag().equals("iv_14")) {
                            playSound14(new View(getBaseContext()));
                            break;
                        }
                        if (imageView.getTag().equals("iv_15")) {
                            playSound15(new View(getBaseContext()));
                            break;
                        }
                    }
                } else {
                    imageView.setImageResource(R.drawable.default_button);
                    statusList.set(i, false);
                }
            }
        }

        return super.onTouchEvent(event);
    }

    boolean isInside(float x, float y, View view) {
        int[] location = new int[2];
        view.getLocationOnScreen(location);

        int left = location[0];
        int top = location[1];
        int right = left + view.getWidth();
        int bottom = top + view.getHeight();

        return (x < right && x > left && y < bottom && y > top);
    }
}

package techkids.com.android9_hw_drumpad;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import techkids.com.android9_hw_drumpad.soundPlayers.SoundPlayer;
import techkids.com.android9_hw_drumpad.touches.Touch;
import techkids.com.android9_hw_drumpad.touches.TouchAction;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = MainActivity.class.toString();
    List<ImageView> buttons;
//    List<Integer> streamIdList;

    ImageView switchButon;
    List<TouchInfo> touchInfoList;

    int isFirstSide = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        buttons = new ArrayList<>();
        buttons.add((ImageView) findViewById(R.id.iv_01));
        buttons.add((ImageView) findViewById(R.id.iv_02));
        buttons.add((ImageView) findViewById(R.id.iv_03));
        buttons.add((ImageView) findViewById(R.id.iv_04));
        buttons.add((ImageView) findViewById(R.id.iv_05));
        buttons.add((ImageView) findViewById(R.id.iv_06));
        buttons.add((ImageView) findViewById(R.id.iv_07));
        buttons.add((ImageView) findViewById(R.id.iv_08));
        buttons.add((ImageView) findViewById(R.id.iv_09));
        buttons.add((ImageView) findViewById(R.id.iv_10));
        buttons.add((ImageView) findViewById(R.id.iv_11));
        buttons.add((ImageView) findViewById(R.id.iv_12));

        switchButon = (ImageView) findViewById(R.id.iv_00);
        touchInfoList = new ArrayList<>();
//        streamIdList = new ArrayList<>();
//        for (int i = 0; i < buttons.size(); i++) {
//            streamIdList.add(-1);
//        }
        SoundPlayer.loadSounds(this);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        List<Touch> touches = Touch.processEvent(event);

        if (touches.size() == 0) {
            return false;
        }
        Touch firstTouch = touches.get(0);
        if (firstTouch.getTouchAction() == TouchAction.DOWN) {
            ImageView pressedButton = findKeyByTouch(firstTouch);
            if (pressedButton == null) {
                return false;
            }
            if (!hasPressedButton(pressedButton)) {
                touchInfoList.add(new TouchInfo(pressedButton, firstTouch));
                if (pressedButton != switchButon) {
                    String button = pressedButton.getTag().toString();
//                    for (int i = 0; i < buttons.size(); i++) {
//                        if (buttons.get(i) == pressedButton) {
//                            streamIdList.set(i, SoundPlayer.playSound(button));
//                        }
//                    }
                    SoundPlayer.playSound(button);
                } else {
                    if (isFirstSide == -1) {
                        for (int indexButton = 1; indexButton <= buttons.size(); indexButton++) {
                            if (indexButton < 10)
                                buttons.get(indexButton - 1).setTag("iv_0" + indexButton + "_a");
                            else
                                buttons.get(indexButton - 1).setTag("iv_" + indexButton + "_a");
                        }
                    } else {
                        for (int indexButton = 1; indexButton <= buttons.size(); indexButton++) {
                            if (indexButton < 10)
                                buttons.get(indexButton - 1).setTag("iv_0" + indexButton + "_b");
                            else
                                buttons.get(indexButton - 1).setTag("iv_" + indexButton + "_b");
                        }
                    }
                    isFirstSide = -isFirstSide;
                }
            }
        } else if (firstTouch.getTouchAction() == TouchAction.UP) {
            ImageView releasedButton = findKeyByTouch(firstTouch);
            if (releasedButton == null) {
                return false;
            }
            Iterator<TouchInfo> touchInfoIterator = touchInfoList.iterator();
            while (touchInfoIterator.hasNext()) {
                TouchInfo touchInfo = touchInfoIterator.next();
                if (touchInfo.touch.getTouchId() == firstTouch.getTouchId()) {
//                    for (int i = 0; i < buttons.size(); i++) {
//                        if (buttons.get(i) == releasedButton) {
//                            SoundPlayer.soundPool.stop(streamIdList.get(i));
//                        }
//                    }
                    touchInfoIterator.remove();
                }
            }
        } else if (firstTouch.getTouchAction() == TouchAction.MOVE) {
            for (Touch touch : touches) {
                ImageView movingButton = findKeyByTouch(touch);
                if (movingButton == null) {
                    return false;
                }
                Iterator<TouchInfo> touchInfoIterator = touchInfoList.iterator();
                while (touchInfoIterator.hasNext()) {
                    TouchInfo touchInfo = touchInfoIterator.next();
                    if (touchInfo.touch.equals(touch) && touchInfo.pressedKey != movingButton) {
//                        for (int i = 0; i < buttons.size(); i++) {
//                            if (buttons.get(i) == touchInfo.pressedKey) {
//                                SoundPlayer.soundPool.stop(streamIdList.get(i));
//                            }
//                        }
                        touchInfoIterator.remove();
                        break;
                    }
                }
                if (!hasPressedButton(movingButton)) {
                    touchInfoList.add(new TouchInfo(movingButton, touch));
                    if (movingButton != switchButon) {
                        String button = movingButton.getTag().toString();

//                        for (int i = 0; i < buttons.size(); i++) {
//                            if (buttons.get(i) == movingButton) {
//                                streamIdList.set(i, SoundPlayer.playSound(button));
//                            }
//                        }

                        SoundPlayer.playSound(button);
                    }
                }
            }
        }

        updateKeyImage();
        return super.onTouchEvent(event);
    }

    void updateKeyImage() {
        if (hasPressedButton(switchButon)) {
            switchButon.setImageResource(R.drawable.pressed_switch_button);
        } else {
            switchButon.setImageResource(R.drawable.default_switch_button);
        }
        for (ImageView button : buttons) {
            if (hasPressedButton(button)) {
                if (button.getTag().toString().contains("01")
                        || button.getTag().toString().contains("02")
                        || button.getTag().toString().contains("03")) {
                    button.setImageResource(R.drawable.pressed_button_1);
                } else if (button.getTag().toString().contains("04")
                        || button.getTag().toString().contains("05")
                        || button.getTag().toString().contains("06")) {
                    button.setImageResource(R.drawable.pressed_button_2);
                } else if (button.getTag().toString().contains("07")
                        || button.getTag().toString().contains("08")
                        || button.getTag().toString().contains("09")) {
                    button.setImageResource(R.drawable.pressed_button_3);
                } else if (button.getTag().toString().contains("10")
                        || button.getTag().toString().contains("11")
                        || button.getTag().toString().contains("12")) {
                    button.setImageResource(R.drawable.pressed_button_4);
                }
            } else {
                if (button.getTag().toString().contains("01")
                        || button.getTag().toString().contains("02")
                        || button.getTag().toString().contains("03")) {
                    button.setImageResource(R.drawable.default_button_1);
                } else if (button.getTag().toString().contains("04")
                        || button.getTag().toString().contains("05")
                        || button.getTag().toString().contains("06")) {
                    button.setImageResource(R.drawable.default_button_2);
                } else if (button.getTag().toString().contains("07")
                        || button.getTag().toString().contains("08")
                        || button.getTag().toString().contains("09")) {
                    button.setImageResource(R.drawable.default_button_3);
                } else if (button.getTag().toString().contains("10")
                        || button.getTag().toString().contains("11")
                        || button.getTag().toString().contains("12")) {
                    button.setImageResource(R.drawable.default_button_4);
                }
            }
        }
    }

    boolean hasPressedButton(ImageView pressedKey) {
        for (TouchInfo touchInfo : touchInfoList) {
            if (pressedKey.getTag().equals(touchInfo.pressedKey.getTag())) {
                return true;
            }
        }
        return false;
    }

    private ImageView findKeyByTouch(Touch touch) {
        if (touch.checkHit(switchButon)) {
            return switchButon;
        }
        for (ImageView button : buttons) {
            if (touch.checkHit(button)) {
                return button;
            }
        }
        return null;
    }

    class TouchInfo {
        public ImageView pressedKey;
        public Touch touch;

        public TouchInfo(ImageView pressedKey, Touch touch) {
            this.pressedKey = pressedKey;
            this.touch = touch;
        }
    }

}

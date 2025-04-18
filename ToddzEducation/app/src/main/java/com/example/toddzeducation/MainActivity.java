package com.example.toddzeducation;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.content.Intent;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements TextToSpeech.OnInitListener {
    private RadioGroup radioGroup;
    private TextToSpeech TTS;
    private TextView input;
    private ImageButton audiobtn;
    ToggleButton btn1;
    ToggleButton btn2;
    ToggleButton btn3;
    ToggleButton btn4;
    MediaPlayer mediaPlayer;
    ImageButton hint;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = findViewById(R.id.radioGroup);
        TTS = new TextToSpeech(this, this);
        input = findViewById(R.id.textView4);
        hint = findViewById(R.id.btnHint);
        audiobtn = findViewById(R.id.audiobtn);
        audiobtn.setOnClickListener(v -> speak());
        // Set up ToggleButtons
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);

        // Set a listener for each ToggleButton
        btn1.setOnCheckedChangeListener(optionCheckedChangeListener);
        btn2.setOnCheckedChangeListener(optionCheckedChangeListener);
        btn3.setOnCheckedChangeListener(optionCheckedChangeListener);
        btn4.setOnCheckedChangeListener(optionCheckedChangeListener);

        Dialog dialog = new Dialog(this);
        hint.setOnClickListener(v -> {
            dialog.setContentView(R.layout.hint_dialog);
            dialog.show();
            mediaPlayer = MediaPlayer.create(this, R.raw.hint_ding);
            mediaPlayer.start();
        });
    }

    private final CompoundButton.OnCheckedChangeListener optionCheckedChangeListener =
            new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        // Uncheck all other buttons in the radio group
                        for (int i = 0; i < radioGroup.getChildCount(); i++) {
                            View child = radioGroup.getChildAt(i);
                            if (child instanceof ToggleButton && child != buttonView) {
                                ((ToggleButton) child).setChecked(false);
                                // Unhighlight the unselected button
                                child.setBackgroundResource(R.drawable.btn_bg);
                            }
                        }

                        // Highlight the selected button
                        buttonView.setBackgroundResource(R.drawable.btn_statepressed);
                        String btntext = buttonView.getText().toString();
                        speakop(btntext);
                    } else {
                        // Unhighlight the unselected button
                        buttonView.setBackgroundResource(R.drawable.btn_bg);
                    }
                }
            };
    public void openResults(View view){
        startActivity(new Intent(this,ResultsActivity.class));
    }

    @Override
    public void onInit(int status) {
        if(status == TextToSpeech.SUCCESS){
            int result = TTS.setLanguage(Locale.getDefault());
            TTS.setSpeechRate(1);
            TTS.setPitch(1);
            if(result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED){
                Log.e("TTS", "Language not supported");
            }
            else{
                audiobtn.setEnabled(true);
                speak();
            }
        }
        else{
            Log.e("TextToSpeech", "Initialization failed");
        }
    }
    private void speak() {
        String message = input.getText().toString();
        TTS.speak(message,TextToSpeech.QUEUE_FLUSH, null,null);

    }
    private void speakop(String message){
        TTS.speak(message,TextToSpeech.QUEUE_FLUSH, null,null);
    }
}

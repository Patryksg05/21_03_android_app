package com.example.radiobuttons;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.MediaStore;
import android.view.accessibility.AccessibilityManager;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radioGroup;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = (RadioGroup) findViewById(R.id.imageRadioGroup);
        imageView = (ImageView) findViewById(R.id.imageView);

        radioGroup.setOnCheckedChangeListener(
                new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
//                        FIRST WAY => find radioButton by checkedId and get text
//                        RadioButton rb = (RadioButton) findViewById(checkedId);
//                        int idRadioGroup = radioGroup.getCheckedRadioButtonId();
//                        Toast.makeText(MainActivity.this, rb.getText(), Toast.LENGTH_SHORT).show();
//                        SECOND WAY => SWITCH
                        RadioButton rb;
                        switch (checkedId)
                        {
                            case R.id.radioBtnOne:
                                imageView.setImageResource(R.drawable.ic_baseline_5k_plus_24);
                                break;
                            case R.id.radioBtnTwo:
                                imageView.setImageResource(R.drawable.ic_baseline_5mp_24);
                                break;
                            case R.id.radioBtnThree:
                                imageView.setImageResource(R.drawable.ic_baseline_5k_24);
                                break;
//                                rb = (RadioButton) findViewById(checkedId);
//                                Toast.makeText(MainActivity.this, rb.getText(),
//                                        Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );
    }
}
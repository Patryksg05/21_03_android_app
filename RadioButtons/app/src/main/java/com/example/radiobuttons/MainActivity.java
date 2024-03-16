package com.example.radiobuttons;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Message;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radioGroup;
    private ImageView imageView;
    private Button changeImageBtn;
    private EditText imageEditText;

    private ArrayList<Integer> images;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        images = new ArrayList<Integer>(3);
        images.add(R.drawable.ic_baseline_5k_24);
        images.add(R.drawable.ic_baseline_5mp_24);
        images.add(R.drawable.ic_baseline_5k_plus_24);

        radioGroup = (RadioGroup) findViewById(R.id.imageRadioGroup);
        imageView = (ImageView) findViewById(R.id.imageView);
        imageEditText = (EditText) findViewById(R.id.imageEditText);
        changeImageBtn = (Button) findViewById(R.id.changeImageBtn);

        imageEditText.addTextChangedListener(
                new TextWatcher() {
                    private String lastValue = "";
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {

                    }

                    @Override
                    public void afterTextChanged(Editable s) {
                        String fullText = s.toString();

                        if(fullText.equals("imageone"))
                            imageView.setImageResource(R.drawable.ic_baseline_5k_plus_24);
                        else if(fullText.equals("imagetwo"))
                            imageView.setImageResource(R.drawable.ic_baseline_5mp_24);
                        else if(fullText.equals("imagethree"))
                            imageView.setImageResource(R.drawable.ic_baseline_5k_24);
                        else
                            imageView.setImageResource(R.drawable.ic_baseline_5k_24);
                    }
                }
        );

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

        changeImageBtn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Random random = new Random();
                        int index = random.nextInt((2));
                        imageView.setImageResource(images.get(index));
                    }
                }
        );
    }
}
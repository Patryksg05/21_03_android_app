package com.example.onchangedapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText newRadioBtnEditText;
    private Button newRadioBtnBtn;
    private RadioGroup radioGroup;
    private TextView onTextChangedTextView;
    private int counter = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        newRadioBtnBtn = (Button) findViewById(R.id.newRadioBtnButton);
        newRadioBtnEditText = (EditText) findViewById(R.id.newRadioButtonEditText);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        onTextChangedTextView = (TextView) findViewById(R.id.onTextChangedTextView);

        newRadioBtnBtn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        counter = 1;
                        addRadioButtons(counter);
                    }
                }
        );

        newRadioBtnEditText.addTextChangedListener(
                new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    }

                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    }

                    @Override
                    public void afterTextChanged(Editable editable) {
                        onTextChangedTextView.setText(editable.toString());
                    }
                }
        );
    }

    public void addRadioButtons(int number)
    {
        radioGroup.setOrientation(LinearLayout.HORIZONTAL);

        for(int i=0; i<number; i++)
        {
            RadioButton rbBtn = new RadioButton(this);
            rbBtn.setId(View.generateViewId());
            rbBtn.setText(newRadioBtnEditText.getText().toString());
            rbBtn.setOnClickListener(this);
            radioGroup.addView(rbBtn);
        }
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(this, ((RadioButton)view).getText() + " id: "
                + view.getId(), Toast.LENGTH_SHORT).show();
    }
}
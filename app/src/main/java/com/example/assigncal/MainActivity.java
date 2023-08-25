package com.example.assigncal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button clearButton;
    private EditText num1EditText, num2EditText;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

                num1EditText = findViewById(R.id.num1);
                num2EditText = findViewById(R.id.num2);
                resultTextView = findViewById(R.id.result);

                Button sumButton = findViewById(R.id.sum);
                Button subButton = findViewById(R.id.sub);
                Button mulButton = findViewById(R.id.mul);
                Button divButton = findViewById(R.id.div);
                clearButton = findViewById(R.id.button);

                sumButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        performCalculation('+');
                    }
                });

                subButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        performCalculation('-');
                    }
                });

                mulButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        performCalculation('*');
                    }
                });

                divButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        performCalculation('/');
                    }
                });


            }

            private void performCalculation(char operator) {
                String num1Str = num1EditText.getText().toString();
                String num2Str = num2EditText.getText().toString();

                if (!num1Str.isEmpty() && !num2Str.isEmpty()) {
                    double num1 = Double.parseDouble(num1Str);
                    double num2 = Double.parseDouble(num2Str);

                    double result = 0;

                    switch (operator) {
                        case '+':
                            result = num1 + num2;
                            break;
                        case '-':
                            result = num1 - num2;
                            break;
                        case '*':
                            result = num1 * num2;
                            break;
                        case '/':
                            if (num2 != 0) {
                                result = num1 / num2;
                            } else {
                                resultTextView.setText("Cannot divide by zero");
                                return;
                            }
                            break;
                    }

                    resultTextView.setText("Result: " + result);
                } else {
                    resultTextView.setText("Enter valid numbers");
                }
            }


    public void clearButton1(View view) {
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                num1EditText.setText("");
                num2EditText.setText("");
                resultTextView.setText("");


            }
        });


    }
}
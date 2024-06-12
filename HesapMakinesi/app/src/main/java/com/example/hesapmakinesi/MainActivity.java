package com.example.hesapmakinesi;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;


import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView textViewResult;

    private StringBuilder currentInput = new StringBuilder();
    private double operand1 = Double.NaN;
    private double operand2 = Double.NaN;
    private String operator = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewResult = findViewById(R.id.textViewResult);

        setNumberButtonClickListeners();
        setOperatorButtonClickListeners();
        setClearButtonClickListener();
    }

    private void setNumberButtonClickListeners() {
        int[] numberButtonIds = {R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3,
                R.id.btn4, R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9};

        for (int buttonId : numberButtonIds) {
            Button button = findViewById(buttonId);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Button clickedButton = (Button) v;
                    currentInput.append(clickedButton.getText());
                    updateResultText();
                }
            });
        }
    }

    private void setOperatorButtonClickListeners() {
        int[] operatorButtonIds = {R.id.btnAdd, R.id.btnSubtract, R.id.btnMultiply, R.id.btnDivide};

        for (int buttonId : operatorButtonIds) {
            Button button = findViewById(buttonId);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    handleOperatorClick(((Button) v).getText().toString());
                }
            });
        }

        // Equals button
        Button equalsButton = findViewById(R.id.btnEquals);
        equalsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleEqualsClick();
            }
        });
    }

    private void setClearButtonClickListener() {
        Button clearButton = findViewById(R.id.btnClear);
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearInput();
            }
        });
    }

    private void handleOperatorClick(String clickedOperator) {
        if (currentInput.length() > 0) {
            if (Double.isNaN(operand1)) {
                operand1 = Double.parseDouble(currentInput.toString());
            } else {
                operand2 = Double.parseDouble(currentInput.toString());
                calculateResult();
                operand1 = Double.parseDouble(textViewResult.getText().toString());
            }

            operator = clickedOperator;
            currentInput.setLength(0); // Clear current input
            updateResultText();
        }
    }

    private void handleEqualsClick() {
        if (currentInput.length() > 0 && !Double.isNaN(operand1) && !operator.isEmpty()) {
            operand2 = Double.parseDouble(currentInput.toString());
            calculateResult();

            // Reset variables for the next calculation
            operand1 = Double.NaN;
            operand2 = Double.NaN;
            operator = "";

            // Start SecondActivity and pass the result as an extra
            String result = textViewResult.getText().toString();
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            intent.putExtra("result", result);
            startActivity(intent);
        }
    }


    private void calculateResult() {
        if (!Double.isNaN(operand1) && !Double.isNaN(operand2) && !operator.isEmpty()) {
            double result = 0;
            switch (operator) {
                case "+":
                    result = operand1 + operand2;
                    break;
                case "-":
                    result = operand1 - operand2;
                    break;
                case "*":
                    result = operand1 * operand2;
                    break;
                case "/":
                    if (operand2 != 0) {
                        result = operand1 / operand2;
                    } else {
                        // Handle division by zero
                        result = Double.NaN;
                    }
                    break;
            }

            // Display result
            textViewResult.setText(String.valueOf(result));
        }
    }

    private void clearInput() {
        currentInput.setLength(0);
        operand1 = Double.NaN;
        operand2 = Double.NaN;
        operator = "";
        updateResultText();
    }

    private void updateResultText() {
        textViewResult.setText(currentInput.toString());
    }
}
package com.calculator.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class MainActivity extends AppCompatActivity {

    private TextView workingTextView, resultTextView;
    private Button deleteButton, paranthesesButton, powerButton
            , divideButton, multiplyButton, addButton, minusButton
            , equalsButton, dotButton, zeroButton
            , oneButton, twoButton, threeButton
            , fourButton, fiveButton, sixButton
            , sevenButton, eightButton, nineButton;

    private String workingsOnTextView = ""; // Helping for updating textview.
    private boolean leftBracket = true; // Help to parantheses
    private String formula = ""; // Updating formula
    private String tempFormula = ""; // Updating formula

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        workingTextView = findViewById(R.id.workingTextView);
        resultTextView = findViewById(R.id.resultTextView);
        deleteButton = findViewById(R.id.deleteButton);
        paranthesesButton = findViewById(R.id.paranthesesButton);
        powerButton = findViewById(R.id.powerButton);
        divideButton = findViewById(R.id.divideButton);
        multiplyButton = findViewById(R.id.multiplyButton);
        addButton = findViewById(R.id.addButton);
        equalsButton = findViewById(R.id.equalsButton);
        dotButton = findViewById(R.id.dotButton);
        zeroButton = findViewById(R.id.zeroButton);
        oneButton = findViewById(R.id.oneButton);
        twoButton = findViewById(R.id.twoButton);
        threeButton = findViewById(R.id.threeButton);
        fourButton = findViewById(R.id.fourButton);
        fiveButton = findViewById(R.id.fiveButton);
        sixButton = findViewById(R.id.sixButton);
        sevenButton = findViewById(R.id.sevenButton);
        eightButton = findViewById(R.id.eightButton);
        nineButton = findViewById(R.id.nineButton);
        minusButton = findViewById(R.id.minusButton);



        equalsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Double result = null;

                /** ScriptEngine does the mathematical operations. */
                ScriptEngine scriptEngine = new ScriptEngineManager().getEngineByName("rhino");
                checkForPowerOf();

                /** scriptEngine object evaluates the formula so that mathematical operation
                 * is performed.*/
                try {
                    result = (double)scriptEngine.eval(formula);
                }
                catch (ScriptException e) {
                    Toast.makeText(MainActivity.this, "Please check again your input values !", Toast.LENGTH_SHORT).show();
                }

                /** If there is not something on result part, then do the following.*/
                if(result != null) {
                    resultTextView.setText(String.valueOf(result.doubleValue()));
                }


            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /** If the user clicks the delete button, then we need to delete the textView */
                workingTextView.setText("");
                workingsOnTextView = "";
                resultTextView.setText("");

                /** We set leftbracket as true since each single deleting, we get an empty text,
                 * and we need to use ( sign with empty texts.
                 * e.g -> (3 + 5, not )3 + 5, etc.*/
                leftBracket = true;

            }
        });


        paranthesesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /** If leftBracket is true, in case, it updates the text as (, if not, it updates as ).
                 * By doing so, if we click multiple times ( and ) button, we get ()()()(). */
                if(leftBracket) {
                    setWorkingsOnTextView("(");
                    leftBracket = false;
                }
                else {
                    setWorkingsOnTextView(")");
                    leftBracket = true;
                }

            }
        });

        /** It used for calculating the power of two number. */
        powerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setWorkingsOnTextView("^");
            }
        });
        divideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setWorkingsOnTextView("/");
            }
        });
        multiplyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setWorkingsOnTextView("*");
            }
        });
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setWorkingsOnTextView("+");
            }
        });

        /** Users are using this button for decimal point numbers, not multiplying as mathematic.  */
        dotButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setWorkingsOnTextView(".");
            }
        });

        /** Users can use this button either negative sign or subtracting operation. */
        minusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setWorkingsOnTextView("-");
            }
        });


        zeroButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setWorkingsOnTextView("0");
            }
        });
        oneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setWorkingsOnTextView("1");
            }
        });
        twoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setWorkingsOnTextView("2");
            }
        });

        threeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setWorkingsOnTextView("3");
            }
        });

        fourButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setWorkingsOnTextView("4");
            }
        });
        fiveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setWorkingsOnTextView("5");
            }
        });
        sixButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setWorkingsOnTextView("6");
            }
        });
        sevenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setWorkingsOnTextView("7");
            }
        });
        eightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setWorkingsOnTextView("8");
            }
        });
        nineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setWorkingsOnTextView("9");
            }
        });
    }

    /** This method updates the textview based on mathematical operations. For every
     * button, we need to call this method. */
    public void setWorkingsOnTextView(String mathematicalText) {
        workingsOnTextView = workingsOnTextView + mathematicalText;
        workingTextView.setText(workingsOnTextView);
    }


    public void checkForPowerOf() {
        ArrayList<Integer> indexOfPowers = new ArrayList<>();
        for(int i = 0 ; i < workingsOnTextView.length() ; i++) {

            if(workingsOnTextView.charAt(i) == '^') {
                indexOfPowers.add(i);
            }
        }

        formula = workingsOnTextView;
        tempFormula = workingsOnTextView;

        for(Integer index : indexOfPowers) {
            changeFormula(index);
        }
        formula = tempFormula;
    }

    private void changeFormula(Integer index) {


        String numberLeft = "";
        String numberRight = "";

        for(int i = index + 1; i< workingsOnTextView.length(); i++)
        {
            if(isNumeric(workingsOnTextView.charAt(i)))
                numberRight = numberRight + workingsOnTextView.charAt(i);
            else
                break;
        }

        for(int i = index - 1; i >= 0; i--)
        {
            if(isNumeric(workingsOnTextView.charAt(i)))
                numberLeft = numberLeft + workingsOnTextView.charAt(i);
            else
                break;
        }

        String original = numberLeft + "^" + numberRight;
        String changed = "Math.pow("+numberLeft+","+numberRight+")";
        tempFormula = tempFormula.replace(original,changed);
    }

    /** The range of 0 to 9 or equals . or it's decimal place return true otherwise return false. */
    private boolean isNumeric(char character) {

        if(character <= '9' && character>= '0' || character == '.')
            return true;
        return false;
    }
}
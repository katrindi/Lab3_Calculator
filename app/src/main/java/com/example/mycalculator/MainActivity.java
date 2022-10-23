package com.example.mycalculator;

import static java.lang.Double.parseDouble;
import static java.lang.Math.sqrt;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.mariuszgromada.math.mxparser.Expression;

public class MainActivity extends AppCompatActivity {
    TextView workingTV;
    TextView resultTV;
    String workings = "";
    boolean isSqrRootPressed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initTextViews();
    }

    private void initTextViews() {
        workingTV=(TextView)findViewById(R.id.workingsTextView);
        resultTV=(TextView)findViewById(R.id.resultTextView);
    }

    public void setWorking(String givenValue){
        workings = workings + givenValue;
        workingTV.setText(workings);
    }

    public double workings(String calc) {
        Expression e = new Expression(calc);
        return e.calculate();
    }

    //Clear All
    public void clearOnClick(View view) {
        workingTV.setText("");
        workings = "";
        resultTV.setText("");
    }

    //Equal to...
    public void equalOnClick(View view) {
        double answer = 0;
        if(isSqrRootPressed == true) {
            workings = workings.substring(1);
            answer = sqrt(parseDouble(workings));
            workings = String.valueOf(answer);
        }
        else {
            answer = workings(workings);
        }
        resultTV.setText(String.valueOf(answer));
    }

    public void sqrOnClick(View view) {
        isSqrRootPressed = true;
        setWorking("\u221A");
    }

    public void delOnClick(View view){
       String val = workingTV.getText().toString();
       if(!val.equals("")) {
           val = val.substring(0,val.length()-1);
           workingTV.setText(val);
       }
    }

    public void oneOnClick (View view){
        setWorking("1");
    }
    public void twoOnClick (View view){
        setWorking("2");
    }
    public void threeOnClick (View view){
        setWorking("3");
    }
    public void fourOnClick (View view){
        setWorking("4");
    }
    public void fiveOnClick (View view){
        setWorking("5");
    }
    public void sixOnClick (View view){
        setWorking("6");
    }
    public void sevenOnClick (View view){
        setWorking("7");
    }
    public void eightOnClick (View view){
        setWorking("8");
    }
    public void nineOnClick (View view){
        setWorking("9");
    }
    public void zeroOnClick (View view){
        setWorking("0");
    }
    public void divisionOnClick (View view){
        setWorking("/");
    }
    public void multiplyOnClick (View view){
        setWorking("*");
    }
    public void minusOnClick (View view){
        setWorking("-");
    }
    public void plusOnClick (View view){
        setWorking("+");
    }
}

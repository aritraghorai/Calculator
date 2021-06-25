package com.example.calculator;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import org.mariuszgromada.math.mxparser.*;

public class MainActivity extends AppCompatActivity {
    private EditText display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display=findViewById(R.id.input);
        display.setShowSoftInputOnFocus(false);
        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(getString(R.string.display).equals(display.getText().toString()))
                {
                    display.setText("");

                }
            }
        });

    }
    private void updateText(String stringToadd)
    {
        String oldString=display.getText().toString();
        int cursorPosition=display.getSelectionStart();
        String leftStr=oldString.substring(0,cursorPosition);
        String rightStr=oldString.substring(cursorPosition);
        if(getString(R.string.display).equals(display.getText().toString()))
        {
            display.setText(stringToadd);
            display.setSelection(cursorPosition+1);
        }
        else
        {
            display.setText(String.format("%s%s%s",leftStr,stringToadd,rightStr));
            display.setSelection(cursorPosition+1);
        }

    }

   public void zeroBtn(View view)
   {
updateText("0");
   }
    public void OneBtn(View view)
    {
updateText("1");
    }
    public void twoBtn(View view)
    {
updateText("2");
    }
    public void threeBtn(View view)
    {
updateText("3");
    }
    public void fourBtn(View view)
    {
updateText("4");
    }
    public void fiveBtn(View view)
    {
updateText("5");
    }
    public void sixBtn(View view)
    {
updateText("6");
    }
    public void sevenBtn(View view)
    {
updateText("7");
    }
    public void eightBtn(View view)
    {
updateText("8");
    }
    public void nineBtn(View view)
    {
updateText("9");
    }
    public void clearBtn(View view)
    {
display.setText("");
    }
    public void parenthasisBtn(View view)
    {
int cursurPosition=display.getSelectionStart();
int openPar=0;
int closePar=0;
int textlen=display.getText().length();
for(int i=0;i<cursurPosition;i++){

if(display.getText().toString().substring(i,i+1).equals("(")){
    openPar++;
}
        if(display.getText().toString().substring(i,i+1).equals(")")) {
            closePar++;
        }
    }
if(openPar==closePar||display.getText().toString().substring(textlen-1,textlen).equals("("))
{
    updateText("(");
    display.setSelection(cursurPosition+1);
}
    else  if(openPar>closePar||!display.getText().toString().substring(textlen-1,textlen).equals("("))
        {
            updateText(")");
            display.setSelection(cursurPosition+1);
        }
    }
    public void powerBtn(View view)
    {
updateText("^");
    }
    public void divisionBtn(View view)
    {
updateText("/");
    }
    public void multiplyBtn(View view)
    {
updateText("*");
    }
    public void subtractionBtn(View view)
    {
updateText("-");
    }
    public void addtionBtn(View view)
    {
updateText("+");
    }
    public void getDivder(View view)
    {
        updateText("%");
    }
    public void resultBtn(View view)
    {
String userExpre=display.getText().toString();
userExpre=userExpre.replaceAll("÷","/");
userExpre=userExpre.replaceAll("X","*");
       Expression exp=new Expression(userExpre);
       String result=String.valueOf(exp.calculate());
       display.setText(result);
       display.setSelection(result.length());
    }
    public void dotBtn(View view)
    {
updateText(".");
    }
    public void backspeaceBtn(View view)
    {
int cursorPos=display.getSelectionStart();
int textLen=display.getText().length();
if(cursorPos!=0&&textLen!=0)
{
    SpannableStringBuilder selection=(SpannableStringBuilder)display.getText();
    selection.replace(cursorPos-1,cursorPos,"");
    display.setText(selection);
    display.setSelection(cursorPos-1);
}
    }

}
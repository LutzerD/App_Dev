package com.example.poo.a331converter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class mainActivity extends AppCompatActivity {

    //TODO: hex testing

    //Declaring items
    Button buttonAnswer;
    TextView textAnswer;
    EditText baseInput,baseAnswer,numInput;

    //Error message tags
    String fnTagE = "FNErr", fnTag = "degbugFN", fnCT = "FNCT", tst = "FNToast";

    //Variables to be gathered from the text fields
    int input, iBase,oBase;
    String newVal,compareVal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Linking the items previously declared to their corrosponding item
        buttonAnswer = (Button) findViewById(R.id.buttonResult);
        textAnswer  = (TextView) findViewById(R.id.resultText);
        baseInput = (EditText) findViewById(R.id.baseFrom);
        baseAnswer = (EditText) findViewById(R.id.baseTo);
        numInput = (EditText) findViewById(R.id.inputFrom);

        //Function to run when calculate button is pressed
        buttonAnswer.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                boolean test;

                //Checks if any field is null
                if (numInput.getText().toString().matches("")||baseAnswer.getText().toString().matches("")||baseInput.getText().toString().matches("")) {
                    toasty("Fill in all the fields nerd.");
                    return;
                }

                //Gather data from input fields
                input = Integer.parseInt( numInput.getText().toString());
                iBase = Integer.parseInt( baseInput.getText().toString());
                oBase = Integer.parseInt( baseAnswer.getText().toString());

                //Checks if inputs are valid, returns false if all are valid
                test = checkItFam(input,iBase,oBase);

                if(!test) {
                    //Call convertNum to find out the result
                    newVal = convertNum(input, iBase, oBase);
                    //Do the same operation in reverse to check consistancy
                    compareVal = convertNum(Integer.parseInt(newVal), oBase, iBase);
                    if (!newVal.contains( compareVal)) {
                        toasty("This might be wrong :( , result: "+newVal+", re-checked value: "+ compareVal);
                    }
                    //Display answer
                    textAnswer.setText(newVal);
                }else{
                    //If the inputs are not valid clear the result so no confusion may happen
                    textAnswer.setText("");
                }
            }
        });
    }

    //Converts the input value to decimal, then that decimal to the new base
    //There is almost definitely a better way to do this :P

    public String convertNum(int input,int base, int nBase){

        String inputStr = (String) Integer.toString(input);
        int answer = 0, exponent = 0, remainder, index = 0, flag = 0;
        String newVal="";
        double temp;

        try {
            //Checks if the input base is already 10, so then it doesnt have to do a redundnat conversion
            //The algorithm here is to go from LSB (is that term relevant to non base 2 systems?)
            //Anyway, it goes from LSB to MSB and adds it all up into answer
            if (base != 10) {
                for (int i = inputStr.length()-1; i > -1; i--) {
                    temp = Character.getNumericValue(inputStr.charAt(i));
                    temp = temp*Math.pow(base, exponent);
                    Log.d(fnTag,"Temp value: "+Double.toString(temp));
                    answer += temp;
                    exponent++;
                }
            }

            //Starts the conversion to new  base
            //flag increments the step before 0 is reached, then the operation is performed once more
            while (flag < 2) {
                remainder = answer % nBase;
                if((answer - remainder) <= 0){
                    flag ++;
                }
                answer = (answer-remainder)/nBase;
                newVal= Integer.toString(remainder) + newVal;

            }
                Log.d(fnTag,"Conversion Result : " + newVal);


        }catch(Exception e){
            Log.d(fnTagE,"Exception was thrown: ",e);
        }

        //Kill any 0's at the beggining
        //so 027 -> 27
        //Goes through the result from before, parses left until it hits something non-zero
        int charFlag = -1, strIndex = 0;
        while(charFlag < 0 && strIndex < newVal.length()){
            Log.d(fnCT,"Checking Char: " + newVal.charAt(strIndex));

            if(newVal.charAt(strIndex) == '0'){
                strIndex++;
            }else if(strIndex != 0){
                charFlag = strIndex;
                newVal = newVal.substring(charFlag,newVal.length());
            }
            Log.d(fnCT,"Exiting at " + Integer.toString(charFlag));
        }

        return newVal;
    };


    public Boolean  checkItFam(int inputo, int inBase, int outBase){
        String acceptableChars = "abcdef";
        //TODO:"Negative functioning??"
        if(inputo < 1){
            //rejects input value of 0, rejects negative values (i didnt cover negative)
            toasty("Awe come on man");
            return true;
        }
        //Only supporting base 2-10, hex
        if(inBase<1 || (inBase > 10 && inBase != 16)){
            toasty("Yikes, use real bases fam.. (2-10, hex)");
            return true;
        }
        if((outBase<1 || (outBase > 10 && outBase != 16))){
            toasty("Yikes, use real bases fam.. (2-10, hex)");
            return true;
        }
        //The error messages kind of explain what this part searches for
        String inputoStr = Integer.toString(inputo);
            for(int i = 0; i < inputoStr.length(); i++){
                if(inBase == 16) {
                    if(Character.getNumericValue(inputoStr.charAt(i)) >= inBase || acceptableChars.indexOf(inputoStr.charAt(i)) < 0 ){
                        toasty(inputoStr.charAt(i) + " is not a hex char go back to school kid.");
                        return true;
                    }
                }else{
                    if(Character.getNumericValue(inputoStr.charAt(i)) >= inBase){
                        String ib = Integer.toString(inBase);
                                toasty("Digits of a base "+ ib + " system can't be >= to " + ib + ", go back to school.");
                                toasty("Problem digit: "+ inputoStr.charAt(i));
                                return true;
                    }
                }
        }


        return false;
    }
    //Function that creates a toast and log message out of input
    public void toasty(String msg){
        Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_SHORT).show();
        Log.d(tst,msg);
    };
}

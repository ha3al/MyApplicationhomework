package com.example.ha3alkaya.myapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.app.Activity;
import android.view.View.OnClickListener;
import android.widget.Toast;


import java.text.DecimalFormat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    ArrayList<String> arrayList = new ArrayList<String>();

    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0,btnEsit,btnTopla,btnFark,
        btnCarp,btnBol,btnTemizle;

    EditText edtislem,edtSonuc;

    String islem = "";
    String sonuc= "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtSonuc = (EditText) findViewById(R.id.edtSonuc);
        edtislem = (EditText) findViewById(R.id.edtislem);

    }

            public void onClick(View v) {

            Button button = (Button) v;

            islem = (String) button.getText().toString();

            if(!islem.contains("+") &&!islem.contains("-") &&!islem.contains("/") &&!islem.contains("x") )
            {
                sonuc = sonuc + islem;

                if (arrayList.size()>0)
                {

                    arrayList.remove((arrayList.size()-1));
                }

                arrayList.add(sonuc);
            }
             else {
                arrayList.add(islem);
                arrayList.add(islem);
                sonuc = "";

            }
                edtislem.setText(edtislem.getText().toString() + islem);


        }
        public void onClick2 (View v) {

            int calc= 0;
            int c =arrayList.size();

            //eg: array  3+5*2-3  size = 7

            while(c!=1){

                if(c>3){

                    if(arrayList.get(3).contains("x") || arrayList.get(3).contains("/")){

                      if(arrayList.get(3).contains("x")){calc = Integer.parseInt(arrayList.get(2)) * Integer.parseInt(arrayList.get(4));}

                        if(arrayList.get(3).contains("/")){
                            if(!arrayList.get(4).contains("0"))
                            calc = Integer.parseInt(arrayList.get(2)) / Integer.parseInt(arrayList.get(4));
                            else

                                Toast.makeText(MainActivity.this, "0'a bölüm yapılamaz!", Toast.LENGTH_SHORT).show();
                        }

                        //calc=10
                        arrayList.remove(2);   // 3+ *2-3
                        arrayList.remove(2);    // 3+2-3
                        arrayList.remove(2);    // 3+ -3
                        arrayList.add(2, Integer.toString(calc)); // 3+10-3

                        c= arrayList.size(); // size: 5
                      }

                    else {

                        //3+10-3

                        if(arrayList.get(1).contains("+")){calc = Integer.parseInt(arrayList.get(0)) + Integer.parseInt(arrayList.get(2));}
                        if(arrayList.get(1).contains("-")){calc = Integer.parseInt(arrayList.get(0)) - Integer.parseInt(arrayList.get(2));}
                        if(arrayList.get(1).contains("x")){calc = Integer.parseInt(arrayList.get(0)) * Integer.parseInt(arrayList.get(2));}
                        if(arrayList.get(1).contains("/")){
                            if(!arrayList.get(2).contains("0"))
                            calc = Integer.parseInt(arrayList.get(0)) / Integer.parseInt(arrayList.get(2));
                            else
                                Toast.makeText(MainActivity.this, "0'a bölüm yapılamaz!", Toast.LENGTH_SHORT).show();
                        }

                        //calc: 13
                        arrayList.remove(0); //+10-3
                        arrayList.remove(0); //10-3
                        arrayList.remove(0); // -3
                        arrayList.add(0, Integer.toString(calc)); //13-3

                        c= arrayList.size(); // size: 3

                    }

                    }
                else {

                    if(arrayList.get(1).contains("+")){calc = Integer.parseInt(arrayList.get(0)) + Integer.parseInt(arrayList.get(2));}
                    if(arrayList.get(1).contains("-")){calc = Integer.parseInt(arrayList.get(0)) - Integer.parseInt(arrayList.get(2));}
                    if(arrayList.get(1).contains("x")){calc = Integer.parseInt(arrayList.get(0)) * Integer.parseInt(arrayList.get(2));}
                    if(arrayList.get(1).contains("/")){
                        if(!arrayList.get(2).contains("0"))
                        calc = Integer.parseInt(arrayList.get(0)) / Integer.parseInt(arrayList.get(2));
                        else
                            Toast.makeText(MainActivity.this, "0'a bölüm yapılamaz!", Toast.LENGTH_SHORT).show();
                    }

                    //calc: 10
                    arrayList.remove(0); // -3
                    arrayList.remove(0); // 3
                    arrayList.remove(0); //
                    arrayList.add(0, Integer.toString(calc)); //10

                    c= arrayList.size(); //size: 1 --> end of while loop

                }
                }

            edtSonuc.setText(Integer.toString(calc));
            }

    public void clear (View v){

        islem="";
        sonuc="";

        edtislem.setText("");
        edtSonuc.setText("");
        arrayList.clear();

    }

    }
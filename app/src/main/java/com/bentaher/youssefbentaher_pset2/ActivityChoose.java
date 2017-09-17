package com.bentaher.youssefbentaher_pset2;

import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class ActivityChoose extends AppCompatActivity {

    Button btnSimple, btnTarzan, btnUniversity, btnClothes, btnDance, btnRandom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);

        btnSimple = (Button) findViewById(R.id.Simple);
        btnTarzan = (Button) findViewById(R.id.Tarzan);
        btnUniversity = (Button) findViewById(R.id.University);
        btnClothes = (Button) findViewById(R.id.Clothes);
        btnDance = (Button) findViewById(R.id.Dance);
        btnRandom = (Button) findViewById(R.id.Random);


        String[] files = new String[0];
        try {
            files = getAssets().list("");
        } catch (IOException e) {
            e.printStackTrace();
        }


        for(String f1 : files){
            Log.i("names",f1);
        }

        Log.i("names", Integer.toString(files.length));


        btnSimple.setOnClickListener(new setTxt("madlib0_simple.txt"));
        btnTarzan.setOnClickListener(new setTxt("madlib1_tarzan.txt"));
        btnUniversity.setOnClickListener(new setTxt("madlib2_university.txt"));
        btnClothes.setOnClickListener(new setTxt("madlib3_clothes.txt"));
        btnDance.setOnClickListener(new setTxt("madlib4_dance.txt"));
        btnRandom.setOnClickListener(new setTxt("rdm"));


    }






    public class setTxt implements View.OnClickListener {

        String[] txtRandom = {"madlib0_simple.txt", "madlib1_tarzan.txt", "madlib2_university.txt",
                "madlib3_clothes.txt", "madlib4_dance.txt"};
        String vrhl;

        public setTxt(String verhl){
            vrhl = verhl;
        }

        @Override
        public void onClick(View view) {

            if(vrhl == "rdm"){
                int txtRnd = new Random().nextInt(txtRandom.length);
                Intent jumppage = new Intent(ActivityChoose.this, ActivityIn.class);
                jumppage.putExtra("text", txtRandom[txtRnd]);
                startActivity(jumppage);
            }
            else {
                Intent jumppage = new Intent(ActivityChoose.this, ActivityIn.class);
                jumppage.putExtra("text", vrhl);
                startActivity(jumppage);
            }

        }


    }

}

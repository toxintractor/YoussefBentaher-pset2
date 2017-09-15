package com.bentaher.youssefbentaher_pset2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.LogPrinter;
import android.widget.TextView;

import com.bentaher.youssefbentaher_pset2.Story;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class ActivityIn extends AppCompatActivity {

    TextView txtje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in);

        txtje = (TextView) findViewById(R.id.textUitleg);


        //InputStream sk = this.getResources().openRawResource("madlib0_simple.txt");

        String sk ="voorbeeld text";

        txtje.setText(sk);
        //Log.i("Alles", sk);

        File file = new File("madlib0_simple.txt");

        try {
            DataInputStream textFileStream = new DataInputStream(getAssets().open(String.format("madlib0_simple.txt")));
            Scanner sc = new Scanner(textFileStream);

            Story st = new Story(textFileStream);

            String i = sc.nextLine();
            Log.i("Alles", i);
                //System.out.println(i);

            sc.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
            Log.i("Alles", "werkt niet");
        } catch (IOException e) {
            e.printStackTrace();
        }


        //InputStream inputstream = new FileInputStream("res/raw/madlib0_simple.txt");


        //Story stry = new Story(fl);



    }

    //Story vb = new Story();

}

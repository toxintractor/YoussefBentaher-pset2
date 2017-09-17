package com.bentaher.youssefbentaher_pset2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.beginKnop);
        Log.d("message", "laat zien");
    }

    public void gaPagina(View v){

        Intent jumppage = new Intent(MainActivity.this, ActivityChoose.class);
        startActivity(jumppage);
    }
}

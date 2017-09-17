package com.bentaher.youssefbentaher_pset2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ActivityShow extends AppCompatActivity {

    TextView txtVerhaal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        txtVerhaal = (TextView) findViewById(R.id.textVerhaal);

        txtVerhaal.setText(getIntent().getExtras().getString("verhaal"));

    }

    public void onBackPressed() {
        Intent jumppage = new Intent(ActivityShow.this, MainActivity.class);
        startActivity(jumppage);

    }
}

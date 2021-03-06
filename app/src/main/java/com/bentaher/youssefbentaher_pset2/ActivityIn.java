package com.bentaher.youssefbentaher_pset2;

import android.content.Intent;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.LogPrinter;
import android.view.View;
import android.view.ViewDebug;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bentaher.youssefbentaher_pset2.Story;

import java.io.InputStream;
import java.io.IOException;
import java.io.InputStream;

import static android.R.attr.button;


public class ActivityIn extends AppCompatActivity {

    TextView txtCount, txtRemain;
    EditText txtInvoer;
    Button btnInvoer;
    InputStream textFileStream = null;
    String wi = "";
    Story saveObject;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in);

        txtCount = (TextView) findViewById(R.id.textUitleg);
        txtRemain = (TextView) findViewById(R.id.textRemain);
        txtInvoer = (EditText) findViewById(R.id.editFill);
        btnInvoer = (Button) findViewById(R.id.knopje);

        readInput();

        saveObject = new Story(textFileStream);
        int pl = saveObject.getPlaceholderCount();
        Log.i("lekker", Integer.toString(pl));

        txtCount.setText("Voer " + String.valueOf(pl) + " woorden in" );
        txtRemain.setText("Nog " + String.valueOf(pl) + " woorden" + " - woordtype: " + saveObject.getNextPlaceholder() );

        btnInvoer.setOnClickListener(new setWord());
        //st.fillInPlaceholder(setWord(this));

    }

    public void readInput(){
        try {
            textFileStream = getAssets().open(getIntent().getExtras().getString("text"));
        }
        catch(IOException e){
            e.printStackTrace();
        }

    }

    public class setWord implements View.OnClickListener {



        public setWord(){

        }

        @Override public void onClick(View view) {
            // some other code
            String str = txtInvoer.getText().toString();

            if(str.matches("")){
                Toast.makeText(getApplicationContext(),"Voer iets in",Toast.LENGTH_SHORT).show();
            }
            else{
                saveObject.fillInPlaceholder(str);
                int pl = saveObject.getPlaceholderRemainingCount();
                txtRemain.setText("Nog " + String.valueOf(pl) + " woorden" + " - woordtype: " + saveObject.getNextPlaceholder() );
                Log.i("lekker", Integer.toString(pl));


                if(pl == 0){
                    Log.i("lekker",saveObject.toString());
                    Intent jumppage = new Intent(ActivityIn.this, ActivityShow.class);
                    jumppage.putExtra("verhaal", saveObject.toString());
                    startActivity(jumppage);

                }


            }


            //Story st = new Story(textFileStream);
            //int pl = st.getPlaceholderCount();
            //st.fillInPlaceholder(setWord());
            //txtCount.setText("Voer " + String.valueOf(pl) + " woorden in" );
            //txtRemain.setText("Nog " + String.valueOf(pl) + " woorden" );
            txtInvoer.setText("");

        }


    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        //Story onSave = saveObject;
        outState.putSerializable("saveStory", saveObject);

    }


    @Override
    public void onRestoreInstanceState(@Nullable Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        saveObject = (Story) savedInstanceState.getSerializable("saveStory");

        int pl = saveObject.getPlaceholderRemainingCount();
        txtRemain.setText("Nog " + String.valueOf(pl) + " woorden" + " - woordtype: " + saveObject.getNextPlaceholder() );

    }

}
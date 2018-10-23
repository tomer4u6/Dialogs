//Version 1.2
package com.example.tomer.dialogs;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button btn1,btn2,btn3,btn4,btn5;
    AlertDialog.Builder adb;
    AlertDialog ad;
    LinearLayout LL;
    Random rnd = new Random();
    int r,g,b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = (Button)findViewById(R.id.btn1);
        btn2 = (Button)findViewById(R.id.btn2);
        btn3 = (Button)findViewById(R.id.btn3);
        btn4 = (Button)findViewById(R.id.btn4);
        btn5 = (Button)findViewById(R.id.btn5);
        LL = (LinearLayout)findViewById(R.id.LL);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String st = "";
        st = item.getTitle().toString();
        if(st.equals("Credits")){
            Intent t = new Intent(this, SecondActivity.class);
            startActivity(t);
        }
        return super.onOptionsItemSelected(item);
    }


    public void btn1_click(View view) {
        adb = new AlertDialog.Builder(this);
        adb.setTitle("First dialog: Only message");
        adb.setMessage("Example message");
        ad = adb.create();
        ad.show();
    }


    public void btn2_click(View view) {
        adb = new AlertDialog.Builder(this);
        adb.setTitle("Second dialog: Icon and message");
        adb.setMessage("Example message");
        adb.setIcon(R.drawable.androidicon);
        ad = adb.create();
        ad.show();
    }

    public void btn3_click(View view) {
        adb = new AlertDialog.Builder(this);
        adb.setTitle("Third dialog: Icon, message and close");
        adb.setMessage("Example message");
        adb.setIcon(R.drawable.androidicon);

        adb.setNegativeButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                ad.cancel();
            }
        });

        ad = adb.create();
        ad.show();
    }

    public void btn4_click(View view) {
        adb = new AlertDialog.Builder(this);
        adb.setTitle("Forth dialog: Change background");
        adb.setMessage("Click to change color randomly");

        adb.setPositiveButton("Change", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                r = rnd.nextInt(256);
                g = rnd.nextInt(256);
                b = rnd.nextInt(256);
                LL.setBackgroundColor(Color.argb(255,r,b,g));
                ad.cancel();
            }
        });

        adb.setNegativeButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                ad.cancel();
            }
        });

        ad = adb.create();
        ad.show();
    }

    public void btn5_click(View view) {
        adb = new AlertDialog.Builder(this);
        adb.setTitle("Forth dialog: Change or reset background");
        adb.setMessage("Click to change color randomly or reset color");

        adb.setPositiveButton("Change", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                r = rnd.nextInt(256);
                g = rnd.nextInt(256);
                b = rnd.nextInt(256);
                LL.setBackgroundColor(Color.argb(255,r,b,g));
                ad.cancel();
            }
        });

        adb.setNeutralButton("Reset", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                LL.setBackgroundColor(Color.WHITE);
                ad.cancel();
            }
        });

        adb.setNegativeButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                ad.cancel();
            }
        });

        ad = adb.create();
        ad.show();
    }
}

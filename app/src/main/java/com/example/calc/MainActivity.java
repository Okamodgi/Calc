package com.example.calc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
        public void CountSum(View view){
            try {
                EditText pervoe = findViewById(R.id.Per1);
                EditText vtoroe = findViewById(R.id.Per2);
                String per = String.valueOf(pervoe.getText());
                String vtor = String.valueOf(vtoroe.getText());
                Integer val1 = Integer.parseInt(per);
                Integer val2 = Integer.parseInt(vtor);
                Integer res = val1 + val2;

                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("Key1", per);
                intent.putExtra("key2", vtor);
                intent.putExtra("Key", per + "+" + vtor + "=" + res);

                startActivity(intent);

            }catch (Exception exception){
                Toast toast = Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_LONG);
                toast.show();
            }
        }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        EditText pervoe = findViewById(R.id.Per1);
        EditText vtoroe = findViewById(R.id.Per2);
        outState.putString("Text1", pervoe.getText().toString());
        outState.putString("Text2", vtoroe.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState (Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        EditText pervoe = findViewById(R.id.Per1);
        EditText vtoroe = findViewById(R.id.Per2);
        pervoe.setText(savedInstanceState.getString("Text1"));
        vtoroe.setText(savedInstanceState.getString("Text1"));
    }

}
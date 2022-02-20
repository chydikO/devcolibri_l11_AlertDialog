package com.chudnovskiy.devcolibri_l11_alertdialog;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.Toast;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Objects.requireNonNull(getSupportActionBar()).hide();

        Button button = (Button) findViewById(R.id.button);

        button.setOnClickListener(view -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

            //.setCancelable(false||true)-можно ли выйти из AlertDialog по Back
            builder.setTitle("Alert !!!")
                    .setMessage(button.getText().toString())
                    .setCancelable(true)
                    .setNegativeButton("Cancel",
                            (dialogInterface, i) ->
                                    Toast.makeText(getApplicationContext(),
                                            "Cancel pressed!!!",
                                            Toast.LENGTH_LONG).show());
            builder.setPositiveButton("ОК",
                    (dialogInterface, i) ->
                        Toast.makeText(getApplicationContext(),
                                "Ok pressed!!!",
                                Toast.LENGTH_LONG).show());

            builder.setOnCancelListener(dialogInterface -> {
                Toast.makeText(getApplicationContext(),
                        "BACK button pressed!!!",
                        Toast.LENGTH_LONG).show();
            });

            builder.setIcon(R.drawable.ic_launcher_foreground);

            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        });
    }
}